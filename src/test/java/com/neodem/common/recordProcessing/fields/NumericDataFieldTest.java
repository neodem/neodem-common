/* file 	: 	NumericDataFieldTest.java
 * created 	:	May 10, 2006
 * modified :	
 */

package com.neodem.common.recordProcessing.fields;

import com.neodem.common.recordProcessing.fields.NumericDataField;

import junit.framework.TestCase;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class NumericDataFieldTest extends TestCase {

	public void testConstructorWithSmallField() {		
		NumericDataField field = null;
		try {
			field = new NumericDataField(1,2);
			fail();
		}
		catch (IllegalArgumentException e) {
			// expected
		}
	}
	
	public void testGetValueWithNullData() {
		NumericDataField field = new NumericDataField(1,5);
		Float value = field.getValue();
		assertNull(value);
	}
	
	public void testGetValueWithBlankData() {
		NumericDataField field = new NumericDataField(1,5);
		field.setData("");
		Float value = field.getValue();
		assertNull(value);
	}
	
	public void testGetValueWithAlphaData() {
		NumericDataField field = new NumericDataField(1,5);
		field.setData("sds23.2");
		Float value = field.getValue();
		assertNull(value);
	}
	
	public void testGetValue() {
		NumericDataField field = new NumericDataField(1,5);
		field.setData("23.23");
		Float value = field.getValue();
		assertEquals(23.23, value.floatValue(), .001);
		assertEquals("23.23", field.getData());
	}
	
	public void testSetValueExtraDecimals() {
		NumericDataField field = new NumericDataField(1,10);
		float value = 123.1234f;
		field.setValue(value);
		
		assertEquals(123.12, field.getValue().floatValue(), .001);	
		assertEquals("    123.12", field.getData());
	}
	
	public void testSetValueTooFewDecimals() {
		NumericDataField field = new NumericDataField(1,10);
		float value = 123.2f;
		field.setValue(value);
		
		assertEquals(123.20, field.getValue().floatValue(), .001);	
		assertEquals("    123.20", field.getData());
	}
	
	public void testSetValueTrimmed() {
		NumericDataField field = new NumericDataField(1,3);
		float value = 123.2f;
		field.setValue(value);
		
		assertEquals(123, field.getValue().floatValue(), .001);	
		assertEquals("123", field.getData());
	}
}
