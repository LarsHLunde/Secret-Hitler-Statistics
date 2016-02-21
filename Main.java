import java.util.*;

public class Main {

	/**
	 * This code calculates the risk of different draw outcomes
	 * in the game Secret Hitler by shuffling the deck
	 * and drawing 3 cards over and over again.
	 * 
	 * On my configuration, it runs the algorithm 21'474'836
	 * times, and I have yet to observer a deviance over 0.05%. 
	 * 
	 * You can however test deviance at different 
	 * round counts by increasing the SETS variable above 1.
	 */
	
	private static final int FACIST = 1;
	private static final int LIBERAL = 0;
	
	//How many rounds there are, and how many sets
	//of rounds you want to run
	private static final long ROUNDS = Integer.MAX_VALUE/100;
	private static final int SETS = 1;
	
	//Edit for different results:
	private static final int liberalCards = 6;
	private static final int facistCards = 11; 
	
	
	static List<Integer> deck = new ArrayList<Integer>();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//INIT
		for(int i = 0; i<liberalCards;i++){
			deck.add(LIBERAL);
		}
		
		for(int i = 0; i<facistCards;i++){
			deck.add(FACIST);
		}
		
		int llfMax = 0, llfMin = Integer.MAX_VALUE, 
			flfMax = 0, flfMin = Integer.MAX_VALUE, 
			lllMax = 0, lllMin = Integer.MAX_VALUE, 
			fffMax = 0, fffMin = Integer.MAX_VALUE;
		int llf = 0, flf= 0, lll = 0, fff = 0; 
		
		//LOOP
		for(int j = 0;j<SETS;j++){
			llf = 0;
			flf = 0;
			lll = 0;
			fff = 0;
			for(int i = 0;i<ROUNDS;i++){
				
				
				Collections.shuffle(deck);
				if(deck.get(0) + deck.get(1) + deck.get(2) == 2){
					flf++;
				}
				
				else if(deck.get(0) + deck.get(1) + deck.get(2) == 3){
					fff++;
				}
				
				else if(deck.get(0) + deck.get(1) + deck.get(2) == 1){
					llf++;
				}
				
				else{
					lll++;
				}
			}
		
		
		//POST
			if(flf>flfMax){flfMax = flf;}
			if(flf<flfMin){flfMin = flf;}
			if(fff>fffMax){fffMax = fff;}
			if(fff<fffMin){fffMin = fff;}
			if(llf>llfMax){llfMax = llf;}
			if(llf<llfMin){llfMin = llf;}
			if(lll>lllMax){lllMax = lll;}
			if(lll<lllMin){lllMin = lll;}
			
			System.out.print("Chance for 2 facist, 1 liberal: \t");
			System.out.println((double)(flf*100)/(double)ROUNDS + "%");
			
			System.out.print("Chance for 3 facist: \t \t \t");
			System.out.println((double)(fff*100)/(double)ROUNDS + "%");
			
			System.out.print("Chance for 1 facist, 2 liberal: \t");
			System.out.println((double)(llf*100)/(double)ROUNDS + "%");
			
			System.out.print("Chance for 3 liberal: \t \t \t");
			System.out.println((double)(lll*100)/(double)ROUNDS + "%");
			System.out.println();
			System.out.println();
			
			System.out.print("Chance for 2 or more facist cards:  \t");
			System.out.println((double)(flf*100)/(double)ROUNDS + (double)(fff*100)/(double)ROUNDS +"%");
	
			System.out.print("Chance to get a liberal card: \t \t");
			System.out.println((double)(flf*100)/(double)ROUNDS + (double)(llf*100)/(double)ROUNDS + (double)(lll*100)/(double)ROUNDS +"%");
			System.out.println();
			
			if(SETS>1){
				System.out.println("Deviations:");
				System.out.print("FLF: \t\t\t\t\t");
				System.out.format("%f %%%n",(double)(flfMax-flfMin)*100/ROUNDS);
				System.out.print("FFF: \t\t\t\t\t");
				System.out.format("%f %%%n",(double)(fffMax-fffMin)*100/ROUNDS);
				System.out.print("LLF: \t\t\t\t\t");
				System.out.format("%f %%%n",(double)(llfMax-llfMin)*100/ROUNDS);
				System.out.print("LLL: \t\t\t\t\t");
				System.out.format("%f %%%n",(double)(lllMax-lllMin)*100/ROUNDS);
			}
			System.out.println();
			System.out.println();
		}
	}

}
