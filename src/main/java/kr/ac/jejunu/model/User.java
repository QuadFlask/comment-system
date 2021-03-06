package kr.ac.jejunu.model;

public class User {
	private String id, name, password, explanation;

	public User() {
		super();
	}

	public User(String id, String name, String password, String explanation) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.explanation = explanation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

}
