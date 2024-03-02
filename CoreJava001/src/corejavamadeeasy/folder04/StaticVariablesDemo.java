package corejavamadeeasy.folder04;


public class StaticVariablesDemo {
	
	static int x = 5;
	
	public static void main(String[] args) {
		System.out.println("Inside main()");
		StaticVariablesDemo.method1();
	}
	
	static void method1() {
		System.out.println("Inside static method1()");
		System.out.println("X Now : " + x++);
	}
	
	static {
		System.out.println("Inside static Block");
		StaticVariablesDemo.method1();
	}
	
}
