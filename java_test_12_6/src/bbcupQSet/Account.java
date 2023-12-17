package bbcupQSet;

import java.util.Date;

public class Account {
	private int id = 0;// 帐号
	private double balance = 0;// 余额
	private double annualInterestRate = 0;// 存储当前利率
	private Date dateCreated;// 存储帐户的开户日期
	// 创建默认账户的无参构造方法

	public Account() {
		dateCreated = new Date();
	}

	// 创建具有指定id和初始余额的账户的构造方法
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		dateCreated = new Date();
	}

	// id、balance和annualInterestRate的访问器方法与修改器方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	// dataCreated的访问器方法
	public Date getdataCreated() {
		return dateCreated;
	}

	// 一个名为getMonthlyInterestRate()的方法，返回月利率
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}

	// 一个名为getMonthlyIntereset()的方法，返回月利息
	public double getMonthlyIntereset() {
		return balance * getMonthlyInterestRate();
	}

	// 一个名为withDraw的方法，从帐户提取指定额度
	public void withdraw(double amount) {
		balance -= amount;
	}

	// 一个名为deposit的方法向帐户提取指定额度
	public void deposit(double amount) {
		balance += amount;
	}
}
