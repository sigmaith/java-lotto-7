package lotto.controller;

import static lotto.controller.LottoDrawController.getBonusNumber;
import static lotto.controller.LottoDrawController.getWinningNumbers;
import static lotto.controller.PurchaseController.purchaseLottoes;
import static lotto.view.OutputView.printEarningRates;
import static lotto.view.OutputView.printPurchasedLottoes;
import static lotto.view.OutputView.printWinningStatistics;

import java.util.HashMap;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottoes;
import lotto.model.Money;
import lotto.model.WinningNumbers;

public class LottoController {
    public static void run() {
        Money money = purchaseLottoes();
        Lottoes lottoes = new Lottoes(money);
        printPurchasedLottoes(lottoes);
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);
        Map<Integer, Integer> matchingRecords = initialize();
        recordMatches(lottoes, winningNumbers, bonusNumber, matchingRecords);
        printWinningStatistics(matchingRecords);
        printEarningRates(matchingRecords, money);
    }

    private static Map<Integer, Integer> initialize() {
        Map<Integer, Integer> matchingRecords = new HashMap<>();
        for (int i = 0; i <= 7; i++) {
            matchingRecords.put(i, 0);
        }
        return matchingRecords;
    }

    private static void recordMatches(Lottoes lottoes, WinningNumbers winningNumbers, BonusNumber bonusNumber,
                                      Map<Integer, Integer> matchingRecords) {
        for (Lotto lotto : lottoes.getLottoes()) {
            Integer idx = winningNumbers.getMatchCountWith(lotto);
            boolean matchedWithBonusNumber = bonusNumber.isMatchedWith(lotto);
            update(idx, matchedWithBonusNumber, matchingRecords);
        }
    }

    private static void update(int idx, boolean matchedWithBonusNumber, Map<Integer, Integer> matchingRecords) {
        if (idx == 6) {
            matchingRecords.put(idx + 1, matchingRecords.get(idx + 1) + 1);
            return;
        }
        if (idx == 5 && matchedWithBonusNumber) {
            matchingRecords.put(idx + 1, matchingRecords.get(idx + 1) + 1);
            return;
        }
        matchingRecords.put(idx, matchingRecords.get(idx) + 1);
    }
}
