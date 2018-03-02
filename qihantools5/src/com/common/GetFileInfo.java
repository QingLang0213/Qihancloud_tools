package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

public class GetFileInfo {
	public  String file_md5;
	public  String file_name;
	public  long file_size;
	
	public GetFileInfo(String path) {
		FileInputStream in = null;
		File file=new File(path);
		file_size=file.length();
		file_name=file.getName();
    try {
    	in = new FileInputStream(file);
        MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file_size);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(byteBuffer);
        BigInteger bi = new BigInteger(1, md5.digest());
        file_md5 = bi.toString(16);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
            if(null != in) {
                try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }
	
    public static void main(String[] args) {
    	String path="C:\\Users\\admin\\Desktop\\test.jpg";
    	GetFileInfo file_info=new GetFileInfo(path);
    	System.out.println(file_info.file_md5);
    	System.out.println(file_info.file_name);
    	System.out.println(file_info.file_size);
    	 
    }
}