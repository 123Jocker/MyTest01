//设计一个名为Fan的类表示一个风扇。这个类包括：
//
//1.三个名为SlOW、MEDIUM和FAST，其值为1、2和3常量表示风扇的速度。
//
//2.一个名为speed的int类型私有数据域表示风扇的速度（默认值为SLOW）。
//
//3.一个名为on的boolean类型私有数据域表示风扇是否打开（默认值为false）。
//
//4.一个名为radius的double类型私有数据域表示风扇的半径（默认值为5）。
//
//5.一个名为color的string类型数据域表示风扇的颜色（默认值为white）。
//
//6.这四个成员变量(数据域)的访问器和修改器。
//
//7.一个无参构造方法;
//
//8.一个有参构造方法 public Fan(int fanSpeed,boolean fanOn,double fanRadius,String fanColor) { ... }，
//
//9.一个名为toString()的方法返回描述风扇的字符串。如果风扇是打开的，那么该方法在一个组合的字符串中返回风扇的速度、颜色和半径。
//如果风扇没有打开，该方法就会返回一个由"fan is off"和风扇颜色以及半径组合成的字符串。
//
//请在自己的草稿本上画出UML图，养成良好的设计习惯。
//
//要求：创建两个Fan对象：
//
//第一个对象利用无参构造方法构造默认风扇对象Fan1；
//
//第二个对象依据输入的风扇属性，调用有参构造方法构造自定义风扇对象Fan2。
//
//通过调用它们的toString方法显示这些对象。
//
//输入格式:
//第二个对象的属性
//
//输出格式:
//分别输出默认风扇和自定义风扇的速度、颜色、半径以及风扇是否打开
//
//输入样例:
//在这里给出一组输入。例如：
//
//2
//True
//6
//Red 
//输出样例:
//在这里给出相应的输出。例如：
//
//-------
//Default
//-------
//speed 1
//color white
//radius 5.0
//fan is off
//-------
//My Fan
//-------
//speed 2
//color Red
//radius 6.0
//fan is on
package java_test_12_6_01;

import java.util.Scanner;

public class Fan {
	// 常量
	static final int SLOW = 1;
	static final int MEDIUM = 2;
	static final int FAST = 3;

	// 默认值--数据域
	private int speed = 1;
	private boolean on = false;
	private double radius = 5;
	String color = "white";

	// 获取速度
	public int getSpeed() {
		return speed;
	}

	// 设置速度
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// 传参---风扇打开
	public boolean isOn() {
		return on;
	}

	// 设置风扇打开
	public void setOn(boolean on) {
		this.on = on;
	}

	// 颜色
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// 半径
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// 无参的风扇
	public Fan() {

	}

	// 有参的构造函数
	public Fan(int speed, boolean on, double radius, String color) {
		this.speed = speed;
		this.on = on;
		this.radius = radius;
		this.color = color;
	}

	public String toString() {
		String s = "speed " + speed + "\n" + "color " + this.getColor() + "\n" + "radius " + radius + "\n";
		if (on == false) {
			s += "fan is off";
		} else {
			s += "fan is on";
		}
		return s;
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("-------\n" + "Default\n" + "-------");
			Fan f1 = new Fan();
			Fan f2 = new Fan(s.nextInt(), s.nextBoolean(), s.nextDouble(), s.next());
			System.out.println(f1.toString());
			System.out.println("-------\n" + "My Fan\n" + "-------");
			System.out.println(f2.toString());
		}
	}
}
