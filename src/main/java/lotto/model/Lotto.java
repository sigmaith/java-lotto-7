package lotto.model;

import static lotto.util.Exception.LOTTO_NOT_SIX_NUMBERS_EXCEPTION;
import static lotto.util.Exception.LOTTO_NUMBER_DUPLICATED_EXCEPTION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NOT_SIX_NUMBERS_EXCEPTION.getDescription());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_EXCEPTION.getDescription());
        }
    }

    @Override
    public String toString() {
        return numbers.stream().sorted().toList().toString();
    }
}
