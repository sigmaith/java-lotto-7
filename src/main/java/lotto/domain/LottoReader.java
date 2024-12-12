package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoReader {
    Map<Integer, Integer> map = new HashMap<>(); // 매칭 개수, 랭크에 해당하는 로또 개수

    public void initialize() {
        for (int i = 0; i <= 7; i++) {
            map.put(i, 0);
        }
    }

    public void read(Lottoes lottoes, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottoes.lottoes()) {
            int matchingIndex = winningNumbers.getMatchingIndex(lotto);
            Integer oldValue = map.get(matchingIndex);
            map.replace(matchingIndex, oldValue + 1);
        }
    }

    public Integer getNumberOfLottoBy(Integer match) {
        return map.get(match);
    }
}
