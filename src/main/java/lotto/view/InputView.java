package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.Parser.parseBonusNumber;
import static lotto.util.Parser.parsePurchaseAmount;
import static lotto.util.Parser.parseWinningNumbers;

import lotto.model.BonusNumber;
import lotto.model.Money;
import lotto.model.WinningNumbers;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_GUIDE = "보너스 번호를 입력해 주세요.";

    public static Money askMoney() {
        System.out.println(PURCHASE_AMOUNT_INPUT_GUIDE);
        return new Money(parsePurchaseAmount(readLine()));
    }

    public static WinningNumbers askWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_INPUT_GUIDE);
        return new WinningNumbers(parseWinningNumbers(readLine()));
    }

    public static BonusNumber askBonusNumber(WinningNumbers winningNumbers) {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_GUIDE);
        return new BonusNumber(winningNumbers, parseBonusNumber(readLine()));
    }
}
