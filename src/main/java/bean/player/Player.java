package bean.player;

import bean.card.PokerCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description 玩家Bean
 * @author chh
 * @date 2020/3/22 6:33
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player {
    /**
     * 玩家姓名
     */
    private String name;

    /**
     * 玩家手中拥有的扑克牌
     */
    private List<PokerCard> pokerCardList;

    /**
     * 玩家目前手中的总分
     */
    private int totalScore;
}
