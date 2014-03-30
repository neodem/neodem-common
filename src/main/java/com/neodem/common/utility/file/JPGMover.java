
package com.neodem.common.utility.file;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.FilenameFilter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * will move jpeg files into dirs with the correct date name
 *
 * @author Vince
 */
public class JPGMover {

    // dirname format
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    // 2000:12:30 10:18:16 ( format in the EXIF data)
    private static final DateFormat FDF = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");

    private JPGMover() throws Exception {
        File dir = new File("/tmp/phone");
        File[] files = dir.listFiles(new FilenameFilter() {

            public boolean accept(File dir, String name) {
                if (name.endsWith(".jpg"))
                    return true;
                return name.endsWith(".JPG");
            }
        });
        for (File file : files) {
            sort(dir, file);
        }
    }

    public static void main(String[] args) throws Exception {
        new JPGMover();
    }

    private void sort(File dir, File file) throws Exception {
        Date taken = getTakenDate(file);
        if (taken != null) {
            File targetDir = makeDir(dir, taken);
            moveFile(file, targetDir);
        }
    }

    private void moveFile(File file, File targetDir) {
        File dest = new File(targetDir, file.getName());
        System.out.println(String.format("moving : %s to %s", file, targetDir.getAbsolutePath()));
        file.renameTo(dest);
    }

    private File makeDir(File baseDir, Date taken) {
        String name = makeName(taken);
        File targetDir = new File(baseDir, name);
        if (!targetDir.exists()) {
            targetDir.mkdir();
        }
        return targetDir;
    }

    private String makeName(Date taken) {
        return df.format(taken);

    }

    private Date getTakenDate(File file) throws Exception {
        Metadata m = JpegMetadataReader.readMetadata(file);
        Iterable<Directory> directories = m.getDirectories();
        Iterator<Directory> iterator = directories.iterator();

        String value = null;
        while (iterator.hasNext()) {
            Directory directory = (Directory) iterator.next();
            Collection<Tag> tags = directory.getTags();
            for (Tag tag : tags) {
                String name = tag.getTagName();
                if ("Date/Time Digitized".equals(name)) {
                    value = tag.getDescription();
                    break;
                }
            }
            if (value != null) {
                break;
            }
        }

        if (value != null) {
            return FDF.parse(value);
        }

        return null;
    }

}
