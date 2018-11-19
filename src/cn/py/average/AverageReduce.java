package cn.py.average;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReduce extends Reducer<Text, LongWritable, Text, LongWritable>{
	
	@Override
	protected void reduce(Text key, Iterable<LongWritable> values,
			Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException {
		long result = 0;
		long count = 0;
		for (LongWritable value : values) {
			result = result+value.get();
			count++;
		}
		long average = result/count;
		context.write(key, new LongWritable(average));
	}
}
