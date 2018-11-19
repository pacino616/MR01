package cn.py.flow;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class Flow implements Writable{
	
	private String phone;
	private String name;
	private String location;
	//��ʹ�ð�װ���ʱ��ע���ʼֵ�����⣨null��
	private Integer size;
	
	/*
	 * ���л�����
	 * �����String,�����writeUTF
	 * �����ģ�WriteInt,WriteLong,WriteByte,WriteDouble��
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(phone);
		out.writeUTF(name);
		out.writeUTF(location);
		out.writeInt(size);
	}
	
	/*
	 * �����л�һ��Ҫע��˳�򣬺����л���˳��һ��
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		this.phone = in.readUTF();
		this.name = in.readUTF();
		this.location = in.readUTF();
		this.size = in.readInt();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Flow [phone=" + phone + ", name=" + name + ", location=" + location + ", size=" + size + "]";
	}
	
	

}
