/* file 	: 	ConsoleWriter.java
 * created 	:	Aug 10, 2006
 * modified :	
 */

package com.neodem.common.utility.text;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

/**
 * tools to help write stuff to the console
 * <p/>
 * TODO change and expand to write to any output stream... or make a parent class
 *
 * @author Vincent Fumo (neodem@gmail.com)
 */
public class ConsoleWriter {

    private final PrintStream out = System.out;

    /**
     *
     */
    public ConsoleWriter() {
        super();
    }

    /**
     * Display a list of objects to the console, one per line
     *
     * @param results
     */
    public void writeListToConsole(List results) {
        for (Iterator iter = results.iterator(); iter.hasNext(); ) {
            Object element = (Object) iter.next();
            out.println(element);
        }
    }

    /**
     * @param string
     */
    public void writeWithUnderline(String string) {
        out.println(string);
        out.println(DisplayHelper.charLine(string.length(), '-'));
    }

    /**
     * @param displayString
     */
    public void writeLine(String string) {
        out.println(string);
    }

    /**
     *
     */
    public void newLine() {
        out.println("");
    }
}
