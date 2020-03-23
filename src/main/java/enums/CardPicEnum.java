package enums;

import lombok.*;

/**
 * @description 扑克牌花色枚举
 * @author chh
 * @date 2020/3/22 13:31
 **/
@AllArgsConstructor
public enum CardPicEnum {
    /**
     * 黑桃
     */
    SPADE("♠", 1),

    /**
     * 红桃
     */
    HEART("♥", 2),

    /**
     * 草花
     */
    CLUB("♣", 3),

    /**
     * 方块
     */
    DIAMOND("♦", 4);

    @Getter
    @Setter
    private String pic;

    @Getter
    @Setter
    private int sort;
}
