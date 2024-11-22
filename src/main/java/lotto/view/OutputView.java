package lotto.view;

import lotto.model.Lottoes;

public class OutputView {
    private static final String PURCHASED_LOTTOES_GUIDE = "%d개를 구매했습니다.";

    public static void printPurchasedLottoes(Lottoes lottoes) {
        System.out.println();
        System.out.println(String.format(PURCHASED_LOTTOES_GUIDE, lottoes.getNumber()));
        System.out.println(lottoes.toString());
    }
}
