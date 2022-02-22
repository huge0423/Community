package com.example.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class TestdaoMybatismpl implements testdao {
    @Override
    public String selectAll() {
        return "Mybatis";
    }
}
