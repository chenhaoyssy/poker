package service.card;

import bean.card.PokerCard;
import bean.player.Player;
import com.google.common.collect.Lists;
import constant.CardConstants;
import enums.CardPicEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import service.player.PlayServiceImpl;
import service.player.PlayerService;

import java.util.Collections;
import java.util.List;

/**
 * @description 扑克牌的相关业务类
 * @author chh
 * @date 2020/3/22 10:13
 **/
public class CardServiceImpl implements CardService {
    private PlayerService playerService = new PlayServiceImpl();

    public List<PokerCard> generateNewCards() {
        //初始化大小王
        List<PokerCard> pokerCardList = Lists.newArrayList(new PokerCard("", CardConstants.BLACK_JOKE, CardConstants.KING_SCORE),
                                                           new PokerCard("", CardConstants.RED_JOKE, CardConstants.KING_SCORE));

        for (int i = 0; i < CardConstants.DOTS.length; i++) {
            //生成点数
            String dot = CardConstants.DOTS[i];
            //J, Q, K, A, 大小王需要转换成对应的分数
            int score = CardConstants.dotScoreMap.get(dot) == null ? NumberUtils.toInt(dot) : CardConstants.dotScoreMap.get(dot);
            for (CardPicEnum cardPicEnum : CardPicEnum.values()) {
                //生成花色
                String pic = cardPicEnum.getPic();

                PokerCard pokerCard = new PokerCard(pic, dot, score);
                pokerCardList.add(pokerCard);
            }
        }

        return pokerCardList;
    }

    public void shuffleCards(List<PokerCard> pokerCardList) {
        Collections.shuffle(pokerCardList);
    }

    public void dealCard(List<PokerCard> pokerCardList, int index, int round, int playerNum, List<Player> playerList) {
        while (CollectionUtils.size(pokerCardList) > index) {
            for (Player currentPlayer : playerList) {
                //将当前牌发入玩家手中
                currentPlayer.getPokerCardList().add(pokerCardList.get(index));
                index++;
                //当前轮数是否结束
                if(round % playerNum == 0 && CollectionUtils.size(pokerCardList) % playerNum == 0){
                    //已经找到了优胜者
                    if (playerService.findWinner(playerList)) {
                        return;
                    }
                }

                if ((index + 1) % playerNum == 0) {
                    round++;
                }
            }
        }
    }

    public void startPoker(List<PokerCard> pokerCardList, int playerNum) {
        //发牌游标
        int index = 0;
        //游戏轮数
        int round = 1;
        //生成玩家
        List<Player> playerList = playerService.generatePlayList(playerNum);

        //开始发牌
        this.dealCard(pokerCardList, index, round, playerNum, playerList);
        index++;

    }

}
