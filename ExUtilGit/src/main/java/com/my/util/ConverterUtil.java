package com.my.util;

import java.text.DecimalFormat;

public class ConverterUtil {
	
	public class DataUnit{
		public static final int BIT = 1;
		public static final int BYTE =2;
		public static final int KB = 3;
		public static final int MB = 4;
		public static final int GB = 5;
		public static final int TB = 6;
	}
	
	public static String converterDataUnit(int insize,int first,int second){
		
		String result = "0";
		DecimalFormat dec = new DecimalFormat("#####.##########");
		double calcRate = 0.0;
		if(first > second){
			int unit = first - second;
			double rate = calcUnit(unit);	
			calcRate = insize * rate;
			
		}else if(first < second){
			int unit = second - first;
			double rate = calcUnit(unit);
			calcRate = insize / rate;
		}	
		
		result = dec.format(calcRate);
		
		return result;
	}
	
	private static double calcUnit(int unit){
		double result = 0.0;
		
		switch(unit){
		case 1 : result = 1024.0; break;
		case 2 : result = 1024.0 * 1024.0;break;
		case 3 : result = 1024.0 * 1024.0 * 1024.0;break;
		case 4 : result = 1024.0 * 1024.0 * 1024.0 * 1024.0;break;
		case 5 : result = 1024.0 * 1024.0 * 1024.0 * 1024.0 * 1024.0;break;
		default : result= 0.0;break;
		}
		
		
		return result;
	}
	
}
