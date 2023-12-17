package experimentReport;

public class Student {
	private Long Sid;// 序号
	private String Sname;// 学生姓名
	private Long Sno;// 学号
	private String CName;// 课程名称
	private double Score;// 成绩

	public Student() {
		super();
	}

	public Student(Long Sid, String Sname, Long Sno, String CName, double Score) {
		super();
		this.Sid = Sid;
		this.Sname = Sname;
		this.Sno = Sno;
		this.CName = CName;
		this.Score = Score;
	}

	// 序号
	public Long getSid() {
		return Sid;
	}

	public void setSid(Long id) {
		this.Sid = id;
	}

	// 学生姓名
	public String getSname() {
		return Sname;
	}

	public void setSname(String name) {
		this.Sname = name;
	}

	// 学生学号
	public Long getSno() {
		return Sno;
	}

	public void setSno(Long sno) {
		this.Sno = sno;
	}

	// 课程名称
	public String getCName() {
		return CName;
	}

	public void setCName(String courseName) {
		this.CName = courseName;
	}

	// 学生成绩
	public double setGrade() {
		return Score;
	}

	public void getGrade(double Sgrade) {
		this.Score = Sgrade;
	}

	public void toString(Long Sid, String Sname, Long Sno, String CName, double Score) {
		System.out.println("\t" + "序号" + "\t\n" + "姓名" + "\t\n" + "学号" + "\t\n" + "课程名称" + "\t\n" + "课程分数");
		System.out.println("\t" + Sid + "\t\n" + Sname + "\t\n" + Sno + "\t\n" + CName + "\t\n" + Score);
	}
}