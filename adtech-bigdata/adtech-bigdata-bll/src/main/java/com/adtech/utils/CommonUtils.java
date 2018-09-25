package com.adtech.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 通用工具类
 * 
 * @author jax-liu
 * @create time 2018-9-20 09:55:39
 */
public class CommonUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}
	
	public static String formatSMD(Date date) {
		return format(date, DATE_TIME_PATTERN);
	}
	
	/**
	 * 时间字符串转换为date
	 * @param date
	 * @param loc
	 * @return
	 */
	public static Date format(String date,Locale loc) {
		if(loc==null){
			loc = Locale.getDefault();
		}
		SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_PATTERN, loc);
		try {
			return df.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}
}
