package com.example.community;

import com.example.community.dao.Mapper.UserMapper;
import com.example.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    //测试Mapper，将Mapperz注入进来
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
}
