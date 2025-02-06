package ProjectG.ProjectG;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private double salary;
	
	public Employee(int id, String firstName, String lastName, int age, double salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId() {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName() {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName() {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge() {
		this.age = age;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary() {
		this.salary = salary;
	}

}
