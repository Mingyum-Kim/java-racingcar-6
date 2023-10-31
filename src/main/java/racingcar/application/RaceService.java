package racingcar.application;

import static racingcar.global.constants.NumberType.*;
import static racingcar.global.constants.SymbolType.DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class RaceService {
    public Cars generateCars(String rawNames) {
        return Cars.of(parseStringToList(rawNames));
    }

    public Integer generateCount(String countInput) {
        Integer count = parseStringToInteger(countInput);
        validateRange(count);
        return count;
    }

    private Integer parseStringToInteger(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식으로 입력해주세요");
        }
    }

    private List<String> parseStringToList(String names) {
        return Arrays.stream(splitNames(names))
                .map(String::new)
                .toList();
    }

    private String[] splitNames(String names) {
        return names.split(DELIMITER.getSymbol());
    }

    private void validateRange(Integer count) {
        if (isLessThanMinCount(count)) {
            throw new IllegalArgumentException(String.format("%d 이상의 정수를 입력해주세요.", MIN_RACE_COUNT.getValue()));
        }
    }

    private boolean isLessThanMinCount(Integer count) {
        return count < MIN_RACE_COUNT.getValue();
    }

    public void startRace(Cars cars, Integer totalCount) {
        for (int count = 0; count < totalCount; count++) {
            cars.tryMoveCars();
        }
    }
}
