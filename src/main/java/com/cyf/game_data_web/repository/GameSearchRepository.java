package com.cyf.game_data_web.repository;

import com.cyf.game_data_web.dataobject.GameDataIntegration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface GameSearchRepository  extends JpaRepository<GameDataIntegration, String> {

    /**
     * 根据游戏名称查询游戏
     * @param gamename 游戏名称
     * @return 游戏列表
     */
    @Query("SELECT G FROM GameDataIntegration G where G.GameName LIKE concat('%',?1,'%') or G.GameNameEng like concat('%',?1,'%')")
    List<GameDataIntegration> findGameDataWithPartOfName(String gamename);


    /**
     * 根据游戏类型，游戏发行时间，游戏发行方 查询游戏
     * @param gametype  游戏类型
     * @param gametime  游戏发行时间
     * @param gameauthor  游戏发行方
     * @param beginScore  分数区间
     * @param endScore
     * @param beginSumplayer 人数（热度）区间
     * @param endSumplayer
     * @return
     */
    @Query("SELECT G from GameDataIntegration G where " +
            "G.GameType LIKE concat('%',?1,'%') and " +
            "G.GameTime LIKE concat('%',?2,'%') and " +
            "G.GameAuthor LIKE concat('%',?3,'%') and " +
            "G.GameAvgScore>= ?4 and G.GameAvgScore<=?5 and " +
            "G.GameSumPlayer>= ?6 and G.GameSumPlayer<=?7 ")
    List<GameDataIntegration> findGameDataByQuerys(String gametype, String gametime, String gameauthor,
                                                   Double beginScore, Double endScore,
                                                   Integer beginSumplayer, Integer endSumplayer);





    @Query(nativeQuery=true,value ="SELECT G.* FROM game_data_integration G, " +
            "(SELECT game_data_youmin.game_link, MATCH (game_describe) AGAINST (?1 IN BOOLEAN MODE) AS score " +
            "FROM game_data_youmin WHERE MATCH (game_describe) AGAINST (?1 IN BOOLEAN MODE) ORDER BY score DESC,_id  " +
            "LIMIT ?2,10) AS x " +
            "WHERE G.youmin_link IS NOT NULL AND G.youmin_link = x.game_link " +
            "ORDER BY score DESC,_id")
    List<GameDataIntegration> findGameDataByYouMinDesc(String query,int  page);

    @Query(nativeQuery=true,value ="SELECT G.* FROM game_data_integration G,\n" +
            "(SELECT game_data_steam.game_link, MATCH (game_describe) AGAINST (?1 IN BOOLEAN MODE) AS score\n" +
            "FROM game_data_steam WHERE MATCH (game_describe) AGAINST (?1 IN BOOLEAN MODE) ORDER BY score DESC,_id\n" +
            "LIMIT ?2,10) AS x\n" +
            "WHERE G.steam_link IS NOT NULL AND G.steam_link = x.game_link\n" +
            "ORDER BY score DESC,_id")
    List<GameDataIntegration> findGameDataBySteamDesc(String query,int page);


    @Query(nativeQuery=true,value ="SELECT G.* FROM game_data_integration G,\n" +
            "(SELECT game_data_tdm.game_link, MATCH (game_describe) AGAINST (?1 IN BOOLEAN MODE) AS score\n" +
            "FROM game_data_tdm WHERE MATCH (game_describe) AGAINST (?1 IN BOOLEAN MODE) ORDER BY score DESC,_id\n" +
            "LIMIT ?2,10) AS x\n" +
            "WHERE G.tdm_link IS NOT NULL AND G.tdm_link = x.game_link\n" +
            "ORDER BY score DESC,_id")
    List<GameDataIntegration> findGameDataBy3dmDesc(String query,int page);


    @Query(nativeQuery=true, value = "SELECT count(*) FROM game_data_youmin WHERE MATCH (game_describe) AGAINST (?1 IN BOOLEAN MODE) ")
    Integer findGameDataByYouminDescTotal(String query);

    @Query(nativeQuery=true, value = "SELECT count(*) FROM game_data_steam WHERE MATCH (game_describe) AGAINST (?1 IN BOOLEAN MODE) ")
    Integer findGameDataBySteamDescTotal(String query);

    @Query(nativeQuery=true, value = "SELECT count(*) FROM game_data_tdm WHERE MATCH (game_describe) AGAINST (?1 IN BOOLEAN MODE) ")
    Integer findGameDataByTdmDescTotal(String query);


}



//SELECT
//        *
//        FROM
//        game_data_integration G
//        WHERE
//        (
//        G.youmin_link IS NOT NULL
//        AND G.youmin_link IN (
//        SELECT
//        game_data_youmin.game_link
//        FROM
//        game_data_youmin
//        WHERE
//        MATCH (game_describe) AGAINST (
//        '世界 -庞大 +血腥 统治' IN BOOLEAN MODE
//        )
//        )
//        )
//        OR (
//        G.tdm_link IS NOT NULL
//        AND G.tdm_link IN (
//        SELECT
//        game_data_tdm.game_link
//        FROM
//        game_data_tdm
//        WHERE
//        MATCH (game_describe) AGAINST (
//        '世界 -庞大 +血腥 统治' IN BOOLEAN MODE
//        )
//        )
//        )OR
//
//        (
//        G.steam_link IS NOT NULL
//        AND G.steam_link IN (
//        SELECT
//        game_data_steam.game_link
//        FROM
//        game_data_steam
//        WHERE
//        MATCH (game_describe) AGAINST (
//        '世界 -庞大 +血腥 统治' IN BOOLEAN MODE
//        )
//        )
//
//        );