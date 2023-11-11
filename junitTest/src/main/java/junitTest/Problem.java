package junitTest;

public class Problem {
	public class Calculator {
		private int c;

		public Calculator(int c) {
			this.c =c;
		}

		public int sum (int a, int b) {
			return a + b + this.c;
		}

		public int subtract(int a ,int b) {
			return a - b -this.c;
		}
	}

	public static boolean isTriangle(int sideA, int sideB, int sideC) {
		if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
			return false; // Các cạnh phải lớn hơn 0
		} else if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
			return true; // Tổng độ dài 2 cạnh bất kỳ phải lớn hơn cạnh còn lại
		} else {
			return false; // Không tạo thành tam giác
		}
	}

	public static double ptbacnhat(int a, int b) {
		if (a == 0) {
			if (b == 0) {
				return Double.MAX_VALUE;
			} else
				return Double.MIN_VALUE;
		} else
			return -b / a;
	}

	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		} else {
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

	public static int findMin(int a, int b, int c) {
		int min;
		if (a <= b) {

			if (a <= c) {
				min = a;
			} else {
				min = c;
			}
		} else {
			if (b <= c) {
				min = b;
			} else {
				min = c;
			}
		}
		return min;

	}

}
