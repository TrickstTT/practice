package com.hehe.myshop2.module.user.mapper.test;

import com.hehe.myshop2.module.user.entity.TbUser;
import com.hehe.myshop2.module.user.mapper.TbUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml"})
public class UserMapperTest {
    @Autowired
    private TbUserMapper tbUserMapper;

    @Test
    public void testInsert(){
        TbUser tbUser = new TbUser();
        tbUser.setId(88L);
        tbUser.setUsername("Tom");
        tbUser.setPassword("123456");
        tbUser.setEmail("3434343434@qq.com");
        tbUser.setPassword("13131313131");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        tbUserMapper.insert(tbUser);
    }
}
