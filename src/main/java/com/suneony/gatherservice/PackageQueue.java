package com.suneony.gatherservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class PackageQueue{
	public static void push(PackageRecord record){
		File packageQueueFile=null;
		BufferedWriter packageQueueWriter=null;
		packageQueueFile=new File(PackageQueue.class.getResource("PackageQueue").getPath());
		//打开队列文件
		try {
			packageQueueWriter=new BufferedWriter(new FileWriter(packageQueueFile, true));
		} catch (IOException e) {
			System.err.println("打开队列文件出错");
			e.printStackTrace();
		}
		//写入队列文件
		try {
			packageQueueWriter.write(record.toString());
			packageQueueWriter.newLine();
		} catch (IOException e) {
			System.err.println("写入队列文件出错");
			e.printStackTrace();
		}
		//关闭队列文件
		try {
			packageQueueWriter.flush();
			packageQueueWriter.close();
		} catch (IOException e) {
			System.err.println("关闭文件出错");
			e.printStackTrace();
		}
		
	}
	public static PackageRecord pop(){
		return null;
	}
	public static void main(String[] args){
		PackageRecord record=new PackageRecord("suneony", "project", "2016", "01", "01", "package");
		PackageQueue.push(record);
	}
}