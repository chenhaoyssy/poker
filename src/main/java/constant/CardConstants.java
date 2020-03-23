package constant;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description 扑克牌属性的相关静态常量
 * @author chh
 * @date 2020/3/22 14:55
 **/
public class CardConstants {
    public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 0,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(),new ThreadPoolExecutor.CallerRunsPolicy());

    public static Map<String, Integer> dotScoreMap = Maps.newHashMap();

    // 将J, Q, K, A, 大小王对应的分数初始化
    static {
        dotScoreMap.put(CardConstants.J, CardConstants.J_SCORE);
        dotScoreMap.put(CardConstants.Q, CardConstants.Q_SCORE);
        dotScoreMap.put(CardConstants.K, CardConstants.K_SCORE);
        dotScoreMap.put(CardConstants.A, CardConstants.A_SCORE);
        dotScoreMap.put(CardConstants.BLACK_JOKE, CardConstants.KING_SCORE);
        dotScoreMap.put(CardConstants.RED_JOKE, CardConstants.KING_SCORE);
    }

    /**
     * 扑克牌点数
     */
    public static final String[] DOTS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /**
     * 扑克牌小王
     */
    public static final String BLACK_JOKE = "Black Joke";

    /**
     * 扑克牌大王
     */
    public static final String RED_JOKE = "Red Joke";

    /**
     * 大小王对应的分数
     */
    public static final int KING_SCORE = 20;

    /**
     * J对应的分数
     */
    public static final int J_SCORE = 11;

    /**
     * Q对应的分数
     */
    public static final int Q_SCORE = 12;

    /**
     * K对应的分数
     */
    public static final int K_SCORE = 13;

    /**
     * A对应的分数
     */
    public static final int A_SCORE = 1;

    /**
     * 获胜分数
     */
    public static final int TARGET_SCORE = 50;

    /**
     * 参与人数
     */
    public static final int PLAYER_NUM = 3;

    public static final String J = "J";

    public static final String Q = "Q";

    public static final String K = "K";

    public static final String A = "A";
}
