/* file 	: 	FixedLengthDataField.java
 * created 	:	May 10, 2006
 * modified :	
 */

package com.neodem.common.recordProcessing.fields;

import org.apache.commons.lang.StringUtils;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class FixedLengthDataField extends DataField {

	private int length;
	private int start;
	private int end;
	
	public FixedLengthDataField() {
		super();
	}

	/**
	 * 
	 */
	public FixedLengthDataField(int order, int length) {
		super(order);
		setLength(length);
	}

	public FixedLengthDataField(int order, String fieldName, int length) {
		super(order, fieldName);
		setLength(length);
	}
	
	public FixedLengthDataField(int order, String fieldName, int length, int start) {
		super(order, fieldName);
		setLength(length);
		setStart(start);
	}

	public FixedLengthDataField(int order, String fieldName, int length, String data) {
		super(order, fieldName);
		setLength(length);
		setData(data);
	}

	/**
	 * @return Returns the length.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length The length to set.
	 */
	public void setLength(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("length may not be less than or equal to zero");
		}
		this.length = length;
		setEnd();
	}

	/**
	 * @return the 0 based start location
	 */
	public int getStart() {
		return start;
	}

	/** will set the data into the field but will trim off the right to fit the field length:
	 * (eg. '123' with a length of 2 will fill as '12'
	 * 
	 * If the data is smaller than the field length it will be padded on the left side..
	 * (eg. '123' with a lenght of 4 will fill as ' 123'.
	 *  
	 * @param data The data to set.
	 */
	public void setData(String data) {
		if (data == null) {
			super.setData(null);
			return;
		}

		int len = data.length();
		if (len == length) {
			super.setData(data);
			return;
		}
		
		String buffer = null;
		if (len > length) {
			buffer = StringUtils.left(data, length);
		} else {
			buffer = StringUtils.leftPad(data, length);
		}

		super.setData(buffer);
	}

	/** will set the data into the field but will trim off the left to fit the field length:
	 * (eg. '123' with a length of 2 will fill as '23'
	 * 
	 * If the data is smaller than the field length it will be padded on the right side..
	 * (eg. '123' with a lenght of 4 will fill as '123 '.
	 *  
	 * @param data The data to set.
	 */
	public void setDataLeft(String data) {
		if (data == null) {
			super.setData(null);
			return;
		}

		int len = data.length();
		if (len == length) {
			super.setData(data);
			return;
		}
		
		String buffer = null;
		if (len > length) {
			buffer = StringUtils.right(data, length);
		} else {
			buffer = StringUtils.rightPad(data, length);
		}

		super.setData(buffer);
	}

	/** will set the start value and set end as well (dependant on length)
	 * 
	 * @param start the 0 based start location
	 */
	public void setStart(int start) {
		if (start < 0) {
			throw new IllegalArgumentException("start may not be less than zero");
		}
		this.start = start;
		setEnd();	
	}

	/**
	 * 
	 */
	private void setEnd() {
		this.end = start + length - 1;	
	}

	/**
	 * @return the 0 based end location
	 */
	public int getEnd() {
		return end;
	}
}
