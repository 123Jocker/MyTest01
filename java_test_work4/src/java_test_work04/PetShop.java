package java_test_work04;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

//宠物商店方法类
public class PetShop {
	Scanner input = new Scanner(System.in);
	private String name;
	private HashMap<String, Pets[]> petsMap;// 存储宠物的信息
	private int petFoot = 0;
	private int num = 0;// 库存
	private int inNum = 0;// 进货数
	private int outNum = 0;// 销售数

	public PetShop(int length) {
		this.petsMap = new HashMap<String, Pets[]>();
		if (length > 0) {
			this.petsMap.put("cat", new Cats[length]);
			this.petsMap.put("dog", new Dogs[length]);
		} else {
			this.petsMap.put("cat", new Cats[1]);
			this.petsMap.put("dog", new Dogs[1]);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 买进宠物
	public void addPets() {
		System.out.println("您添加的是狗还是猫？\n" + "1.狗 2.猫");
		String choice = input.next();

		if (choice.equals("1")) {
			Dogs dog = new Dogs();

			System.out.println("请输入您要添加的宠物的信息");
			System.out.print("种类：");
			dog.setKind(input.next());
			System.out.print("颜色：");
			dog.setColor(input.next());

			// 循环验证年龄是否为正整数
			int age;
			while (true) {
				System.out.print("年龄：");
				try {
					age = Integer.parseInt(input.next());
					if (age > 0) {
						break;
					} else {
						System.out.println("年龄必须为正整数，请重新输入！");
					}
				} catch (NumberFormatException e) {
					System.out.println("年龄必须为正整数，请重新输入！");
				}
			}
			dog.setAge(age);

			System.out.print("性别：");
			dog.setSex(input.next());
			System.out.print("体型：");
			dog.setShape(input.next());
			System.out.print("进货价格：");
			dog.setInprice(input.nextDouble());

			System.out.print("出售价格：");
			dog.setOutprice(input.nextDouble());

			// 检查存储空间是否足够，如果不足则扩容
			if (petFoot == petsMap.get("dog").length) {
				int newLength = petsMap.get("dog").length * 2;
				petsMap.put("dog", Arrays.copyOf(petsMap.get("dog"), newLength));
			}

			// 添加宠物信息
			petsMap.get("dog")[petFoot] = dog;
			petFoot++;
			System.out.println("添加成功！");
			inNum++;
			num++;
		} else if (choice.equals("2")) {
			Cats cat = new Cats();
			System.out.println("请输入您要添加的宠物的信息");
			System.out.print("种类：");
			cat.setKind(input.next());
			System.out.print("颜色：");
			cat.setColor(input.next());

			// 循环验证年龄是否为正整数
			int age;
			while (true) {
				System.out.print("年龄：");
				try {
					age = Integer.parseInt(input.next());
					if (age > 0) {
						break;
					} else {
						System.out.println("年龄必须为正整数，请重新输入！");
					}
				} catch (NumberFormatException e) {
					System.out.println("年龄必须为正整数，请重新输入！");
				}
			}
			cat.setAge(age);

			System.out.print("性别：");
			cat.setSex(input.next());
			System.out.print("体型：");
			cat.setShape(input.next());
			System.out.print("进货价格：");
			cat.setInprice(input.nextDouble());

			System.out.print("出售价格：");
			cat.setOutprice(input.nextDouble());

			// 检查存储空间是否足够，如果不足则扩容
			if (petFoot == petsMap.get("cat").length) {
				int newLength = petsMap.get("cat").length * 2;
				petsMap.put("cat", Arrays.copyOf(petsMap.get("cat"), newLength));
			}

			// 添加宠物信息
			petsMap.get("cat")[petFoot] = cat;
			petFoot++;
			System.out.println("添加成功！");
			inNum++;
			num++;
		} else {
			System.out.println("没有这个选项，请重新输入!");
		}
	}

	// 查看所有宠物的库存清单
	public void printView() {
		Date date = new Date();
		System.out.println("===============宠物商店库存清单===============");
		// 打印猫的信息
		System.out.println("*******************C A T S*******************");
		System.out
				.println("种类" + "\t" + "颜色" + "\t" + "年龄" + "\t" + "性别" + "\t" + "体型" + "\t" + "进货价格" + "\t" + "销售价格");
		for (Pets pet : petsMap.get("cat")) {
			if (pet != null) {
				System.out.println(pet.getKind() + "\t" + pet.getColor() + "\t" + pet.getAge() + "月" + "\t"
						+ pet.getSex() + "\t" + pet.getShape() + "\t" + pet.getInprice() + "\t" + pet.getOutprice());
			}
		}
		// 打印狗的信息
		System.out.println("\n*******************D O G S*******************");
		System.out
				.println("种类" + "\t" + "颜色" + "\t" + "年龄" + "\t" + "性别" + "\t" + "体型" + "\t" + "进货价格" + "\t" + "销售价格");
		for (Pets pet : petsMap.get("dog")) {
			if (pet != null) {
				System.out.println(pet.getKind() + "\t" + pet.getColor() + "\t" + pet.getAge() + "月" + "\t"
						+ pet.getSex() + "\t" + pet.getShape() + "\t" + pet.getInprice() + "\t" + pet.getOutprice());
			}
		}
		System.out.println("=============================================");
		System.out.println("date: " + date);
	}

	public void modifyPets() {
		if (num == 0) {
			System.out.println("当前库存为空，无法修改！");
		} else {
			System.out.println("请选择要修改的宠物类别：\n1.猫 2.狗");
			String choice = input.next();
			if (choice.equals("1")) {
				System.out.println("请输入要修改的猫的特征");
				System.out.print("种类：");
				String kind = input.next();
				System.out.print("颜色：");
				String color = input.next();
				System.out.print("年龄：");
				int age = input.nextInt();
				System.out.print("性别：");
				String sex = input.next();
				int i, flag = -1;
				for (i = 0; i < petsMap.get("cat").length; i++) {
					if (petsMap.get("cat")[i] != null && kind.equals(petsMap.get("cat")[i].getKind())
							&& color.equals(petsMap.get("cat")[i].getColor()) && age == petsMap.get("cat")[i].getAge()
							&& sex.equals(petsMap.get("cat")[i].getSex())) {
						flag = i;
						break;
					}
				}
				if (flag == -1) {
					System.out.println("查无此猫！请核对后重新输入 \n");
				} else {
					System.out.println("请输入新的信息：");
					System.out.print("颜色：");
					petsMap.get("cat")[flag].setColor(input.next());
					System.out.print("年龄：");
					int newAge = input.nextInt();
					petsMap.get("cat")[flag].setAge(newAge);
					System.out.println("修改成功！\n");
				}
			} else if (choice.equals("2")) {
				System.out.println("请输入要修改的狗的特征");
				System.out.print("种类：");
				String kind = input.next();
				System.out.print("颜色：");
				String color = input.next();
				System.out.print("年龄：");
				int age = input.nextInt();
				System.out.print("性别：");
				String sex = input.next();
				int i, flag = -1;
				for (i = 0; i < petsMap.get("dog").length; i++) {
					if (petsMap.get("dog")[i] != null && kind.equals(petsMap.get("dog")[i].getKind())
							&& color.equals(petsMap.get("dog")[i].getColor()) && age == petsMap.get("dog")[i].getAge()
							&& sex.equals(petsMap.get("dog")[i].getSex())) {
						flag = i;
						break;
					}
				}
				if (flag == -1) {
					System.out.println("查无此狗！请核对后重新输入 ");
				} else {
					System.out.println("请输入新的信息：");
					System.out.print("颜色：");
					petsMap.get("dog")[flag].setColor(input.next());
					System.out.print("年龄：");
					int newAge = input.nextInt();
					petsMap.get("dog")[flag].setAge(newAge);
					System.out.println("修改成功！\n");
				}
			} else {
				System.out.println("没有这个选项，请重新输入!");
			}
		}
	}

	// 销售宠物
	public void sell() {
		if (num == 0) {
			System.out.println("库存为零，请及时购进宠物！\n");
		} else {
			System.out.println("您要出售的是猫还是狗？\n" + "1.猫 2.狗");
			String choice = input.next();
			if (choice.equals("1")) {
				System.out.println("请输入您要出售的猫的特征");
				System.out.print("种类：");
				String kind = input.next();
				System.out.print("颜色：");
				String color = input.next();
				System.out.print("年龄：");
				int age = input.nextInt();
				System.out.print("性别：");
				String sex = input.next();
				int i, flag = -1;
				for (i = 0; i < petsMap.get("cat").length; i++) {
					if (petsMap.get("cat")[i] != null && kind.equals(petsMap.get("cat")[i].getKind())
							&& color.equals(petsMap.get("cat")[i].getColor()) && age == petsMap.get("cat")[i].getAge()
							&& sex.equals(petsMap.get("cat")[i].getSex())) {
						flag = i;
						break;
					}
				}
				if (flag == -1) {
					System.out.println("查无此猫！请核对后重新输入 \n");
					sell();
				} else {
					petsMap.get("cat")[flag] = null;
					System.out.println("售出成功！\n");
					outNum++;
					num--;
				}
			} else if (choice.equals("2")) {
				System.out.println("请输入您要出售的狗的特征");
				System.out.print("种类：");
				String kind = input.next();
				System.out.print("颜色：");
				String color = input.next();
				System.out.print("年龄：");
				int age = input.nextInt();
				System.out.print("性别：");
				String sex = input.next();
				int i, flag = -1;
				for (i = 0; i < petsMap.get("dog").length; i++) {
					if (petsMap.get("dog")[i] != null && kind.equals(petsMap.get("dog")[i].getKind())
							&& color.equals(petsMap.get("dog")[i].getColor()) && age == petsMap.get("dog")[i].getAge()
							&& sex.equals(petsMap.get("dog")[i].getSex())) {
						flag = i;
						break;
					}
				}
				if (flag == -1) {
					System.out.println("查无此狗！请核对后重新输入 ");
					sell();
				} else {
					petsMap.get("dog")[flag] = null;
					System.out.println("售出成功！\n");
					outNum++;
					num--;
				}
			} else {
				System.out.println("没有这个选项，请重新输入!");
			}
		}
	}

	// 销售统计

	public void note() {
		Date date = new Date();
		System.out.println("===============宠物商店销售记录清单===============");
		System.out
				.println("种类" + "\t" + "颜色" + "\t" + "年龄" + "\t" + "性别" + "\t" + "体型" + "\t" + "进货价格" + "\t" + "销售价格");
		for (Pets pet : petsMap.get("cat")) {
			if (pet != null) {
				System.out.println(pet.getKind() + "\t" + pet.getColor() + "\t" + pet.getAge() + "月" + "\t"
						+ pet.getSex() + "\t" + pet.getShape() + "\t" + pet.getInprice() + "\t" + pet.getOutprice());
			}
		}
		for (Pets pet : petsMap.get("dog")) {
			if (pet != null) {
				System.out.println(pet.getKind() + "\t" + pet.getColor() + "\t" + pet.getAge() + "月" + "\t"
						+ pet.getSex() + "\t" + pet.getShape() + "\t" + pet.getInprice() + "\t" + pet.getOutprice());
			}
		}
		System.out.println("=================================================");
		System.out.println("date: " + date);
	}

	// 盈利情况统计
	public void profitNote() {
		Date date = new Date();
		System.out.println("===========宠物商店盈利情况===========");
		double cost = 0.0;
		double income = 0.0;
		double myProfit = 0.0;
		for (Pets pet : petsMap.get("cat")) {
			if (pet != null) {
				cost += pet.getInprice();
				income += pet.getOutprice();
			}
		}
		for (Pets pet : petsMap.get("dog")) {
			if (pet != null) {
				cost += pet.getInprice();
				income += pet.getOutprice();
			}
		}
		myProfit = income - cost;
		System.out.println("成本：" + cost + "\n" + "总收入：" + income + "\n" + "利润：" + myProfit);
		if (myProfit > 0) {
			System.out.println("恭喜，您的店处于盈利状态！");
		} else {
			System.out.println("很遗憾，您的店处于亏损状况！");
		}
		System.out.println("=======================================");
		System.out.println("date: " + date);
	}

	public int getOutNum() {
		return outNum;
	}

	public int getInNum() {
		return inNum;
	}

	public int getNum() {
		return num;
	}
}
