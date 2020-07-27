package com.cyf.game_data_web.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class GameDataIntegration {
    @Id
    private String _Id;
    /*游戏名*/
    private String GameName;
    /*游戏英文名*/
    private String GameNameEng;
    /*游戏图片链接*/
    private String GameImg;
    /*游戏发行方*/
    private String GameAuthor;
    /* 游戏总人数*/
    private  Integer GameSumPlayer;
    /* 游戏平均分*/
    private Double GameAvgScore;
    /* 游戏时长*/
    private String GameTime;
    /* 游戏类型*/
    private  String GameType;
    /*steam链接*/
    private String SteamLink;
    /*3dm链接*/
    private String TdmLink;
    /*游民众评链接*/
    private String YouminLink;

}
