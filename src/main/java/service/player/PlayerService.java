package service.player;

import bean.player.Player;

import java.util.List;

/**
 * @description 玩家接口
 * @author chh
 * @date 2020/3/22 18:31
 **/
public interface PlayerService {
    /**
     * 获取玩家当前总分
     * @author chh
     * @date 2020/3/23 7:15
     * @param player 当前玩家
     * @return int 当前总分
     **/
    int getTotalScore(Player player);

    /**
     * 生成X名玩家
     * @author chh
     * @date 2020/3/23 9:57
     * @param x 玩家数量
     * @return java.util.List<bean.player.Player>
     **/
    List<Player> generatePlayList(int x);

    /**
     * 拼接获胜者信息
     * @author chh
     * @date 2020/3/22 21:30
     * @param playerList
     * @return void
     **/
    boolean findWinner(List<Player> playerList);
}
