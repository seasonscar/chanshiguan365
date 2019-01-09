package com.chanshiguan365.dao.impl;

import com.chanshiguan365.dao.intf.CardDao;
import com.chanshiguan365.dao.intf.CsgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

    private static String QUERY_ACCOUNT_INFO2 = "SELECT * FROM USER_ACCOUNT_INFO WHERE 1=1 AND ACCOUNT=?";

    private static String INSERT_ACCOUNT_INFO = "INSERT INTO  USER_ACCOUNT_INFO (ACCOUNT,PASSWORD,CSGID,CREATETIME) VALUES (?,?,?,CURRENT_TIMESTAMP)";

    private static String INSERT_CSG_INFO = "INSERT INTO  CSG_BASE_INFO (CREATETIME) VALUES (CURRENT_TIMESTAMP)";

    private static String UPDATE_CSG_NAME = "UPDATE CSG_BASE_INFO SET CSGNAME=? WHERE ID=?";

    @Override
    public Map<String, Object> queryCsgInfo(String csgId) {
        Map<String, Object> result = jdbcTemplate.queryForMap(QUERY_CSG_INFO, csgId);
        return result;
    }

    @Override
    public Map<String, Object> queryUserAccountInfo(String account, String password) {
        List<Map<String, Object>> l = jdbcTemplate.queryForList(QUERY_ACCOUNT_INFO, account, password);
        if (l.size() == 0) {
            return null;
        } else {
            return l.get(0);
        }
    }

    @Override
    public Map<String, Object> queryUserAccountInfoByAccount(String account) {
        List<Map<String, Object>> l = jdbcTemplate.queryForList(QUERY_ACCOUNT_INFO2, account);
        if (l.size() == 0) {
            return null;
        } else {
            return l.get(0);
        }
    }

    @Override
    public Map<String, Object> insertCsgInfo() {
        Map<String, Object> retMap = new HashMap<>();
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(INSERT_CSG_INFO, Statement.RETURN_GENERATED_KEYS);
                return ps;
            }
        };
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int result = jdbcTemplate.update(preparedStatementCreator, keyHolder);
        retMap.put("pk", keyHolder.getKey().toString());
        return retMap;
    }

    @Override
    public boolean insertAccountInfo(String accunt, String password, String csgId) {
        Map<String, Object> paramMap = new HashMap();
        int r = jdbcTemplate.update(INSERT_ACCOUNT_INFO, accunt, password, csgId);
        return r == 1 ? true : false;
    }

    @Override
    public boolean updateCsgName(String csgId,String csgName){
        if(csgId==null||csgId==""){
            return false;
        }
        Map<String, Object> paramMap = new HashMap();
        int r = jdbcTemplate.update(UPDATE_CSG_NAME,csgName,csgId);
        return r == 1 ? true : false;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
