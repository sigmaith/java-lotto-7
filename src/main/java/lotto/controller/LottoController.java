package lotto.controller;

import static lotto.controller.LottoDrawController.getBonusNumber;
import static lotto.controller.LottoDrawController.getWinningNumbers;
import static lotto.controller.PurchaseController.purchaseLottoes;

import lotto.model.BonusNumber;
import lotto.model.Lottoes;
import lotto.model.WinningNumbers;

public class LottoController {
    public static void run() {
        Lottoes lottoes = purchaseLottoes();
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
    }
}
