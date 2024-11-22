package lotto.model;

import static lotto.util.Exception.BONUS_NUMBER_DUPLICATED_EXCEPTION;

public class BonusNumber {
    private final int number;

    public BonusNumber(WinningNumbers winningNumbers, Integer number) {
        validateNoDuplicates(winningNumbers, number);
        this.number = number;
    }

    private void validateNoDuplicates(WinningNumbers winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_EXCEPTION.getDescription());
        }
    }
}
