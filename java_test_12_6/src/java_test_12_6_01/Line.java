/*都说两点确定一条直线，那么设计一个直线类Line，需要通过两个点Point对象来确定。Line类具体要求如下：

1)定义两个Point对象p1，p2；

2)写出有参构造方法，传递两个对象值给p1，p2

3）为p1，p2写出setters，和getters方法

4）为Line写出一个getLength方法求直线中两点的长度

5) 为LIne写一个ToString方法，方法如下所示：

public String toString() {
return "Line [p1=" + p1 + ", p2=" + p2 + "]";
}

在Main类的main方法中，定义一个Line数组，数组长度通过键盘给出，然后通过键盘为每线段的两个Point对象的坐标赋值，并生成相应Line对象放入数组中，循环数组，输出每条直线的信息，以及两个点之间的距离。

Point 类如下所示：

public class Point {
    private int x, y;// x,y为点的坐标
    //求两点之间的距离
    public double distance(Point p1) {
        return Math.sqrt((p1.x -this.x)*(p1.x -this.x)+(p1.y-this.y)*(p1.y-this.y));
    }
    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Point() {
        super();
        x = y =0;
    }
    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}
输入格式:
第一行输入数组的长度n
每一行输入一个Line对象的两个点对象的 x y的坐标，中间用空格隔开

输出格式:
循环输出，输出直线的信息，以及每条直线的两个点的距离，保留一位小数。

输入样例:
在这里给出一组输入。例如：

2
0 0 2 3
1 3 2 5
输出样例:
在这里给出相应的输出。例如：

Line [p1=Point [x=0, y=0], p2=Point [x=2, y=3]]
此线段的长度为：3.6
Line [p1=Point [x=1, y=3], p2=Point [x=2, y=5]]
此线段的长度为：2.2
 */
package java_test_12_6_01;

import java.util.Scanner;

class Point {
	private int x, y;// x,y为点的坐标
	// 求两点之间的距离

	public double distance(Point p1) {
		return Math.sqrt((p1.x - this.x) * (p1.x - this.x) + (p1.y - this.y) * (p1.y - this.y));
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point() {
		super();
		x = y = 0;
	}

	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

public class Line {
	Point p1, p2;// 定义两个Point对象p1，p2
	// 有参构造方法，传递两个对象给p1，p2

	public Line(Point x, Point y) {
		p1 = x;
		p2 = y;
	}

	// 给对象p1，p2写setters和getters方法
	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	// 为Line写一个getLength方法求直线中两点的长度
	public double getLength() {
		return p1.distance(p2);
	}

	// 为Line写一个ToString方法
	public String toString() {
		return "Line [p1=" + p1 + ", p2=" + p2 + "]";
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNextInt()) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				int d = sc.nextInt();
				Point x = new Point(a, b);
				Point y = new Point(c, d);
				Line l = new Line(x, y);
				System.out.println(l.toString());
				System.out.println("此线段的长度为：" + String.format("%.1f", l.getLength()));
				// l.getLength();
			}
		}
	}
}
