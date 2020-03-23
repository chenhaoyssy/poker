package service.card;

import bean.card.PokerCard;
import bean.player.Player;

import java.util.List;

/**
 * @description 扑克牌接口
 * @author chh
 * @date 2020/3/22 10:12
 **/
public interface CardService {
    /**
     * 生成一副新扑克牌(54张，包含大小王)
     * @author chh
     * @date 2020/3/22 17:03
     * @return java.util.List<bean.card.PokerCard> 得到一副全新的扑克牌
     **/
    List<PokerCard> generateNewCards();

    /**
     * 洗牌(将一副扑克牌打乱)
     * @author chh
     * @date 2020/3/22 15:34
     * @param pokerCardList
     * @return void
     **/
    void shuffleCards(List<PokerCard> pokerCardList);

    /**
     * 荷官发牌
     * @author chh
     * @date 2020/3/22 17:03
     * @param pokerCardList 一副完整的扑克牌
     * @param index         发牌索引
     * @param round         游戏轮数
     * @param playerNum     游戏人数
     * @param playerList    总游戏人员信息
     **/
    void dealCard(List<PokerCard> pokerCardList, int index, int round, int playerNum, List<Player> playerList);

    /**
     * 开始游戏！
     * @author chh
     * @date 2020/3/22 10:32
     * @param playerNum 玩家数量
     * @return void
     **/
    void startPoker(List<PokerCard> pokerCardList, int playerNum);
}
