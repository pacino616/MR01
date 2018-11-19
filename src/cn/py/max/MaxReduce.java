package cn.py.max;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxReduce extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable>{
	
	@Override
	protected void reduce(IntWritable key, Iterable<IntWritable> values,
			Reducer<IntWritable, IntWritable, IntWritable, IntWritable>.Context context)
					throws IOException, InterruptedException {
		int max = 0;
		for (IntWritable value : values) {
			if(max < value.get()){
				max = value.get();
			}
		}
		context.write(key, new IntWritable(max));
	}
}
