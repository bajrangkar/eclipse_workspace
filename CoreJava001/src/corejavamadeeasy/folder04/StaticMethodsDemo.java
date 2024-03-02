package corejavamadeeasy.folder04;


public class StaticMethodsDemo {
	public static void main(String[] args) {
		System.out.println("Inside main()");
		StaticMethodsDemo.method1();
	}
	
	static void method1() {
		System.out.println("Inside static method1()");
	}
	
	static {
		System.out.println("Inside static Block");
		StaticMethodsDemo.method1();
	}
	
}
