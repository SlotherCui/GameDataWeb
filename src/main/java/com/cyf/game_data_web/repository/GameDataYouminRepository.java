package com.cyf.game_data_web.repository;

import com.cyf.game_data_web.dataobject.GameDataIntegration;
import com.cyf.game_data_web.dataobject.GameDataYoumin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameDataYouminRepository extends JpaRepository<GameDataYoumin, String> {

    @Query("SELECT G from GameDataYoumin G  WHERE G.GameLink=?1")
    List<GameDataYoumin> findByGameLink(String GameLink);
}
