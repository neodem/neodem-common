/* file 	: 	DefaultApplication.java
 * created 	:	Dec 29, 2005
 * modified :	
 */

package com.neodem.common.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * all arguments come first and be prefaced with a '-'
 *
 * @author Vincent Fumo (neodem@gmail.com)
 */
public class BaseApplication implements Application {

    public static void main(String[] args) {
        run(new BaseApplication(), args);
    }

    /**
     * @param args
     */
    protected static void run(Application app, String[] args) {
        app.setup(args);
        try {
            app.start();
        } catch (ApplicationException e) {
            showCleanException(e);
        }
    }

    /**
     * @param e
     */
    protected static void showCleanException(ApplicationException e) {
        // TODO fix
        e.printStackTrace();
    }


    /**
     *
     */
    public BaseApplication() {
        super();
        // set the default -h option
        addOption('h', "Show Usage (this message)");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.neodem.common.command.Application#setup(java.lang.String[])
     */
    public void setup(String[] args) {
        // parse args
        if (args.length == 0) {
            if (showHelpOnNoArgs) {
                displayUsage();
            }
        } else {
            parseArgs(args);
        }

        if (isOptionSet('h')) {
            displayUsage();
        }
    }


    /**
     *
     */
    protected void displayUsage() {
        System.out.println("usage:");
        displayOptions();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.neodem.common.command.Application#start()
     */
    public void start() throws ApplicationException {
        // start timer
        startTime = System.currentTimeMillis();

        // run app
        execute();

        // stop timer
        endTime = System.currentTimeMillis();

        if (showTimer) {
            displayTimer();
        }
    }

    /**
     *
     */
    protected void displayTimer() {
        StringBuilder b = new StringBuilder();
        b.append("Execution Time : ");
        long time = endTime - startTime;
        b.append(time);
        b.append(" ms");

        System.out.println(b.toString());
    }

    protected long startTime;
    protected long endTime;

    /**
     *
     */
    @SuppressWarnings({ "EmptyMethod", "RedundantThrows" })
    protected void execute() throws ApplicationException {
        // should be overridden to do something
    }

    /**
     * @param args
     */
    protected void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (isOption(arg)) {
                parseOption(arg);
            } else {
                parseArgument(arg);
            }
        }

    }

    // -- arguments

    private final List arguments = new ArrayList(5);

    /**
     * @param arg
     */
    private void parseArgument(String arg) {
        arguments.add(arg);
    }

    protected List getArguments() {
        return arguments;
    }

    // --

    private boolean showTimer;
    private boolean showHelpOnNoArgs = false;

    protected void setShowHelpOnNoArgs(boolean value) {
        showHelpOnNoArgs = value;
    }

    /**
     * @param value
     */
    protected void setShowTimer(boolean value) {
        showTimer = value;
    }

    // -- deal with the options set

    private final Map options = new HashMap();

    /**
     * @param arg
     */
    private void parseOption(String arg) {
        char key = arg.charAt(1);
        setOption(key, true);
    }

    /**
     * @param arg
     * @return
     */
    private boolean isOption(String arg) {
        return arg.indexOf('-') == 0;
    }

    /**
     *
     */
    private void displayOptions() {
        StringBuilder buffer = new StringBuilder(300);
        Set keys = options.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            Option option = (Option) options.get(iter.next());
            buffer.append(option.getDisplayString());
            buffer.append("\n");
        }

        System.out.println(buffer.toString());

    }

    @SuppressWarnings("SameParameterValue")
    protected void addOption(char key, String description) {
        Option option = new Option(key, description);
        options.put(new Character(key), option);
    }

    protected void removeOption(char key) {
        Character mapKey = new Character(key);
        options.remove(mapKey);
    }

    @SuppressWarnings("SameParameterValue")
    protected boolean isOptionSet(char key) {
        Character mapKey = new Character(key);
        Option option = (Option) options.get(mapKey);
        return option != null && option.value;
    }

    @SuppressWarnings("SameParameterValue")
    private void setOption(char key, boolean value) {
        Character mapKey = new Character(key);
        Option option = (Option) options.get(mapKey);
        if (option != null) {
            option.value = value;
        }
    }

    private class Option {

        public char key;
        public String description;
        public boolean value;

        public Option() {
            super();
            this.value = false;
        }

        /**
         * @return
         */
        public String getDisplayString() {
            StringBuilder buffer = new StringBuilder(200);

            buffer.append("-");
            buffer.append(key);
            buffer.append(" : ");
            buffer.append(description);

            return buffer.toString();

        }

        public Option(char key, String description) {
            this.key = key;
            this.description = description;
            this.value = false;
        }
    }

}
