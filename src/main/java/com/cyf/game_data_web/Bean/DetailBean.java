package com.cyf.game_data_web.Bean;

import com.cyf.game_data_web.dataobject.GameDataSteam;
import com.cyf.game_data_web.dataobject.GameDataTdm;
import com.cyf.game_data_web.dataobject.GameDataYoumin;
import lombok.Data;

@Data
public class DetailBean {

    private GameDataTdm gameDataTdm;
    private GameDataSteam gameDataSteam;
    private GameDataYoumin gameDataYoumin;
}
