package univ.lecture;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by tchi on 2017. 3. 19..
 */

/*
 * 연산자 우선순위를 지원해주는 간단한 계산 어플리케이션.
 * 이 클래스는 중위식을 후위식으로 변환 후 사칙연산 계산을 하는 클래스이다.
 */

public class Calculator {
	
	String a[];
	
	Stack stack = new Stack();
	int b;
	int c;
	ArrayList<Character> array;
	
	
    public int calculate(String exp) {
    	int i2=0;
    	
    	StringTokenizer token = new StringTokenizer(exp,"+-*/()");//숫자
    	StringTokenizer token2 = new StringTokenizer(exp,"0123456789()");//+-*/
    	StringTokenizer token3 = new StringTokenizer(exp,"0123456789+-*/");//( )
    	String sentence[]=new String[token.countTokens()+token2.countTokens()+token3.countTokens()];
    	while(token.hasMoreTokens()||token2.hasMoreTokens()||token3.hasMoreTokens()){
    	if(token3.hasMoreTokens()||token.hasMoreTokens()){
    		if(token3.hasMoreTokens())
    		sentence[i2++]=token3.nextToken();
    		if(token.hasMoreTokens())
    			sentence[i2++]=token.nextToken();
    	}
    	if(token.hasMoreTokens()||token2.hasMoreTokens()){
    		if(token2.hasMoreTokens())
        		sentence[i2++]=token2.nextToken();
        	if(token.hasMoreTokens())
        			sentence[i2++]=token.nextToken();
    	}
    	
    	if(token.hasMoreTokens()||token2.hasMoreTokens()){
    		if(token3.hasMoreTokens())
    		sentence[i2++]=token3.nextToken();
    		if(token2.hasMoreTokens())
    			sentence[i2++]=token2.nextToken();
    	}
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
	
	public String[] infixToPostfix(String[] args) {//후위식으로 변환해주는 함수
		a = new String[args.length];//args의 길이만큼의 배열 a를 만듬
		Stack s = new Stack();		
		
		for(int i=0;i<args.length;i++){//args의 길이만큼 돌아가는 for문
			
			if(args[i]==null){
				break;
			}
			
			if(args[i].equals("(")){//열린 괄호 만났을 때
				s.push(args[i]);
			}
			else if(args[i].equals(")")){//닫힌 괄호 만났을 때
				while(!s.isEmpty()&&!(precedence((String)s.peek())==0)){
					a[c++]=(String)s.pop();
				}if(s.peek().equals("(")){
						s.pop();
					}//열린 괄호 제거
				
			}else if(isAnOperator(args[i])){//연산자의 경우
				while(!s.isEmpty()&&precedence((String)s.peek())>=precedence(args[i])){
				a[c++]=(String)s.pop();
				}s.push(args[i]);
			}//맨 위의 스택이 args[i] 보다 연산 순위가 높으면, pop해서 a에 저장. args[i]를 push
			
			else if(!(isAnOperator(args[i]))){//피연산자의 경우
				a[c++]=args[i];//배열에 저장
			}
		}

		while(!s.isEmpty()){
			a[c++]=(String)s.pop();
		}//남아있는 모든 원소를 pop
		
//		System.out.print("변환된 후위식 : ");
//		
//		for(int j=0;j<c;j++){
//			System.out.print(a[j]+" ");
//		}
//		System.out.println(" ");
		
		return a;
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
