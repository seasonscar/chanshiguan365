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
    private static String QUERY_CARD_LIST_BY_CSGID = "SELECT * FROM CARD_BASE_INFO WHERE 1=1 AND  CSGID=? ORDER BY CREATETIME DESC";
    private static String QUERY_CARD_LIST_BY_CATID = "SELECT * FROM CARD_BASE_INFO WHERE 1=1 AND  CATID=?";
    private static String QUERY_CARD_LIST2 ="SELECT T1.ID,CARDPHOTO,CARDNOTE,CSGPHOTO,CSGNAME,CSGID,CSGTITLE FROM CARD_BASE_INFO T1 LEFT JOIN CSG_BASE_INFO T2 ON T1.CSGID=T2.ID ORDER BY T1.CREATETIME DESC limit 8";
    private static String INSERT_CARD_INFO ="INSERT INTO CARD_BASE_INFO(CSGID,CARDPHOTO,CARDNOTE,CREATETIME) VALUES (?,?,?,CURRENT_TIMESTAMP)";
    private static String QUERY_CARD_INFO="SELECT CSGID,CARDNOTE,CSGPHOTO,CSGTITLE,CSGNAME,CSGCONST FROM CARD_BASE_INFO T1 LEFT JOIN CSG_BASE_INFO T2  ON T1.CSGID=T2.ID WHERE T1.ID=?";
    @Override
    public List<Map<String, Object>> queryCardList() {
        Map<String, Object> paramMap=new HashMap();
        List<Map<String, Object>> result = jdbcTemplate.queryForList(QUERY_CARD_LIST2);
        return result;
    }

    @Override
    public List<Map<String, Object>> queryCardListByCsgId(String csgID) {
        Map<String, Object> paramMap=new HashMap();
        List<Map<String, Object>> result = jdbcTemplate.queryForList(QUERY_CARD_LIST_BY_CSGID,csgID);
        return result;
    }

    @Override
    public List<Map<String, Object>> queryCardListByCatId(String catID) {
        Map<String, Object> paramMap=new HashMap();
        List<Map<String, Object>> result = jdbcTemplate.queryForList(QUERY_CARD_LIST_BY_CATID,catID);
        return result;
    }

    @Override
    public boolean insertCardInfo(String csgId,String cardPhoto,String cardNote) {
        Map<String, Object> paramMap=new HashMap();
        int r=jdbcTemplate.update(INSERT_CARD_INFO,csgId,cardPhoto,cardNote);
        return r==1?true:false;
    }

    @Override
    public Map<String, Object> queryCardInfo(String cardId) {
        Map<String, Object> result = jdbcTemplate.queryForMap(QUERY_CARD_INFO, cardId);
        return result;
    }
}
