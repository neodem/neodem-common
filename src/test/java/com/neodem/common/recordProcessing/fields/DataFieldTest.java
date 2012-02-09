/* file 	: 	DataFieldTest.java
 * created 	:	May 10, 2006
 * modified :	
 */

package com.neodem.common.recordProcessing.fields;

import com.neodem.common.recordProcessing.fields.DataField;

import junit.framework.TestCase;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class DataFieldTest extends TestCase {

	public void testCompare() {
		DataField first = new DataField(5);
		DataField second = new DataField(20);
		
		assertEquals(-1, first.compareTo(second));
		assertEquals(1, second.compareTo(first));
		
		DataField same = new DataField(5);
		assertEquals(0, first.compareTo(same));
	}
	
	public void testEquals() {
		// equals is only based on order
		DataField first = new DataField(5);
		DataField second = new DataField(20);
		
		assertFalse(first.equals(second));
		
		DataField same = new DataField(5);
		assertTrue(first.equals(same));
		
	}
}
