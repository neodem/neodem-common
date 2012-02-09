
package com.neodem.common.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.configuration.ConfigurationUtils;

import com.neodem.common.service.FileLocator;

/** Uses the commons.configuration class to help
 * @author Vincent Fumo
 * @version 1.0
 */
public class CommonsFileLocator implements FileLocator {

    public CommonsFileLocator() {
        super();
    }

    public URL locate(String base, String name) {
        return ConfigurationUtils.locate(base, name);
    }

    public URL locate(String name) {
        return ConfigurationUtils.locate(name);
    }

    public File getFile(String name) throws IOException {
        URL url = ConfigurationUtils.locate(name);
        if(url != null) {
            return new File(url.getFile());
        }
        
        throw new IOException("file not found :'" + name + "'");
    }
}
