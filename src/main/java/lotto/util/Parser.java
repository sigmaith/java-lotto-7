package lotto.util;

import static lotto.util.Exception.PURCHASE_AMOUNT_NOT_IN_RANGE_EXCEPTION;

public class Parser {
    public static Integer parsePurchaseAmount(final String rawPurchaseAmount) {
        try{
            return Integer.parseInt(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_IN_RANGE_EXCEPTION.getDescription());
        }
    }
}
