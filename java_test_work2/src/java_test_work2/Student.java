//package java_test_work2;
//
//public abstract class Student extends User {
//	private Long sid;
//	private String sname;
//	private Long sno;
//	private Score score;
//
//	public Student(String username, String password, String personID, String phoneNumber, Long sid, String sname,
//			Long sno) {
//		super(username, password, personID, phoneNumber);
//		this.sid = sid;
//		this.sname = sname;
//		this.sno = sno;
//		this.score = new Score();
//	}
//
//	@Override
//	public boolean login() {
//		// 假设用户名和密码分别存储在username和password字段中
//		System.out.println("请输入用户名：");
//		String username = this.getUsername();
//		System.out.println("请输入密码：");
//		String password = this.getPassword();
//
//		// 假设UserStorage是一个存储用户信息的类
//		User user = UserStorage.getInstance().getUserByUsername(username);
//		if (user != null && user.getPassword().equals(password)) {
//			return true; // 验证成功
//		} else {
//			return false; // 验证失败
//		}
//	}
//
//	public Long getSid() {
//		return sid;
//	}
//
//	public void setSid(Long sid) {
//		this.sid = sid;
//	}
//
//	public String getSname() {
//		return sname;
//	}
//
//	public void setSname(String sname) {
//		this.sname = sname;
//	}
//
//	public Long getSno() {
//		return sno;
//	}
//
//	public void setSno(Long sno) {
//		this.sno = sno;
//	}
//
//	public Score getScore() {
//		return score;
//	}
//
//	public void setScore(Score score) {
//		this.score = score;
//	}
//
//	@Override
//	public String toString() {
//		return "序号: " + sid + "\n姓名: " + sname + "\n学号: " + sno + "\n成绩: " + score.toString();
//	}
//
//	public int getStudentId() {
//		return sno.intValue();
//	}
//}