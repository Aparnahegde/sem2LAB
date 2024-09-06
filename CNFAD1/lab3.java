import java.util.*;

abstract class Printer{
	public abstract void display();
	public void show() {
		System.out.println("This is a printer class");
	}
}

class DotMatrix extends Printer{
	private String s;
	public DotMatrix(String s) {
		this.s = s;
	}

	public void display() {
		System.out.println("This is a "+s+" class");
	}
}

class LaserJet extends Printer{
	private String s;
	public LaserJet(String s) {
		this.s=s;
	}

	public void display() {
		System.out.println("This is a "+s+" class");
	}
}

public class AbstractionEx {
	public static void main(String[] args) {
		boolean flag=true;
		Scanner sc = new Scanner(System.in);
		while(flag) {
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				Printer p1  = new DotMatrix("Dot Matrix");
				p1.display();
				p1.show();
				break;
			case 2:
				Printer p2  = new LaserJet("Laser Jet");
				p2.display();
				p2.show();
				break;
			case 3:
				flag=false;
				break;
			default:
				System.out.println("Invalid Choice");
				
			}
		}
		
		
	}

}



// 2nd
import java.util.Scanner;

interface Vehicle{
	public void drive();
	default void show() {
		System.out.println("This is a Vehicle interface");
	}
}

class Car implements Vehicle{
	private String s;
	public Car(String s) {
		this.s=s;
	}
	public void drive() {
		System.out.println("This is a "+s+" class");
	}
}

class MotorCycle implements Vehicle{
	private String s;
	public MotorCycle(String s) {
		this.s=s;
	}
	public void drive() {
		System.out.println("This is a "+s+" class");
	}
}

public class OverridingEx {

	public static void main(String[] args) {
		boolean flag=true;
		Scanner sc = new Scanner(System.in);
		
		while(flag) {
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				Car p1  = new Car("Car");
				p1.drive();
				p1.show();
				break;
			case 2:
				MotorCycle p2  = new MotorCycle("Motor Cycle");
				p2.drive();
				p2.show();
				break;
			case 3:
				flag=false;
				break;
			default:
				System.out.println("Invalid Choice");
				
			}
		}

	}

}


