package lotto.controller;

import static lotto.view.InputView.askBonusNumber;
import static lotto.view.InputView.askWinningNumbers;

import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;

public class LottoDrawController {
    public static WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                WinningNumbers winningNumbers = askWinningNumbers();
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusNumber getBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                BonusNumber bonusNumber = askBonusNumber(winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
