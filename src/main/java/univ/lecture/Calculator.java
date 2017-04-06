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

/*
 * 수정 test
 */

public class Calculator {
	int b;
    public int calculate(String exp) {
    	    return 2;
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
