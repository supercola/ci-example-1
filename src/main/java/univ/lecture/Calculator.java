package univ.lecture;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class Calculator {
	
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
    
}
