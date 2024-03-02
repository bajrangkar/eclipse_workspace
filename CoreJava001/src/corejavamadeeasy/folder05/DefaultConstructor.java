package corejavamadeeasy.folder05;


public class DefaultConstructor {
	
	static int x = 5;
	
	DefaultConstructor() {
		System.out.println("Inside Default Constructor");
		DefaultConstructor.method1(); // Cannot access static members from non static scope		
		// This would compile and run also. Until an object of the class is made, no error occurs.
	}
	
	public static void main(String[] args) {
		System.out.println("Inside main()");
		DefaultConstructor.method1();
	}
	
	static void method1() {
		System.out.println("Inside static method1()");
		System.out.println("X Now : " + x++);
	}
	
	static {
		System.out.println("Inside static Block");
		DefaultConstructor.method1();
	}
	
}

class DefaultContructorZingalala {
	public static void main(String[] args) {
		System.out.println("Inside Zingalala Main method");
		DefaultConstructor.method1(); //The constructor not runs yet. Because calling the class in static context does not run instance scope. 
		
		DefaultConstructor dc = new DefaultConstructor(); //now the constructor invokes. No errors, as static members are used from instance scope after class load.
		
		dc.method1();
	}
}
