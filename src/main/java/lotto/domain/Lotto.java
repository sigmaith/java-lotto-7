package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.CustomException;
import lotto.exception.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNoDuplicates(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw CustomException.from(ErrorMessage.SIX_NUMBER_LOTTO);
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw CustomException.from(ErrorMessage.DUPLICATED_LOTTO_NUMBER);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(number -> number >= 1 && number <= 45)) {
            throw CustomException.from(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE);
        }
    }

    @Override
    public String toString() {
        return numbers.stream().sorted().toList().toString();
    }
}
