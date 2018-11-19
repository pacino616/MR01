package cn.py.average;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AverageMapper extends Mapper<LongWritable,Text,Text,LongWritable>{
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
//		String[] words = line.split(" ");
//		for (String word : words) {
//			context.write(new Text(word), new LongWritable(1L));
//		}
		//读取的时候是一行一行的读取
		String name = line.split(" ")[0];
		long score = Long.parseLong(line.split(" ")[1]);
		context.write(new Text(name), new LongWritable(score));
	}
}
