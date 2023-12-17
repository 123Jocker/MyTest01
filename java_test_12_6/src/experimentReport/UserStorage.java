package experimentReport;
/*实现了用户注册和存储用户注册信息的功能，
并为每个注册的用户分配了一个唯一的用户ID。
用户注册完成后，可以跳转到用户登录页面，
然后使用用户ID和密码进行登录验证。
如果用户ID存在且密码匹配，
则可以进入用户管理学生成绩信息的选项页面。
如果用户ID不存在或密码不匹配，
则可以返回注册页面进行注册或重新输入密码。
*/

import java.util.HashMap;

public class UserStorage {
    private static UserStorage instance = new UserStorage();
    private HashMap<String, User> users = new HashMap<>();

    private UserStorage() {
        // 私有构造函数，防止外部实例化
    }

    public static UserStorage getInstance() {
        return instance;
    }

    public boolean addUser(User user) {
        if (users.containsKey(user.getUserID())) {
            return false; // 用户ID已存在，注册失败
        }
        users.put(user.getUserID(), user);
        return true; // 注册成功
    }

    public User getUserByID(String userID) {
        return users.get(userID); // 根据用户ID获取用户信息
    }

    public boolean checkUserCredentials(String userID, String password) {
        if (users.containsKey(userID)) {
            User user = users.get(userID);
            return user.getPassword().equals(password); // 验证用户ID和密码是否匹配
        }
        return false; // 用户ID不存在
    }

    //用于注册用户
    public void registerUser(User user) {
        users.put(user.getUserID(), user);
    }

    //用于用户登录验证
    public boolean loginUser(String userID, String password) {
        if (users.containsKey(userID)) {
            User user = users.get(userID);
            return user.getPassword().equals(password);
        }
        return false;
    }
}
