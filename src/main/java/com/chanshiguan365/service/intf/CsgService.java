package com.chanshiguan365.service.intf;

import java.util.Map;

/**
 * Created by 15082188 on 2018/12/6.
 */
public interface CsgService {
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
    Map<String, Object> queryUserAccountInfo(String account,String password);
}
