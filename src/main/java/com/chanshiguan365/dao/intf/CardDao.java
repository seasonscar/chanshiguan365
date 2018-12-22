package com.chanshiguan365.dao.intf;


import java.util.List;
import java.util.Map;

/**
 * Created by 15082188 on 2018/12/6.
 */
public interface CardDao {
    /**
     * 查询卡片列表
     * @return
     */
    List<Map<String,Object>> queryCardList();

    /**
     * 保存卡片信息
     * @param csgId
     * @param cardphoto
     * @return
     */
    public boolean insertCardInfo(String csgId,String cardphoto);
}
