package junitTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
public class IsTriangleTest {
	
    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, true",   // Tam giác vuông
            "6, 8, 10, true",  // Tam giác vuông
            "5, 12, 13, true", // Tam giác vuông
            "2, 3, 6, false",  // Không tạo thành tam giác
            "1, 1, 2, false",   // Không tạo thành tam giác
            "0, 0, 2, false"   // Không tạo thành tam giác
    })
	public void test(int sideA, int sideB, int sideC,boolean expResult) {
		boolean actResult = Problem.isTriangle(sideA,sideB,sideC);
		assertEquals(actResult, expResult);
	}
}
