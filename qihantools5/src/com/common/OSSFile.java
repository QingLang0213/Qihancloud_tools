package com.common;

import java.io.BufferedInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import org.apache.log4j.Logger;


public class OSSFile {
	private static Logger logger = Logger.getLogger(OSSFile.class);
	
	public static boolean uploadFileByHttpPut(String path, String filePath) throws IOException {
	    if (path == null || filePath == null) {
	        return false;
	    }
	    RandomAccessFile raf = new RandomAccessFile(filePath, "rw");

	    if (raf == null) {
	        return false;
	    }
	    int FIX_SIZE = 100 * 1024;
	    boolean flag = false;
	    try {
	        URL url = null;
	        try {
	            url = new URL(path);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	        HttpURLConnection conn = null;
	        if (url != null) {
	            conn = (HttpURLConnection) url.openConnection();
	            if (conn != null) {
	                byte[] data = new byte[FIX_SIZE];
	                conn.setConnectTimeout(10 * 60 * 1000);
	                conn.setChunkedStreamingMode(0);
	                conn.setRequestMethod("PUT");
	                conn.setDoOutput(true);
	                conn.setRequestProperty("Content-Type", "");
	                OutputStream outStream = conn.getOutputStream();
	                int num = -1;
	                do {
	                    num = raf.read(data);//每次读取FIX_SIZE大小的数据
	                    if (num > 0) {
	                        outStream.write(data, 0, num);//写入每次实际读取到的数据
	                    }
	                } while (num > 0);
	                outStream.flush();
	                outStream.close();
	                data = null;
	                flag = conn.getResponseCode() == 200;
	                conn.disconnect();
	                conn = null;
	                return flag;
	            }
	            url = null;
	        }

	    } catch (ProtocolException | UnknownHostException e) {
	        e.printStackTrace();
	        logger.error(e);
	    }
	    return flag;
	}
	
	
	public static boolean getNetWorkBitmap(String urlString, String path) {
	    URL imgUrl = null;
	    boolean flag = false;
	    try {
	        imgUrl = new URL(urlString);
	        // 使用HttpURLConnection打开连接
	        HttpURLConnection urlConn = (HttpURLConnection) imgUrl
	                .openConnection();
	        urlConn.setDoInput(true);
	        urlConn.connect();

	        
	        // 将得到的数据转化成InputStream
	        InputStream is = urlConn.getInputStream();
	        //InputStream is =urlConn.getErrorStream();
	        if (path != null) {
	            BufferedInputStream bin = new BufferedInputStream(is);
	            RandomAccessFile file = new RandomAccessFile(path, "rw");
	            if (file != null) {
	                byte[] buffer = new byte[1024];
	                int len = 0;
	                while ((len = bin.read(buffer)) != -1) {
	                    file.write(buffer, 0, len);
	                }
	                bin.close();
	                file.close();
	            }
	        }
	        is.close();
	        flag = true;
	    } catch (MalformedURLException e) {
	        // TODO Auto-generated catch block
	        logger.error("[getNetWorkBitmap->]MalformedURLException");
	        logger.error("下载文件失败:" + e.getMessage());
	        e.printStackTrace();
	    } catch (IOException e) {
	    	logger.error("[getNetWorkBitmap->]IOException");
	        e.printStackTrace();
	        logger.error("下载文件失败:" + e.getMessage());
	    }
	    return flag;
	}

	
	
}
