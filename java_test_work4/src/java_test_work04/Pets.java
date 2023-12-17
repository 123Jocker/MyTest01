package java_test_work04;

public class Pets {
//	种类
	private String kind;
//	颜色
	private String color;
//	年龄
	private int age;
//	性别
	private String sex;
//	形状
	private String shape;
//	进货价格
	private double inPrice;
//	销售价格
	private double outPrice;
//	盈利
	private double profit;

//宠物的父类方法
	public Pets(String kind, String color, int age, String sex, String shape) {
		this.kind = kind;
		this.color = color;
		this.age = age;
		this.sex = sex;
		this.shape = shape;
	}

	public Pets() {

	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	// 宠物商店价目
	public double getInprice() {
		return inPrice;
	}

	public void setInprice(double inPrice) {
		this.inPrice = inPrice;
	}

	public double getOutprice() {
		return outPrice;
	}

	public void setOutprice(double outPrice) {
		this.outPrice = outPrice;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
}
