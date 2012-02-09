/* file 	: 	Application.java
 * created 	:	Dec 29, 2005
 * modified :	
 */

package com.neodem.common.command;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 *
 */
public interface Application {
	public void setup(String[] args);
	public void start() throws ApplicationException;
}
