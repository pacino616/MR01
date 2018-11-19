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
		//��ȡjob����
		Job job = Job.getInstance(conf);
		//����job���������������
		job.setJarByClass(WordCountDriver.class);
		//����Mapper�齨��
		job.setMapperClass(WordCountMaoper1.class);
		//����mapper�����key����
		job.setMapOutputKeyClass(Text.class);
		//����mapper�����value����
		job.setMapOutputValueClass(IntWritable.class);
		//����reducer�����
		job.setReducerClass(WordCoutReduce1.class);
		//����reduce�����key����
		job.setOutputKeyClass(Text.class);
		//����reduce�����value����
		job.setOutputValueClass(IntWritable.class);
		//��������·��
		FileInputFormat.setInputPaths(job, new Path("hdfs://192.168.80.72:9000/work"));
		//��������ļ�·��,Ҫ����·����ǰ���ܴ��ڣ����Զ�����
		FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.80.72:9000/work/result"));
		//�ύjob
		job.waitForCompletion(true);
	}
}
