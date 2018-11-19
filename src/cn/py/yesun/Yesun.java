package cn.py.yesun;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class Yesun implements Writable{
	
	private String fartherName;
	private String sonName;
	
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(fartherName);
		out.writeUTF(sonName);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.fartherName = in.readUTF();
		this.sonName = in.readUTF();
	}

	public String getFartherName() {
		return fartherName;
	}

	public void setFartherName(String fartherName) {
		this.fartherName = fartherName;
	}

	
	
	public String getSonName() {
		return sonName;
	}

	public void setSonName(String sonName) {
		this.sonName = sonName;
	}

	@Override
	public String toString() {
		return "Yesun [fartherName=" + fartherName + ", sonName=" + sonName + "]";
	}
	
	
}
