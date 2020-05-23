import java.util.Scanner;
//Raja Hammad Mehmood
// This program would play the Pennywise game

/**
 * Play Pennywise.
 */

public class Pennywise {
 
	// the coin denominations available
	public static final int[] DENOMINATIONS = { 1, 2, 3, 5, 10, 20, 25 };// constant for denominations
    public static final int[] TAYLOR = { 3, 0, 0, 2, 1, 0, 0 };// set of coins as per taylor type
    public static final int[] SUGAR = { 2,2,0,2,1,0,0 };// set of coins as per sugar type
    public static final int[] DARLENE = { 3,0,3,0,2,1,0 };// set of coins as per darlene type
    public static final int[] CODY = {4,0,0,3,2,0,1};// set of coins as per cody type

	/**
	 * Print a collection of coins.
	 * 
	 * @param coins
	 *          coins[i] is the number of coins of denomination DENOMINATION[i]
	 */
	public static void print ( int[] coins ) {
		boolean first = true;
		for ( int i = 0 ; i < coins.length ; i++ ) {
			if ( coins[i] > 0 ) {
				if ( !first ) {
					System.out.print(", ");
				} else {
					first = false;
				}
				System.out.print(DENOMINATIONS[i] + "c (" + coins[i] + ")");
			}
		}
		System.out.println();
	}

