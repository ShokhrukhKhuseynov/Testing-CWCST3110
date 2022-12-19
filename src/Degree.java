import java.util.List;

public class Degree {
	// Your additions/changes below this line
	private Profile level5Profile;
	private Profile level6Profile;
	
	public Degree(List<Grade> year2, List<Grade> year3) {
		if(year2 == null || year3 == null || year2.size() < 4 || year3.size() < 4 )
			throw new IllegalArgumentException();
		year2.forEach(grade -> {
			if(grade.classify().equals(Classification.Fail))
				throw new IllegalArgumentException();
		});
		year3.forEach(grade -> {
			if(grade.classify().equals(Classification.Fail))
				throw new IllegalArgumentException();
		});
		
		this.level6Profile = new Profile(year3);
		//Concatenates array to itself
		year2.addAll(year3);
		this.level5Profile = new Profile(year2);
	}
		
	public Classification classify() {
		
		if(level6Profile.classify().equals(level5Profile.classify()))
			return level6Profile.classify();
		else if(level6Profile.isClear() && level6Profile.classify().compareTo(level5Profile.classify()) == 1)
			return level6Profile.classify();
		else if(level5Profile.isClear() && level5Profile.classify().compareTo(level6Profile.classify()) == 1)
			return level5Profile.classify();
		return Classification.Discretion;
	}
}
