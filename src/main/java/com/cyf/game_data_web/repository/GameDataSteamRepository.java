package com.cyf.game_data_web.repository;

import com.cyf.game_data_web.dataobject.GameDataSteam;
import com.cyf.game_data_web.dataobject.GameDataTdm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameDataSteamRepository  extends JpaRepository<GameDataSteam, String> {
    @Query("SELECT G from GameDataSteam G  WHERE G.GameLink=?1")
    List<GameDataSteam> findByGameLink(String GameLink);
}
