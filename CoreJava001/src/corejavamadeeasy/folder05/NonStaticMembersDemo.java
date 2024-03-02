package corejavamadeeasy.folder05;


public class NonStaticMembersDemo {
	
	static int x = 5;
	
	NonStaticMembersDemo() {
		System.out.println("Inside Default Constructor");
		NonStaticMembersDemo.staticMethod("From Inside constructor"); // Cannot access static members from non static scope		
		// This would compile and run also. Until an object of the class is made, no error occurs.
	}
	
	public static void main(String[] args) {
		System.out.println("Inside main()");
		NonStaticMembersDemo.staticMethod("From inside main");
	}
	
	static void staticMethod(String k) {
		System.out.println("Inside staticMethod :: " + k);
		System.out.println("X Now : " + x++);
	}
	
	static {
		System.out.println("Inside static Block");
		NonStaticMembersDemo.staticMethod("From static Block");
	}
	
	{
		System.out.println("Non Static Block");
		NonStaticMembersDemo.staticMethod("From Instance Block");
	}
	
	void instanceMethod(String k) {
		System.out.println("Inside instanceMethod() :: " + k);
		if(x >= 10) x = 2;
		System.out.println("X Now : " + x++);
	}
	
}

class NonStaticMembersDemoZingalala {
	public static void main(String[] args) {
		System.out.println("Inside Zingalala Main method");
		NonStaticMembersDemo.staticMethod("First call to staticMethod from outside class"); //The constructor not runs yet. Because calling the class in static context does not run instance scope. 
		NonStaticMembersDemo.staticMethod("Second call to staticMethod from outside class");
		NonStaticMembersDemo dc = new NonStaticMembersDemo(); //now the constructor invokes. No errors, as static members are used from instance scope after class load.
		
		dc.staticMethod("Third call to staticMethod from outside class using object");
		
		dc.instanceMethod("First call to instanceMethod");
		
		NonStaticMembersDemo dc2 = new NonStaticMembersDemo(); //now the constructor invokes. No errors, as static members are used from instance scope after class load.
		
		dc2.staticMethod("Fourth call to staticMethod from outside class using object");
		
		dc2.instanceMethod("Second call to instanceMethod");
		
		
	}
}

/*
 * Order is as following -
 * static block - only once - when the class loads first time
 * instance block - every time when an instance created 
 * constructor - every time an object created
 *  
 * 
 * */
