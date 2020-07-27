package com.cyf.game_data_web.Bean;

import com.cyf.game_data_web.dataobject.GameDataIntegration;
import lombok.Data;

import java.util.List;

@Data
public class PageBean {
    private List<GameDataIntegration> content;
    private  Integer totalElements;
}
