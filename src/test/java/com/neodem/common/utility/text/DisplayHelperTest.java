/* file 	: 	DisplayHelperTest.java
 * created 	:	Feb 17, 2006
 * modified :	
 */

package com.neodem.common.utility.text;

import junit.framework.TestCase;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class DisplayHelperTest extends TestCase {
	public void testTrim() {
		String input;
		
		input = null;
		assertNull(DisplayHelper.trim(input, 3));
		
		input = "";
		assertEquals("", DisplayHelper.trim(input, 3));
		
		input = "abcde";
		assertEquals("abc", DisplayHelper.trim(input, 3));
		assertEquals("", DisplayHelper.trim(input, 0));
		assertEquals("abcde", DisplayHelper.trim(input, 5));	
		assertEquals("abcde", DisplayHelper.trim(input, 6));
	}
	
	public void testCharLine() {
		char input;
		
		input = '*';
		assertEquals("", DisplayHelper.charLine(0,input));
		assertEquals("***", DisplayHelper.charLine(3,input));
	}
	
	public void testRepeatedPatternLine() {
		String input;
		
		input = null;
		assertEquals("     ", DisplayHelper.repeatedPatternLine(input, 5));
		assertEquals("", DisplayHelper.repeatedPatternLine(input, 0));
		
		input = "-";
		assertEquals("", DisplayHelper.repeatedPatternLine(input, 0));
		assertEquals("", DisplayHelper.repeatedPatternLine(input, -2));	
		
		input = "-*-*";
		assertEquals("-*-", DisplayHelper.repeatedPatternLine(input, 3));
		assertEquals("-*-*", DisplayHelper.repeatedPatternLine(input,4));
		assertEquals("-*-*-", DisplayHelper.repeatedPatternLine(input,5));	
		assertEquals("-*-*-*", DisplayHelper.repeatedPatternLine(input,6));	
	}
	
	public void testCenterTextLine() {
		String input;
		char side;

		input = null;
		side = '|';
		assertEquals("|   |", DisplayHelper.centerTextLine(input,side,5));
		
		input = "a";
		assertEquals("| a |", DisplayHelper.centerTextLine(input,side,5));
		
		input = "ab";
		assertEquals("|ab |", DisplayHelper.centerTextLine(input,side,5));
		
		input = "abc";
		assertEquals("|abc|", DisplayHelper.centerTextLine(input,side,5));
		
		input = "abcd";
		assertEquals("|abc|", DisplayHelper.centerTextLine(input,side,5));
	}
	
}
