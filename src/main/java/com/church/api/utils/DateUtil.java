package com.church.api.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getFirstDayOfYear() {
		Calendar cld = Calendar.getInstance();
		
		cld.set(Calendar.MONTH ,Calendar.JANUARY);
		cld.set(Calendar.DAY_OF_MONTH, cld.getActualMinimum(Calendar.DAY_OF_MONTH));
		cld.set(Calendar.HOUR, cld.getActualMinimum(Calendar.HOUR));
		cld.set(Calendar.MINUTE, cld.getActualMinimum(Calendar.MINUTE));
		cld.set(Calendar.SECOND, cld.getActualMinimum(Calendar.SECOND));
				
		return cld.getTime();
	}
	
	public static Date getLastDayOfYear() {
		Calendar cld = Calendar.getInstance();
		
		cld.set(Calendar.MONTH ,Calendar.DECEMBER);
		cld.set(Calendar.DAY_OF_MONTH, cld.getActualMaximum(Calendar.DAY_OF_MONTH));
		cld.set(Calendar.HOUR, cld.getActualMaximum(Calendar.HOUR));
		cld.set(Calendar.MINUTE, cld.getActualMaximum(Calendar.MINUTE));
		cld.set(Calendar.SECOND, cld.getActualMaximum(Calendar.SECOND));
				
		return cld.getTime();
	}
}
