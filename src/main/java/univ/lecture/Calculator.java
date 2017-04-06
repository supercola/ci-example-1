package univ.lecture;

import java.util.Stack;
import java.util.ArrayList;

/**
 * Created by tchi on 2017. 3. 19..
 */

public class Calculator {
	
	String a[];
	String sentence[];
	int b;
	int c;
	Stack stack = new Stack();
	ArrayList<Character> array;
    public int calculate(String exp) { 
    	char[] chararray = exp.toCharArray();
      	
    	sentence = new String[exp.length()];
    	array = new ArrayList();
    	
    	for(int i3=0;i3<exp.length();i3++){
    		array.add(chararray[i3]);
    	}	
    	int i2=0;
    	while(!(array.isEmpty())){
    		String test_s;
    		if("0123456789".indexOf(Character.toString(array.get(0)))>=0){
    			test_s = Character.toString(array.remove(0));
    			if(!array.isEmpty()){
        			while(("0123456789".indexOf(Character.toString(array.get(0)))>=0)){
        				test_s += Character.toString(array.remove(0));
        				if(array.isEmpty()){
        					break;
        				}
        			}	
    			}	
    			}
    		else{
    			test_s = Character.toString(array.remove(0));
    		}
    		
    		sentence[i2] = test_s;
    		i2++;
    	
    	}
    	
    	RPN(infixToPostfix(sentence));
    	
    	double result = Double.parseDouble((String) stack.pop());
    	
        return (int)result;
    }
    
    private boolean isAnOperator(String s){
    	
    	if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
    		return true;
    	}else
    		return false;
    }
    
    public double evaluate(double x2, double y2, String op){
    	double z=0;
    	
		if (op.equals("+"))
			z = x2 + y2;
		else if (op.equals("-"))
			z = x2 - y2;
		else if (op.equals("*"))
			z = x2 * y2;
		else
			z = x2 / y2;
		
		return z;
    }
    
	public String[] infixToPostfix(String[] args) {
		a = new String[args.length];
		Stack s = new Stack();		
		
		for(int i=0;i<args.length;i++){
			
			if(args[i]==null){
				break;
			}
			
			if(args[i].equals("(")){
				s.push(args[i]);
			}
			else if(args[i].equals(")")){
				while(!s.isEmpty()&&!(precedence((String)s.peek())==0)){
					a[c++]=(String)s.pop();
				}if(s.peek().equals("(")){
						s.pop();
					}				
			}else if(isAnOperator(args[i])){
				while(!s.isEmpty()&&precedence((String)s.peek())>=precedence(args[i])){
				a[c++]=(String)s.pop();
				}s.push(args[i]);
			}
			
			else if(!(isAnOperator(args[i]))){
				a[c++]=args[i];
			}
		}
		while(!s.isEmpty()){
			a[c++]=(String)s.pop();
		}	
		return a;
	}
	
	public int precedence(String token) {
		switch (token) {
		case "(":
			b = 0;
			break;
		case "*":
			b = 2;
			break;
		case "/":
			b = 2;
			break;
		case "+":
			b = 1;
			break;
		case "-":
			b = 1;
			break;

		}
		return b;
	}
	
	public void RPN(String[] args) {

		for (int i = 0; i < args.length; i++) {
			String input = args[i];
			if(input ==  null)break;
			if (isAnOperator(input)) {
				
				double y2=Double.parseDouble((String) stack.pop());
				double x2=Double.parseDouble((String) stack.pop());
				double z2 = evaluate(x2, y2, input);
				
				stack.push("" + z2);
			} else
				stack.push(input);
		}
	}
    
}
