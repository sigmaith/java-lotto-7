package lotto.controller.dto;

import java.util.List;

public record WinningInfo(
        List<String> winningNumbers,
        String bonusNumber
) {
}
