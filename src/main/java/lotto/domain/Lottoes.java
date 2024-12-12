package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottoes {
    private List<Lotto> lottoes;

    public static Lottoes from(Money money) {
        return new Lottoes(money);
    }

    public List<Lotto> lottoes() {
        return lottoes;
    }

    private Lottoes(Money money) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < money.ticketNumber(); i++) {
            lottoes.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        this.lottoes = lottoes;
    }

    public int size() {
        return lottoes.size();
    }

    @Override
    public String toString() {
        return lottoes.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
