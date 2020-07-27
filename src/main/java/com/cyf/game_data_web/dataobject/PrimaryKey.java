package com.cyf.game_data_web.dataobject;

import lombok.Data;

import java.io.Serializable;

@Data
class  PrimaryKey implements Serializable {

    private String GameLink;

    private String _Id;
}
