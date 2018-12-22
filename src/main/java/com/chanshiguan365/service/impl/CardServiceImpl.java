package com.chanshiguan365.service.impl;

import com.chanshiguan365.dao.intf.CardDao;
import com.chanshiguan365.service.intf.CardService;
import com.chanshiguan365.util.Base64Util;
import com.chanshiguan365.util.StringUtil;
import com.chanshiguan365.util.PropUtil;
import com.chanshiguan365.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by 15082188 on 2018/12/6.
 */
@Service
public class CardServiceImpl implements CardService {
    private static final  String PATH=PropUtil.getProperty("image_path");
    @Autowired
    CardDao cardDao;
    @Override
    public List<Map<String, Object>> queryCardList() {
        List<Map<String, Object>> result=cardDao.queryCardList();
        return result;
    }

    @Override
    public boolean createCard(String csgId,String croperImgCode) {
        if(StringUtil.isNullOrEmpty(croperImgCode)||croperImgCode.length()<23){
            return false;
        }
        croperImgCode=croperImgCode.substring(23);
        byte[] b= Base64Util.GenerateImage(croperImgCode,PATH);
        String imgName= UUIDGenerator.getUUID()+".jpg";
        String imgFilePath = PATH+imgName;//新生成的图片
        cardDao.insertCardInfo(csgId,imgName);
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
