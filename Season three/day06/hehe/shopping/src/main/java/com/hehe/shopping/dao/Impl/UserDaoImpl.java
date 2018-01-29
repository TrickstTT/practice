package com.hehe.shopping.dao.Impl;

import com.hehe.shopping.dao.UserDao;
import com.hehe.shopping.entity.User;
import com.hehe.shopping.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao{
    @Override
    public User selectUserByUsernameAndPassword(User user) {
        User resultUser = null;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        resultUser = sqlSession.selectOne("selectUserByUsernameAndPassword", user);
        sqlSession.commit();
        sqlSession.close();
        return resultUser;
    }
}
