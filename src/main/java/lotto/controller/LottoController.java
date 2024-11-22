package lotto.controller;

import static lotto.controller.LottoDrawController.getBonusNumber;
import static lotto.controller.LottoDrawController.getWinningNumbers;
import static lotto.controller.PurchaseController.purchaseLottoes;
import static lotto.view.OutputView.printWinningStatistics;

import java.util.HashMap;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottoes;
import lotto.model.WinningNumbers;

public class LottoController {
    public static void run() {
        Lottoes lottoes = purchaseLottoes();
        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);

        HashMap<Integer, Integer> matchingRecords = initialize();
        recordMatches(lottoes, winningNumbers, bonusNumber, matchingRecords);
        printWinningStatistics(matchingRecords);
    }

    private static HashMap<Integer, Integer> initialize() {
        HashMap<Integer, Integer> matchingRecords = new HashMap<>();
        matchingRecords.put(3, 0);
        matchingRecords.put(4, 0);
        matchingRecords.put(5, 0);
        matchingRecords.put(6, 0);
        matchingRecords.put(7, 0);
        return matchingRecords;
    }

    private static void recordMatches(Lottoes lottoes, WinningNumbers winningNumbers, BonusNumber bonusNumber,
                                      HashMap<Integer, Integer> matchingRecords) {
        for (Lotto lotto : lottoes.getLottoes()) {
            Integer idx = winningNumbers.getMatchCountWith(lotto);
            boolean matchedWithBonusNumber = bonusNumber.isMatchedWith(lotto);
            update(idx, matchedWithBonusNumber, matchingRecords);
        }
    }

    private static void update(int idx, boolean matchedWithBonusNumber, HashMap<Integer, Integer> matchingRecords) {
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
