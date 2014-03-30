/* file 	: 	CommandLineSupport.java
 * created 	:	Dec 17, 2005
 * modified :	
 */

package com.neodem.common.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Vincent Fumo (neodem@gmail.com)
 */
public abstract class CommandLineSupport {

    /**
     * get an input string, prface with prompt
     *
     * @param string
     * @return
     * @throws IOException
     */
    protected static String prompt(String prompt) throws IOException {
        System.out.print(prompt);
        return readInputLine();
    }

    protected static String readInputLine() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();

        if (s == null) return null;
        if ("".equals(s)) return null;

        return s;
    }

    /**
     * return the token indexed by the index param (1 is first) that is not an
     * option token (ie. prefaced by OPTION_TOKEN_PREFIX)
     *
     * @param index
     * @param args
     * @return null if token cannot be found
     */
    protected static String getNonOptionToken(int index, String[] args) {
        int tokenCount = 1;
        for (int i = 0; i < args.length; i++) {
            String str = args[i];
            if (isOptionToken(str)) {
                continue;
            }
            if (tokenCount == index) {
                return str;
            }
            tokenCount++;
        }

        return null;
    }

    /**
     * return true if the string inputted begins with a OPTION_TOKEN_PREFIX
     *
     * @param str
     * @return
     */
    protected static boolean isOptionToken(String str) {
        if (str == null) return false;
        char OPTION_TOKEN_PREFIX = '-';
        return str.charAt(0) == OPTION_TOKEN_PREFIX;
    }

    /**
     * return true if the option is found in the argument array
     *
     * @param option
     * @param args
     * @return
     */
    protected static boolean findOption(char option, String[] args) {
        for (int i = 0; i < args.length; i++) {
            String str = args[i];
            if (isOptionToken(str)) {
                if (str.charAt(1) == option) return true;
            }
        }
        return false;
    }
}
