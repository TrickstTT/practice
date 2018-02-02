package com.trickster.addmybatis;

import com.trickster.addmybatis.entity.Channel;
import com.trickster.addmybatis.mapper.ChannelMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddMybatisApplicationTests {
	@Autowired
	ChannelMapper channelMapper;

	@Test
	public void contextLoads() {
		List<Channel> channels = channelMapper.selectAll();
		System.out.println(channels);
	}

}
