public class Grade {
	private final int points;

	public int getPoints() {
		return points;
	}

	public Grade(int p) throws IllegalArgumentException {
		if(p<1 || p>20) 
			throw new IllegalArgumentException();
		points = p;
	}
	
	// Your additions/changes below this line
	public Classification classify() {
		if(this.points < 5)
			return Classification.First;
		else if(this.points < 9)
			return Classification.UpperSecond;
		else if(this.points < 13)
			return Classification.LowerSecond;
		else if(this.points < 17)
			return Classification.Third;
		return Classification.Fail;
	}
	
	public static Grade fromPercentage(int g) throws IllegalArgumentException {
		int point = 0;
		if(g < -1 || g > 100)
			throw new IllegalArgumentException();
		if(g > 78)
			point = 1;
		else if(g > 75)
			point = 2;
		else if(g > 72)
			point = 3;
		else if(g > 69)
			point = 4;
		else if(g > 66)
			point = 5;
		else if(g > 64)
			point = 6;
		else if(g > 61)
			point = 7;
		else if(g > 59)
			point = 8;
		else if(g > 56)
			point = 9;
		else if(g > 54)
			point = 10;
		else if(g > 51)
			point = 11;
		else if(g > 49)
			point = 12;
		else if(g > 46)
			point = 13;
		else if(g > 44)
			point = 14;
		else if(g > 41)
			point = 15;
		else if(g > 39)
			point = 16;
		else if(g > 34)
			point = 17;
		else if(g > 29)
			point = 18;
		else if(g > 0)
			point = 19;
		else
			point = 20;
		
		return new Grade(point);
	}
}
