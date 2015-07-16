package com.king.util;

import java.util.HashMap;

import com.king.entry.Reader;

public class ReaderMgr {
	private static HashMap<Integer, Reader> map= new HashMap<Integer, Reader>();

	  public static void addReader(Integer key,Reader reader){
		  map.put(key,reader);
		  
	  }
	  public static Reader getReader(Integer key){
		  return (Reader)map.get(key);
	  }
	  
	  public static boolean isEmpty(){
		  return map.isEmpty();
	  }
	  
	  public static void clean(){
		  map.clear();
	  }
}
