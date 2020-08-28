package cn.edu.guet.system.model;

import lombok.Data;

@Data
public class Course {
    private String courseId;
    private String courseName;
    private Major major;
    private Teacher teacher;
}
