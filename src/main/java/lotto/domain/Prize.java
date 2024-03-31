package lotto.domain;

import java.util.Arrays;

public enum Prize {
	MATCHED_3(3, 5000),
	MATHCED_4(4, 50000),
	MATHCED_5(5, 1500000),
	MATHCED_6(6, 2000000000);

	private final long count;
	private final int price;

	Prize(int count, int price) {
		this.count = count;
		this.price = price;
	}

	public long getCount() {
		return count;
	}

	public int getPrice() {
		return price;
	}

	public static int findPriceByCount(long count) {
		return Arrays.stream(values())
				.filter(prize -> prize.count == count)
				.map(prize -> prize.price)
				.findFirst()
				.orElse(0);
	}
}
