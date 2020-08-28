package cn.edu.guet.system.model;

import lombok.Data;

@Data
public class Teacher {
    private String teacherId;
    private String tpassword;
    private String teacherName;
    private School school;
}
