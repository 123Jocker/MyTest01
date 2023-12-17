//package java_test_work2;
//
///*实现了用户注册和存储用户注册信息的功能，
//并为每个注册的用户分配了一个唯一的用户ID。
//用户注册完成后，可以跳转到用户登录页面，
//然后使用用户ID和密码进行登录验证。
//如果用户ID存在且密码匹配，
//则可以进入用户管理学生成绩信息的选项页面。
//如果用户ID不存在或密码不匹配，
//则可以返回注册页面进行注册或重新输入密码。
//*/
//
////getInstance()方法用于获取UserStorage的唯一实例，
//// 如果实例不存在，则创建一个新实例并返回。
////UserStorage 类
//import java.util.HashMap;
//import java.util.Map;
//
//public class UserStorage {
//	private Map<String, User> userMap;
//
//	public UserStorage() {
//		userMap = new HashMap<>();
//	}
//
//	public void registerUser(User user) {
//		userMap.put(user.getUsername(), user);
//	}
//
//	public User login(String username, String password) {
//		User user = userMap.get(username);
//		if (user != null && user.getPassword().equals(password)) {
//			return user;
//		}
//		return null;
//	}
//}
