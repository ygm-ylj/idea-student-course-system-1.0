package cn.edu.guet.system.util;


public class GetRole {
    public static String getRole(String username){
        String roleid=null;
        if (username.length()==6){
            roleid="R002";
        }
        else if (username.length()==10){
            roleid="R001";
        }
        else if ("17007".equals(username)){
            roleid="R003";
        }
        return roleid;
    }
}
