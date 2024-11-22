package lotto.controller;

import static lotto.view.InputView.askMoney;

import lotto.model.Lottos;
import lotto.model.Money;

public class PurchaseController {
    public static Lottos purchaseLottos() {
        while (true) {
            try {
                Money money = askMoney();
                return new Lottos(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
