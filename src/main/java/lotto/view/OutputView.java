package lotto.view;

import lotto.domain.LottoReader;
import lotto.domain.Lottoes;
import lotto.domain.constants.Award;

public class OutputView {

    public void printIssued(Lottoes lottoes) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottoes.size());
        System.out.println(lottoes.toString());
        System.out.println();
    }

    public void printResult(Double earningRate, LottoReader lottoReader) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 4; i >= 0; i--) {
            Award award = Award.getAwardBy(i);
            Integer match = award.getMatch();
            System.out.printf("%s - %d개\n", award.getDescription(), lottoReader.getNumberOfLottoBy(match));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }
}
