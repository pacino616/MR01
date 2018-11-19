package cn.py.flow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FlowPartitions extends Partitioner<Text, Flow>{

	@Override
	public int getPartition(Text key, Flow value, int numPartitions) {
		if("bj".equals(value.getLocation())){
			return 0;
		}else if("sh".equals(value.getLocation())){
			return 1;
		}else {
			return 2;
		}
		//默认的分区方式，以map的输出key的hash值取余分区数量
//		return (key.hashCode() & Integer.MAX_VALUE) % numPartitions;
	}
}
