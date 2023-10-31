import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	private static String[][] Language;

	public static void main(String[] args) {
		int die1;
		int die2;
		String[] playerChoices;
		Language = initLang();
		die1 = roll();
		die2 = roll();
		String choice;
		choice = getInput(Language[0][0]);
		choice = choice.toLowerCase();
		int count = 0;
		String playerCount = getInput(Language[0][1]);
		count = Integer.parseInt(playerCount);
		playerChoices = new String[count];
		while(choice.equals(Language[0][2])) {
			
			for(int c= 0; c < count; c++) {
			playerChoices[c] = getInput(Language[0][3]+(c+1)+Language[0][4]);
			
			}
			System.out.println(Language[0][5]+die1+Language[0][6]+die2);
			//Start a new loop here.
			for(int c=0; c<count;c++) {
				if(didIWin(die1,die2,playerChoices[c]))
				{
					System.out.println(Language[0][3]+(c+1)+Language[0][7]);
				}else
				{
					System.out.println(Language[0][3]+(c+1)+Language[0][8]);
				}
			}
			
			choice = getInput(Language[0][9]);
			choice = choice.toLowerCase();
			die1 = roll();
			die2 = roll();
		}
	}
	private static String[][] initLang() {
		String [][] temp = new String[][] {
			{"Do you want to play?\nYes\nNo","How many players are there?","yes",
				"Player ",": [0] Even\n[1] Odd","Die 1: ","\nDie 2: "," wins!",
				" loses!","Do you want to play again?\nYes\nNo"}
			
			
			};
		return temp;
	}
	private static boolean didIWin(int die1, int die2, String choice)
	{
		
		return false;
	}
	
	
	private static int roll()
	{
		return roll(6,1);
	}
	private static int roll(int sides,int start) {
		Random roller = new Random();
		return roller.nextInt(sides)+start;
	}
	private static String getInput(String text) {
		Scanner input = new Scanner(System.in);
		String choice = "";
		try 
		{
			System.out.println(text);
			choice = input.nextLine();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return choice;
	}
	
	private static boolean isInputInteger(String input) {
		boolean isAnInteger = true;
		for(int c = 0; c < input.length();c++) {
			char letter = input.charAt(c);
			//'-' is 45 '0 - 9' 48 - 57
			if(c!=0 &&!(letter >= 48 && letter<= 57))
			{
				isAnInteger = false;
			}else if(letter != 45 && !(letter >= 48 && letter <= 57))
			{
				isAnInteger = false;
			}
		}
		return isAnInteger;
	}
}
