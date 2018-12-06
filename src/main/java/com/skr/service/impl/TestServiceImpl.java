package com.skr.service.impl;

import com.skr.dao.intf.TestDao;
import com.skr.service.intf.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by 15082188 on 2018/8/2.
 */
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    TestDao testDao;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public String queryForString() {
        Map m=jdbcTemplate.queryForMap("select * from CATS_BASE_INFO where id=1");
        return m.get("ID").toString();
    }
}
