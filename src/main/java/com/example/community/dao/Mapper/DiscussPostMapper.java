package com.example.community.dao.Mapper;

import com.example.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //查询用户的帖子，分页，offect每一页起始行的行号
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //查询帖子的总数,首页时一般不分页,起别名
    int selectDiscussPostRows(@Param("userId") int userId);
}
