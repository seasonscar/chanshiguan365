package com.chanshiguan365.dao.intf;


import java.util.List;
import java.util.Map;

/**
 * Created by 15082188 on 2018/12/6.
 */
public interface CsgDao {
    /**
     * 查询铲屎官信息
     * @param csgId
     * @return
     */
    Map<String,Object> queryCsgInfo(String csgId);

    /**
     * 查询账户信息
     * @param account
     * @param password
     * @return
     */

    public Map<String, Object> queryUserAccountInfo(String account,String password);
}
