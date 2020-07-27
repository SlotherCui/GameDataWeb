package com.cyf.game_data_web.repository;

import com.cyf.game_data_web.dataobject.GameDataIntegration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameDataRepository  extends JpaRepository<GameDataIntegration, String> {
//    List<GameDataIntegration> findByCategoryTypeIn(List<Integer>categoryTypeList);
}
