package TIC_TAC_TOE;

public class MultiPlayer extends GameFeatures {
	public static void computerPlayer() {
		System.out.println("Game starting..... Be ready!!!!!");
		System.out.println("player 1 start the game");
		ticTacBox();
		boolean pOne = true;
		boolean pSec = false;
		boolean draw = true;
		for(int i = 1;i<=9;i++)
		{
		   if(pOne) {
			     System.out.println("P1 choose the box :");
			     int user_input = sc.nextInt();
			     if(isPresentOrNot(user_input)) {
			    	 
				    	 putIntoBox(user_input,pOne,pSec,playerOne);
				    	 pOne = false;
						 pSec = true;
						 ticTacBox();
			    	
			     }else if(user_input==0) {
			    	  System.out.println("enter number from 1 onwards...");
					   i--;
			     }else {
			    	 System.out.println("Already present something");
			    	 i--;
			     }
			     if(isGameOver()) {
			    	   System.out.println("\t\t\t--you win player 2--");
					   System.out.println("\t\t\t\t------------------");
					   draw = false;
					   break;
			     }
					   
			  }else if(pSec) {
			   System.out.println("P2 selected ");
			   int user_input = (int) (Math.random()*10);
			   
			   if(isPresentOrNot(user_input)) {
				   
				    	 putIntoBox(user_input,pOne,pSec,playerTwo);
				         pSec = false;
				         pOne = true;
				         ticTacBox();
				   }else if(user_input==0) {
				    	  System.out.println("enter number from 1 onwards...");
						   i--;
				     }else {
				        i--;
			   }   
		   }
		   if(isGameOver()) {
			   System.out.println("\t\t\t--you win player 2--");
			   System.out.println("\t\t\t\t---------------");
			   draw = false;
			   break;
		   }
		   
		}
		if(draw)
			System.out.println("match draw");
	
	}
	
	

}
