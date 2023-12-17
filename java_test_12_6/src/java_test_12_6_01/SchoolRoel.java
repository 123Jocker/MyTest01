package java_test_12_6_01;

public class SchoolRoel {
	public static void main(String[] args) {
		Faculty fac = new Faculty("张三", 32, "33006", 2021, 9, 1, "讲师");
		StudentPerson stu = new StudentPerson("李四", 19, "20201103", "202011");
		Staff sta = new Staff("王五", 27, "32011", 2017, 7, 23, "教务员");
		fac.show();
		sta.show();
		stu.show();
	}
}

// 基类 Role
class Role {
	String name; // 姓名
	int age;

	// 构造方法
	public Role() {
	}

	public Role(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Setter/Getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 业务方法
	public void show() {
		System.out.println("我是" + name + "，年龄" + age + "岁。");
	}
}

// 派生类 Faculty 教员
class Faculty extends Role {
	// 入职时间
	protected int Y;
	protected int M;
	protected int D;
	protected String num; // 工号
	protected String zc;

	public Faculty(String name, int age, String num, int Y, int M, int D, String zc) {
		this.name = name;
		this.age = age;
		this.Y = Y;
		this.D = D;
		this.M = M;
		this.zc = zc;
		this.num = num;
	}

	public void show() {
		System.out.println(
				"我是" + name + "，年龄" + age + "岁。工号是" + num + "，" + Y + "年" + M + "月" + D + "日入职。是一名教师，" + zc + "职称。");
	}
}

// 派生类 Student 学生
class StudentPerson extends Role {
	protected String num; // 学号
	protected String classnum; // 班级

	public StudentPerson(String name, int age, String num, String classnum) {
		this.name = name;
		this.age = age;
		this.classnum = classnum;

		this.num = num;
	}

	public void show() {
		System.out.println("我是" + name + "，年龄" + age + "岁。学号是" + num + "，来自" + classnum + "班。");

	}

}

// 派生类 Staff 职员
class Staff extends Role {
	protected int Y;// 年
	protected int M;// 月
	protected int D;// 日
	protected String num; // 工号
	protected String zc;

	public Staff(String name, int age, String num, int Y, int M, int D, String zc) {
		this.name = name;
		this.age = age;
		this.Y = Y;
		this.D = D;
		this.M = M;
		this.zc = zc;// 职称
		this.num = num;// 工号
	}

	public void show() {
		System.out.println(
				"我是" + name + "，年龄" + age + "岁。工号是" + num + "，" + Y + "年" + M + "月" + D + "日入职。是一名" + zc + "。");
	}
}
