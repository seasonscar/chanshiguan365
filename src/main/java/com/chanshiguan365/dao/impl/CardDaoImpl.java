package com.chanshiguan365.dao.impl;

import com.chanshiguan365.dao.intf.CardDao;
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
public class CardDaoImpl implements CardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String QUERY_CARD_LIST = "SELECT * FROM CARD_BASE_INFO WHERE 1=1";
    private static String QUERY_CARD_LIST2 ="SELECT CARDPHOTO,CSGPHOTO,CSGNAME,CSGID,CSGTITLE FROM CARD_BASE_INFO T1 LEFT JOIN CSG_BASE_INFO T2 ON T1.CSGID=T2.ID";

    @Override
    public List<Map<String, Object>> queryCardList() {
        Map<String, Object> paramMap=new HashMap();
        List<Map<String, Object>> result = jdbcTemplate.queryForList(QUERY_CARD_LIST2);
        return result;
    }
}