package lotto.view;

import java.util.HashMap;
import lotto.model.Lottoes;
import lotto.model.Money;
import lotto.util.Rank;

public class OutputView {
    private static final String PURCHASED_LOTTOES_GUIDE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String EARNING_RATES = "총 수익률은 %.2f입니다.";

    public static void printPurchasedLottoes(Lottoes lottoes) {
        System.out.println();
        System.out.println(String.format(PURCHASED_LOTTOES_GUIDE, lottoes.getNumber()));
        System.out.println(lottoes.toString());
    }

    public static void printWinningStatistics(HashMap<Integer, Integer> matchingRecords) {
        System.out.println(WINNING_STATISTICS);
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i <= 7; i++) {
            sb.append(Rank.getRankByCode(i).getDescription()).append(matchingRecords.get(i));
        }
        System.out.println(sb.toString());
    }

    public static void printEarningRates(HashMap<Integer, Integer> matchingRecords, Money money) {
        int earnings = 0;
        for (int i = 3; i <= 7; i++) {
            earnings += matchingRecords.get(i) * Rank.getRankByCode(i).getWinningMoney();
        }
        System.out.println(String.format(EARNING_RATES, money.getEarningRates(earnings)));
    }
}
