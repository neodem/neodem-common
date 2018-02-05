package com.neodem.common.sandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Some old code I found that will allow us to run a process inside java
 *
 * Created by Vincent Fumo (neodem@gmail.com)
 * Created on 2/5/18
 */
public class CommandRunner {
    public static void main(String args[]) throws IOException {
        // create the ping command as a list of strings
        CommandRunner ping = new CommandRunner();
        List<String> commands = new ArrayList<>();
        commands.add("ping");
        commands.add("-c");
        commands.add("1");
        commands.add("google.com");
        ping.doCommand(commands);
    }

    public void doCommand(List<String> command) throws IOException {
        String s = null;
        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        // read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

        // read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }

}
