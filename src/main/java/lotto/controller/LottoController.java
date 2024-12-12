package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Lottoes;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = getMoney();
        Lottoes lottoes = getLottoes(money);
    }

    private Money getMoney() {
        return retry(() -> Money.from(inputView.askMoney()));
    }

    private Lottoes getLottoes(Money money) {
        Lottoes lottoes = Lottoes.from(money);
        outputView.printIssued(lottoes);
        return lottoes;
    }

    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
