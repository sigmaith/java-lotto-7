package lotto.model;

import static lotto.util.Exception.LOTTO_NOT_SIX_NUMBERS_EXCEPTION;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NOT_SIX_NUMBERS_EXCEPTION.getDescription());
        }
    }

    // TODO: 추가 기능 구현
}
