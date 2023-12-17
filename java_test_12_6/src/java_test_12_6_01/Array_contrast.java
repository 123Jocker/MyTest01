//给定两个整型数组A和B，将A的元素复制到B中，使得两个数组完全相同。再将B数组从小到大排列，将两数组的同一位置上对应的元素进行比较，统计出A中大于B的元素个数，等于B中元素的个数，小于B中的元素的个数。
//提示：可用Arrays.sort排序
//
//输入格式:
//数组A的个数
//数组A元素
//
//输出格式:
//A大于B的个数
//A等于B的个数
//A小于B的个数
//
//输入样例:
//在这里给出一组输入。例如：
//
//10
//23 1 32 87 65 12 21 9 76 45
//输出样例:
//在这里给出相应的输出。例如：
//
//4
//1
//5
package java_test_12_6_01;

import java.util.Arrays;
import java.util.Scanner;

public class Array_contrast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scan = new Scanner(System.in)) {
			int num = scan.nextInt();
			int BigNum = 0;
			int EqualNum = 0;
			int SmallNum = 0;
			int ArrayA[] = new int[num];
			int ArrayB[] = new int[num];
			for (int i = 0; i < num; i++) {
				ArrayA[i] = scan.nextInt();
			}
			System.arraycopy(ArrayA, 0, ArrayB, 0, num);
			Arrays.sort(ArrayB);
			for (int i = 0; i < num; i++) {
				if (ArrayA[i] > ArrayB[i]) {
					BigNum++;
				} else if (ArrayA[i] == ArrayB[i]) {
					EqualNum++;
				} else if (ArrayA[i] < ArrayB[i]) {
					SmallNum++;
				}
			}
			System.out.println(BigNum);
			System.out.println(EqualNum);
			System.out.println(SmallNum);
		}
	}

}
