package com.cyf.game_data_web.Controller;


import com.cyf.game_data_web.Bean.DescribeBean;
import com.cyf.game_data_web.Bean.DetailBean;
import com.cyf.game_data_web.Bean.PageBean;
import com.cyf.game_data_web.Bean.SearchBean;
import com.cyf.game_data_web.Utils.PageAbleUtils;
import com.cyf.game_data_web.VO.ResultVO;
import com.cyf.game_data_web.VO.ResultVOUtil;
import com.cyf.game_data_web.dataobject.GameDataIntegration;
import com.cyf.game_data_web.service.GameDataService;
import com.cyf.game_data_web.service.GameSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private GameSearchService gameSearchService;

    @Autowired
    private GameDataService gameDataService;

    @GetMapping("/searchByName")
    public ResultVO<List<GameDataIntegration>> searchByName(String name,Integer page){

        //搜素全部
        if (name.equals("")){
            Pageable pageable = new PageRequest(page,10, Sort.Direction.ASC,"_Id");
            Page<GameDataIntegration> page_able = gameDataService.findAll(pageable);
            return ResultVOUtil.success(page_able);
        }

        //按名称搜索名称
        List<GameDataIntegration> GameDatas = gameSearchService.findGameDataWithPartOfName(name);
        Pageable pageable = new PageRequest(page,10, Sort.Direction.ASC,"_Id");

        //分页
        PageImpl<GameDataIntegration> pPage = PageAbleUtils.Paged(pageable,GameDatas);

        return ResultVOUtil.success(pPage);

    }


    @PostMapping("/search")
    public ResultVO<List<GameDataIntegration>> searchByCombine(@RequestBody SearchBean searchBean){
        System.out.println(searchBean);
        // 根据游戏类型/时间/发行方查询
        List<GameDataIntegration> GameDatas = gameSearchService.findGameDataByQuerys(searchBean.getQuerys());

        // 分页
        Pageable pageable = new PageRequest(searchBean.getPage(),10, Sort.Direction.ASC,"_Id");
        PageImpl<GameDataIntegration> pPage = PageAbleUtils.Paged(pageable,GameDatas);

        // 将结果返回
        return ResultVOUtil.success(pPage);
    }

    @PostMapping("/detail")
    public ResultVO<DetailBean> searchDetail(@RequestBody String [] links){

        return ResultVOUtil.success(gameSearchService.findGameFullDetail(links));
    }


    @PostMapping("/searchByDesc")
    public ResultVO<DetailBean> searchDetail(@RequestBody DescribeBean describeBean){
        System.out.println(describeBean);
        PageBean pageBean = gameSearchService.findGameDataByDesc(describeBean.getDesc(),describeBean.getDatasrc(),describeBean.getPage());
        return ResultVOUtil.success(pageBean);
    }


}
