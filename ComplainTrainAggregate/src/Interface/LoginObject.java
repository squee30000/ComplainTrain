package Interface;

public class LoginObject {
	String name;
	int rank;
	public LoginObject(String x, int y){
		name = x;
		rank = y;
	};
	public String getName() {
		return name;
	}
	public int getRank() {
		return rank;
	}
}
