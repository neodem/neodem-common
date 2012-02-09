/* file 	: 	NumericDataField.java
 * created 	:	May 10, 2006
 * modified :	
 */

package com.neodem.common.recordProcessing.fields;

import org.apache.commons.lang.StringUtils;

/** fixed len data field that will hold numerics:
 * 
 * numerics have infinite left hand side values and 2 decimal places:
 * eg. 12234.58
 * 
 * Since this is based on a fixed length field, they will be trimmed on the left side if needed,
 * the decimal will always be there.
 * 
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class NumericDataField extends FixedLengthDataField {

	/**
	 * @param order
	 * @param length
	 */
	public NumericDataField(int order, int length) {
		super(order, length);
	}
	
	public NumericDataField() {
		super();
	}

	/**
	 * @param order
	 * @param fieldName
	 * @param length
	 */
	public NumericDataField(int order, String fieldName, int length) {
		super(order, fieldName, length);
	}
	
	public NumericDataField(int order, String fieldName, int length, int start) {
		super(order, fieldName, length, start);
	}

	/**
	 * @param order
	 * @param fieldName
	 * @param length
	 */
	public NumericDataField(int order, String fieldName, int length, float value) {
		super(order, fieldName, length);
		setValue(value);
	}

	/**
	 * @param length The length to set.
	 */
	public void setLength(int length) {
		if (length < 3) {
			throw new IllegalArgumentException("length must be equal to or greater than 3");
		}
		super.setLength(length);
	}

	/**
	 * @return Returns the value.
	 */
	public Float getValue() {
		// create new value from underlying field
		String data = getData();
		if (StringUtils.isBlank(data)) return null;

		Float value = null;
		try {
			value = Float.valueOf(data);
		} catch (NumberFormatException e) {
			return null;
		}
		
		return value;
	}

	/**
	 * @param value The value to set.
	 */
	public void setValue(float value) {
		// create a 2 decimal place value and store it
		float newAmount = value * 100;
		newAmount = Math.round(newAmount);
		newAmount = newAmount / 100;

		String amountString = Float.toString(newAmount);
		// add a 0 if necc.
		int dotSpot = amountString.length() - 2;
		char dot = amountString.charAt(dotSpot);
		if (dot == '.') {
			amountString = amountString + "0";
		}

		super.setData(amountString);
	}
}
