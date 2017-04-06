package univ.lecture;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tchi on 2017. 3. 19..
 */

/*
 * 연산자 우선순위를 지원해주는 간단한 계산 어플리케이션.
 * 이 클래스는 중위식을 후위식으로 변환 후 사칙연산 계산을 하는 클래스이다.
 */
<<<<<<< HEAD
/* 7조
=======

/*

 * 변경
>>>>>>> 05874b3f5eff8f579bfd0e4d196bbdf07be11936
 */

public class Calculator {
	int b;
    public int calculate(String exp) {
    	String s;
    	Stack<String> stack = new Stack<String>();
    	ArrayList<String> array = new ArrayList<String>();
    	int c=1;
    	int length = exp.length();
    	while(length>0){
    		s = exp.substring(c-1,c);
    		if(s.equals("(")){//열린 괄호 만났을 때
				stack.push(s);
			}
			else if(s.equals(")")){//닫힌 괄호 만났을 때
				while(!stack.isEmpty()&&!(precedence((String)stack.peek())==0)){
					array.add((String)stack.pop());
				}if(stack.peek().equals("(")){
						stack.pop();
					}//열린 괄호 제거				
			}else if("+-/*".indexOf(s)>=0){//연산자의 경우
				while(!stack.isEmpty()&&precedence((String)stack.peek())>=precedence(s)){
					array.add((String)stack.pop());
				}stack.push(s);
			}//맨 위의 스택이 args[i] 보다 연산 순위가 높으면, pop해서 a에 저장. args[i]를 push
			else if(!("+-/*".indexOf(s)>=0)){//피연산자의 경우
				   if(c>1 && array.size()>0){ try {
				    	Double.parseDouble(exp.substring(c-2,c-1));
				    	array.set(array.size()-1,array.get(array.size()-1)+s);
				    } catch (NumberFormatException e) {
				    	array.add(s);
				    }}
				   else{
					   array.add(s);
				   }

			}
    		c+=1;
    		length-=1;
		}
    	while(!stack.isEmpty()){
    		array.add((String)stack.pop());
		}
    		//return 2;
    	Stack<String> stac = new Stack<String>();
		for (int i = 0; i < array.size(); i++) {
			String input = array.get(i);
			if(input ==  null)break;
			if (isAnOperator(input)) {
				int y = Integer.parseInt(stac.pop());
				int x = Integer.parseInt(stac.pop());
				int z = evaluate(x, y, input);
				stac.push(Integer.toString(z));
			} else
				stac.push(input);
		}
		return Integer.parseInt((String)stac.pop());
    }
    private boolean isAnOperator(String s) {
		return (s.length() == 1 && "+-/*".indexOf(s) >= 0);
	}
    
	private int evaluate(int x, int y, String op) {
		int z = 0;
		
		if (op.equals("+"))//A
			z = x + y;
		else if (op.equals("-"))//S
			z = x - y;
		else if (op.equals("*"))//M
			z = x * y;
		else
			z = x / y;
		return z;
	}
    
    public int precedence(String token) {
		switch(token){
		case "(":
			b=0;
			break;
		case "*":
			b=2;
			break;
		case "/":
			b=2;
			break;
		case "+":
			b=1;
			break;
		case "-":
			b=1;break;

		}
		return b;}
        

}
