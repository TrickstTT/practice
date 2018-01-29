package com.hehe.mybatis.dao.impl;

import com.hehe.mybatis.dao.StudentDao;
import com.hehe.mybatis.entity.Student;
import com.hehe.mybatis.utils.MybatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void insert(Student student) {
        //oldMethod(student, sqlSession);
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        sqlSession.insert("insert",student);
        sqlSession.commit();
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        sqlSession.insert("deleteById",id);
        sqlSession.commit();
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    @Override
    public void update(Student student) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        sqlSession.update("update",student);
        sqlSession.commit();
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    @Override
    public void insertForId(Student student) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        sqlSession.insert("insertForId",student);
        sqlSession.commit();
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

    @Override
    public List<Student> selectAll() {
        List<Student> list = new ArrayList<>();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        list = sqlSession.selectList("selectAll");
        sqlSession.commit();
        if(sqlSession!=null){
            sqlSession.close();
        }
        return list;
    }

    @Override
    public Map<String, Object> selectAllForMap() {
        Map<String, Object> map = new HashMap<>();
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        if(sqlSession!=null){
            map =sqlSession.selectMap("selectAll","name");
            sqlSession.commit();
            sqlSession.close();
        }
        return map;
    }

    private void oldMethod(Student student, SqlSession sqlSession) {
        try {
            //获取资源
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //创建工sqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //创建SqlSession对象
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("insert",student);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
