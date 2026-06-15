package fst;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10, 77, 10, 54, -11, 10};
		int temp = 0;
		int value = 30;
		for (int num : nums) {
			if (num == 10) {
				temp += num;
//				System.out.println("The number is Present!");
			}
		}
		if(temp == value) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
	}

}
