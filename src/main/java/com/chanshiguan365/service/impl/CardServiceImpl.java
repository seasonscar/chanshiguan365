package com.chanshiguan365.service.impl;

import com.chanshiguan365.dao.intf.CardDao;
import com.chanshiguan365.service.intf.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 15082188 on 2018/12/6.
 */
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardDao cardDao;
    @Override
    public List<Map<String, Object>> queryCardList() {
        List<Map<String, Object>> result=cardDao.queryCardList();
        return result;
    }
}
