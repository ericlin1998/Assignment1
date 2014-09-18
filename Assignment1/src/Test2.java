import java.util.ArrayList;
import java.util.Scanner;


public class Test2 {
	static final int MIN = 1;
	static final int MAX = 100;
	//if true, program repeats until quit
	//currently disabled due reduce error
	static boolean repeat = true;
	static boolean error = false;
	
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
				ArrayList<Integer> intList = new ArrayList<Integer>(0);
				for(int a = 0; a<strList.length; a++){
					if(isInteger(strList[a])){
						if(Integer.parseInt(strList[a])<MIN || Integer.parseInt(strList[a])>MAX){
							System.out.println("error: " + (a+1) + " input less than 1 or greater than 100");
							error = true;
						}
						else{
							intList.add(Integer.parseInt(strList[a]));
						}
					}
					else{
						if(checkInput(strList[a])){
							System.out.println("error: " + (a+1) + " input not an int");
							error = true;
						}
						else{
							repeat = false;
						}
					}
				}
				if(!error){
					System.out.println(cgf(intList));
				}
				error = false;
			}
			//second part
			else if(isInteger(strList[0])){
				int num = Integer.parseInt(strList[0]);
				if(num<MIN || num>MAX){
					System.out.println("error: Input number less than 1 or greater than 100.");
				}
				else{
					int[] list = factor(num);
					System.out.println(toString(list));
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
	
	public static int cgf(ArrayList<Integer> list){
		ArrayList<int[]> fList = new ArrayList<int[]>(0);
		int common = 0;
		int cFactor = 0;
		for(int x=0; x<list.size(); x++){
			fList.add(factor(list.get(x)));
		}
		for(int a=fList.get(0).length-1; a>-1; a--){
			cFactor = fList.get(0)[a];
			for(int b=1; b<fList.size(); b++){
				for(int c=fList.get(b).length-1; c>-1; c--){
					if(fList.get(0)[a] == fList.get(b)[c]){
						common++;
					}
				}
			}
			if(common == fList.size()-1){
				return cFactor;
			}
			else{
				common = 0;
			}
		}
		return cFactor;
	}
	
	//prints int[] 
	public static String toString(int[] list){
		String str = "[" + list[0];
		for(int x=1; x<list.length; x++){
			str = str + ", " + list[x];
		}
		str = str +"]";
		return str;
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
