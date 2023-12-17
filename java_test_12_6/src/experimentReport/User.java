package experimentReport;

import java.util.UUID;

public class User {
    private String username;
    private String password;
    private String personID;
    private String phoneNumber;
    private String userID;
    
    public User() {
    }

    public User(String username, String password, String personID, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.personID = personID;
        this.phoneNumber = phoneNumber;
        this.setUserID(generateUserID());
        UserStorage.getInstance().registerUser(this); // 添加用户信息到UserStorage
    }

    // 省略了getter和setter方法

    private String generateUserID() {
        // 生成随机用户ID并返回
        String generatedUserID = UUID.randomUUID().toString();
        return generatedUserID;
    }

    public boolean login(String username, String password) {
        // 根据输入的用户名和密码进行登录验证
        return UserStorage.getInstance().loginUser(this.userID, password);
    }

    @Override
    public String toString() {
        return "用户名：" + username + "\n" + "密码：" + password + "\n" + "用户id：" + userID + "\n" + "电话号码：" + phoneNumber
                + "\n";
    }
}
