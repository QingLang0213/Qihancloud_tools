package com.test.tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class CreatImage {
	public static String image_path=System.getProperty("user.dir")+"\\img\\"; 
	
	public static String create(int width, int height){
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphic = bi.createGraphics();
        
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g=rand.nextInt(255);
        int b=rand.nextInt(255);
        System.out.println(r+"-"+g+"-"+b);
        Color color= new Color(r,g,b);
        graphic.setColor(color);
        graphic.fillRect(0, 0, width, height);
        
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("png");
        ImageWriter writer = it.next();
        File file=new File(image_path);
        if(!file.exists() && !file.isDirectory())      
        {       
        	file .mkdir();    
        }
        
        String up_file_path=image_path+"up"+r+"-"+g+"-"+b+".png";
        File f = new File(up_file_path);
        ImageOutputStream ios;
		try {
			ios = ImageIO.createImageOutputStream(f);
			writer.setOutput(ios);
		    writer.write(bi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        return up_file_path;
    }
	
	/*
	public static void main(String[] args) throws Exception {  
        
		create(600,600);
		
    }  
	*/
}
