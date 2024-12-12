package lotto.domain.constants;

import java.util.Arrays;
import lotto.exception.CustomException;
import lotto.exception.ErrorMessage;

public enum Award {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)");

    private final Integer match;
    private final Integer money;
    private final String description;

    Award(Integer match, Integer money, String description) {
        this.match = match;
        this.money = money;
        this.description = description;
    }

    public Integer getMatch() {
        return match;
    }

    public Integer getMoney() {
        return money;
    }

    public String getDescription() {
        return description;
    }

    public static Award getAwardBy(int ordinal) {
        return Arrays.stream(values())
                .filter(award -> award.ordinal() == ordinal)
                .findFirst().orElseThrow(() -> CustomException.from(ErrorMessage.UNDEFINED_ORDINAL_AWARD));
    }
}
