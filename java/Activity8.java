package fst;

class CustomException extends Exception {
	private String message = null;
	
	public CustomException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		System.out.println("Throwing custom exception: ");
		return message;
	}
	
}


public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Inside try block");
			Activity8.exceptionTest("Test method to check.");
			Activity8.exceptionTest(null);
		}
		catch(CustomException e) {
	
            System.out.println("Inside catch block: " + e.getMessage());
	
        }
	}
		
		static void exceptionTest(String str) throws CustomException {
			if (str == null) {
				throw new CustomException("'String value is null.'");
			}else {
				System.out.println(str);
			}
		
	}

}
