/**
 * 
 */
package com.yfq.common.utils;

import com.yfq.common.exception.DataParseException;
import com.yfq.common.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;


/**
 * @author Bean
 *
 */
public class IntegerUtils {

	/**
	 * 
	 */
	public IntegerUtils() {
	}

	public static Integer parseInteger(Object value, Integer defaultValue) {
		if(value == null || StringUtils.isBlank(value.toString())) {
			return defaultValue;
		}
		
		if(value instanceof Integer) {
			return (Integer)value;
		}
		
		if(value.getClass().isAssignableFrom(Number.class)) {
			return ((Number)value).intValue();
		}
		
		try {
			return Integer.parseInt(value.toString());
		} catch(Exception exp) {
			throw new DataParseException("数据类型转换失败, value = " + value);
		}		
	}
	
	public static Integer parseInteger(Object value, Integer defaultValue, String tips) {
		try {
			return parseInteger(value, defaultValue);
		} catch(DataParseException exp) {
			throw new ServiceException(tips, exp);
		}
	}
}
