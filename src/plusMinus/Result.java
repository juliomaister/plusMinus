package plusMinus;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class Result {

	/*
	 * Complete the 'plusMinus' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void plusMinus(List<Integer> arr) {
		Double positiveValues = (double) arr.stream().filter(x -> x > 0).count();
		Double negativeValues = (double) arr.stream().filter(x -> x < 0).count();
		Double zeroValues = arr.size() - (negativeValues + positiveValues);
		System.out.println("ratio: " + calculateRatio(positiveValues, arr.size()));
		System.out.println("ratio: " + calculateRatio(negativeValues, arr.size()));
		if (zeroValues != 0) {
			System.out.println("ratio: " + calculateRatio(zeroValues, arr.size()));
		}else {
			System.out.printf("%.6f", zeroValues);
		}
	}

	private static BigDecimal calculateRatio(Double value, int arrSize) {
		BigDecimal t = BigDecimal.valueOf(value).setScale(6);
		BigDecimal x = BigDecimal.valueOf(arrSize).setScale(6);
		return BigDecimal.valueOf(t.divide(x , 6, RoundingMode.HALF_EVEN).doubleValue()).setScale(6);
	}
}
