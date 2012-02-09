/* file 	: 	DataField.java
 * created 	:	May 10, 2006
 * modified :	
 */

package com.neodem.common.recordProcessing.fields;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class DataField implements Comparable {

	private int index;
	private String name;
	private String data;
	
	public DataField() {
		super();
	}

	public DataField(int index) {
		this.index = index;
	}
	
	public DataField(int index, String fieldName) {
		this.index = index;
		this.name = fieldName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		if(o instanceof DataField) {
			int other = ((DataField)o).getIndex();
			if(this.index > other) return 1;
			if(this.index < other) return -1;
		}
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if(o instanceof DataField) {
			int other = ((DataField)o).getIndex();
			if(this.index == other) return true;
		}
		return false;
	}
		
	/**
	 * @return Returns the order.
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * @param order The order to set.
	 */
	public void setIndex(int order) {
		this.index = order;
	}
	
	/**
	 * @return Returns the fieldName.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param fieldName The fieldName to set.
	 */
	public void setName(String fieldName) {
		this.name = fieldName;
	}

	
	/**
	 * @return Returns the data.
	 */
	public String getData() {
		return data;
	}

	
	/**
	 * @param data The data to set.
	 */
	public void setData(String data) {
		this.data = data;
	}
}
