package testcase;

public class LearnThrow {
	
	public void div() {
		int num1 = 0,num2 = 0;
		if(num1>num2) {
			System.out.println(num1/num2);
		}else {
			throw new ArithmeticException("the number  not divide");
		}

	}
	

	public static void main(String[] args) {
		 LearnThrow obj=new  LearnThrow();
		try {
		 obj.div();
		}catch(Exception e){
			System.out.println(e);
			
		}
		System.out.println("output");
	}

}
