package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningNumbersTest {
	@Test
	void 여섯개의_번호를_입력하지_않으면_오류_발생() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningNumbers(new LottoNumbers(List.of(1, 2, 3, 4, 5)), 6))
				.withMessageMatching("번호는 6개를 입력해야 합니다.");
	}

	@Test
	void 당첨_번호는_1_미만_이면_오류_발생() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningNumbers(new LottoNumbers(List.of(0, 1, 2, 3, 4, 5)), 6))
				.withMessageMatching("번호는 1 미만 45 초과인 수를 입력할 수 없습니다.");
	}

	@Test
	void 당첨_번호는_45_초과_이면_오류_발생() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningNumbers(new LottoNumbers(List.of(46, 1, 2, 3, 4, 5)), 6))
				.withMessageMatching("번호는 1 미만 45 초과인 수를 입력할 수 없습니다.");
	}

	@Test
	void 보너스_번호는_45_초과_이면_오류_발생() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new WinningNumbers(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)), 0))
				.withMessageMatching("보너스 번호는 1 미만 45 초과인 수를 입력할 수 없습니다.");
	}
}
