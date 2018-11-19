package cn.py.max;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxMapper extends Mapper<LongWritable,Text,IntWritable,IntWritable>{
	
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, IntWritable, IntWritable>.Context context)
					throws IOException, InterruptedException {
		String line = value.toString();
		int year = Integer.parseInt(line.substring(8, 12));
		int warm = Integer.parseInt(line.substring(18));
		context.write(new IntWritable(year), new IntWritable(warm));
	}
	
//	@Override
//	protected void map(Text key, LongWritable value,
//			Mapper<Text, LongWritable, IntWritable, IntWritable>.Context context)
//					throws IOException, InterruptedException {
//	}
}
