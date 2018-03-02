package com.common;

import java.util.ArrayList;

public class Common {
	/**
	 * �߳�����
	 * 
	 * @param mils
	 *            ����
	 */
	public static void sleepTime(long mils) {
		try {
			Thread.sleep(mils);
		} catch (InterruptedException e) {
			System.out.println("ֹͣʱ������Ƿ�:" + mils);
			e.printStackTrace();
		}
	}
	
	
	public static boolean compareList(ArrayList<String> listA,ArrayList<String>  listB){
		if(listA.size()!=listB.size()){
			return false;
		}
		else{
			 for (String a : listA) {
		            if (!listB.contains(a)){
		            	return false;
		            }	
			 }
		}
		return true;
	}
}
