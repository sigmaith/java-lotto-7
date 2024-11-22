package lotto.util;

public enum Exception {
    PURCHASE_AMOUNT_NOT_IN_RANGE_EXCEPTION("구입 금액은 1000 ~ 1000000 범위의 숫자 형식이어야 합니다."),
    PURCHASE_AMOUNT_NOT_THOUSAND_UNIT_EXCEPTION("구입 금액은 1,000원 단위로 입력해 주세요."),
    LOTTO_NOT_SIX_NUMBERS_EXCEPTION("로또 번호는 6개여야 합니다.");
    private final String description;
    private final String header = "[ERROR]";

    Exception(final String description) {
        this.description = header + description;
    }

    public String getDescription() {
        return description;
    }
}
