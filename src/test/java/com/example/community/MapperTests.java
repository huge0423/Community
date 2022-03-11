//package com.example.community;
//
//import com.example.community.dao.Mapper.DiscussPostMapper;
//import com.example.community.dao.Mapper.UserMapper;
//import com.example.community.entity.DiscussPost;
//import com.example.community.entity.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import java.util.List;
//
//@SpringBootTest
//@ContextConfiguration(classes = CommunityApplication.class)
//public class MapperTests {
//
//    //测试Mapper，将Mapperz注入进来
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private DiscussPostMapper discussPostMapper;
//
//    @Test
//    public void testSelectUser() {
//        User user = userMapper.selectById(1);
//        System.out.println(user);
//    }
//
//    @Test void testSelectDiscussPost() {
//        List<DiscussPost> discussPostsList = discussPostMapper.selectDiscussPosts(0,0,10);
//        for (DiscussPost discussPost : discussPostsList) {
//            System.out.println(discussPost);
//        }
//
//        int rows = discussPostMapper.selectDiscussPostRows(0);
//        System.out.println(rows);
//    }
//}
