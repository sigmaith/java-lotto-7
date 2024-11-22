package lotto.controller;

import static lotto.view.InputView.askMoney;

import lotto.model.Money;

public class PurchaseController {
    public static Money purchaseLottoes() {
        while (true) {
            try {
                Money money = askMoney();
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
