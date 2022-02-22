package com.example.community.dao;

import org.springframework.stereotype.Repository;

@Repository("testHibernate")
public class TestdaoHibernateImpl implements testdao {
    @Override
    public String selectAll() {
        return "Hibernate";
    }
}
