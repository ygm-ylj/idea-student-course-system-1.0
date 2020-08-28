package cn.edu.guet.system.exception;

public class InsertException extends RuntimeException {
    public InsertException(){
        super();
    }
    public InsertException(String errorMessage){
        super(errorMessage);
    }
}
