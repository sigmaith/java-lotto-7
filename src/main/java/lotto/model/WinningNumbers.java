package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(final Integer number) {
        return numbers.contains(number);
    }

    public Integer getMatchCountWith(Lotto lotto) {
        Integer count = 0;
        for (Integer number : lotto.getNumbers()) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
