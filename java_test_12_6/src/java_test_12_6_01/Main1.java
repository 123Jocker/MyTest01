package java_test_12_6_01;

import java.util.Scanner;

//学生类（Student）
class Student {
	// Student类有姓名（name）和年龄（age）属性，两者的访问权限为protected
	protected String name;
	protected int age;

	// 一个包含两个参数的构造方法，用于给姓名和年龄属性赋值
	public Student(String sname, int sage) {
		this.name = sname;
		this.age = sage;
	}

	// 一个show( )方法用于输出Student的属性信息，输出格式为Student[name=XXX,age=XX]
	public void show() {
		System.out.println("Student[name=" + name + ",age=" + age + "]");
	}
}

//学生类（Student）的一个子类——本科生类（Undergraduate）
class Undergraduate extends Student {
	private String major;

//Undergraduate类增加一个专业（major）属性，该属性的访问权限为private
	// 有一个包含三个参数的构造方法，前两个参数用于给继承的年龄和姓名属性赋值，第三个参数给专业属性赋值
	public Undergraduate(String sname, int sage, String major) {
		super(sname, sage);
		this.major = major;
	}

//一个show( )方法用于输出Undergraduate的属性信息,Undergraduate[name=XXX,age=XXX,major=XXX]
	public void show() {
		System.out.println("Undergraduate[name=" + name + ",age=" + age + ",major=" + major + "]");
	}
}

public class Main1 {
	// 测试类Main的main( )方法
	public static void main(String[] args) {
		// 然后分别调用它们的show( )方法
		try (Scanner scanner = new Scanner(System.in)) {
			String name1 = scanner.next();
			int age1 = scanner.nextInt();
			// 调用Student类的带参数的构造方法创建对象object1
			Student object1 = new Student(name1, age1);
			object1.show();

			String name2 = scanner.next();
			int age2 = scanner.nextInt();
			String major = scanner.next();
			// 调用Undergraduate类的带参数的构造方法创建对象object2
			Undergraduate object2 = new Undergraduate(name2, age2, major);
			object2.show();
		}
	}
}