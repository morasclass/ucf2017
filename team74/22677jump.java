import java.util.*;

public class jump{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int trials = Integer.parseInt(scanner.nextLine());		
		for(int i = 0; i < trials; i++){
			System.out.println("Trip #" + (i + 1) + " :");
			int x = Integer.parseInt(scanner.nextLine());
			int y = Integer.parseInt(scanner.nextLine());
			int inTrials = Integer.parseInt(scanner.nextLine());
			int[][] arr = new int[x][y];
			arr = populateArr(arr);
			
			for(int j = 0; j < inTrials; j++){
				String dir = scanner.nextLine();			
				if(dir.equals("R")){
					arr = shiftRight(arr);
				}
				else if(dir.equals("L")){
					arr = shiftLeft(arr);
				}
				else if(dir.equals("F")){
					arr = shiftForward(arr);
				}
				else{
					arr = shiftBackward(arr);
				}

				System.out.println(checkZero(arr));
			}
		}
	}
	
	public static int[][] populateArr(int[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = 1;
			}
		}
		return arr;
	}
	
	public static int[][] shiftRight(int[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = arr[i].length - 1; j > 0; j--){
				arr[i][j] += arr[i][j - 1];
				arr[i][j - 1] = 0;
			}
		}
		return arr;
	}
	
	public static int[][] shiftLeft(int[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length - 1; j++){
				arr[i][j] += arr[i][j + 1];
				arr[i][j + 1] = 0;
			}
		}
		return arr;
	}
	
	public static int[][] shiftForward(int[][] arr){
		for(int i = 0; i < arr.length - 1; i++){
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] += arr[i + 1][j];
				arr[i + 1][j] = 0;
			}
		}
		return arr;
	}
	
	public static int[][] shiftBackward(int[][] arr){
		for(int i = arr.length - 1; i > 0; i--){
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] += arr[i - 1][j];
				arr[i - 1][j] = 0;
			}
		}
		return arr;
	}
	
	public static int checkZero(int[][] arr){
		int counter = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				if(arr[i][j] != 0){
					counter++;
				}
			}
		}
		return counter;
	}
	
	public static void printArr(int[][] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + "   ");
			}
			System.out.println();
		}
	}
}




















