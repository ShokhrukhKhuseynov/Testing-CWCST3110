import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DegreeTest {

	@Test
	void nullArgumentConstructorTest() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {new Degree(new ArrayList<Grade>(), null);});
	}
	@Test
	void nullArgumentConstructorTest2() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {new Degree(null, new ArrayList<Grade>());});
	}
	@Test
	void invalidArgumentSizeConstructorTest() {
		List<Grade> year2 = new ArrayList<Grade>(Arrays.asList(new Grade(1), new Grade(2), new Grade(3), new Grade(4)));
		List<Grade> year3 = new ArrayList<Grade>(Arrays.asList(new Grade(1), new Grade(2), new Grade(3)));
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {new Degree(year2, year3);});
	}
	@Test
	void invalidArgumentSizeConstructorTest2() {
		List<Grade> year2 = new ArrayList<Grade>(Arrays.asList(new Grade(1), new Grade(2), new Grade(3)));
		List<Grade> year3 = new ArrayList<Grade>(Arrays.asList(new Grade(1), new Grade(2), new Grade(3), new Grade(4)));
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {new Degree(year2, year3);});
	}
	@Test
	void invalidArgmentConstructorTest() {
		List<Grade> year2 = new ArrayList<Grade>(Arrays.asList(new Grade(1), new Grade(2), new Grade(3), new Grade(4)));
		List<Grade> year3 = new ArrayList<Grade>(Arrays.asList(new Grade(1), new Grade(2), new Grade(3), new Grade(18)));
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {new Degree(year2, year3);});
	}
	
	@Test
	void invalidArgmentConstructorTest2() {
		List<Grade> year2 = new ArrayList<Grade>(Arrays.asList(new Grade(1), new Grade(2), new Grade(3), new Grade(18)));
		List<Grade> year3 = new ArrayList<Grade>(Arrays.asList(new Grade(1), new Grade(2), new Grade(3), new Grade(4)));
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {new Degree(year2, year3);});
	}
	

	@ParameterizedTest
	@MethodSource("generateGrades")
	void classificationTest(Classification classification, ArrayList<Grade> year2, ArrayList<Grade> year3) {
		Assertions.assertEquals(classification, new Degree(year2, year3).classify());
	}
	private static Stream<Arguments> generateGrades(){
		
		return Stream.of(
				Arguments.of(Classification.First, new ArrayList<Grade>(Arrays.asList(new Grade(1),new Grade(1),new Grade(1),new Grade(1))), new ArrayList<Grade>(Arrays.asList(new Grade(1),new Grade(1),new Grade(1),new Grade(1)))),
				Arguments.of(Classification.First, new ArrayList<Grade>(Arrays.asList(new Grade(6),new Grade(6),new Grade(6),new Grade(6))), new ArrayList<Grade>(Arrays.asList(new Grade(10),new Grade(5),new Grade(1),new Grade(1)))),
				Arguments.of(Classification.UpperSecond, new ArrayList<Grade>(Arrays.asList(new Grade(6),new Grade(6),new Grade(6),new Grade(6))), new ArrayList<Grade>(Arrays.asList(new Grade(10),new Grade(10),new Grade(10),new Grade(10)))),	
				Arguments.of(Classification.Third, new ArrayList<Grade>(Arrays.asList(new Grade(1),new Grade(13),new Grade(13),new Grade(13))), new ArrayList<Grade>(Arrays.asList(new Grade(1),new Grade(13),new Grade(13),new Grade(13)))),
				Arguments.of(Classification.Discretion, new ArrayList<Grade>(Arrays.asList(new Grade(6),new Grade(6),new Grade(6),new Grade(6))), new ArrayList<Grade>(Arrays.asList(new Grade(1),new Grade(1),new Grade(15),new Grade(15)))),	
				Arguments.of(Classification.Discretion, new ArrayList<Grade>(Arrays.asList(new Grade(1),new Grade(1),new Grade(1),new Grade(1))), new ArrayList<Grade>(Arrays.asList(new Grade(6),new Grade(15),new Grade(15),new Grade(15)))));
	}

}
