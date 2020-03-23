package bean.card;

import lombok.*;

/**
 * @description 扑克牌bean
 * @author chh
 * @date 2020/3/22 15:05
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokerCard {
    /**
     * 扑克牌花色
     */
    private String pic;

    /**
     * 扑克牌点数
     */
    private String dot;

    /**
     * 扑克牌对应分数
     */
    private int score;
}
