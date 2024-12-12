package lotto.exception;

public enum ErrorMessage {
    NUMBER_FORMAT("구입 금액은 숫자 형식이어야 합니다."),
    UNIT_EXCEPTION("구입 금액은 1,000으로 나누어 떨어지는 숫자여야 합니다");
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
