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

public class Calculator {
	
	String a[];
	String sentence[];
	Stack stack = new Stack();
	int b;
	int c;
	ArrayList<Character> array;
	
	
    public int calculate(String exp) {
    	
    	/*
    	 *  해당 클래스는 하나의 String 값으로 들어온 연산식을 숫자, 괄호, 연산자로 구별 한 뒤 RPN 메소드를 이용해
    	 *  후위식의 변환 및 연산을 수행하고 결과값을 반환하는 클래스이다.
    	 */
    	
    	
    	
        return 2;
    }
    
    private boolean isAnOperator(String s){
    	
    	if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
    		return true;
    	}else
    		return false;
    }//연산자인지 확인해주는 함수
    
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
    }//계산이 이루어지는 함수.
    
	public int precedence(String token) {
		switch (token) {
		case "(":
			b = 0;
			break;
		case "*":// 곱하기
			b = 2;
			break;
		case "/":// 나누기
			b = 2;
			break;
		case "+":// 더하기
			b = 1;
			break;
		case "-":// 빼기
			b = 1;
			break;

		}
		return b;
	}
	
	public void RPN(String[] args) {//최종적으로 계산 해주는 메소드

		for (int i = 0; i < args.length; i++) {
			String input = args[i];
			if(input ==  null)break;
//			System.out.print(input + " ");

			if (isAnOperator(input)) {
				
				double y2=Double.parseDouble((String) stack.pop());
				double x2=Double.parseDouble((String) stack.pop());
				double z2 = evaluate(x2, y2, input);
				
				stack.push("" + z2);
			} else
				stack.push(input);
		}
	}//RPN의 끝
    
}
