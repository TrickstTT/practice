package com.hehe.mybatis.dao;

import com.hehe.mybatis.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    public void insert(Student student);

    public void deleteById(Long id);

    public void update(Student student);

    public void insertForId(Student student);

    public List<Student> selectAll();

    public Map<String,Object> selectAllForMap();

}
