package com.nanyou.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class RemoveSameUtils {

	public static String removeArray(String[] array){
		String result = "";
		List<String> list = new ArrayList<>();  
		list.add(array[0]);  
		for(int i=0;i<array.length;i++){  
		    for(int j=i+1;j<array.length;j++){  
		        if(array[i] == array[j]){  
		            j = ++i;  
		        }  
		    }  
		    list.add(array[i]);  
		} 
		String[] arrayResult = (String[]) list.toArray(new String[list.size()]);  
		if(arrayResult.length>0)result = StringUtils.join(arrayResult, ",");
		return result;
	}
	
	public static void main(String[] args) {
		String perm = "1,2,3,4,5,";
		System.out.println(perm.substring(0,perm.length() - 1));
	}
	
}
