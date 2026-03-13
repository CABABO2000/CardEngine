import java.net.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
import java.awt.font.*;
import java.lang.*;

// https://docs.oracle.com/javase/tutorial/2d/images/drawonimage.html referencing java tutorial
// https://docs.oracle.com/javase/tutorial/2d/images/saveimage.html

public class CardEngine{
	
	public static boolean isdone = false;
	public static Scanner console = new Scanner(System.in);
	
	void main(){
		// Modified Ascii art from patorjk.com/software/taag/
		IO.println(" __      __   _                               ___             _   ___ _          _      ");
		IO.println(" \\ \\    / /__| |__ ___ _ __  ___  | |_ ___   / __|__ _ _ _ __| | | __|_| _  __ _(_)_   ___");
		IO.println("  \\ \\/\\/ / -_) / _/ _ \\ '  \\/ -_) |  _/ _ \\ | (__/ _` | '_/ _` | | _|| ' \\/ _` | | ' \\/ -_)");
		IO.println("   \\_/\\_/\\___|_\\__\\___/_|_|_\\___|  \\__\\___/  \\___\\__,_|_| \\__,_| |___|_||_\\__, |_|_||_\\___|");
		IO.println("                                                                          |___/            ");
		IO.println("-------------------------------------------------------------------------------------------");
		IO.println("");
		
		promptStart();
	}
	
	public static void promptStart(){
			
			IO.println("");
			IO.println("What do you want to do?");
			IO.println("= = = = = = = = = = = =");
			IO.println("");
			IO.println("Enter \"Card\" to make a new card");
			IO.println("");
			IO.println("Enter \"Deck\" to make a new deck/set [TO BE IMPLEMENTED]");
			IO.println("");
			IO.println("= = = = = = = = = = = =");
			IO.println("");
			IO.print("==> ");
			
			String answer = console.nextLine();
			
			while(!isdone){
				if(answer.equals("Card")){
					IO.println("");
					IO.println("= = = = = = = =");
					promptCardCreation();
					isdone = true;
				}else if(answer.equals("Deck")){
					IO.println("Sorry! This isn't implemented yet!");
					IO.print("==> ");
					answer = console.nextLine();
					IO.println("");
					isdone = false;
				} else if(!answer.equals("Card") | !answer.equals("Deck")){
					IO.println("Please type either \"Card\" or \"Deck\" (Preferably \"Card\")");
					IO.print("==> ");
					answer = console.nextLine();
					IO.println("");
					isdone = false;
				}
			}
	}
	
