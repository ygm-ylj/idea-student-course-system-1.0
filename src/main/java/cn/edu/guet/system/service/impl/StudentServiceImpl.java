package cn.edu.guet.system.service.impl;

import cn.edu.guet.system.exception.InsertException;
import cn.edu.guet.system.mapper.MajorMapper;
import cn.edu.guet.system.mapper.StudentMapper;
import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    MajorMapper majorMapper;



    @Override
    public List<Course> getCourse(String majorid, String studentid) {
        List<Course> courseList=studentMapper.getCourse(majorid,studentid);
        return courseList;
    }

    @Override
    public List<Major> getMajor() {
        List<Major> majorList=majorMapper.getMajor();
        return majorList;
    }

    @Override
    public void courseSelection(String courseid, String studentid) throws DuplicateKeyException {
        try{
            studentMapper.courseSelection(courseid,studentid);
        }
        catch (DuplicateKeyException e){
            throw new InsertException("这门课已被选择");
        }

    }
}
