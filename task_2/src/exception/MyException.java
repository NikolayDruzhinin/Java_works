package exception;

public class MyException extends Exception{
	public enum errorCodes {
		INCORRECT_VALUE,
		ZERO_DIVISION,
		MATRIX_SIZE,
		NO_FILE,
		NO_PERM
		};
	
	private errorCodes error;
	
	public MyException(errorCodes error) {
		this.error = error;
	}
	
	public String toString() {
		String detail;
		
		switch (error) {
		case INCORRECT_VALUE:
			detail = "Incorrect value error";
			break;
		case ZERO_DIVISION:
			detail = "Zero division error";
			break;
		case MATRIX_SIZE:
			detail = "Matrix size is too big";
			break;
		case NO_FILE:
			detail = "An input file doesn't exist";
			break;
		case NO_PERM:
			detail = "Can't read an input file";
			break;
		default:
			detail = "Error undefined";
			break;
		}
		
		return "Exception [" + detail + "]";
	}
}
