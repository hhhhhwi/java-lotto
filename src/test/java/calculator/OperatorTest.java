package calculator;

import calculator.domain.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {
	@Test
	void 덧셈() {
		assertThat(Operator.PLUS.calculate(6, 3)).isEqualTo(9);
	}

	@Test
	void 뺄셈() {
		assertThat(Operator.MINUS.calculate(6, 3)).isEqualTo(3);
	}

	@Test
	void 곱하기() {
		assertThat(Operator.MULTIPLY.calculate(6, 3)).isEqualTo(18);
	}

	@Test
	void 나누기() {
		assertThat(Operator.DIVIDE.calculate(6, 3)).isEqualTo(2);
	}

	@Test
	void 올바른_사칙연산_기호가_아니면_예외_호출() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> Operator.getOperatorBySymbol("!"))
				.withMessageMatching("올바른 사칙연산 기호가 아닙니다.");
	}
}
