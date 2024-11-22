package lotto.model;

import static lotto.util.Exception.PURCHASE_AMOUNT_NOT_THOUSAND_UNIT_EXCEPTION;

public class Money {
    private final Integer MONEY_UNIT = 1_000;
    Integer money;

    public Money(final Integer money) {
        validate(money);
        this.money = money;
    }

    private void validate(final Integer money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_THOUSAND_UNIT_EXCEPTION.getDescription());
        }
    }

    public Integer getNumberOfLottos() {
        return money / MONEY_UNIT;
    }
}
