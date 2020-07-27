package com.cyf.game_data_web.repository;

import com.cyf.game_data_web.dataobject.GameDataTdm;
import com.cyf.game_data_web.dataobject.GameDataYoumin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameDataTdmRepository extends JpaRepository<GameDataTdm, String> {

    @Query("SELECT G from GameDataTdm G  WHERE G.GameLink=?1")
    List<GameDataTdm> findByGameLink(String GameLink);
}
