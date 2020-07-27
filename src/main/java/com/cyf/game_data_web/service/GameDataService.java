package com.cyf.game_data_web.service;

import com.cyf.game_data_web.dataobject.GameDataIntegration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GameDataService {
    Page<GameDataIntegration> findAll(Pageable pageable);
    GameDataIntegration findOne(String _Id);
}
