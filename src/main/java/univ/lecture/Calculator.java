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
 * 수정 test 2
 */

public class Calculator {
	
	String post[];
	String sentence[];
	Stack stack = new Stack();
	int priority;
	int indexOfpost;
	ArrayList<Character> array;	
	
    public int calculate(String exp) {
    	
    	/*
    	 *  해당 클래스는 하나의 String 값으로 들어온 연산식을 숫자, 괄호, 연산자로 구별 한 뒤 RPN 메소드를 이용해
    	 *  후위식의 변환 및 연산을 수행하고 결과값을 반환하는 클래스이다.
    	 */
    	char[] chararray = exp.toCharArray(); // 연산식을 전부 char 형으로 하나하나 쪼개놓음.
    	
    	//    	for(int j=0;j<exp.length();j++){
    	//    		System.out.println(chararray[j]);
    	//    	} //잘 나오나 테스트 -> 잘 됨.
    	
    	sentence = new String[exp.length()];//연산식을 string으로 변환한 뒤 저장할 함수
    	array = new ArrayList();//쪼개진 연산식을 저장할 ArrayList
    	
    	for(int i3=0;i3<exp.length();i3++){
    		array.add(chararray[i3]);
    	}//쪼개인 연산식을 하나한 넣는다.
    	
    	int i2=0;//후위식 배열의 인덱스를 표현할 변수
    	while(!(array.isEmpty())){//어레이리스트에 원소가 있을 동안
    		String test_s;
    		if("0123456789".indexOf(Character.toString(array.get(0)))>=0){//만약 이번에 들어온 char의 값이 숫자라면
    			//이 다음 값도 숫자 인지 확인한다. 만약 10이 들어왔다면, 1을 test_s에 저장하고 그 뒤 0을 1에 붙여 저장하기 위한 확인이다.
    			test_s = Character.toString(array.remove(0));//char값을 string으로 변환
    			if(!array.isEmpty()){
        			while(("0123456789".indexOf(Character.toString(array.get(0)))>=0)){//다음 값이 숫자가 아닐때까지
        				test_s += Character.toString(array.remove(0));//test_s에 다음 숫자값을 붙인다.
        				if(array.isEmpty()){//만약 어레이리스트가 비어있다면 while문을 나간다.
        					break;
        				}
        			}//while문의 끝	
    			}	
    			}//if의 끝
    		else{//원소가 숫자가 아니라면 바로 test_s에 해당 값을 저장한다.
    			test_s = Character.toString(array.remove(0));
    		}
    		
    		sentence[i2] = test_s;//완성된 String 값을 후위식 배열에 저장한다.
    		i2++;//인덱스 값을 증가한다.
    	
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
			priority = 0;
			break;
		case "*":// 곱하기
			priority = 2;
			break;
		case "/":// 나누기
			priority = 2;
			break;
		case "+":// 더하기
			priority = 1;
			break;
		case "-":// 빼기
			priority = 1;
			break;

		}
		return priority;
	}
	
	public String[] infixToPostfix(String[] args) {//후위식으로 변환해주는 함수
		post = new String[args.length];//args의 길이만큼의 배열 a를 만듬
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
					post[indexOfpost++]=(String)s.pop();
				}if(s.peek().equals("(")){
						s.pop();
					}//열린 괄호 제거
				
			}else if(isAnOperator(args[i])){//연산자의 경우
				while(!s.isEmpty()&&precedence((String)s.peek())>=precedence(args[i])){
				post[indexOfpost++]=(String)s.pop();
				}s.push(args[i]);
			}//맨 위의 스택이 args[i] 보다 연산 순위가 높으면, pop해서 a에 저장. args[i]를 push
			
			else if(!(isAnOperator(args[i]))){//피연산자의 경우
				post[indexOfpost++]=args[i];//배열에 저장
			}
		}

		while(!s.isEmpty()){
			post[indexOfpost++]=(String)s.pop();
		}//남아있는 모든 원소를 pop
		
//		System.out.print("변환된 후위식 : ");
//		
//		for(int j=0;j<c;j++){
//			System.out.print(a[j]+" ");
//		}
//		System.out.println(" ");
		
		return post;
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
