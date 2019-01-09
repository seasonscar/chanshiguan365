package com.chanshiguan365.service.impl;

import com.chanshiguan365.dao.impl.CsgDaoImpl;
import com.chanshiguan365.dao.intf.CardDao;
import com.chanshiguan365.dao.intf.CsgDao;
import com.chanshiguan365.service.intf.CardService;
import com.chanshiguan365.service.intf.CsgService;
import com.chanshiguan365.util.StringUtil;
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

    public Map<String, Object> queryUserAccountInfo(String account,String password){
        return csgDao.queryUserAccountInfo(account,password);
    }

    public boolean checkAccountIsNotExist(String account){
        Map<String, Object> accountInfo=csgDao.queryUserAccountInfoByAccount(account);
        if(accountInfo!=null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean createNewAccount(String account,String password){
        Map<String, Object> m=csgDao.insertCsgInfo();
        String csgId=(String) m.get("pk");
        if(StringUtil.isNullOrEmpty(csgId)){
            return false;
        }else{
            boolean ret=csgDao.insertAccountInfo(account,password,csgId);
            return ret;
        }
    }

    public void setCsgDao(CsgDao csgDao) {
        this.csgDao = csgDao;
    }
}
