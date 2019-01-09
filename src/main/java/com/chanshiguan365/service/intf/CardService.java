package com.chanshiguan365.service.intf;

import java.util.List;
import java.util.Map;

/**
 * Created by 15082188 on 2018/12/6.
 */

public interface CardService {
    /**
     * 查询卡片列表
     * @return
     */
    List<Map<String,Object>> queryCardList();

    List<Map<String,Object>> queryCardListByCsgId(String csgId);

    /**
     * 插入新的卡片
     * @param croperImgCode
     * @param csgId
     * @return
     */
    public boolean createCard(String croperImgCode,String csgId,String cardNote);

    public Map<String, Object> queryCardInfo(String cardId);
}
