/**
 * 
 */
package duke.learn.practice;

/**
 * @author Kazi
 *
 */
public class AbstractFactoryDesign {

    /**
     * @param args
     */
    public static void main(String[] args) {
	AbstractFactory<Animal> factory = FactoryProvider.getFactory("animal");
	Animal animal = factory.create("Dog");
	System.out.println(animal.makeSound());
	// Employee e1 = new Employee(1, "E1"), e2 = new Employee(2, "E2"), e3 = new
	// Employee(3, "E3"),
	// e4 = new Employee(4, "E4"), e5 = new Employee(1, "E1");
	// Map<Employee, Integer> map = new HashMap<Employee, Integer>();
	// map.put(e1, e1.id);
	// map.put(e2, e2.id);
	// map.put(e3, e3.id);
	// map.put(e4, e4.id);
	// map.put(e5, e5.id);
	// System.out.println(map.size());
	// System.out.println(map.get(e5));
    }

}

class FactoryProvider {
    @SuppressWarnings("rawtypes")
    public static AbstractFactory getFactory(String choice) {
	if (choice != null) {
	    if (choice.equalsIgnoreCase("animal"))
		return new AnimalFactory();
	    else if (choice.equalsIgnoreCase("color"))
		return new ColorFactory();
	}
	return null;

    }
}

class AnimalFactory implements AbstractFactory<Animal> {

    public Animal create(String type) {
	if (type != null) {
	    if (type.equalsIgnoreCase("dog"))
		return new Dog();
	    else if (type.equalsIgnoreCase("cat"))
		return new Cat();
	    else if (type.equalsIgnoreCase("duck"))
		return new Duck();
	}
	return null;
    }

}

class ColorFactory implements AbstractFactory<Color> {

    public Color create(String type) {
	if (type != null) {
	    if (type.equalsIgnoreCase("black"))
		return new Black();
	    else if (type.equalsIgnoreCase("white"))
		return new White();
	    else if (type.equalsIgnoreCase("red"))
		return new Red();
	}
	return null;
    }
}

interface AbstractFactory<T> {
    T create(String type);
}

interface Animal {
    String getType();

    String makeSound();
}

class Duck implements Animal {
    public String getType() {
	return "Duck is a bird";
    }

    public String makeSound() {
	return ("Quack Quack !!");
    }
}

class Dog implements Animal {
    public String getType() {
	return "Dog is a Canine.";
    }

    public String makeSound() {
	return ("Woof Woof!!");
    }
}

class Cat implements Animal {

    public String getType() {
	return "Cat is a Feline!";
    }

    public String makeSound() {
	return ("Meow Meow!!");
    }

}

interface Color {
    String getColour();
}

class White implements Color {
    public String getColour() {
	return "White color";
    }
}

class Black implements Color {
    public String getColour() {
	return "Black color";
    }
}

class Red implements Color {
    public String getColour() {
	return "Red color";
    }
}

class A {

    public A() {
	System.out.println("A");
    }
}

class B extends A {
    public B() {
	System.out.println("B");
    }
}

class C extends B {
    C(String val) {
	System.out.println(val);
    }
}

class D extends C {
    public D() {
	super("from D");
    }
}

class Employee {
    int id;
    String name;

    /**
     * 
     */
    public Employee() {
	super();
    }

    /**
     * @param id
     * @param name
     */
    public Employee(int id, String name) {
	super();
	this.id = id;
	this.name = name;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "Employee [id=" + id + ", name=" + name + "]";
    }

}