/**
密码安全性：在User类中，密码是以明文形式存储的。通常情况下，存储密码时应该使用加密算法，以确保用户密码的安全性。

用户ID生成：在User类中，使用UUID生成用户ID。这种方法通常适用于生成唯一标识符，但在某些情况下可能会导致性能问题。另外，如果您希望用户ID是可读的，可以考虑使用其他生成唯一ID的方法。

用户信息验证：在User类中的login方法中，使用了UserStorage的实例来进行用户登录验证。这种做法使得User类与UserStorage类强耦合，不够灵活。

用户信息注册：在User类的构造函数中，直接调用UserStorage的registerUser方法来注册用户信息。这种做法使得User类与UserStorage类强耦合，不够灵活。
**/
/**
1. 密码安全性：使用加密算法存储密码，例如使用哈希函数对密码进行加密存储。这样可以确保用户密码的安全性。例如，可以使用Java中的MessageDigest类来进行密码加密。
*/
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    // ...其他属性和方法...

    public void setPassword(String password) {
        this.password = encryptPassword(password);
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : hash) {
                result.append(String.format("%02x", b));
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return password; // 返回原始密码作为备选方案
        }
    }
}
/**
2. 用户ID生成：如果您希望用户ID是可读的，可以考虑使用其他生成唯一ID的方法，例如使用时间戳结合随机数生成唯一ID。
**/
public class User {
    // ...其他属性和方法...

    public String generateUserID() {
        // 生成可读的唯一用户ID并返回
        String generatedUserID = "UID_" + System.currentTimeMillis() + "_" + Math.random();
        return generatedUserID;
    }
}

/**
3. 用户信息验证和注册：将用户信息验证和注册的逻辑与User类分离，以减少User类与UserStorage类的耦合度。可以将这些逻辑放到一个单独的服务类中，例如UserService。
**/
public class UserService {
    private UserStorage userStorage;

    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public boolean loginUser(String userID, String password) {
        User user = userStorage.getUserByID(userID);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public void registerUser(User user) {
        userStorage.registerUser(user);
    }
}
/**
可以提高密码安全性，改善用户ID生成方式，并将用户信息验证和注册的逻辑与User类分离，使得代码更加灵活和可维护。
**/