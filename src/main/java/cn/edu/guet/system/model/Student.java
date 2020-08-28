package cn.edu.guet.system.model;

import lombok.Data;

@Data
public class Student {
    private String studentId;
    private String spassword;
    private String studentName;
    private Clazz clazz;
}
