package cn.sims.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelUtil {
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String dateToString(Date date)
	{
		return simpleDateFormat.format(date);
	}
}
