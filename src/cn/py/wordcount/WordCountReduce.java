package cn.py.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * ֪ʶ�㣺
 * 1.��һ���������Ͷ�Ӧ��Mapper�����key����
 * 2.�ڶ����������Ͷ�Ӧ��Mapper�����value����
 * 3.������������reduce�����key����
 * 4.���ĸ�������reduce�����value����
 * 5.reduce��������ܵ������ڣ���ΪҪ����Mapper��������
 * 6.Mapper������Ե������ڣ���ֻ��Mapperʱ�����Ľ���ļ�ʱMapTask�����
 * 7.������Mapper����Reduceʱ�����ļǹ��ļ���Reduce�������Mapper�������Ϊ�м���
 */
public class WordCountReduce extends Reducer<Text,IntWritable,Text,Text>{
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, Text>.Context context)
			throws IOException, InterruptedException {
		String result = "";
		for(IntWritable value:values){
			result = result +","+value.get();
		}
		//���ԣ���һ��reduce�����������key��Iterable
		context.write(key,new Text(result));
	}
}
