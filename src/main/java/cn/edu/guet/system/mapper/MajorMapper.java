package cn.edu.guet.system.mapper;

import cn.edu.guet.system.model.Major;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorMapper {
    List<Major> getMajor();
}
