package cn.py.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * ֪ʶ�㣺
 * 1.job��MapTask��δ����ļ������ݣ�����Mapper�������������������Ĵ������ɳ���Ա��д
 * 2.����һ��Mapper�齨�ķ�ʽ����һ����̳�Mapper
 * 3.��һ���������Ͷ�Ӧ��MapTask������Key����
 * 4.�ڶ����������Ͷ�Ӧ��MapTask������value����
 * 5.����keyʱÿ�е�����ƫ������������LongWritable
 * 6.����value��ÿ�е����ݣ�������Text
 * 7.Writable������hadoop�����л�����
 * 8.map()�������ڽ�����key������value���������Ա����һ�����ݾͻ����һ��
 * 9.����������������MapTask�����key����
 * 10.���ĸ�����������MapTask�����value����
 * 11.��ѧʱ����һ���͵ڶ�������д�����������͵��ĸ����Ͳ��̶�
 */
public class WordCountMapper extends Mapper<LongWritable,Text,LongWritable,Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, LongWritable, Text>.Context context)
			throws IOException, InterruptedException {
		super.map(key, value, context);
		//������key�����value��Ŀ��������֤����
		context.write(key,value);	
	}
}
