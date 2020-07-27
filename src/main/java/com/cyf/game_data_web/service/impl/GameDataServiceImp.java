package com.cyf.game_data_web.service.impl;

import com.cyf.game_data_web.dataobject.GameDataIntegration;
import com.cyf.game_data_web.repository.GameDataRepository;
import com.cyf.game_data_web.service.GameDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameDataServiceImp implements GameDataService {
    @Autowired
    private GameDataRepository repository;

    @Override
    public Page<GameDataIntegration> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public GameDataIntegration findOne(String _Id) {
        return repository.findById(_Id).get();
    }
}
