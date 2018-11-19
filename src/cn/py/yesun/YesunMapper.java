package cn.py.yesun;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class YesunMapper extends Mapper<LongWritable,Text,Text,Text>{
	
//	@Override
//	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Yesun>.Context context)
//			throws IOException, InterruptedException {
//		String line = value.toString();
//		Yesun ye = new Yesun();
//		ye.setFartherName(line.split(" ")[1]);
//		ye.setSonName(line.split(" ")[0]);
//		context.write(new Text(ye.getFartherName()), ye);
//	}
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		String s1 = line.split(" ")[0];
		String s2 = line.split(" ")[1];
		context.write(new Text(s1), new Text("+"+s2));
		context.write(new Text(s2), new Text("-"+s1));
	}
}
