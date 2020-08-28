package cn.edu.guet.system.exception;

public class PermissionException extends RuntimeException {
    public PermissionException(){
        super();
    }
    public PermissionException(String errorMessage){
        super(errorMessage);
    }
}
