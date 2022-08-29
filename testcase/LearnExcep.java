package testcase;

public class LearnExcep {

	static int x=10;
	 static int y=15;
	public static void main(String[] args) {
		int[]nums= {10,20,30};
		try {
			System.out.println(x/y);
			try {
				System.out.println(nums[3]);
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println(e);
				
		}
			catch(ArithmeticException e) {
			if(x==0) {
				System.out.println(y/1);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		}
		finally {
			System.out.println("end of the code");
		}
		

		}
	}


