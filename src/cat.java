package com.userspace.Cat;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class cat {
    static boolean[] flags = {false, false, false, false}; //-n -b -s -u
    static void checkFlags(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) { //arguments- none will just output the regular text
                    if (args[i].contains("n"))  //will output with numbered lines
                        flags[0] = true;
                    if (args[i].contains("b")) //implies 'n' but ignores blank lines
                        flags[1] = true;
                    if (args[i].contains("s")) //if there is more than one blank line, it will condense them down to one
                        flags[2] = true;
                    if (args[i].contains("h"))
                        flags[3] = true;
            }
        }
    }
    public static void main(String[] args) {
        checkFlags(args);
        if (!flags[3]) {
            for (int i = 0; i < args.length; i++) {
                    if (!args[i].startsWith("-")) {
                        try {
                            File input = new File(args[i]);
                            Scanner reader = new Scanner(input);
                            int line = 0;
                            int fullLine = 0;
                            boolean whitespace = false;
                            while (reader.hasNextLine()) {
                                line++;
                                String data = reader.nextLine();
                                if (!data.trim().isEmpty())
                                    fullLine++;
                                if (flags[2]) {
                                    while (data.trim().isEmpty()) {
                                        if (whitespace) {
                                            data = reader.nextLine();
                                            if (!data.trim().isEmpty())
                                                fullLine++;
                                        }
                                        else
                                            break;
                                    }
                                }
                                whitespace = (data.trim().isEmpty()); 
                                if (flags[0] && !flags[1])
                                    System.out.println("   " + line + "    " + data);
                                else if (flags[1])
                                    if (!data.trim().isEmpty())
                                        System.out.println("   " + fullLine + "    " + data);
                                    else
                                        System.out.println("       " + data);
                                else 
                                    System.out.println(data);
                            }   
                            reader.close();
                        }
                        catch (FileNotFoundException e) {
                            System.out.println("File does not exist");
                        }
                    }
            }
        } else {
            System.out.println("cat [-nbsh] [file]");
            System.out.println("-n              number outputted lines");
            System.out.println("-b              implies -n, doesn't output empty lines");
            System.out.println("-s              will condense consecutive empty lines to one");
            System.out.println("-h              print this help text");    
        }    
    }    
}
    

