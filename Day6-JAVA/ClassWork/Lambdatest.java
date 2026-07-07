package day6.java8.features;

@FunctionalInterface
interface Calculator {
	public int calc(int a,int b);
}

public class Lambdatest {

	public static void main(String[] args) {
		Calculator calculator = (a,b) -> a+b;
		System.out.println(calculator.calc(10,20));
		
		calculator = (a,b) -> a-b;
		System.out.println(calculator.calc(10,20));
	}

}
