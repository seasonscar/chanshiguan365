package com.chanshiguan365.service.impl;

import com.chanshiguan365.dao.intf.CardDao;
import com.chanshiguan365.dao.intf.CsgDao;
import com.chanshiguan365.service.intf.CardService;
import com.chanshiguan365.service.intf.CsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 15082188 on 2018/12/6.
 */
@Service
public class CsgServiceImpl implements CsgService {
    @Autowired
    CsgDao csgDao;

    @Override
    public Map<String, Object> queryCsgInfo(String csgId) {
        return csgDao.queryCsgInfo(csgId);
    }
}
