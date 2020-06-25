package garbage;

public class Dog {
	private String name;
	private int age;
	
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	
	// Special finalizer method
	public void finalize() {
		System.out.println("Oh no! " + name + " is being collected by the GC!");
	}
	
}
