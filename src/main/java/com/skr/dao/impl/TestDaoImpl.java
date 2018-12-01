package com.skr.dao.impl;

import com.skr.dao.intf.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by 15082188 on 2018/8/2.
 */

@Repository
public class TestDaoImpl implements TestDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String queryForString(){
        String sql="select * from app_config";
        jdbcTemplate.queryForList("");
        return "ss";
    }
}
