
package com.neodem.common.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neodem.common.service.FileLocator;

/** will search the context and then the classpath for a file
 * @author Vincent Fumo
 * @version 1.0
 */
public class ContextClasspathFileLocator implements FileLocator {

    private static Log _log = LogFactory.getLog(ContextClasspathFileLocator.class.getName());

    public ContextClasspathFileLocator() {
        super();
    }

    public URL locate(String base, String name) throws IOException {
        URL url = null;

        // attempt to load from the context classpath
        if (url == null) {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            url = loader.getResource(name);

            if (url != null) {
                _log.debug("file located on the context classpath (" + name + ")");
            }
        }

        // attempt to load from the system classpath
        if (url == null) {
            url = ClassLoader.getSystemResource(name);

            if (url != null) {
                _log.debug("file located on the system classpath (" + name + ")");
            }
        }

        if (url == null) {
            String msg = "file not found :(" + name + ")";
            _log.error(msg);
            throw new IOException(msg);
        }

        return url;
    }

    public URL locate(String name) throws IOException {
        return locate(null, name);
    }

    public File getFile(String name) throws IOException {
        URL url = locate(name);
        return new File(url.getFile());
    }
}