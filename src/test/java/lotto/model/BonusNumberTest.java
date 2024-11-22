package lotto.model;

import static lotto.util.Exception.BONUS_NUMBER_DUPLICATED_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    void 보너스_번호가_당첨번호와_중복되면_예외가_발생한다() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(winningNumbers, 1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATED_EXCEPTION.getDescription());
    }
}