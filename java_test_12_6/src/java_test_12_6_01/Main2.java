package java_test_12_6_01;

import java.util.Scanner;
//定义抽象类Shape，包含两个抽象方法getArea()和getCircum()，分别实现获取图形的面积和周长。一个普通方法print()用于输出面积和周长。
//基于Shape类定义矩形类Ranctangle和圆类Circle。圆类包含数据成员有半径，矩形类包含数据成员的有长、宽，
//每个类都要重写从Shape类继承的两个抽象方法getArea()和getCircum()：
//计算并获取面积和周长。
//在测试类中创建圆类和矩形类的对象，调用方法print()输出面积和周长。
//
//编程要求：请在下面标注 【】 的位置添加代码。圆周率用：Math.PI
//
//import java.util.Scanner;
//
////定义形状类Shape
//【】class Shape{
//    public 【】 double GetArea();   //定义抽象方法GetArea()
//    public 【】 double GetCircum(); //定义抽象方法GetCircum()
//    public void print()
//    {
//        System.out.println("周长："+GetCircum()+" 面积："+GetArea());
//    }
//}
////矩形类，从形状类Shape派生
//class Rectangle 【】 Shape{
//      double width;
//      double length;
//    public Rectangle(double wid,double len){
//        this.width=wid;
//        this.length=len;
//    }
//    //重写GetArea()方法
//		【】
//    //重写GetCircum()方法
//    	【】
//}
////圆类，从形状类派生
//class Circle extends Shape{
//    public double radius;
//    public Circle(double r){
//      this.radius=r;
//    }
//     //重写GetArea()方法
//    【】
//
//    //重写GetCircum()方法
//    【】
//}
////测试类Test
//public class Main {
//    public static void main(String[] args){
//        Scanner input = new Scanner(System.in);
//        double radius = input.nextDouble();
//        double width = input.nextDouble();
//        double length = input.nextDouble();
//        Circle cir = new Circle(radius);   //创建圆的对象cir
//        cir.print();                       //输出圆的的信息        
//        Rectangle rec = new Rectangle(width, length);  //创建矩形的对象rec        
//        rec.print();             //输出矩形的的信息
//    }
//}
//
//输入样例:
//5
//2 4
//输出样例:
//在这里给出相应的输出。例如：
//
//周长：31.41592653589793 面积：78.53981633974483
//周长：8.0 面积：12.0

//定义抽象abstract类Shape
abstract class Shape {
	// 实现获取图形的面积和周长
	public abstract double GetArea(); // 定义抽象方法GetArea()

	public abstract double GetCircum(); // 定义抽象方法GetCircum()
	// 一个普通方法print()用于输出面积和周长。

	public void print() {
		System.out.println("周长：" + GetCircum() + " 面积：" + GetArea());
	}
}

//基于Shape类定义矩形类Ranctangle和圆类Circle。
//矩形类，从形状类Shape派生
////矩形类包含数据成员的有长、宽
class Rectangle extends Shape {
	double width;
	double length;

	public Rectangle(double wid, double len) {
		this.width = wid;
		this.length = len;
	}

	// 重写GetArea()方法
	// 面积
	@Override
	public double GetArea() {
		return length * width;
	}

	@Override
	// 重写GetCircum()方法
	// 周长
	public double GetCircum() {
		// TODO Auto-generated method stub
		return 2 * (width + length);
	}
}

////圆类，从形状类派生
//圆类包含数据成员有半径
class Circle extends Shape {
	public double radius;// 半径

	public Circle(double r) {
		this.radius = r;
	}

	@Override
	// 重写GetArea()方法
	public double GetArea() {
		return Math.PI * radius * radius;
	}

	@Override
	// 重写GetCircum()方法
	public double GetCircum() {
		return 2 * Math.PI * radius;
	}
}

//测试类Test
public class Main2 {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			double radius = input.nextDouble();
			double width = input.nextDouble();
			double length = input.nextDouble();
			Circle cir = new Circle(radius); // 创建圆的对象cir
			cir.print(); // 输出圆的的信息
			Rectangle rec = new Rectangle(width, length); // 创建矩形的对象rec
			rec.print(); // 输出矩形的的信息
		}
	}
}