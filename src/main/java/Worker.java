
public class Worker {
	private String firstName;

	private Gender gender;

	public int id;

	public Worker(String firstName, Gender gender, int id) {
		this.firstName = firstName;
		this.gender = gender;
		this.id = id;
	}

	public String getFullName() {
		return firstName;
	}

}