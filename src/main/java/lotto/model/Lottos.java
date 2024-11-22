package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.getNumberOfLottos(); i++) {
            lottos.add(new Lotto(pickUniqueNumbersInRange(1, 45, 6)));
        }
        this.lottos = lottos;
    }
}
