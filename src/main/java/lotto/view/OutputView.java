package lotto.view;

import lotto.domain.Lottoes;

public class OutputView {

    public void printIssued(Lottoes lottoes) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottoes.size());
        System.out.println(lottoes.toString());
    }
}
