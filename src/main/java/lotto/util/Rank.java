package lotto.util;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(7, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(6, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - ");

    private final int code;
    private final int winningMoney;
    private final String description;
    private static final Map<Integer, Rank> map = Stream.of(values()).collect(
            Collectors.toMap(Rank::getCode, type -> type)
    );

    Rank(final int code, final int winningMoney, final String description) {
        this.code = code;
        this.winningMoney = winningMoney;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Rank getRankByCode(Integer code) {
        return map.get(code);
    }

    public Integer getWinningMoney() {
        return winningMoney;
    }
}
