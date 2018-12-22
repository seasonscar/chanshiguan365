package com.chanshiguan365.dao.impl;

import com.chanshiguan365.dao.intf.CardDao;
import com.chanshiguan365.dao.intf.CsgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 15082188 on 2018/12/6.
 */
@Service
public class CsgDaoImpl implements CsgDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String QUERY_CSG_INFO = "SELECT * FROM CSG_BASE_INFO WHERE 1=1 AND ID=?";

    private static String QUERY_ACCOUNT_INFO = "SELECT * FROM USER_ACCOUNT_INFO WHERE 1=1 AND ACCOUNT=? AND PASSWORD=?";

    @Override
    public Map<String, Object> queryCsgInfo(String csgId) {
        Map<String, Object> result = jdbcTemplate.queryForMap(QUERY_CSG_INFO,csgId);
        return result;
    }

    @Override
    public Map<String, Object> queryUserAccountInfo(String account,String password) {
        Map<String, Object> result = jdbcTemplate.queryForMap(QUERY_ACCOUNT_INFO,account,password);
        return result;
    }
}
