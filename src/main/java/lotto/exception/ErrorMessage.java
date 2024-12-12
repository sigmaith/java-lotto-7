package lotto.exception;

public enum ErrorMessage {
    NUMBER_FORMAT("구입 금액은 숫자 형식이어야 합니다."),
    UNIT_EXCEPTION("구입 금액은 1,000으로 나누어 떨어지는 숫자여야 합니다"),
    SIX_NUMBER_LOTTO("로또 번호는 6개여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복되지 않아야 합니다"),
    LOTTO_NUMBER_NOT_IN_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_FORMAT("로또 번호는 숫자 형식 이어야 합니다"),
    BONUS_NUMBER_FORMAT("보너스 번호는 숫자 형식 이어야 합니다"),
    BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBERS("보너스 번호는 당첨 번호와 중복되지 않아야 합니다"),
    BONUS_NUMBER_NOT_IN_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
