package com.neusoft.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	//获取系统日期
	public static String getCurDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
}
