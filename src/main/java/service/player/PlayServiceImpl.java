package service.player;

import bean.card.PokerCard;
import bean.player.Player;
import com.google.common.collect.Lists;
import constant.CardConstants;

import java.util.List;

/**
 * @description 玩家相关业务类
 * @author chh
 * @date 2020/3/22 17:15
 **/
public class PlayServiceImpl implements PlayerService{
    public int getTotalScore(Player player) {
        int totalScore = 0;
        //玩家目前手中的扑克牌数量
        List<PokerCard> pokerCardList = player.getPokerCardList();
        for (PokerCard pokerCard : pokerCardList) {
            totalScore = pokerCard.getScore() + totalScore;
        }
        return totalScore;
    }

    public boolean findWinner(List<Player> playerList){
        for (Player player : playerList) {
            int winnerScore = this.getTotalScore(player);
            //达到目标分数
            if (winnerScore > CardConstants.TARGET_SCORE){
                StringBuilder sb = new StringBuilder("--------比赛结束，获胜者为：").append(player.getName()).append("，手里的牌为：");
                for (PokerCard pokerCard : player.getPokerCardList()) {
                    sb.append(pokerCard.getPic()).append(pokerCard.getDot()).append("，");
                }
                sb.append("总分为：").append(winnerScore).append("--------");
                System.out.println(sb.toString());

                CardConstants.threadPoolExecutor.shutdownNow();
                return true;
            }
        }
        return false;
    }

    public List<Player> generatePlayList(int x) {
        List<Player> playerList = Lists.newArrayList();
        for (int i = 1; i <= x; i++) {
            Player player = new Player("玩家第" + i + "号", Lists.<PokerCard>newArrayList(), 0);
            playerList.add(player);
        }
        return playerList;
    }
}
