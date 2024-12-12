package lotto.domain;

import lotto.exception.CustomException;
import lotto.exception.ErrorMessage;

public class Money {
    private final Integer money;

    private final Integer UNIT = 1_000;

    public static Money from(String input) {
        return new Money(input);
    }

    private Money(String input) {
        validateNumberformat(input);
        int money = Integer.parseInt(input);
        validateUnit(money);
        this.money = money;
    }

    private void validateNumberformat(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw CustomException.from(ErrorMessage.NUMBER_FORMAT);
        }
    }

    private void validateUnit(int money) {
        if (money % UNIT != 0) {
            throw CustomException.from(ErrorMessage.UNIT_EXCEPTION);
        }
    }
}
