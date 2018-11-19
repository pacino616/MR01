package cn.py.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountDriver {
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		//获取job对象
		Job job = Job.getInstance(conf);
		//设置job方法的入口驱动类
		job.setJarByClass(WordCountDriver.class);
		//设置Mapper组建类
		job.setMapperClass(WordCountMaoper1.class);
		//设置mapper的输出key类型
		job.setMapOutputKeyClass(Text.class);
		//设置mapper的输出value类型
		job.setMapOutputValueClass(IntWritable.class);
		//设置reducer组件类
		job.setReducerClass(WordCoutReduce1.class);
		//设置reduce的输出key类型
		job.setOutputKeyClass(Text.class);
		//设置reduce的输出value类型
		job.setOutputValueClass(IntWritable.class);
		//设置输入路径
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.80.72:9000/work"));
		//设置输出文件路径,要求结果路径事前不能存在，会自动创建
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.80.72:9000/work/result"));
		//提交job
		job.waitForCompletion(true);
	}
}
