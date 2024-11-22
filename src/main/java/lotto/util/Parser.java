package lotto.util;

import static lotto.util.Exception.BONUS_NUMBER_NUMBER_FORMAT_EXCEPTION;
import static lotto.util.Exception.PURCHASE_AMOUNT_NUMBER_FORMAT_EXCEPTION;
import static lotto.util.Exception.WINNING_NUMBERS_NUMBER_FORMAT_EXCEPTION;

import java.util.List;

public class Parser {
    public static Integer parsePurchaseAmount(final String rawPurchaseAmount) {
        try {
            int purchaseAmount = Integer.parseInt(rawPurchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NUMBER_FORMAT_EXCEPTION.getDescription());
        }
    }

    public static List<Integer> parseWinningNumbers(final String rawWinningNumbers) {
        try {
            String[] splits = rawWinningNumbers.split(",", -1);
            List<Integer> winningNumbers = List.of(splits).stream().map(rawNumber -> Integer.parseInt(rawNumber))
                    .toList();
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NUMBER_FORMAT_EXCEPTION.getDescription());
        }
    }

    public static Integer parseBonusNumber(final String rawBonusNumber) {
        try {
            return Integer.parseInt(rawBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_NUMBER_FORMAT_EXCEPTION.getDescription());
        }
    }
}

