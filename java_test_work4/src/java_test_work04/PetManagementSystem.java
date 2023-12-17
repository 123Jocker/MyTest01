package java_test_work04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PetManagementSystem {
	private Map<String, String> keepers; // 存储管理员的信息

	public PetManagementSystem() {
		keepers = new HashMap<>();
	}

//用户注册
	public void register() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = scanner.nextLine();
		System.out.println("请输入密码：");
		String password = scanner.nextLine();
		if (keepers.containsKey(username)) {
			System.out.println("该用户名已被注册！");
		} else {
			keepers.put(username, password);
			System.out.println("注册成功！");
		}
	}

//用户登录
	public boolean login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String keepername = scanner.nextLine();
		System.out.println("请输入密码：");
		String password = scanner.nextLine();
		if (keepers.containsKey(keepername) && keepers.get(keepername).equals(password)) {
			System.out.println("登录成功！");
			return true;
		} else {
			System.out.println("用户名或密码错误！");
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 创建宠物商店管理系统对象
		PetManagementSystem system = new PetManagementSystem();

		System.out.println("欢迎使用宠物商店管理系统！");

		while (true) {
			System.out.println("请选择操作：");
			System.out.println("1. 注册");
			System.out.println("2. 登录");
			System.out.println("0. 退出");

			int choice = scanner.nextInt();
			scanner.nextLine(); // 读取换行符

			switch (choice) {
			case 1:
				system.register(); // 调用注册方法
				break;
			case 2:
				if (system.login()) { // 调用登录方法
					System.out.println("登录成功！");
					// 登录成功后进入成绩管理系统
					enterPetManagementSystem(system, scanner);
				} else {
					System.out.println("登录失败，请重新登录或注册！");
				}
				break;
			case 0:
				System.out.println("感谢使用宠物管理系统，再见！");
				return;
			default:
				System.out.println("输入无效，请重新输入！");
			}
		}
	}

//进入宠物管理系统 
	private static void enterPetManagementSystem(PetManagementSystem system, Scanner scanner) {
		Scanner input = new Scanner(System.in);
		PetShop shop = new PetShop(100);

		System.out.print("请为您的宠物商店取个名字：");
		shop.setName(input.nextLine());

		System.out.println("您好！" + shop.getName() + "的店长，欢迎使用宠物商店管理系统！");

		String choice = "1";

		while (choice.equals("0") == false) {

			System.out.println("==========宠物商店管理系统==========");
			System.out
					.println("1.查看库存\n" + "2.添加宠物\n" + "3.出售宠物\n" + "4.修改库存信息\n" + "5.查看盈利\n" + "6.销售记录\n" + "0.退出程序");
			System.out.println("===================================");
			System.out.print("请输入你的选择：");

			choice = input.next();

			switch (choice) {

			case "1":
				shop.printView();
				System.out.println("请问您还需要什么服务？");
				break;

			case "2":
				String choice1 = "1";
				do {
					shop.addPets();
					System.out.println("是否继续添加？\n" + "1.是 2.否");
					choice1 = input.next();
				} while (choice1.equals("1"));
				System.out.println("请问您还需要什么服务？");
				break;

			case "3":
				String choice2 = "1";
				do {
					shop.sell();
					System.out.println("是否选择继续出售？\n" + "1.是 2.否");
					choice2 = input.next();
				} while (choice2.equals("1"));
				System.out.println("请问您还需要什么服务？");
				break;
			case "4":
				String choice3 = "1";
				do {
					shop.modifyPets();
					System.out.println("是否选择继续修改？\n" + "1.是 2.否");
					choice3 = input.next();
				} while (choice3.equals("1"));
				System.out.println("请问您还需要什么服务？");
				break;
			case "5":
				shop.profitNote();
				System.out.println("请问您还需要什么服务？");
				break;

			case "6":
				shop.note();
				System.out.println("请问您还需要什么服务？");
				break;

			case "0":
				System.out.println("谢谢您的使用，欢迎下次再来！\n" + "**********按任意键结束程序**********");
				break;

			default:
				System.out.println("错误输入，请重新输入！");
				break;
			}
		}
	}

}
