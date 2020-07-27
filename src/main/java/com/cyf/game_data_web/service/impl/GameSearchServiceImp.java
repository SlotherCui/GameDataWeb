package com.cyf.game_data_web.service.impl;

import com.cyf.game_data_web.Bean.DetailBean;
import com.cyf.game_data_web.Bean.PageBean;
import com.cyf.game_data_web.dataobject.GameDataIntegration;
import com.cyf.game_data_web.dataobject.GameDataSteam;
import com.cyf.game_data_web.dataobject.GameDataTdm;
import com.cyf.game_data_web.dataobject.GameDataYoumin;
import com.cyf.game_data_web.repository.GameDataSteamRepository;
import com.cyf.game_data_web.repository.GameDataTdmRepository;
import com.cyf.game_data_web.repository.GameDataYouminRepository;
import com.cyf.game_data_web.repository.GameSearchRepository;
import com.cyf.game_data_web.service.GameSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GameSearchServiceImp implements GameSearchService {


    @Autowired
    private GameSearchRepository gameSearchRepository;

    @Autowired
    private GameDataYouminRepository gameDataYouminRepository;

    @Autowired
    private GameDataSteamRepository gameDataSteamRepository;

    @Autowired
    private GameDataTdmRepository gameDataTdmRepository;

    @Override
    public List<GameDataIntegration> findGameDataWithPartOfName(String gamename) {
        return gameSearchRepository.findGameDataWithPartOfName(gamename);
    }

    @Override
    public List<GameDataIntegration> findGameDataByQuerys(String[] querys) {
        return gameSearchRepository.
                findGameDataByQuerys(querys[0], querys[1],querys[2],
                                        Double.parseDouble(querys[3]),Double.parseDouble(querys[4]),
                                        Integer.parseInt(querys[5]),Integer.parseInt(querys[6]));
    }

    /**
     * 获得全部详细数据
     * @param links
     * @return
     */
    @Override
    public DetailBean findGameFullDetail(String[] links) {
        String steam_link = links[0];
        String tdm_link = links[1];
        String youmin_link = links[2];

        DetailBean detailBean = new DetailBean();
        if (steam_link!=null){
            List<GameDataSteam> steamData = gameDataSteamRepository.findByGameLink(steam_link);
            if (steamData.size()>0)
                detailBean.setGameDataSteam(steamData.get(0));
        }

        if (tdm_link!=null){
            List<GameDataTdm> tdmData = gameDataTdmRepository.findByGameLink(tdm_link);
            if (tdmData.size()>0)
                detailBean.setGameDataTdm(tdmData.get(0));
        }
        if(youmin_link!=null){

            List<GameDataYoumin> youminData = gameDataYouminRepository.findByGameLink(youmin_link);
            if (youminData.size()>0)
                detailBean.setGameDataYoumin(youminData.get(0));
        }

        return detailBean;
    }

    @Override
    public PageBean findGameDataByDesc(String desc, String dataSrc, int page) {
        PageBean pageBean = new PageBean();

        switch (dataSrc){
            case "steam":
                pageBean.setContent(gameSearchRepository.findGameDataBySteamDesc(desc,page*10));
                pageBean.setTotalElements(gameSearchRepository.findGameDataBySteamDescTotal(desc));
                return pageBean;
            case "youmin":
                pageBean.setContent(gameSearchRepository.findGameDataByYouMinDesc(desc,page*10));
                pageBean.setTotalElements(gameSearchRepository.findGameDataByYouminDescTotal(desc));
                return pageBean;
            case "3dm":
                pageBean.setContent(gameSearchRepository.findGameDataBy3dmDesc(desc,page*10));
                pageBean.setTotalElements(gameSearchRepository.findGameDataByTdmDescTotal(desc));
                return pageBean;
        }

        return pageBean;
    }


}
