package racingcar.domain;

import static racingcar.global.constants.NumberType.INITIAL_POSITION;
import static racingcar.global.constants.NumberType.MIN_FORWARD_THRESHOLD;
import static racingcar.global.constants.SymbolType.RESULT_POSITION;
import static racingcar.global.constants.SymbolType.RESULT_TOKEN;

import racingcar.global.constants.NumberType;
import racingcar.utils.RandomUtils;

public class Car {
    private Name name;
    private Integer position;

    private Car(final String name) {
        this.name = Name.of(name);
        this.position = INITIAL_POSITION.getValue();
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public Name getName() {
        return this.name;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void tryMove() {
        Integer randomNumber = RandomUtils.generateRandomNumber();
        if (isQualified(randomNumber)) {
            move();
        }
    }

    private boolean isQualified(final Integer randomNumber) {
        return randomNumber >= MIN_FORWARD_THRESHOLD.getValue();
    }

    private void move() {
        this.position++;
    }

    public boolean isSamePosition(final Integer position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return name + RESULT_TOKEN.getSymbol() + RESULT_POSITION.getSymbol().repeat(position);
    }
}