	public static void promptCardCreation(){
		
		IO.println("Card Creation:");
		IO.println("= = = = = = = =");
		IO.println("");
		
		Card newcard = new Card(new String[2], new String[3], null, null, null, 0, "https://drive.google.com/uc?export=download&id=1HMHhPj290ICULgHcH0mLeWA_t8DeEYvT");
		String tempname = "";
		String temptype = "";
		String tempatk = "";
		String temphp = "";
		String tempbld = "";
		
		IO.println("Card Identity");
		IO.println("- - - - - - -");
		IO.println("Please enter the Card's name:");
		IO.print("==> ");
		String answer = console.nextLine();
		IO.println("");
		if(!answer.equals("")){
			tempname = answer;
		}
			
			
		IO.println("Please enter the Card's type:");
		IO.print("==> ");
		answer = console.nextLine();
		if(!answer.equals("")){
			temptype = answer;
		}
		
		String[] newidentity = {tempname, temptype};
		newcard.setIdentity(newidentity);
		
		IO.println("");
		IO.println("Card Stats");
		IO.println("- - - - - -");
		IO.println("");
		
		isdone = false;
		
		IO.println("Please enter the Card's Attack:");
		IO.print("==> ");
		answer = console.next();
		
		while(!isdone){
			if(!isInteger(answer) || Integer.parseInt(answer) < 0){
				IO.println("Please only enter positive integers (EX: 1, 0, 500, 2000)");
				IO.print("==> ");
				answer = console.next();
			}else if(Integer.parseInt(answer) > 0){
			isdone = true;
			}
		}
		tempatk = answer;
		
		isdone = false;
		
		IO.println("Please enter the Card's Max Health:");
		IO.print("==> ");
		answer = console.next();
		
		while(!isdone){
			if(!isInteger(answer) || Integer.parseInt(answer) < 0){
				IO.println("Please only enter positive integers (EX: 1, 0, 500, 2000)");
				IO.print("==> ");
				answer = console.next();
			}else if(Integer.parseInt(answer) > 0){
			isdone = true;
			}
		}
		temphp = answer;
	
		isdone = false;
		
		IO.println("Please enter the Card's Blood:");
		IO.print("==> ");
		answer = console.next();
		
		while(!isdone){
			if(!isInteger(answer) || Integer.parseInt(answer) < 0){
				IO.println("Please only enter positive integers (EX: 1, 0, 500, 2000)");
				IO.print("==> ");
				answer = console.next();
			}else if(Integer.parseInt(answer) > 0){
			isdone = true;
			}
		}
		tempbld = answer;
		
		String[] tempstats = {tempatk, temphp, tempbld};
		
		newcard.setStats(tempstats);
		
		answer = console.nextLine();
		IO.println("");
		IO.println("Card Text");
		IO.println("- - - - - - -");
		IO.println("Please enter the Card's text:");
		IO.print("==> ");
		answer = console.nextLine();
		IO.println("");
		if(!answer.equals("")){
			newcard.setText(answer);
		}
		
		IO.println("");
		IO.println("Card Art Author");
		IO.println("- - - - - - -");
		IO.println("Please enter the Art Author:");
		IO.print("==> ");
		answer = console.nextLine();
		IO.println("");
		if(!answer.equals("")){
			newcard.setAuthor(answer);
		}
		
		IO.println("");
		IO.println("Card Set");
		IO.println("- - - - - - -");
		IO.println("Please enter the Card's Set (Usually abbreviated):");
		IO.print("==> ");
		answer = console.nextLine();
		IO.println("");
		if(!answer.equals("")){
			newcard.setSet(answer);
		}
		
		IO.println("");
		IO.println("Do you want to Output this card?");
		IO.println("= = = = = = = = = = = = = = = = =");
		IO.println("");
		IO.println("Enter \"Y\" to output an image of this card");
		IO.println("");
		IO.println("Enter \"N\" to scrap this card");
		IO.println("");
		IO.println("= = = = = = = = = = = = = = = = =");
		IO.println("");
		IO.print("==> ");
		
		answer = console.nextLine();
		isdone = false;
		
		while(!isdone){
			if(answer.equals("Y")){
				IO.println("");
				IO.println("Card output in /output/images/ !");
				IO.println("= = = = = = = = = = = = = = = = =");
				newcard.outputCardImage();
				isdone = true;
			}else if(answer.equals("N")){
				IO.println("Are you sure? This card will not be recoverable");
				IO.print("==> ");
				answer = console.nextLine();
				IO.println("");
				if(answer.equals("Y")){
					IO.println("");
					IO.println("Card output in /output/images/ !");
					IO.println("= = = = = = = = = = = = = = = = =");
					newcard.outputCardImage();
					isdone = true;
				}else if(answer.equals("No")){
					IO.println("Card not output");
					IO.println("- - - - - - - -");
					isdone = true;
					IO.println("");
				} else if(!answer.equals("Y") | !answer.equals("N")){
				IO.println("Please type either \"Y\" or \"N\"");
				IO.print("==> ");
				answer = console.nextLine();
				IO.println("");
				isdone = false;
			}
			} else if(!answer.equals("Y") | !answer.equals("N")){
				IO.println("Please type either \"Y\" or \"N\"");
				IO.print("==> ");
				answer = console.nextLine();
				IO.println("");
				isdone = false;
			}
		}
		
		IO.println("");
		IO.println("Are you finished?");
		IO.println("= = = = = = = = =");
		IO.println("");
		IO.println("Enter \"Y\" to keep going");
		IO.println("");
		IO.println("Enter \"N\" to close this application");
		IO.println("");
		IO.println("= = = = = = = = =");
		IO.println("");
		IO.print("==> ");
		
		answer = console.nextLine();
		isdone = false;
		
		while(!isdone){
			if(answer.equals("Y")){
				IO.println("");
				promptStart();
				isdone = true;
			}else if(answer.equals("N")){
				isdone = true;
			} else if(!answer.equals("Y") | !answer.equals("N")){
				IO.println("Please type either \"Y\" or \"N\"");
				IO.print("==> ");
				answer = console.nextLine();
				IO.println("");
				isdone = false;
			}
		}
	}
	
	// User corsiKa (https://stackoverflow.com/users/330057/corsika) posted a response to this thread: https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
	// This method is not made by me
	public static boolean isInteger(String str) {
		try { 
			Integer.parseInt(str); 
		} catch(NumberFormatException nfe) { 
			return false; 
		} catch(NullPointerException npe) {
			return false;
		}
		return true;
	}
	
}
