package univ.lecture;

import java.util.Stack;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class Calculator {
	
	Stack stack = new Stack();
	int b;
	
    public int calculate(String exp) {
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
