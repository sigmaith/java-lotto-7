package lotto.domain;

import static lotto.domain.Lotto.getMatchedNumbersWith;

import java.util.List;
import lotto.controller.dto.WinningInfo;
import lotto.exception.CustomException;
import lotto.exception.ErrorMessage;

public class WinningNumbers {
    private Lotto winningLotto;
    private Integer bonusNumber;

    public static WinningNumbers from(WinningInfo winningInfo) {
        return new WinningNumbers(winningInfo);
    }

    private WinningNumbers(WinningInfo winningInfo) {
        List<Integer> winningNumbers = validateNumberFormat(winningInfo.winningNumbers());
        Integer bonusNumber = validateNumberFormatAndRange(winningInfo.bonusNumber());
        validateNotDuplicated(winningNumbers, bonusNumber);
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> validateNumberFormat(List<String> input) {
        try {
            return input.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw CustomException.from(ErrorMessage.LOTTO_NUMBER_FORMAT);
        }
    }

    private Integer validateNumberFormatAndRange(String input) {
        try {
            int bounsNumber = Integer.parseInt(input);
            if (bounsNumber < 1 || bounsNumber > 45) {
                throw CustomException.from(ErrorMessage.BONUS_NUMBER_NOT_IN_RANGE);
            }
            return bounsNumber;
        } catch (NumberFormatException e) {
            throw CustomException.from(ErrorMessage.BONUS_NUMBER_FORMAT);
        }
    }

    private void validateNotDuplicated(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw CustomException.from(ErrorMessage.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBERS);
        }
    }

    public int getMatchingIndex(Lotto lotto) {
        int matchedNumber = getMatchedNumbersWith(winningLotto, lotto);
        if (matchedNumber == 6) {
            return 7;
        }
        if (matchedNumber == 5 && lotto.contains(bonusNumber)) {
            return 6;
        }
        return matchedNumber;
    }
}
