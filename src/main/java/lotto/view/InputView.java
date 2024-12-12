package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import lotto.controller.dto.WinningInfo;

public class InputView {
    public String askMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public WinningInfo askWinningInfo() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> winningNumbers = Arrays.stream(readLine().split(",", -1)).toList();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        return new WinningInfo(winningNumbers, bonusNumber);
    }
}
