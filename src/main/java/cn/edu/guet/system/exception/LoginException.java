package cn.edu.guet.system.exception;

public class LoginException extends RuntimeException {
    public LoginException(){
        super();
    }
    public LoginException(String errorMessage){
        super(errorMessage);
    }
}