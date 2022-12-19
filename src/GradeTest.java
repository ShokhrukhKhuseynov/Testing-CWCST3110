import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
class GradeTest {

	@ParameterizedTest
	@MethodSource("generateInvalidPoints")
	void invalidBoudraryConstructorTest(int points) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {new Grade(points);});
	}
	private static Stream<Arguments> generateInvalidPoints(){
		
		return Stream.of(
				Arguments.of(0),
				Arguments.of(21));
	}
	
	@Test
	void getPointsTest(){
		Grade grade = new Grade(15);
		Assertions.assertEquals(15, grade.getPoints());
	}
	
	@ParameterizedTest
	@MethodSource("generateClassificationsAndPoints")
	void classificationTest(Classification classification, int points) {
		Assertions.assertEquals(classification, new Grade(points).classify());
	}
	private static Stream<Arguments> generateClassificationsAndPoints(){
		
		return Stream.of(
				Arguments.of(Classification.First, 2),
				Arguments.of(Classification.UpperSecond, 5),
				Arguments.of(Classification.LowerSecond, 10),
				Arguments.of(Classification.Third, 13),
				Arguments.of(Classification.Fail, 20));
	}
	
	@ParameterizedTest
	@MethodSource("generateInvalidPercentages")
	void invalidBoundraryFromPercentageTest(int points) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {Grade.fromPercentage(points);});
	}
	private static Stream<Arguments> generateInvalidPercentages(){
		
		return Stream.of(
				Arguments.of(-2),
				Arguments.of(101));
	}
	
	@ParameterizedTest
	@MethodSource("generateClassificationsAndPercentages")
	void fromPersentageTest(Classification classification, int percentage) {
		Assertions.assertEquals(classification, Grade.fromPercentage(percentage).classify());
	}
	private static Stream<Arguments> generateClassificationsAndPercentages(){
		
		return Stream.of(
				Arguments.of(Classification.First,79),
				Arguments.of(Classification.First,77),
				Arguments.of(Classification.First,73),
				Arguments.of(Classification.First,72),
				Arguments.of(Classification.UpperSecond,69),
				Arguments.of(Classification.UpperSecond,65),
				Arguments.of(Classification.UpperSecond,63),
				Arguments.of(Classification.UpperSecond,60),
				Arguments.of(Classification.LowerSecond,59),
				Arguments.of(Classification.LowerSecond,56),
				Arguments.of(Classification.LowerSecond,54),
				Arguments.of(Classification.LowerSecond,50),
				Arguments.of(Classification.Third,47),
				Arguments.of(Classification.Third,46),
				Arguments.of(Classification.Third,44),
				Arguments.of(Classification.Third,41),
				Arguments.of(Classification.Fail,35),
				Arguments.of(Classification.Fail,30),
				Arguments.of(Classification.Fail,25),
				Arguments.of(Classification.Fail,-1));
	}
}
