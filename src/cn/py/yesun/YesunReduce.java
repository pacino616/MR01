package cn.py.yesun;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class YesunReduce extends Reducer<Text, Text, Text, NullWritable>{
	
//	@Override
//	protected void reduce(Text key, Iterable<Yesun> values, Reducer<Text, Yesun, Text, Text>.Context context)
//			throws IOException, InterruptedException {
//		List<String> list = new ArrayList<>();
//		for(Yesun value:values){
//			list.add(value.getSonName());
//		}
//		String text = list.toString();
//		context.write(key, new Text(text));
//	}
	
	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		List<String> grandFaList = new ArrayList<>();
		List<String> grandSonList = new ArrayList<>();
		for (Text value : values) {
			if(value.toString().startsWith("+")){
				grandFaList.add(value.toString().substring(1));
			}else{
				grandSonList.add(value.toString().substring(1));
			}
		}
		if(grandFaList.size()>0&&grandSonList.size()>0){
			String grandFa = grandFaList.toString();
			String grandSon = grandSonList.toString();
			
			String result = "爷爷辈："+grandFa+"-->孙子辈："+grandSon;
			context.write(new Text(result), NullWritable.get());
		}
		
	}
}
