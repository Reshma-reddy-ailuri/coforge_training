package day6.java8.features;
//creating interface
interface MyInterface{
	// default belongs to object and can be override but static methods belongs to interface and cannot be override
	//creating default method
	public default void myMethod1() {
		System.out.println("Default Method");
	}
	void myMethod2();
	public static void myMethod3() {
		System.out.println("Static Method");
	}
	
}

public class Java8InterfaceTest implements MyInterface {
	@Override
    public void myMethod1() {
        System.out.println("Overridden Default Method");
    }
	//static method belong to class not object so we can't override
	/*@Override
	public void myMethod3() {
		System.out.println("Static Method");
	}*/
	
	public static void main(String[] args) {

	    Java8InterfaceTest obj = new Java8InterfaceTest();

	    obj.myMethod1();
	    obj.myMethod2();
	    MyInterface.myMethod3();
	}
	@Override
	public void myMethod2() {
		// TODO Auto-generated method stub
		
	}

}
