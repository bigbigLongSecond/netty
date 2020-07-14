package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Daemons {
    public static void main(String[] args) {
    	Thread d = new Daemon();
    	System.out.println("d.isDaemon() = " + d.isDaemon());
    	BufferedReader stdin =new BufferedReader(new InputStreamReader(System.in));
    	 System.out.println("Waiting for CR");
    	 try {
			stdin.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
