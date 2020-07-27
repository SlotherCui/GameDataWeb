package com.cyf.game_data_web.service;

import com.cyf.game_data_web.Bean.DetailBean;
import com.cyf.game_data_web.Bean.PageBean;
import com.cyf.game_data_web.dataobject.GameDataIntegration;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameSearchService {

    List<GameDataIntegration> findGameDataWithPartOfName(String gamename);      // 根据名称找游戏

    List<GameDataIntegration> findGameDataByQuerys(String [] querys);          // 根据特征找游戏

    DetailBean findGameFullDetail(String [] links);      //获取游戏详细数据

    PageBean findGameDataByDesc(String desc, String dataSrc, int page);  //根据游戏匹配
}
