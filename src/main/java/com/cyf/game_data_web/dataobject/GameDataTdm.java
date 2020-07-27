package com.cyf.game_data_web.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@IdClass(PrimaryKey.class)
public class GameDataTdm {
    @Id
    private String _Id;

    private String GameConfigure;

    private String GameDescribe;

    private String GameDownloader;

    private String GameImg;

    @Id
    private String GameLink;
}
