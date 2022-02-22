package com.example.community.dao.Mapper;

import com.example.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
//@Repository
public interface UserMapper {

    User selectById(int id);

    User selectByUserName(String username);

    User selectByEmail(String email);

    //插入的行数
    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String HeaderUrl);

    int updatePassword(int id, String password);
}
