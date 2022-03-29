package Leyitner_lib;

public class MyException extends Exception{
    public enum errorCodes {
        INVALID_OPERATION_INPUT,
        INVALID_FILE_NAME
    }

    private errorCodes error;

    public MyException(errorCodes error) {
        this.error = error;
    }

    @Override
    public String toString() {
        String detail;
        switch (error) {
            case INVALID_OPERATION_INPUT -> detail = "Invalid operation code input";
            case INVALID_FILE_NAME -> detail = "Invalid file name";
            default -> detail = "Undefined error";
        }
        return "MyException{" +
                "error=" + detail +
                '}';
    }
}
