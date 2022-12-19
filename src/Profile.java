import java.util.List;

public class Profile {
	// Your additions/changes below this line
	private List<Grade> listOfGrades;
	public Profile(List<Grade> g) {
		if(g == null || g.isEmpty())
			throw new IllegalArgumentException();
		
		//Goes through List, checks whether classify method of item in the list returns FAIL. If it does, throws exception. 
		g.forEach(grade ->{
			if(grade.classify().equals(Classification.Fail))
				throw new IllegalArgumentException();
		});
		
		this.listOfGrades = g;
	}
	public Classification classify() {
		//Filters items in the list by classification, counts them and compares the count.
		if(this.listOfGrades.stream().filter(grade -> grade.classify().equals(Classification.First)).count() >= this.listOfGrades.size() / 2)
			return Classification.First;
		else if(this.listOfGrades.stream().filter(grade -> grade.classify().equals(Classification.UpperSecond)).count() >= this.listOfGrades.size() / 2)
			return Classification.UpperSecond;
		else if(this.listOfGrades.stream().filter(grade -> grade.classify().equals(Classification.LowerSecond)).count() >= this.listOfGrades.size() / 2)
			return Classification.LowerSecond;
		return Classification.Third;
	}

	public boolean isClear() {
		//Calls function classify, checks whether it returns a certain classification.
		//Then Filters items in the list by classification, counts them and compares the count.
		if(classify().equals(Classification.First) || classify().equals(Classification.UpperSecond))
			if(this.listOfGrades.stream().filter(grade -> grade.classify().equals(Classification.Third)).count() > (this.listOfGrades.size() / 2) / 2)
				return false;
		return true;
	}	
}
