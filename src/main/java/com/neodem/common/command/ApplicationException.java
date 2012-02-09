/* file 	: 	ApplicationException.java
 * created 	:	Dec 29, 2005
 * modified :	
 */

package com.neodem.common.command;

/** 
 * Base Exception Class for all Application objects
 * 
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ApplicationException() {
		super();
	}

	/**
	 * @param arg0
	 */
	public ApplicationException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ApplicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public ApplicationException(Throwable arg0) {
		super(arg0);
	}

}
