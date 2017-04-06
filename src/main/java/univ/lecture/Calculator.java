package univ.lecture;

/**
 * Created by tchi on 2017. 3. 19..
 */
public class Calculator {
	
	int b;
	
    public int calculate(String exp) {
        return 2;
    }
    
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
