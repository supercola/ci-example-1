package univ.lecture;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by tchi on 2017. 3. 19..
 */

/*
 * �뿰�궛�옄 �슦�꽑�닚�쐞瑜� 吏��썝�빐二쇰뒗 媛꾨떒�븳 怨꾩궛 �뼱�뵆由ъ��씠�뀡.
 * �씠 �겢�옒�뒪�뒗 以묒쐞�떇�쓣 �썑�쐞�떇�쑝濡� 蹂��솚 �썑 �궗移숈뿰�궛 怨꾩궛�쓣 �븯�뒗 �겢�옒�뒪�씠�떎.
 */

/*
 * �닔�젙 test
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
    	 *  �빐�떦 �겢�옒�뒪�뒗 �븯�굹�쓽 String 媛믪쑝濡� �뱾�뼱�삩 �뿰�궛�떇�쓣 �닽�옄, 愿꾪샇, �뿰�궛�옄濡� 援щ퀎 �븳 �뮘 RPN 硫붿냼�뱶瑜� �씠�슜�빐
    	 *  �썑�쐞�떇�쓽 蹂��솚 諛� �뿰�궛�쓣 �닔�뻾�븯怨� 寃곌낵媛믪쓣 諛섑솚�븯�뒗 �겢�옒�뒪�씠�떎.
    	 */
char[] chararray = exp.toCharArray(); // �뿰�궛�떇�쓣 �쟾遺� char �삎�쑝濡� �븯�굹�븯�굹 履쇨컻�넃�쓬.
    	
//    	for(int j=0;j<exp.length();j++){
//    		System.out.println(chararray[j]);
//    	} //�옒 �굹�삤�굹 �뀒�뒪�듃 -> �옒 �맖.
    	
    	sentence = new String[exp.length()];//�뿰�궛�떇�쓣 string�쑝濡� 蹂��솚�븳 �뮘 ���옣�븷 �븿�닔
    	array = new ArrayList();//履쇨컻吏� �뿰�궛�떇�쓣 ���옣�븷 ArrayList
    	
    	for(int i3=0;i3<exp.length();i3++){
    		array.add(chararray[i3]);
    	}//履쇨컻�씤 �뿰�궛�떇�쓣 �븯�굹�븳 �꽔�뒗�떎.
    	
    	int i2=0;//�썑�쐞�떇 諛곗뿴�쓽 �씤�뜳�뒪瑜� �몴�쁽�븷 蹂��닔
    	while(!(array.isEmpty())){//�뼱�젅�씠由ъ뒪�듃�뿉 �썝�냼媛� �엳�쓣 �룞�븞
    		String test_s;
    		if("0123456789".indexOf(Character.toString(array.get(0)))>=0){//留뚯빟 �씠踰덉뿉 �뱾�뼱�삩 char�쓽 媛믪씠 �닽�옄�씪硫�
    			//�씠 �떎�쓬 媛믩룄 �닽�옄 �씤吏� �솗�씤�븳�떎. 留뚯빟 10�씠 �뱾�뼱�솕�떎硫�, 1�쓣 test_s�뿉 ���옣�븯怨� 洹� �뮘 0�쓣 1�뿉 遺숈뿬 ���옣�븯湲� �쐞�븳 �솗�씤�씠�떎.
    			test_s = Character.toString(array.remove(0));//char媛믪쓣 string�쑝濡� 蹂��솚
    			if(!array.isEmpty()){
        			while(("0123456789".indexOf(Character.toString(array.get(0)))>=0)){//�떎�쓬 媛믪씠 �닽�옄媛� �븘�땺�븣源뚯�
        				test_s += Character.toString(array.remove(0));//test_s�뿉 �떎�쓬 �닽�옄媛믪쓣 遺숈씤�떎.
        				if(array.isEmpty()){//留뚯빟 �뼱�젅�씠由ъ뒪�듃媛� 鍮꾩뼱�엳�떎硫� while臾몄쓣 �굹媛꾨떎.
        					break;
        				}
        			}//while臾몄쓽 �걹	
    			}	
    			}//if�쓽 �걹
    		else{//�썝�냼媛� �닽�옄媛� �븘�땲�씪硫� 諛붾줈 test_s�뿉 �빐�떦 媛믪쓣 ���옣�븳�떎.
    			test_s = Character.toString(array.remove(0));
    		}
    		
    		sentence[i2] = test_s;//�셿�꽦�맂 String 媛믪쓣 �썑�쐞�떇 諛곗뿴�뿉 ���옣�븳�떎.
    		i2++;//�씤�뜳�뒪 媛믪쓣 利앷��븳�떎.
    	
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
    }//�뿰�궛�옄�씤吏� �솗�씤�빐二쇰뒗 �븿�닔
    
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
    }//怨꾩궛�씠 �씠猷⑥뼱吏��뒗 �븿�닔.
    
	public int precedence(String token) {
		switch (token) {
		case "(":
			b = 0;
			break;
		case "*":// 怨깊븯湲�
			b = 2;
			break;
		case "/":// �굹�늻湲�
			b = 2;
			break;
		case "+":// �뜑�븯湲�
			b = 1;
			break;
		case "-":// 鍮쇨린
			b = 1;
			break;

		}
		return b;
	}
	
	public String[] infixToPostfix(String[] args) {//�썑�쐞�떇�쑝濡� 蹂��솚�빐二쇰뒗 �븿�닔
		a = new String[args.length];//args�쓽 湲몄씠留뚰겮�쓽 諛곗뿴 a瑜� 留뚮벉
		Stack s = new Stack();		
		
		for(int i=0;i<args.length;i++){//args�쓽 湲몄씠留뚰겮 �룎�븘媛��뒗 for臾�
			
			if(args[i]==null){
				break;
			}
			
			if(args[i].equals("(")){//�뿴由� 愿꾪샇 留뚮궗�쓣 �븣
				s.push(args[i]);
			}
			else if(args[i].equals(")")){//�떕�엺 愿꾪샇 留뚮궗�쓣 �븣
				while(!s.isEmpty()&&!(precedence((String)s.peek())==0)){
					a[c++]=(String)s.pop();
				}if(s.peek().equals("(")){
						s.pop();
					}//�뿴由� 愿꾪샇 �젣嫄�
				
			}else if(isAnOperator(args[i])){//�뿰�궛�옄�쓽 寃쎌슦
				while(!s.isEmpty()&&precedence((String)s.peek())>=precedence(args[i])){
				a[c++]=(String)s.pop();
				}s.push(args[i]);
			}//留� �쐞�쓽 �뒪�깮�씠 args[i] 蹂대떎 �뿰�궛 �닚�쐞媛� �넂�쑝硫�, pop�빐�꽌 a�뿉 ���옣. args[i]瑜� push
			
			else if(!(isAnOperator(args[i]))){//�뵾�뿰�궛�옄�쓽 寃쎌슦
				a[c++]=args[i];//諛곗뿴�뿉 ���옣
			}
		}

		while(!s.isEmpty()){
			a[c++]=(String)s.pop();
		}//�궓�븘�엳�뒗 紐⑤뱺 �썝�냼瑜� pop
		
//		System.out.print("蹂��솚�맂 �썑�쐞�떇 : ");
//		
//		for(int j=0;j<c;j++){
//			System.out.print(a[j]+" ");
//		}
//		System.out.println(" ");
		
		return a;
	}
	
	public void RPN(String[] args) {//理쒖쥌�쟻�쑝濡� 怨꾩궛 �빐二쇰뒗 硫붿냼�뱶

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
	}//RPN�쓽 �걹
    
}
