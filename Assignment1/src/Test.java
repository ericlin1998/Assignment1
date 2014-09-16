import java.util.ArrayList;
import java.util.Scanner;

public class Test {
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
			//requests for ints to find cgf
			System.out.println("Common greatest factor of: ");
			String str1 = console.nextLine();
			String[] strList = toStringList(str1);
			for(int a = 0; a<strList.length; a++){
				if(isInteger(strList[a])){
					if(Integer.parseInt(strList[a])<MIN || Integer.parseInt(strList[a])>MAX){
						System.out.println("error: " + a + " input less than 0 or greater than 100");
						error = true;
					}
				}
				else{
					System.out.println("error: " + a + " input not an int");
					error = true;
				}
			}
			//error testing
			System.out.println("Error? " + error);
			error = false;
			
			if(!error){
				
			}
		}
		while(repeat);
		console.close();
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
			ArrayList<int[]> fList = new ArrayList<int[]>();
			for(int x=0; x<list.size(); x++){
				fList.add(factor(list.get(x)));
			}
			for(int a=fList.get(0).length-1; a>-1; a--){
				for(int b=1; b<fList.size()-1; b++){
					for(int c=fList.get(b).length-1; c>0; c--){
						if(fList.get(0)[a] == fList.get(b)[c]){
							
						}
					}
				}
			}
		}
		
		public static String[] toStringList(String str){
			String[] list = str.split("\\s+");
			return list;
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
