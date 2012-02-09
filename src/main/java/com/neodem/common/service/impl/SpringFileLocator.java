
package com.neodem.common.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.neodem.common.service.FileLocator;


/** Uses Spring to help find the file
 * @author Vincent Fumo
 * @version 1.0
 */
public class SpringFileLocator implements FileLocator {

    public SpringFileLocator() {
        super();
    }

    public URL locate(String base, String name) throws IOException {
        String loc = base + "/" + name;
        Resource resource = new ClassPathResource(loc);
        return resource.getURL();  
    }

    public URL locate(String name) throws IOException {
        Resource resource = new ClassPathResource(name);
        return resource.getURL();
    }

    public File getFile(String name) throws IOException {
        Resource resource = new ClassPathResource(name);
        return resource.getFile();
    }

}
