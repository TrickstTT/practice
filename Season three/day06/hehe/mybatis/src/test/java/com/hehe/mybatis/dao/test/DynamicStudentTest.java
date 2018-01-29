package com.hehe.mybatis.dao.test;

import com.hehe.mybatis.dao.DynamicStudentDao;
import com.hehe.mybatis.entity.Student;
import com.hehe.mybatis.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DynamicStudentTest {
    SqlSession sqlSession = null;
    DynamicStudentDao dynamicStudentDao = null;
    @Before
    public void befor(){
        sqlSession = MybatisUtil.getSqlSession();
        dynamicStudentDao = sqlSession.getMapper(DynamicStudentDao.class);
    }
    @Test
    public void testDynamicSearchStudent(){
        Student param = new Student();
//        param.setName("赵气");
        param.setAge(23);
        List<Student> list = dynamicStudentDao.DynamicSearchStudent(param);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectByWhere(){
        Student param = new Student();
//        param.setName("赵气");
//        param.setAge(23);
        List<Student> list = dynamicStudentDao.selectByWhere(param);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectByChoose(){
        Student param = new Student();
//        param.setName("赵气");
//        param.setAge(23);
        List<Student> list = dynamicStudentDao.selectByChoose(param);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectByArray(){
        Long[] ids = {2L, 4L, 8L};
        List<Student> students = dynamicStudentDao.selectByArray(ids);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectByNormalList(){
        List<Long> ids = new ArrayList<>();
        ids.add(2L);
        ids.add(4L);
        ids.add(7L);
        List<Student> students = dynamicStudentDao.selectByNormalList(ids);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @After
    public void after(){
        if(sqlSession != null){
            sqlSession.close();
        }
    }
}
