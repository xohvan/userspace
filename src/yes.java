package com.userspace.Yes;

public class yes {
    public static void main(String[] args) {
        for (;;) {
            System.out.println((args.length != 0) ? args[0] : "y"); //checks for arguments to print, otherwise it will print 'y'
        }
    }
}

