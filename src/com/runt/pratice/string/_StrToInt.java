package com.runt.pratice.string;

public class _StrToInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(strToInt("+ 00001234"));
	}
	
	/**
	 * 字符串转换成数字
	 * 
	 * "" => 0
	 * "12ab" => 12
	 * "  12d " => 12
	 * "  ba12" => 0
	 * 
	 * @param str
	 * @return
	 * 
	 * @author yeziran Jun 21, 2013
	 */
	public static int strToInt(String str){
		int result = 0;//返回的目标数字
		String srcStr = str.trim();//去左右空格
		int len = str.length();//长度
		int i =0;
		char firstChart = srcStr.charAt(0);
		boolean negative = false;//是否负数
		
		if(len >0){
			StringBuilder sb = new StringBuilder(16);
			if(firstChart < '0'){
				if(firstChart == '-'){
					negative = true;
				}
				i++;
			}
			char newChar;
			
			while(i<len){
				newChar = srcStr.charAt(i++);
				if(!('0'<=newChar && newChar <='9')){
					break;
				}
				sb.append(newChar);
			}
			if( sb.length() > 0 ){
				result = Integer.valueOf(sb.toString());
			}
		}
		if(result != 0 && negative){
			result = -result;
		}
		return result;
	}

}
