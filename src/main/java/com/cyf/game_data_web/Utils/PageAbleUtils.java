package com.cyf.game_data_web.Utils;

import com.cyf.game_data_web.VO.ResultVOUtil;
import com.cyf.game_data_web.dataobject.GameDataIntegration;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class PageAbleUtils {
    public  static <T>PageImpl Paged(Pageable pageable,List<T> GameDatas){
        if (pageable.getOffset() > GameDatas.size()) {
            long total = 0L;
            PageImpl<GameDataIntegration> emptyPage = new PageImpl<GameDataIntegration>(new ArrayList<GameDataIntegration>(), pageable, total);
            return emptyPage;
        }

        if (pageable.getOffset() <= GameDatas.size() && pageable.getOffset() + pageable.getPageSize() > GameDatas.size()) {
            List<T> GameSearchPage = GameDatas.subList((int)pageable.getOffset(), GameDatas.size());
            PageImpl<T> pPage = new PageImpl<T>(GameSearchPage, pageable, GameDatas.size());
            return pPage;
        }

        List<T> GameSearchPage = GameDatas.subList((int)pageable.getOffset(), (int)pageable.getOffset() + pageable.getPageSize());
        PageImpl<T> pPage = new PageImpl<T>(GameSearchPage, pageable, GameDatas.size());
        return pPage;
    }
}
