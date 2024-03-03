import helper_functions.DefaultStruct;
import helper_functions.Gender;

public class Worker implements DefaultStruct {
	public final String name;
	public final int id;
	private final Gender gender;

	public Worker(String name, Gender gender, int id) {
		this.name = name;
		this.gender = gender;
		this.id = id;
	}

	public void print() {
		System.out.println(id);
	}
}