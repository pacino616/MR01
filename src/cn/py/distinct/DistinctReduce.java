package cn.py.distinct;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DistinctReduce extends Reducer<Text, NullWritable, Text, NullWritable>{
	/**
	 * reducer�������ȥ�صĹ��ܣ��ײ�Ὣmap�д��ݹ�����keyֵ����ȥ��
	 */
	@Override
	protected void reduce(Text key, Iterable<NullWritable> values,
			Reducer<Text, NullWritable, Text, NullWritable>.Context context) throws IOException, InterruptedException {
		context.write(key, NullWritable.get());
	}
	
	
//	@Override
//	protected void reduce(Text key, Iterable<IntWritable> values,
//			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
//		String text = "";
//		Set<Integer> sets = new HashSet<Integer>();
//		for (IntWritable  value: values) {
//			sets.add(value.get());
//		}
//		for (Integer set : sets) {
//			text = key+""+set;
//		}
//		context.write(new Text(text), new IntWritable(1));
//	}
}
