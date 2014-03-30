package com.neodem.common.utility.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * adapted from : http://www.javapractices.com/Topic42.cjp
 *
 * @author Vincent Fumo
 * @version 1.0
 */
public class FileToFromString {

    /**
     * Fetch the entire contents of a text file, and return it in a String. This
     * style of implementation does not throw Exceptions to the caller.
     *
     * @param aFile is a file which already exists and can be read.
     * @throws IOException
     */
    public static String getContents(File aFile) throws IOException {
        if (aFile == null) {
            throw new IllegalArgumentException("File should not be null.");
        }
        if (!aFile.exists()) {
            throw new FileNotFoundException("File does not exist: " + aFile);
        }
        if (!aFile.isFile()) {
            throw new IllegalArgumentException("Should not be a directory: "
                    + aFile);
        }

        StringBuilder contents = new StringBuilder();

        // declared here only to make visible to finally clause
        BufferedReader input = null;
        try {
            // use buffering
            // this implementation reads one line at a time
            input = new BufferedReader(new FileReader(aFile));
            String line = null; // not declared within while loop
            while ((line = input.readLine()) != null) {
                contents.append(line);
                contents.append(System.getProperty("line.separator"));
            }
        } finally {
            if (input != null) {
                // flush and close both "input" and its underlying FileReader
                input.close();
            }
        }
        return contents.toString();
    }

    /**
     * Change the contents of text file in its entirety, overwriting any
     * existing text.
     * <p/>
     * This style of implementation throws all exceptions to the caller.
     *
     * @param aFile is an existing file which can be written to.
     * @throws IllegalArgumentException if param does not comply.
     * @throws FileNotFoundException    if the file does not exist.
     * @throws IOException              if problem encountered during write.
     */
    static public void setContents(File aFile, String aContents)
            throws IOException {
        if (aFile == null) {
            throw new IllegalArgumentException("File should not be null.");
        }
        if (!aFile.exists()) {
            throw new FileNotFoundException("File does not exist: " + aFile);
        }
        if (!aFile.isFile()) {
            throw new IllegalArgumentException("Should not be a directory: "
                    + aFile);
        }
        if (!aFile.canWrite()) {
            throw new IllegalArgumentException("File cannot be written: "
                    + aFile);
        }

        // declared here only to make visible to finally clause; generic
        // reference
        Writer output = null;
        try {
            // use buffering
            output = new BufferedWriter(new FileWriter(aFile));
            output.write(aContents);
        } finally {
            // flush and close both "output" and its underlying FileWriter
            if (output != null)
                output.close();
        }
    }
}
