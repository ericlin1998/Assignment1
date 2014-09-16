import java.util.ArrayList;
import java.util.Scanner;


public class Assignment1 {
	static final int MIN = 1;
	static final int MAX = 100;
	//if true, program repeats until quit
	//currently disabled due reduce error
	static boolean repeat = true;
	
	//main
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		//repeats until quit
		do{
			//requests for int to factor
			System.out.println("Factor of or common greatest factor of: ");
			String str1 = console.nextLine();
			String[] strList = toStringList(str1);
			if(strList.length>1){
				if(isInteger(strList[0])){
					int num = Integer.parseInt(strList[0]);
					if(num<MIN || num>MAX){
						System.out.println("error: First input number less than 1 or greater than 100.");
					}
					else if(isInteger(strList[1])){
						int num2 = Integer.parseInt(strList[1]);
						if(num2>=MIN && num2<=MAX){
							ArrayList<Integer> nums = new ArrayList<Integer>();
							nums.add(num);
							nums.add(num2);
							cgf(nums);
						}
						else{
							System.out.println("error: Second input number less than 1 or greater than 100.");
						}
					}
					else{
						String str = strList[1];
						if(checkInput(str)){
							System.out.println("error: Second input not an int");
						}
						else{
							repeat = false;
						}
					}
				}
				else{
					String str = strList[0];
					if(checkInput(str)){
						System.out.println("error: First input not an int");
					}
					else{
						repeat = false;
					}
				}
			}
			//second part
			else if(isInteger(strList[0])){
				int num = Integer.parseInt(strList[0]);
				if(num<MIN || num>MAX){
					System.out.println("error: Input number less than 1 or greater than 100.");
				}
				else{
					int[] list = factor(num);
					toString(list);
				}
			}
			else{
				String str = strList[0];
				if(checkInput(str)){
					System.out.println("error: Input not an int");
				}
				else{
					repeat  = false;
				}
			}
		}
		while(repeat);
		console.close();
	}
	
	//checks if input quits
	public static boolean checkInput(String str){
		if(str.toUpperCase().equals("QUIT")){
			System.out.println("quit");
			return false;
		}
		else{
			return true;
		}
	}
	
	public static String[] toStringList(String str){
		String[] list = str.split("\\s+");
		return list;
	}
	
	public static ArrayList<Integer> arrangeArray(String[] str){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int x=0; x<str.length; x++){
			nums.add(Integer.parseInt(str[x]));
		}
		return nums;
	}
	
	//factors a number and returns a int[] of the factors
	public static int[] factor(int num){
		int temp1 = 1;
		int temp2 = 1;
		String str = "";
		for(temp1 = 1; temp1 <= num; temp1++){
			temp2 = num / temp1;
			if(temp1 * temp2 == num){
					str = str + temp1 + ", ";
				}
		}
		String[] str2 = str.split(", ");
		int[] factors = new int[str2.length];
		for(int x=0; x<str2.length; x++){
			factors[x] = Integer.parseInt(str2[x]);
		}
		return factors;
	}
	
	public static void cgf(ArrayList<Integer> list){
		int num1 = list.get(0);
		int num2 = list.get(1);
		int[] factors1 = factor(num1);
		int[] factors2 = factor(num2);
		for(int x = factors2.length-1; x>-1; x--){
			for(int y = 0; y<factors1.length; y++){
				if(factors2[x] == factors1[y]){
					System.out.println(factors1[y]);
					return;
				}
			}
		}
	}
	
	//prints int[] 
	public static void toString(int[] list){
		System.out.print("[" + list[0]);
		for(int x=1; x<list.length; x++){
			System.out.print(", " + list[x]);
		}
		System.out.println("]");
	}
	
	public static boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
}
