package lotto.model;

import static lotto.util.Exception.PURCHASE_AMOUNT_NOT_IN_RANGE_EXCEPTION;
import static lotto.util.Exception.PURCHASE_AMOUNT_NOT_THOUSAND_UNIT_EXCEPTION;

public class Money {
    private final Integer MONEY_UNIT = 1_000;
    private static final Integer MONEY_MAX = 1_000_000;
    Integer money;

    public Money(final Integer money) {
        validateUnit(money);
        validateInRange(money);
        this.money = money;
    }

    private void validateUnit(final Integer money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_THOUSAND_UNIT_EXCEPTION.getDescription());
        }
    }

    private void validateInRange(final Integer money) {
        if (money > MONEY_MAX) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_IN_RANGE_EXCEPTION.getDescription());
        }
    }

    public Integer getNumberOfLottoes() {
        return money / MONEY_UNIT;
    }
}
