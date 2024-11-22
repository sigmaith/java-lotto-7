package lotto.controller;

import static lotto.view.InputView.askMoney;
import static lotto.view.OutputView.printPurchasedLottoes;

import lotto.model.Lottoes;
import lotto.model.Money;

public class PurchaseController {
    public static Lottoes purchaseLottoes() {
        while (true) {
            try {
                Money money = askMoney();
                Lottoes lottoes = new Lottoes(money);
                printPurchasedLottoes(lottoes);
                return lottoes;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
