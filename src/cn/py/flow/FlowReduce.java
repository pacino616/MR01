package cn.py.flow;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FlowReduce extends Reducer<Text, Flow, Flow, NullWritable>{
	
	@Override
	protected void reduce(Text key, Iterable<Flow> values, Reducer<Text, Flow, Flow, NullWritable>.Context context)
			throws IOException, InterruptedException {
		Flow flow = new Flow();
		for (Flow value : values) {
			flow.setPhone(value.getPhone());
			flow.setName(value.getName());
			flow.setLocation(value.getLocation());
			flow.setSize(flow.getSize()==null?0:flow.getSize()+value.getSize());
		}
		context.write(flow, NullWritable.get());
	}
}
