package racingcar.domain;

import static racingcar.global.constants.NumberType.MAX_LENGTH_OF_NUMBER;

public class Car {
    private String name;
    private Integer position;

    private Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    private void validateName(String name) {
        validateLength(name);
        validateCharacters(name);
    }

    private void validateLength(String name) {
        if (isLengthExceeded(name)) {
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
        }
    }

    private boolean isLengthExceeded(String name) {
        return name.length() > MAX_LENGTH_OF_NUMBER.getValue();
    }

    private void validateCharacters(String name) {
        if (containsInvalidCharacters(name)) {
            throw new IllegalArgumentException("영문자만 입력해주세요.");
        }
    }

    private boolean containsInvalidCharacters(String name) {
        return !name.matches("[a-zA-Z]+");
    }
}