	/**
	 * Determine the index where coins of the specified denomination are stored.
	 * 
	 * @param denom
	 *          denomination
	 * @return the index i such that DENOMINATIONS[i] == denom, or -1 if denom is
	 *         not a valid denomination
	 */
	public static int getIndex ( int denom ) {
		for ( int i = 0 ; i < DENOMINATIONS.length ; i++ ) {
			if ( DENOMINATIONS[i] == denom ) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Determine if the player has any coins remaining.
	 * 
	 * @param coins
	 *          the player's coins
	 * @return true if the player has at least one coin, false if none
	 */
	public static boolean hasCoins ( int[] coins ) {
		for ( int i = 0 ; i < coins.length ; i++ ) {
			if ( coins[i] > 0 ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Compute a player's score.
	 * 
	 * @param coins
	 *          player's coins
	 * @return the score
	 */
	public static int score ( int[] coins ) {
		int sum = 0;
		for ( int i = 0 ; i < coins.length ; i++ ) {
			sum += DENOMINATIONS[i] * coins[i];
		}
		return sum;
	}
   /**
	 * Gets the type of recipe from the user.
	 * 
	 * @param scanner
	 *          @return is the recipe name as string
	 */
	public static String getRecipe ( Scanner scanner ) {
		System.out.println("Which character recipe do you want? taylor, sugar, darlene, or cody?");
        String recipename= scanner.nextLine();
        while(recipename.equalsIgnoreCase("taylor")!=true && recipename.equalsIgnoreCase("sugar")!=true && recipename.equalsIgnoreCase("darlene")!=true && recipename.equalsIgnoreCase("cody")!=true){
            System.out.println("Error. Which character recipe do you want? taylor, sugar, darlene, or cody?");
         recipename= scanner.nextLine();
            }
            return recipename;
            
	}
	/**
	 * makes one player perform a turn
	 * 
	 * @param1 is scanner
	 * @param2 is the player turn 
	 *         
	 */
	public static void taketurn(Scanner scanner,int turn){  		
			System.out.print("the pot contains : ");
			print(pot);
		if(turn==1){
			System.out.print("your coins : ");
			print(player1coins);
		}
		else{
			System.out.print("your coins : ");
			print(player2coins);
		}
	 int coinplace=0; // it's the array position of the denomination the user chosed
		System.out.println("What denomination do you want to play?");
		int coin= scanner.nextInt();// coin is the denomination
		coinplace=getIndex(coin);
		while (coinplace==-1){
			System.out.println("In valid coin. Which coin do you want to throw? 1, 2, 3, 5, 10, 20, 25?");
			coin=scanner.nextInt();
			coinplace=getIndex(coin);
		}

		while (player1coins[coinplace] ==0){
			System.out.println("You are out of these coins. Which other coin do you want to throw? 1, 2, 3, 5, 10, 20, 25?");
			coin=scanner.nextInt();
			coinplace=getIndex(coin);
		while (coinplace==-1){
			System.out.println("In valid coin. Which coin do you want to throw? 1, 2, 3, 5, 10, 20, 25?");
			coin=scanner.nextInt();
			coinplace=getIndex(coin);
		}
			
				
		}
		if (turn==1){
			player1coins[coinplace]=(player1coins[coinplace])-1;
			pot[coinplace]=(pot[coinplace])+1;
			takecoin(scanner, coin, turn);
		}
		if (turn==2){
			player2coins[coinplace]=(player2coins[coinplace])-1;
			pot[coinplace]=(pot[coinplace])+1;
			takecoin(scanner, coin, turn);
		}
		
		  
		  
	}
	public static void takecoin(Scanner scanner, int coin,int turn ){
		System.out.print("the pot contains : ");
			print(pot);
	    int limitcoin= coin-1;
		System.out.println(" you can take up to "+ limitcoin+ " c more");
		
		
		int countplace=0;
		String choice="";
		int coinGet;
		int coinplace;
	     
		 
		 if (limitcoin!=0){
		 System.out.println("Do you want to take a coin from the pot. yes or no?");
		  scanner.nextLine();
		  choice=scanner.nextLine();
		 }
		 else{
			System.out.println("You can't take a coin from the pot");
		 }
		 
		boolean flag=false; // flag is a checking boolean
		int i=getIndex(coin); // i is the previous array position
		while(i!=0){
			i=i-1;
			if(pot[i]>0){
				flag=true;
			}
		}
		if (flag==false){
			System.out.println(" pot doesn't have denominations of value under the limit value hence you can't pick any");
		}
		else{
		 
		while(  limitcoin!=0 &&  choice.equalsIgnoreCase("yes") ){
			
			System.out.println("Which denomination do you want to remove. Max is "+limitcoin);
			coinGet=scanner.nextInt();
		coinplace=getIndex(coin); 
			
			while ((coinGet<=limitcoin && (coinplace!= -1)) !=true ){
				System.out.println("You are either exceeding limit or invalid coin. Which denomination do you want to remove. Max is "+limitcoin);
			 coinGet=scanner.nextInt();
			 	coinplace=getIndex(coinGet); 
			}
		        
		while (pot[coinplace] ==0){
			System.out.println("Pot doesn't have this denomination. Which other coin do you want to take? Limit is "+limitcoin);
			coinGet=scanner.nextInt();
			coinplace=getIndex(coinGet);
			while ((coinGet<=limitcoin && (coinplace!= -1)) !=true ){
				System.out.println("You are either exceeding limit or invalid coin. Which denomination do you want to remove. Max is "+limitcoin);
			 coinGet=scanner.nextInt();
			 	coinplace=getIndex(coinGet); 
			}
		
		}
		
		if (turn==1){
		pot[coinplace]=(pot[coinplace])-1; // removing a denomination from the pot
			player1coins[coinplace]=(player1coins[coinplace])+1; // adding a denomination to the player coins
	    limitcoin=limitcoin-coinGet;
		 if (limitcoin!=0){
			 System.out.println(" you can take up to "+ limitcoin+ " c more");
		 System.out.println("Do you want to take a coin from the pot. yes or no?");
		 scanner.nextLine();
		 choice=scanner.nextLine();
		 }	
		}
		if (turn==2){
		pot[coinplace]=(pot[coinplace])-1;
			player2coins[coinplace]=(player2coins[coinplace])+1;
	    limitcoin=limitcoin-coinGet;
		 if (limitcoin!=0){
			 System.out.println(" you can take up to "+ limitcoin+ " c more");
		 System.out.println("Do you want to take a coin from the pot. yes or no?");
		 scanner.nextLine();
		 choice=scanner.nextLine();
		 }		
		}
		
		flag=false;
	    i=getIndex(limitcoin+1);
		while(i!=0){
			i=i-1;
			if(pot[i]>0){
				flag=true;
			}
		}
		if (flag==false){
			System.out.println(" pot doesn't have denominations of value under the limit value and hence you can't pick a denomination");
			break;
		}
		
		}
	}
	}
	/**
	 * Plays the entire game
	 * 
	 * @param scanner
	 *          
	 */
    public static void play(Scanner scanner){
		 String recipename=getRecipe(scanner);
    if(recipename.equalsIgnoreCase("taylor")){
                for(int i=0; i<player1coins.length;i++){
                  player1coins[i]=TAYLOR[i];
				  player2coins[i]=TAYLOR[i];
                }
                
            }
	else if(recipename.equalsIgnoreCase("sugar")){
                for(int i=0; i<player1coins.length;i++){
                  player1coins[i]=SUGAR[i];
				  player2coins[i]=SUGAR[i]; 
                }
                
            }		

	else if(recipename.equalsIgnoreCase("darlene")){
                for(int i=0; i<player1coins.length;i++){
                  player1coins[i]=DARLENE[i];
				  player2coins[i]=DARLENE[i];  
                }
                
            }
	else if(recipename.equalsIgnoreCase("cody")){
                for(int i=0; i<player1coins.length;i++){
                  player1coins[i]=CODY[i];
				  player2coins[i]=CODY[i];  
                }
                
            }
			
	
	int turn; // shows which player's turn it is.
	while(true){
		turn=1;
		System.out.println("It's player's 1 turn");
		taketurn(scanner, turn);
		System.out.print("your coins : ");
			print(player1coins);
		if(hasCoins(player1coins)==false){
			System.out.println("That was your last coin");
			System.out.println("Player 2 won the game");
			break;
		}
		turn=2;
		System.out.println("It's player's 2 turn");
		taketurn(scanner, turn);
		System.out.print("your coins : ");
			print(player2coins);
		if(hasCoins(player2coins)==false){
			System.out.println("That was your last coin");
			System.out.println("Player 1 won the game");
			break;
		}
		
	}
	System.out.println("Player 1 : "+ score(player1coins));
	System.out.println("Player 2 : " + score(player2coins));
		// get the name of the character recipe to use from the user
		// play the game (player 1 goes first)
		// play the game (player 2 goes first)
		// identify and congratulate the overall winner
	}
	
    
    
    public static int[] player1coins= new int [7]; // denominations of player1 are stored
	public static int[] player2coins= new int [7];// denominations of player2 are stored
	public static int[] pot=new int[7];//// denominations of the pot are stored
	
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
   play(scanner); // plays the entire game
    
}
}