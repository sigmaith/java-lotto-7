package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottoes {
    private final List<Lotto> lottoes;

    public Lottoes(Money money) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < money.getNumberOfLottoes(); i++) {
            lottoes.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
        }
        this.lottoes = lottoes;
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }

    public Integer getNumber() {
        return lottoes.size();
    }

    @Override
    public String toString() {
        return lottoes.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
