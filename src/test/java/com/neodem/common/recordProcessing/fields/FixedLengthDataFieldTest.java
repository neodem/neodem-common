/* file 	: 	FixedLengthDataFieldTest.java
 * created 	:	May 10, 2006
 * modified :	
 */

package com.neodem.common.recordProcessing.fields;

import com.neodem.common.recordProcessing.fields.FixedLengthDataField;

import junit.framework.TestCase;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class FixedLengthDataFieldTest extends TestCase {

	public void testSetLengthBadLength() {	
		FixedLengthDataField field = null;
		try {
			field = new FixedLengthDataField(1, -1);
			fail();
		}
		catch (IllegalArgumentException e) {
			// expected
		}
		
		try {
			field = new FixedLengthDataField(1, 0);
			fail();
		}
		catch (IllegalArgumentException e) {
			// expected
		}
	}
	
	public void testSetStartBadValue() {
		FixedLengthDataField field = new FixedLengthDataField(1, 5);
		
		// test setter with neg value
		try {
			field.setStart(-1);
			fail();
		}
		catch (IllegalArgumentException e) {
			// expected
		}
	}
	
	public void testSetStart() {
		FixedLengthDataField field = new FixedLengthDataField(1, 5);
			
		// test that setter works
		field.setStart(10);
		assertEquals(10, field.getStart());
		assertEquals(14, field.getEnd());		
	}
	
	public void testSetDataSmallerThan() {
		// field with len of 3
		FixedLengthDataField field = new FixedLengthDataField(1, 3);
		
		//data len of 2
		String data = "12";
		
		field.setData(data);
		
		assertEquals(" 12", field.getData());
	}
	
	public void testSetDataBiggerThan() {
		// field with len of 3
		FixedLengthDataField field = new FixedLengthDataField(1, 3);
		
		//data len of 4
		String data = "1234";
		
		field.setData(data);
		
		assertEquals("123", field.getData());
	}
	
	public void testSetDataSameAs() {
		// field with len of 3
		FixedLengthDataField field = new FixedLengthDataField(1, 3);
		
		//data len of 3
		String data = "123";
		
		field.setData(data);
		
		assertEquals("123", field.getData());
	}
	
	public void testSetDataLeftSmallerThan() {
		// field with len of 3
		FixedLengthDataField field = new FixedLengthDataField(1, 3);
		
		//data len of 2
		String data = "12";
		
		field.setDataLeft(data);
		
		assertEquals("12 ", field.getData());
	}
	
	public void testSetDataLeftBiggerThan() {
		// field with len of 3
		FixedLengthDataField field = new FixedLengthDataField(1, 3);
		
		//data len of 4
		String data = "1234";
		
		field.setDataLeft(data);
		
		assertEquals("234", field.getData());
	}
	
	public void testSetDataLeftSameAs() {
		// field with len of 3
		FixedLengthDataField field = new FixedLengthDataField(1, 3);
		
		//data len of 3
		String data = "123";
		
		field.setDataLeft(data);
		
		assertEquals("123", field.getData());
	}
}
