import bean.card.PokerCard;
import constant.CardConstants;
import service.card.CardService;
import service.card.CardServiceImpl;

import java.util.List;

/**
 * @description 项目运行入口
 * @author chh
 * @date 2020/3/22 15:31
 **/
public class Application {
    public static void main(String[] args) {
        final CardService cardService = new CardServiceImpl();
        CardConstants.threadPoolExecutor.execute(new Runnable() {
            public void run() {
                //打开一副新扑克牌
                List<PokerCard> pokerCardList = cardService.generateNewCards();
                //洗牌
                cardService.shuffleCards(pokerCardList);
                //初始化三个玩家
                cardService.startPoker(pokerCardList, CardConstants.PLAYER_NUM);
            }
        });
    }

}
