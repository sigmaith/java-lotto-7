package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Parser.parsePurchaseAmount;

import lotto.model.Money;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_GUIDE = "구입금액을 입력해 주세요.";

    public static Money askMoney() {
        System.out.println(PURCHASE_AMOUNT_INPUT_GUIDE);
        return new Money(parsePurchaseAmount(readLine()));
    }
}
