package com.nanyou.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class KeyGenerator {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static final Map<String, Integer> countMap = new HashMap<String, Integer>();
	private static byte[] lock = new byte[0];  
	
	/**
	 * 获取系统单号
	 * @param beanName
	 * @return
	 */
	public static String getUID(String beanName) {
		String pre = beanName.length() > 4 ? beanName.substring(0, 4) : beanName;
		pre = pre.toUpperCase();
		Integer count = countMap.get(pre);
		count = count == null || count > 9000 ? 1000 : ++count;
		countMap.put(pre, count);
		return pre + dateFormat.format(new Date()) + count;
	}
	
	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",  
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",  
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",  
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",  
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
            "W", "X", "Y", "Z" };  
	/**
	 * 生成8位唯一键
	 * @return
	 */
	public static String generateShortUuid() {  
	    StringBuffer shortBuffer = new StringBuffer();  
	    String uuid = UUID.randomUUID().toString().replace("-", "");  
	    for (int i = 0; i < 8; i++) {  
	        String str = uuid.substring(i * 4, i * 4 + 4);  
	        int x = Integer.parseInt(str, 16);  
	        shortBuffer.append(chars[x % 0x3E]);  
	    }  
	    return shortBuffer.toString();  
	  
	} 
	
	public static void main(String[] args) {
	    System.out.println(getUID("ZB")); 
	}
}
