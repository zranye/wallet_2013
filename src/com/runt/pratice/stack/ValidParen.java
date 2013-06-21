package com.runt.pratice.stack;

/**
 * stack的括号匹配练习
 * @author zrany_000
 *
 */
public class ValidParen {
	
	static int size = 0;
	
	/**
	 * 计算传进字符串内，最长的有效括号内子括号的长度
	 * 
	 * 例如对于"( ()"，最长的有效的括号中的子字符串是"()" ，有效双括号数1个，故它的长度为 2。  
	 * 再比如对于字符串") () () )"，其中最长的有效的括号中的子字符串是"() ()"，有效双括号数2个，故它的长度为4。
	 * 
	 * @param s 传进的字符串
	 * @return
	 * 
	 * @author yeziran Jun 21, 2013
	 */
	public static int longestValidParentheses(String s){
		int  len =0, tmpLen=0, tmpIdx=0;
		len = s.length();
		Stack stack = new Stack();
		while(tmpIdx < len ){
			char ch = s.charAt(tmpIdx++);
			if(ch == '('){
				stack.push();
			} else if( ch == ')'){
				if(stack.size != 0){
					stack.pop();
				}else{
					tmpLen = tmpLen > stack.validSize ? tmpLen : stack.validSize;
					stack.clear();
				}
			}
		}
		//当左右括号正好匹配的时候，tmpLen一直为0，所以这里也要赋值一次
		tmpLen = tmpLen > stack.validSize ? tmpLen : stack.validSize;
		return tmpLen;
	}
	
	public static void main(String[] args) {
		int length = longestValidParentheses("()())((((()))");
		System.out.println("有效长度为： " + length);
	}

}

class Stack {
	
	int size;
	int validSize;
	
	void push(){
		size += 1;
	}
	
	void pop(){
		size -= 1;
		validSize += 2;
	}
	
	void clear(){
		size = 0;
		validSize = 0;
	}
}
