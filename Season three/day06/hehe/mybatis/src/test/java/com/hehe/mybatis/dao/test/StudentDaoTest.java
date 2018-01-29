package com.hehe.mybatis.dao.test;

import com.hehe.mybatis.dao.StudentDao;
import com.hehe.mybatis.dao.impl.StudentDaoImpl;
import com.hehe.mybatis.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StudentDaoTest {
    StudentDao studentDao = null;
    @Before
    public void before(){
        studentDao = new StudentDaoImpl();
    }

    @Test
    public void testInsert(){
        Student student = new Student("李四",24,74.5);
        studentDao.insert(student);
    }

    @Test
    public void testDeleteById(){
        studentDao.deleteById(3L);
    }

    @Test
    public void testUpdate(){
        Student student = new Student("赵柳",23,99D);
        student.setId(2L);
        studentDao.update(student);
    }

    @Test
    public void testInsertForId(){
        Student student = new Student("将气",23,32D);
        System.out.println(student);
        studentDao.insertForId(student);
        System.out.println(student);
    }

    @Test
    public void testSelectAll(){
        List<Student> list = studentDao.selectAll();
        System.out.println(list);
    }

    @Test
    public void testSelectAllForMap(){
        Map<String,Object> map = studentDao.selectAllForMap();
        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }
    }

    @Test
    public void test(){

    }
}
