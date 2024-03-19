package com.m1;

import java.util.Stack;

public class Testpp {
	

	    public static int getTotalExecutionTime(int n, String[] logs) {

	        Stack<Integer> stack = new Stack<>();

	        int prevTime = 0;

	        int totalExecutionTime = 0;

	        for (String log : logs) {

	            String[] parts = log.split(":");

	            int fid = Integer.parseInt(parts[0]);

	            String marker = parts[1];

	            int time = Integer.parseInt(parts[2]);

	            if (marker.equals("start")) {

	                if (!stack.isEmpty()) {

	                    totalExecutionTime += time - prevTime;

	                }

	                stack.push(fid);

	                prevTime = time;

	            } else { // marker.equals("end")

	                totalExecutionTime += time - prevTime + 1;

	                stack.pop();

	                prevTime = time + 1;

	            }

	        }

	        return totalExecutionTime;

	    }

	    public static void main(String[] args) {

	        int n = 3;

	        String[] logs = {"0:start:0", "2:start:4", "2:end:5", "1:start:7", "1:end:10"};

	        System.out.println("Total execution time: " + getTotalExecutionTime(n, logs)); // Output: 642

	    }
}
