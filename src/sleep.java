package com.userspace.Sleep;

public class sleep {
    public static void main(String[] args) {
        try { 
            Thread.sleep(Integer.parseInt(args[0]) * 1000); //Thread.sleep is in milliseconds
        } catch (Exception e) {
            try {
                Thread.sleep(1000); //default to 1 second
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

