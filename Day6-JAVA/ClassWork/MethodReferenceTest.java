package day6.java8.features;

@FunctionalInterface
interface MyReference {
	void showMessage();
}
public class MethodReferenceTest {
	void myInstanceMethod() { // to call an instance method you need an object
		System.out.println("Example for Instance Method Reference");
	}
	static void myStaticMethod() { // to call a static method you do it with class
		System.out.println("Example for Static Method Reference");
	}
	
	MethodReferenceTest() {
		System.out.println("Constructor");
	}
	
	public static void main(String[] args) {
		//Reference to a Instance Method
		MethodReferenceTest obj = new MethodReferenceTest();
		MyReference reference = obj :: myInstanceMethod;
		reference.showMessage();
		
		//Reference to a static method
		reference = MethodReferenceTest :: myStaticMethod;
		reference.showMessage();
		
		
		//Reference to a Constructor
		reference = MethodReferenceTest :: new; //here you are using class not object because obj will be created after constructor is created
		reference.showMessage();
	}
}
