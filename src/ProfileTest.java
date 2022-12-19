import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
 
class ProfileTest {

	@Test
	void emptyArgumentConstructorTest() {
		List<Grade> gradesList = new ArrayList<Grade>();
		Assertions.assertThrows(IllegalArgumentException.class,() ->{new Profile(gradesList);});
	}
	@Test
	void nullArgumentConstructorTest() {
		Assertions.assertThrows(IllegalArgumentException.class,() ->{new Profile(null);});
	}
	
	@Test
	void invalidArgumentConstructorTest() {
		List<Grade> gradesList = new ArrayList<Grade>();
		gradesList.add(new Grade(1));
		gradesList.add(new Grade(10));
		gradesList.add(new Grade(20));
		Assertions.assertThrows(IllegalArgumentException.class,() ->{new Profile(gradesList);});
	}
	
	@Test
	void validArgumentConstructorTest() {
		List<Grade> gradesList = new ArrayList<Grade>();
		gradesList.add(new Grade(1));
		gradesList.add(new Grade(5));
		gradesList.add(new Grade(10));
		Profile profile1 = new Profile(gradesList);
		Assertions.assertTrue(profile1 instanceof Profile);
	}
	
	
	@ParameterizedTest
	@MethodSource("generateClassificationsBooleanValuesAndListGrades")
	void classificationTest(Classification classification, boolean isClear, List<Grade> listGrades) {
		Profile profile = new Profile(listGrades);
		Assertions.assertEquals(classification, profile.classify());
		Assertions.assertEquals(isClear, profile.isClear());
	}
	private static Stream<Arguments> generateClassificationsBooleanValuesAndListGrades(){
		return Stream.of(
				Arguments.of(Classification.First, true, new ArrayList<Grade>(Arrays.asList(new Grade(1), new Grade(2),new Grade(3),new Grade(4),new Grade(9),new Grade(6),new Grade(10),new Grade(11)))),
				Arguments.of(Classification.First, false, new ArrayList<Grade>(Arrays.asList(new Grade(2), new Grade(2),new Grade(1),new Grade(1),new Grade(9),new Grade(13),new Grade(14),new Grade(15)))),
				Arguments.of(Classification.UpperSecond, true,new ArrayList<Grade>(Arrays.asList(new Grade(5), new Grade(6),new Grade(1),new Grade(15)))),
				Arguments.of(Classification.UpperSecond, false,new ArrayList<Grade>(Arrays.asList(new Grade(5), new Grade(5),new Grade(6),new Grade(7),new Grade(9),new Grade(15),new Grade(15),new Grade(15)))),
				Arguments.of(Classification.LowerSecond, true, new ArrayList<Grade>(Arrays.asList(new Grade(10), new Grade(10), new Grade(15), new Grade(15)))),
				Arguments.of(Classification.Third, true, new ArrayList<Grade>(Arrays.asList(new Grade(10), new Grade(15), new Grade(15), new Grade(15)))));
	}
}
