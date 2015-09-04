package com.fdmgroup.assignment.Calculator;

import java.util.Arrays;
import java.util.Stack;

public class Calculator {
	
	public static String ops = "-+/*^";
	
	/*
	 * Implement Shunting-yard Algorithm to get Reverse Polish Notation of the expression
	 */
	
	public static String getRPN(String expression){
		
	        StringBuilder sb = new StringBuilder();
	        Stack<Integer> s = new Stack<Integer>();
	        	        
	        for (String token : expression.split("\\s")) {
	            if (token.isEmpty())
	                continue;
	            
	            int idx = -1;
	            
	            if (token.length() == 1)
	            {
	            	idx = ops.indexOf(token.charAt(0));
	            }
	            
	            // check for operator
	            if (idx != -1) {
	                if (s.isEmpty())
	                    s.push(idx);
	 
	                else {
	                    while (!s.isEmpty()) {
	                        int prec2 = s.peek() / 2;
	                        int prec1 = idx / 2;
	                        if (prec2 > prec1 || (prec2 == prec1 && !token.equals("^")))
	                            sb.append(ops.charAt(s.pop())).append(' ');
	                        else break;
	                    }
	                    s.push(idx);
	                }
	            } 
	            else if (token.equals("(")) {
	                s.push(-2); // -2 stands for '('
	            } 
	            else if (token.equals(")")) {
	                // until '(' on stack, pop operators.
	                while (s.peek() != -2)
	                    sb.append(ops.charAt(s.pop())).append(' ');
	                s.pop();
	            }
	            else {
	                sb.append(token).append(' ');
	            }
	        }
	        while (!s.isEmpty())
	            sb.append(ops.charAt(s.pop())).append(' ');

	        return sb.toString();
	        
	}
	
	/*
	 * Calculate RPN 
	 */
	
	public static double calculateRPN(String rpn){
        String[] slist =  rpn.split(" ");
        Stack<Double> res = new Stack<Double>();
       
    	for (int i = 0; i<slist.length; i++){
    				  		
    		if (!ops.contains(slist[i])){  	
    			double value = Double.parseDouble(slist[i]);
    			res.push(value); 			
    		}   		
    		else {    			
    			double x = res.pop();
    			double y = 0;
    			if (res.size() > 0) {
    				y = res.pop();}
    			
    			if (slist[i].equals("+")){
    				res.push(x+y);
    			}
    			else if (slist[i].equals("-")){
    				res.push(y-x);
    			}
    			else if (slist[i].equals("*")){
    				res.push(y*x);
    			}
    			else if (slist[i].equals("/")){
    				res.push(y/x);
    			}
    			else if (slist[i].equals("^")){
    				res.push(Math.pow(y, x));
    			}			
    		}
    	}
    
    	double ans = Math.floor(res.pop() * 100) / 100;
        return ans;
        
	}
	
	/*
	 * Put together	
	 */
	
	public static double evaluateExp(String expression){
		
		double ans = calculateRPN(getRPN(expression));
		return ans;
		
	};	
	
		
	public static void main(String[] args) {
		
//		double res = evaluateExp("- ( ( 16.345 / 2.743 ) / ( 4.567 * 3.905 - 10.53 ) ^ 1.5 ) ^ -2.1 * 3.7 - 60.433 / 30.97");
//		System.out.println(res);
		
	}
	
}
