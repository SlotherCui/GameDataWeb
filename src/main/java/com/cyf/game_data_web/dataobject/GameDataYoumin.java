package com.cyf.game_data_web.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@Entity
@IdClass(PrimaryKey.class)
public class GameDataYoumin {

    @Id
    private  String _Id;

    private  String GamePlayTime;

    private  String GameDescribe;

    private  String GameImg;

    @Id
    private  String GameLink;

    private String GamePlayerComments;

    private String GameStrategys;

    private String GameTags;

}
