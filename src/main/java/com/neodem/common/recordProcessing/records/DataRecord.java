/* file 	: 	DataRecord.java
 * created 	:	May 10, 2006
 * modified :	
 */

package com.neodem.common.recordProcessing.records;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.neodem.common.recordProcessing.fields.DataField;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class DataRecord {

	protected Map fields;
	
	/**
	 * 
	 */
	public DataRecord(int size) {
		super();
		if(size <= 0) throw new IllegalArgumentException("initial size must be greater than 0");
		fields = new HashMap(size);
	}
	
	protected void addField(DataField field) {
		Integer index = new Integer(field.getIndex());
		fields.put(index, field);	
	}
	
	public DataField getField(int index) {
		return (DataField) fields.get(new Integer(index));
	}

	protected void clearFieldData() {
		Set entries = fields.entrySet();			
		for (Iterator iter = entries.iterator(); iter.hasNext();) {
			Map.Entry element = (Map.Entry) iter.next();
			DataField field = (DataField) element.getValue();
			field.setData(null);
		}
	}
	
	protected List getOrderedFieldList() {
		Set entries = fields.entrySet();	
		List fieldList = new ArrayList(entries.size());		
		for (Iterator iter = entries.iterator(); iter.hasNext();) {
			Map.Entry element = (Map.Entry) iter.next();
			DataField field = (DataField) element.getValue();
			fieldList.add(field);
		}
		Collections.sort(fieldList);
		return fieldList;
	}

}
