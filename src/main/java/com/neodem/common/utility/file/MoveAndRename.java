package com.neodem.common.utility.file;

import java.io.File;

/**
 * Will start in a dir and get all files in it and any included dirs over a
 * given size. It will then rename the files sequentially and also move them all
 * to a target dir
 *
 * @author Vince
 */
public class MoveAndRename {
    public static final String START_DIR = "C:/done";

    public static final String END_DIR = "C:/n";

    public static final String NEWFILE_PREFIX = "";

    public static final long MIN_FILESIZE_TOPROCESS = 0 * 1024;

    public static final String INPUT_SUFFIX = ".jpg";

    public static final int STARTING_INDEX = 0;

    private String namePrefix = NEWFILE_PREFIX;

    private String nameSuffix = INPUT_SUFFIX;

    private String inputSuffix = INPUT_SUFFIX;

    private String targetDirecory = END_DIR;

    private String sourceDirectory = START_DIR;

    private int startingIndex = 0;

    private long minSize = MIN_FILESIZE_TOPROCESS;

    public MoveAndRename(String[] args) {
        processArgs(args);
        process();
    }

    /**
     * args are in the form of sourceDir, targetDir, suffix, startindex
     *
     * @param args
     */
    private void processArgs(String[] args) {
        if (args.length > 0) {
            setSourceDirectory(args[0]);
        }
        if (args.length > 1) {
            setTargetDirecory(args[1]);
        }
        if (args.length > 2) {
            setInputSuffix(args[2]);
        }
        if (args.length > 3) {
            setMinSize(Long.parseLong(args[3]));
        }
    }

    private void process() {
        File targetDirectory = new File(getTargetDirecory());
        if (!targetDirectory.exists()) {
            targetDirectory.mkdir();
        }
        File sourceDirectory = new File(getSourceDirectory());
        File[] sources = sourceDirectory.listFiles();
        moveFiles(sources, targetDirectory, getStartingIndex());
    }

    /**
     * @param sources
     * @param targetDirectory
     * @param minFileSize
     * @param startIndex
     * @return number of files processed
     */
    private int moveFiles(File[] sources, File targetDirectory, int startIndex) {
        int index = startIndex;
        for (int i = 0; i < sources.length; i++) {
            if (sources[i].isDirectory()) {
                File[] contents = sources[i].listFiles();
                int processed = moveFiles(contents, targetDirectory, index);
                index += processed;
            } else {
                if (passes(sources[i])) {
                    index = moveFile(sources[i], targetDirectory, index);
                }
            }
        }
        return index - startIndex;
    }

    /**
     * move file if it doesn't exist in the new dir
     */
    private int moveFile(File file, File targetDirectory, int index) {
        File dest;
        do {
            String newName = makeName(index);
            dest = new File(targetDirectory, newName);
            index++;
        } while (dest.exists());

        System.out.println("moving " + file + " to " + dest);
        if (file.renameTo(dest)) {
            return index;
        }
        System.out.println("ERROR :  " + file + " could not be moved to "
                + dest);
        return index;
    }

    private boolean passes(File file) {
        if (!file.isFile())
            return false;
        long fLen = file.length();
        long min = getMinSize();
        if (fLen < min)
            return false;

        String name = file.getName();
        int len = name.length();
        if (len > 4) {
            String suffix = name.substring(len - 4);
            if (!suffix.equalsIgnoreCase(getInputSuffix()))
                return false;
        } else {
            return false;
        }

        return !file.isHidden();
    }

    private String makeName(int index) {
        StringBuilder b = new StringBuilder();
        b.append(getNamePrefix());
        b.append(getNumberRep(index));
        b.append(getNameSuffix());
        return b.toString();
    }

    private String getNumberRep(int num) {
        StringBuilder b = new StringBuilder();
        if (num < 10) {
            b.append("0000");
        } else if (num < 100) {
            b.append("000");
        } else if (num < 1000) {
            b.append("00");
        } else if (num < 10000) {
            b.append("0");
        }

        b.append(num);

        return b.toString();
    }

    public static void main(String[] args) {
        new MoveAndRename(args);
    }

    public String getInputSuffix() {
        return inputSuffix;
    }

    public void setInputSuffix(String inputSuffix) {
        this.inputSuffix = inputSuffix;
    }

    public String getNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    public long getMinSize() {
        return minSize;
    }

    public void setMinSize(long minSize) {
        this.minSize = minSize;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }

    public String getTargetDirecory() {
        return targetDirecory;
    }

    public void setTargetDirecory(String targetDirecory) {
        this.targetDirecory = targetDirecory;
    }

    public int getStartingIndex() {
        return startingIndex;
    }

    public void setStartingIndex(int startingIndex) {
        this.startingIndex = startingIndex;
    }
}
