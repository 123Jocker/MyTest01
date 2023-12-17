package experimentReport;

public class Score {
	private int java;
	private int Math;
	private int SQL;// 数据库
	private int C_language;// C语言
	private int Software;// 软件工程
	private int physics;// 物理

	private double sum;// 总分
	private double avg;// 平均分

	public Score() {

	}

	public Score(int java, int Math, int SQL, int C_language, int Software, int physics) {
		super();
		this.java = java;
		this.Math = Math;
		this.SQL = SQL;
		this.C_language = C_language;
		this.Software = Software;
		this.physics = physics;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getMath() {
		return Math;
	}

	public void setMath(int Math) {
		this.Math = Math;
	}

	public int getSql() {
		return SQL;
	}

	public void setSql(int SQL) {
		this.SQL = SQL;
	}

	public int getC_language() {
		return C_language;
	}

	public void setC_language(int C_language) {
		this.C_language = C_language;
	}

	public int getSoftware() {
		return Software;
	}

	public void setSoftware(int Software) {
		this.Software = Software;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public double getSum() {
		double sum = this.java + this.Math + this.SQL + this.C_language + this.Software + this.physics;
		return sum;
	}

	public double getAvg() {
		double avg = this.getSum() / 6;
		return avg;
	}

	@Override
	public String toString() {
		return "Java程序设计: " + java + "\n" + "高等数学: " + Math + "\n" + "数据库系统概念: " + SQL + "\n" + "C语言: " + C_language
				+ "\n" + "软件工程理论: " + Software + "\n" + "大学物理: " + physics + "\n" + "综合总分: " + getSum() + "\n" + "平均分: "
				+ getAvg();
	}
}