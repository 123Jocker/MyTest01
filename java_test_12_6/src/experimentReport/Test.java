package experimentReport;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    	// 创建用户管理对象
    	UserStorage userManagement = new UserStorage();

        // 用户注册
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        System.out.println("请输入学号：");
        String studentID = scanner.nextLine();
        System.out.println("请输入电话号码：");
        String phoneNumber = scanner.nextLine();

        User newUser = new User(username, password, studentID, phoneNumber);
        userManagement.registerUser(newUser);

        // 用户登录
        System.out.println("请输入用户名：");
        String loginUsername = scanner.nextLine();
        System.out.println("请输入密码：");
        String loginPassword = scanner.nextLine();

        if (userManagement.checkUserCredentials(loginUsername, loginPassword)) {
            System.out.println("登录成功，进入学生成绩信息管理页面");
            // 进入学生成绩信息管理页面的逻辑
            
        } else {
            System.out.println("用户名或密码错误");
            // 返回登录页面或其他逻辑
            
        }
    }
}
