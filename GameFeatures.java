package TIC_TAC_TOE;

import java.util.Arrays;
import java.util.Scanner;

public class GameFeatures {
	static Scanner sc = new Scanner(System.in);
	static boolean flag = true;
	static char [][] arr= new char[3][3];
    static String playerOne = "";
    static String playerTwo = "";
    static String computer = "";
    
    /* Display Tic tac board */
   	public static void  ticTacBox(){
   		for(int j =0;j<arr.length;j++) {
   			System.out.println(Arrays.toString(arr[j]));
   		}
   	}
   	public static void welcomePage() {
   		System.out.println("\t\t\t\tWelcome to Tic Toc Game\t\t\t\t");
   		System.out.println("\t\t\t\t-----------------------\t\t\t\t");
   		    /* 2D array creation */
   			do {
   				char num = '1';
   				for(int i =0;i<arr.length;i++) {
   					for(int j = 0;j<arr.length;j++) {
   						arr[i][j] = num++;
   					}
   				}
   				/* welcome msg and info */
   				System.out.println("\n1.Player 1 vs Player 1\n2.Player vs Computer\n3.Exit");
   				System.out.println();
   				System.out.print("Choose your Game : ");
   				int user_selected = -1;
   				try {
   					 user_selected = sc.nextInt();
   				}catch(Exception e) {
   					System.out.println("\t\t\t\t!!!!!!Please Enter the only Numbers!!!!!");
   					System.out.println("\t\t\t\t----------------------------------------");
   				}
   				
   				sc.nextLine();
   				switch(user_selected) {
   				case 1:{
   					
   					System.out.println("\n!! You choose 1 vs 1 Mode !!");
   					ticTacBox();
   					playerSelection();
   					SinglePlayer.singlePlayer(); 
   					break;
   					}
   				case 2:{
   					
   					System.out.println("\n!! You choose Player vs Computer Mode !!");
   					playerSelection();
   					MultiPlayer.computerPlayer();
   					break;
   					}
   				case 3:{
   					System.out.println("\t\t\t\tThank you for visit!!!!!!\t\t\t\t");
   					System.out.println("\t\t\t\t-------------------------\t\t\t\t");
   					flag = false;
   					break;}
   				}
   			}while(flag);
   		}
   	

 // player selection
    public static void playerSelection() {
		boolean invalid = true;
		 do {
			 System.out.println("Player 1 : Pick onyone X (or) O : ");
				playerOne = sc.nextLine();
				
				playerOne = playerOne.toLowerCase();
				System.out.println("you selected :" + playerOne);
			 if(playerOne.equals("x") || playerOne.equals("o")) {
					if(playerOne.equals("x")) {
						playerTwo = "o";
					    computer = playerTwo;}
					else {
						playerTwo="x";
					computer = playerTwo;}
				invalid = false;	
				}
				else {
					System.out.println("Attention !!! enter X or O only");
				}
		 }while(invalid);
	}
    public static void putIntoBox(int user_input,boolean pOne,boolean pSec,String player) {
		char[] playerarr = player.toCharArray();
		char playerval = playerarr[0];
		  if(user_input <=3) {
			  int index = 0;
			  
           if(pOne) {
				arr[index][user_input-1] = playerval; 
			  }else if(pSec) {
				arr[index][user_input-1] = playerval;
			  }
		  } else if(user_input<=6) {
			  int index = 1;
	           if(pOne) {
	        	   
					arr[index][user_input-4] = playerval; 
				  }else if(pSec) {
					arr[index][user_input-4] = playerval;
				  }
			  } else if(user_input<=9) {
				  int index = 2;
		           if(pOne) {
						arr[index][user_input-7] = playerval; 
					  }else if(pSec) {
						arr[index][user_input-7] = playerval;
					  }
				  }
	}
	
	public static boolean isPresentOrNot(int user_input) {
		if(user_input==0) {
			return false;
		}
	   if(user_input<=3) {
		   int index = 0;
		   if(arr[index][user_input-1]<='1' || arr[index][user_input-1]<='9') {
			   return true;
		   };	
	   }else if(user_input<=6) {
		   int index = 1;
		   if(arr[index][user_input-4]<='1' || arr[index][user_input-4]<='9') {
			   return true;
		   }
	   }else if(user_input<=9) {
		   int index = 2;
		   if(arr[index][user_input-7]<='1' || arr[index][user_input-7]<='9') {
			   return true;
		   }
	   }
		return false;
	}
	
	// game over or not
	public static boolean isGameOver(){
		// horizantal check
		for(int i =0;i<=2;i++) {
			for(int j =0;j<=2;j++) {
				int x=0,o=0;
				for(int k =0;k<=2;k++)
				{
					if(arr[j][k]=='x'){
						x++;
					}
					if(arr[j][k]=='o') {
						o++;
					}
				}
				if(x==3) {
					return true;
				}
				if(o==3) {
					return true;
				}
			}
			//vertical
			int x =0,o=0;
			for(int l =0;l<=2;l++) {
				
				if(arr[l][i]=='x') {
					x++;
				}
				if(arr[l][i]=='o') {
					o++;
				}
			}
			if(x==3)
				return true;
			if(o==3)
				return true;
			
		}
		//diagonal 
		int x =0,o=0;
		for(int i =0,j=2;i<=2 && j>=0;i++,j--) {
			if(arr[i][j]=='x')
				x++;
			if(arr[i][j]=='o')
				o++;
			if(x==3)
				return true;
			if(o==3)
				return true;
		}
		int l=0,r=0;
		for(int i =0,j=0;i<=2 && j<=2;i++,j++) {
			if(arr[i][j]=='x')
				l++;
			if(arr[i][j]=='o')
				r++;
			if(l==3)
				return true;
			if(r==3)
				return true;
		}
		
		return false;		
	}

}
