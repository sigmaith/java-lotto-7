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
}
