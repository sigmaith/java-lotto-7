package lotto.controller;

import java.util.Arrays;
import java.util.function.Supplier;
import lotto.domain.LottoReader;
import lotto.domain.Lottoes;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.domain.constants.Award;
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
        WinningNumbers winningNumbers = getWinningNumbers();
        LottoReader lottoReader = new LottoReader();
        lottoReader.initialize();
        lottoReader.read(lottoes, winningNumbers);
        Integer earnings = getEarnings(lottoReader);
        outputView.printResult(money.getEarningRate(earnings), lottoReader);
    }

    private Money getMoney() {
        return retry(() -> Money.from(inputView.askMoney()));
    }

    private Lottoes getLottoes(Money money) {
        Lottoes lottoes = Lottoes.from(money);
        outputView.printIssued(lottoes);
        return lottoes;
    }

    private WinningNumbers getWinningNumbers() {
        return retry(() -> WinningNumbers.from(inputView.askWinningInfo()));
    }

    private Integer getEarnings(LottoReader lottoReader) {
        return Arrays.stream(Award.values())
                .mapToInt(award -> {
                    Integer match = award.getMatch();
                    Integer numberOfLottoMatched = lottoReader.getNumberOfLottoBy(match);
                    Integer winningMoney = numberOfLottoMatched * award.getMoney();
                    return winningMoney;
                })
                .sum();
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
