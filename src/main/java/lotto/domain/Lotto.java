package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_GAME_NUMBERS_SIZE = 6;
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isSixNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!isBetweenLottoRange(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private boolean isSixNumbers(List<Integer> numbers) {
        return numbers.size() == LOTTO_GAME_NUMBERS_SIZE;
    }

    private boolean isBetweenLottoRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number ->
                number >= LOTTO_GAME_START_NUMBER && number <= LOTTO_GAME_END_NUMBER);
    }

    private boolean isDuplicateNumber(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }
}