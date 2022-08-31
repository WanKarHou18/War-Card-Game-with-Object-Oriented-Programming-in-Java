import java.util.ArrayList;     //import ArrayList  

import java.util.Random;        //import Random
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



import java.util.List;          //import List
import java.util.NoSuchElementException;
import java.util.Collections;   //import Collections
import java.util.InputMismatchException;
import java.util.LinkedList;    //import LinkList

public class WarDemo {

    public static void main(String[] args)  {
    	
    	char option;
      	int point1=0; //Initialize Score Point for Player 1 
      	int point2=0; //Initialize Score Point for Player 2
      	int initiateBattle =0;
      	int i =0 ;
      	
      	 Player p1=new Player(); //Initialize Player 1 
         Player p2=new Player(); //Initialize Player 2
         
        boolean pass ;
        
        
        List<Card> DeckOfCard = new ArrayList<Card>(); //create an ArrayList "DeckOfCard"
        
        //initialize War part 
        War War1 = new War() ; // For Player1
        War War2 = new War() ; //For Player 2
        War Compare = new War();
        
	
        
        for(int x=0; x<4; x++){          //0-3 for suit (4 suits)
            for(int y=1; y<14; y++){     //1-13 for rank (13 ranks)
                DeckOfCard.add(new Card(x,y)); //create new card and add into the deckOfCard
            } //end rank for
        }//end suit for
        
        
    
        
        Collections.shuffle(DeckOfCard, new Random()); //shuffle the deck randomly
        
        //creating 2 decks, each for player1/player2
       LinkedList<Card> firstDeck = new LinkedList<Card>();
       LinkedList<Card> secondDeck = new LinkedList<Card>();
        
       //Cards from DeckOfCard are divided into firstDeck and Second Deck
        firstDeck.addAll(DeckOfCard.subList(0, 26));              //26 cards of  firstDeck
        secondDeck.addAll(DeckOfCard.subList(26,DeckOfCard.size()));//26 cards of SecondDeck
        
        
        // Display the main menu of the Card Game 
		System.out.print("Welcome to WAR GAME\n") ;
		
		System.out.println("Do you want to listen to the rules before playing the game?(Enter 1 for YES or Enter ANY NUMBERS for NO)");
		try
		{Scanner scn = new Scanner(System.in);
		int input = scn.nextInt();
		
		
		if((input==1))
		{
		System.out.println("**THE DEAL**\r\n" + 
				"\r\n" + 
				"The deck is divided evenly, with each player receiving 26 cards, dealt one at a time, face down. Anyone may deal first."
				+ "\nEach player places their stack of cards face down, in front of them.\r\n" + 
				"\n**THE GAMEPLAY**\r\n" + 
				"\r\n" + 
				"Each player turns up a card at the same time and the player with the higher card takes both cards "
				+ "\nand puts them, face up, on the bottom of his stack.\r\n" + 
				"\r\n" + 
				"If the cards are the same rank, it is War. Each player turns up one card face down and one card face up."
				+ "\nThe player with the higher cards takes both piles (six cards). If the turned-up cards are again the same rank, "
				+ "\neach player places another card face down and turns another card face up. The player with the higher card takes all 10 cards,"
				+ "\n and so on.\r\n" + 
				"\n**HOW TO KEEP THE SCORE**\r\n" + 
				"\r\n" + 
				"The game ends when one player has won all the cards. Good luck and HAVE FUN!!! \n\n");
		}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please ONLY ENTER NUMBERS!\n");
			main(args);
		}
		
		
		p1.EnterPlayer();  //Enter Player 1 name
		p2.EnterPlayer(); //Enter Player 2 name
        
        while(true){
        	
        	initiateBattle =0;
        	pass = true ;

            while(pass == true)
            {
        
        	System.out.println("\n****************************************");
        	System.out.println("It's " + p1.getName() + "'s turn!");
        	System.out.println("****************************************");
            System.out.println("Please choose an option from below : \n" ) ;
            System.out.println("~Enter 'S' or 's' to Shuffle the Cards from your deck and Draw");
            System.out.println("~Enter 'D' or 'd' to Draw a card from currently shuffled deck! ");
            System.out.println("~Enter 'Q' or 'q' to Surrender !! ");
            System.out.println("~Enter 'E' or 'e' to End the game\n");
            Scanner inputOption = new Scanner(System.in) ;
             option = inputOption.next().trim().charAt(0);
     
			if(option == 'S' || option == 's')
            {
				
				War1.shuffle1(firstDeck);        	 
				initiateBattle += 1 ;
            	  pass = false ;
                  
            }
            else if(option == 'D' || option == 'd')
            {
            	initiateBattle+= 1 ;
            	pass = false ;
            }
            
            else if(option == 'Q' || option == 'q')
            {
                 System.out.println(p2.getName()+ " " + " wins the game! Congrats !!\n");
                 main(args) ;
           
                 
            }
            else if(option == 'E' || option == 'e')
            {
            	System.out.println("Shutting down the Program in 3...");
            	System.out.println("Shutting down the Program in 2...");
            	System.out.println("Shutting down the Program in 1...");
            	System.out.println("Program has been Shut Down. Press X at the CONSOLE TAB to EXIT from the CONSOLE");
            	System.exit(0);
            }
            else 
            {
            	System.out.print("\n==>Invalid Input!!!\n");
            	System.out.print("==>Please Enter only Given Options! (If Enter Wrong Options TWO Times in a row : The program will RESTART!) <==\n\n");
            	i++ ;
            	if(i==2)
            	{
            		
            		main(args) ;
            		
            	}
            	else
            	{
            		pass= true ;
            	}
            }
            }
          

			i =0;
			pass = true ;
			  while(pass == true)
	            {
	        
	        	System.out.println("\n****************************************");
	        	System.out.println("It's " + p2.getName() + "'s turn!");
	        	System.out.println("****************************************");
	            System.out.println("Please choose an option from below : \n" ) ;
	            System.out.println("~Enter 'S' or 's' to Shuffle the Cards from your deck and Draw");
	            System.out.println("~Enter 'D' or 'd' to Draw a card from currently shuffled deck! ");
	            System.out.println("~Enter 'Q' or 'q' to Surrender !! ");
	            System.out.println("~Enter 'E' or 'e' to End the game\n");
	            Scanner inputOption = new Scanner(System.in) ;
	            option = inputOption.next().trim().charAt(0);
	     
				if(option == 'S' || option == 's') 
	            {
					War2.shuffle2(secondDeck);
	            	  initiateBattle += 1 ;
	            	  pass = false ;
	                  
	            }
	            else if(option == 'D' || option == 'd')
	            {
	            	initiateBattle+= 1 ;
	            	pass = false ;
	            }
	            
	            else if(option == 'Q' || option == 'q')
	            {
	                 System.out.println(p1.getName()+ " " + " wins the game! Congrats !!\n");
	                 main(args) ;
	                 
	            }
	            else if(option == 'E' || option == 'e')
	            {
	            	System.out.println("Shutting down the Program in 3...");
	            	System.out.println("Shutting down the Program in 2...");
	            	System.out.println("Shutting down the Program in 1...");
	            	System.out.println("Program has been Shut Down. Press X at the CONSOLE TAB to EXIT from the CONSOLE");
	            	System.exit(0);
	            }
	            else 
	            {
	            	System.out.print("\n==>Invalid Input!!!\n");
	            	System.out.print("==>Please Enter only Given Options! (If Enter Wrong Options TWO Times in a row : The program will RESTART!) <==\n\n");
	            	i++ ;
	            	if(i==2)
	            	{
	            		main(args);
	            		
	            	}
	            	else
	            	{
	            		pass= true ;
	            	}
	            }
				i=0;
        	}
            //rank comparing between two cards
        	
			// When initiateBattle==2 , means both player agree to continue the game 
			  if(initiateBattle ==2 )
	            {
	              
	                
	               
	        
	                Card p1Card = firstDeck.pop();  //each player place one card face up
	                Card p2Card = secondDeck.pop();
	                System.out.print(p1.getName() +" "+" plays card is " + p1Card.toString()+"\n");
	                System.out.print(p2.getName()+" "+"  plays card is " + p2Card.toString()+"\n");
	                
	              
	                
	                
	                //Initialize the War Part 
	                
	               
	                if(p1Card.getCard() > p2Card.getCard()){
	                	
	                
	                	firstDeck = War1.Battle1(firstDeck, p2Card, p1Card);
	                   
	                    System.out.println("\nCongrats! " + p1.getName() +" wins the round\n");
	                    
	                    System.out.println(p1.getName() + "'s current deck size is  : " + firstDeck.size());
	                    System.out.println(p2.getName() + "'s current deck size is : " + secondDeck.size());
	                    
	                    point1++;
	                    p1.setPoint(point1);
	                    System.out.println("\nCURRENT SCORE : ");
	                    System.out.println(p1.getName()+" 's Point score is "+  p1.getPoint()) ;
	                    System.out.println(p2.getName()+" ' s Point score is "+  p2.getPoint()) ;
	                    p1.Compare(p2);
	                }   
	                else  if(Compare.CompareIfGotWar(p1Card, p2Card)){ ////when nobody wins - it's a WAR! and both card are in same rank
	      		      
		            	war() ;
		            	LinkedList<Card> war1 = new LinkedList<Card>(); 
		                LinkedList<Card> war2 = new LinkedList<Card>();

		            
		                LinkedList<Card> war1_total = new LinkedList<Card>() ;
		                LinkedList<Card> war2_total = new LinkedList<Card>() ;
		               
		               //Add the card into each Linked List to store
		                war1_total.add(p1Card) ;
		                war2_total.add(p2Card) ;
		                
		                try {
		                //creating war cards
		                //checking do players have enough (4)cards to stay in game
		                for(int x=0; x<3; x++){ 
		                    //either one player runs out of card is game over
		                    if((firstDeck.size() == 0)||	(secondDeck.size() == 0 )){       
		                        
		                    	
		                    	break;
		                    }//end if
		                    
		                    System.out.println("War card for "+p1.getName()+" is xx\nWar card for "+p2.getName()+" is xx");

		                    war1.add(firstDeck.pop());  //place additional card for war
		                    war2.add(secondDeck.pop()); 
		                }//end for
		             
		                
		                
		                war1_total.addAll(war1) ;//Add the war1 into war1_total
		                war2_total.addAll(war2) ;//Add the war2 into war2_total
		           
		                
		                 war1_total.add(firstDeck.pop()) ;
		                 war2_total.add(secondDeck.pop()) ;
		                       
		                //only compare result when both players have enough cards for war
		                if(war1.size() == 3 && war2.size() == 3){
		                    //display the war cards from each player
		                    System.out.println("War card for "+" " +p1.getName()+" " +" is "+  " " +war1_total.get(4).toString()+"\n");
		                    System.out.println("War card for "+" "+p2.getName()+" " +" is " + " "+war2_total.get(4).toString()+"\n");
		                    
		                    
		                    
		                    //WHEN PLAYER 1 WIN THE WAR
		                    if(Compare.CompareWarCard1(war1_total, war2_total)){
		                        firstDeck.addAll(war1_total); //player1 get all 10 cards
		                        firstDeck.addAll(war2_total);
		                        
		                        firstDeck = War1.shuffle1(firstDeck);
		                       
		                        System.out.println("\nCongrats! " + p1.getName() +" wins the round\n");
		                        
		                        System.out.println(p1.getName() + "'s current deck size is  : " + firstDeck.size());
		                        System.out.println(p2.getName() + "'s current deck size is : " + secondDeck.size());
		                        
		                        point1 = point1+5 ;
		                        
		                        p1.setPoint(point1) ;
		                        System.out.println("\n\nCURRENT SCORE : ");//Display current Score of both players
		                        System.out.println(p1.getName()+" 's Point score is "+  p1.getPoint()) ;
		                        System.out.println(p2.getName()+" ' s Point score is "+  p2.getPoint()) ;
		                        p1.Compare(p2);
		                      
		                    }//end if
		                
		                    //WHEN PLAYER 2 WINS THE WAR
		                    else if(Compare.CompareWarCard2(war1_total , war2_total))
		                    {
		                        secondDeck.addAll(war1_total); //player2 get all 10 cards
		                        secondDeck.addAll(war2_total);
		                        
		                       secondDeck = War2.shuffle2(secondDeck);
		                        
		                       
		                        System.out.println("\nCongrats! " + p2.getName() +" wins the round\n");
		                        
		                        System.out.println(p1.getName() + "'s current deck size is  : " + firstDeck.size());
		                        System.out.println(p2.getName() + "'s current deck size is : " + secondDeck.size());
		                        
		                        point2 = point2 +5 ;
		                        
		                        p2.setPoint(point2);
		                        System.out.println("\nCURRENT SCORE : ");
		                        System.out.println(p1.getName()+" 's Point score is "+  p1.getPoint()) ;
		                        System.out.println(p2.getName()+" ' s Point score is "+  p2.getPoint()) ;
		                        p1.Compare(p2);
		                        System.out.println(p2.getName()+" " + " wins the war round\n");
		                       
		                        }
		                    else 
		                    {
		                    	System.out.println("Its a draw for  both sides\n");
		                    	System.out.println("Cards will be returned to each side\n");
		                    	
		                    	secondDeck.addAll(war2_total) ;
		                    	firstDeck.addAll(war1_total);
		                    	
		                    	firstDeck =War1.shuffle1(firstDeck);
		                    	secondDeck = War2.shuffle2(secondDeck);
		                    	
		                    	System.out.println(p1.getName() + "'s current deck size is  : " + firstDeck.size());
		                        System.out.println(p2.getName() + "'s current deck size is : " + secondDeck.size());
		                        
		                        System.out.println("\nCURRENT SCORE : ");
		                        System.out.println(p1.getName()+" 's Point score is "+  p1.getPoint()) ;
		                        System.out.println(p2.getName()+" ' s Point score is "+  p2.getPoint()) ;
		                        
		                    	
		                    }
		                }
		                }
		                
		                catch(NoSuchElementException e)
		                {
		                	if(firstDeck.size()<secondDeck.size())
		                	{
		                	System.out.println("Since " + p1.getName() + "'s current deck size is not enough to War," + p2.getName() + " automatically wins the game!" );
		                	main(args);
		                	}
		                	else if(firstDeck.size()>secondDeck.size())
		                	{
		                		System.out.println("Since " + p2.getName() + "'s current deck size is not enough to War," + p1.getName() + " automatically wins the game!" );
		                		main(args);
		                	}
		                	else
		                	{
		                		System.out.println("Since both players do not have enough cards to War, the game ends in a DRAW " );
		                		main(args);
		                	}
		                }
		                    
		                
		                }//end else  if 
	                
	                else {//if player 2 win 
	                	
	                	
	                	secondDeck =War2.Battle2(secondDeck, p2Card, p1Card) ;
	                           
	                    System.out.println("\nCongrats! " + p2.getName() +" wins the round\n");
	                    
	                    System.out.println(p1.getName() + "'s current deck size is  : " + firstDeck.size());
	                    System.out.println(p2.getName() + "'s current deck size is : " + secondDeck.size());
	                   point2++;
	                   
	                   p2.setPoint(point2);
	                   System.out.println("\nCURRENT SCORE : ");
	                   System.out.println(p1.getName()+" 's Point score is "+  p1.getPoint()) ;
	                   System.out.println(p2.getName()+" ' s Point score is "+  p2.getPoint()) ;
	                   p1.Compare(p2);
	                } 
	            
	            
			 
	                    
	                
	               
	            	
	          }
			  if(secondDeck.size() == 0){ // Only when one of the player's deck is empty , winner will be declared
		            System.out.println();
		            
		            JFrame f1 = new JFrame();
		            JOptionPane.showMessageDialog(f1, "game over\n"+" "+p1.getName()+" "+" wins the game");
		           
		            break;
		        }
		        else if(firstDeck.size() ==0){
		        	
		        	JFrame f2 = new JFrame(); 
		        	JOptionPane.showMessageDialog(f2, "game over\n"+" "+p2.getName()+" "+" wins the game");
		            
		            break;
		        }           
			            //game over either one player runs out of card(deck size is 0)
			         
	            }
	        
        }
       
          
	            
	        
	              
	    //endwhile
	    


		public static void war(){ //war is a method that prints out the War message
		System.out.println("************************************************WAR*******************************************");
		}


		

		
		

	}//end WarCardGame class
  

	

