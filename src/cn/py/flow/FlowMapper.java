package cn.py.flow;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlowMapper extends Mapper<LongWritable, Text, Text, Flow>{
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Flow>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		Flow flow = new Flow();
		flow.setPhone(line.split(" ")[0]);
		flow.setName(line.split(" ")[1]);
		flow.setLocation(line.split(" ")[2]);
		flow.setSize(Integer.parseInt(line.split(" ")[3]));
		context.write(new Text(flow.getName()), flow);
	}
}
