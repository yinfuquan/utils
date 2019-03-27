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
public class DoubleUtils {

	/**
	 * 
	 */
	public DoubleUtils() {
	}

	public static Double parseDouble(Object value, Double defaultValue) {
		if(value == null || StringUtils.isBlank(value.toString())) {
			return defaultValue;
		}
		
		if(value instanceof Double) {
			return (Double)value;
		}
		
		if(value.getClass().isAssignableFrom(Number.class)) {
			return ((Number)value).doubleValue();
		}
		
		try {
			return Double.parseDouble(value.toString());
		}catch(NumberFormatException exp) {
			throw new DataParseException(exp.getMessage(), exp);
		}
	}
	
	public static Double parseDouble(Object value, Double defaultValue, String tips) {
		try {
			return parseDouble(value, defaultValue);
		} catch(DataParseException exp) {
			throw new ServiceException(tips, exp);
		}
	}
}
