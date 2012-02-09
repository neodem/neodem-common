package com.neodem.common.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;


/** interface for a service that will locate files on the classpath
 * @author Vincent Fumo
 * @version 1.0
 */
public interface FileLocator {

    /**
     * Return the location of the specified resource by searching the current 
     * classpath and the system classpath.
     *
     * @param name the name of the resource
     *
     * @return the location of the resource
     * @throws IOException if file can't be found
     */
    public abstract URL locate(String base, String name) throws IOException;
    
    
    /**
     * Return the location of the specified resource by searching the current 
     * classpath and the system classpath.
     *
     * @param base the base path of the resource
     * @param name the name of the resource
     *
     * @return the location of the resource
     * @throws IOException if file can't be found
     */
    public abstract URL locate(String name) throws IOException;
    
    /**
     * Return a {@File} object for the resource
     *
     * @param name the name of the resource
     *
     * @return the location of the resource
     * @throws IOException if file can't be found
     */
    public abstract File getFile(String name) throws IOException;
    
    
}
