package lotto.util;

public enum Exception {
    PURCHASE_AMOUNT_NOT_IN_RANGE_EXCEPTION("구입 금액은 1000 ~ 1000000 범위여야 합니다."),
    PURCHASE_AMOUNT_NUMBER_FORMAT_EXCEPTION("구입 금액은 숫자 형식이어야 합니다."),
    PURCHASE_AMOUNT_NOT_THOUSAND_UNIT_EXCEPTION("구입 금액은 1,000원 단위로 입력해 주세요."),
    WINNING_NUMBERS_NUMBER_FORMAT_EXCEPTION("당첨 번호는 숫자 형식이어야 합니다."),
    BONUS_NUMBER_DUPLICATED_EXCEPTION("보너스 번호는 당첨 번호와 중복되지 않아야 합니다"),
    BONUS_NUMBER_NUMBER_FORMAT_EXCEPTION("보너스 번호는 숫자 형식이어야 합니다."),
    LOTTO_NOT_SIX_NUMBERS_EXCEPTION("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATED_EXCEPTION("로또 번호는 1~45 범위의 중복되지 않는 6개의 숫자여야 합니다.");
    private final String description;
    private final String header = "[ERROR]";

    Exception(final String description) {
        this.description = header + description;
    }

    public String getDescription() {
        return description;
    }
}
