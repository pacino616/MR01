package cn.py.flow;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class FlowDriver {
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(FlowDriver.class);
		job.setMapperClass(FlowMapper.class);
		job.setReducerClass(FlowReduce.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Flow.class);
		
		//自定义分区方式
		job.setNumReduceTasks(3);
		job.setPartitionerClass(FlowPartitions.class);
		
		job.setOutputKeyClass(Flow.class);
		job.setOutputValueClass(NullWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.80.72:9000/flow"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.80.72:9000/flow/result"));
		
		job.waitForCompletion(true);
	}
}
