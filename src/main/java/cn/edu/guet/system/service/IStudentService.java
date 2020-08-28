package cn.edu.guet.system.service;

import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;

import java.util.List;

public interface IStudentService {
    List<Course> getCourse(String majorid, String studentid);
    List<Major> getMajor();
    void courseSelection(String courseid, String studentid);
}
