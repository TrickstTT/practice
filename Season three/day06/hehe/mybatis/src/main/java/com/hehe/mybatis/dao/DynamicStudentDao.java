package com.hehe.mybatis.dao;

import com.hehe.mybatis.entity.Student;

import java.util.List;

public interface DynamicStudentDao {
    public List<Student> DynamicSearchStudent(Student param);

    public List<Student> selectByWhere(Student param);

    public List<Student> selectByChoose(Student param);

    public List<Student> selectByArray(Long[] ids);

    public List<Student> selectByNormalList(List<Long> ids);
}
