import java.net.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;
import java.util.*;

// User Zach Scrivena(https://stackoverflow.com/users/20029/zach-scrivena) posted a response to this thread: https://stackoverflow.com/questions/500891/generating-an-image-with-data-fields-using-java
// which I've used as a reference.

public class Card{
	
	private String url = new String("");
	private String[] identity = new String[2];
	private String[] stats = new String[3];
	private String text = new String("");
	private String author = new String("");
	private String set = new String("");
	private int count = 0;
	
	public Card(){
		url = "https://drive.google.com/uc?export=download&id=1HMHhPj290ICULgHcH0mLeWA_t8DeEYvT"; // defaults to the standard card background.
		String[] identity = {"NAME", "SPECIES"};
		String[] stats = {"0", "0", "0"};
	}
	
	public Card(String[] indentity, String[] stats, String text, String author, String set, int count){
		
	}
	
	/*
	*	The Getters
	*/
	
	public BufferedImage getCardBackgroundImage(){
		
		try{
			URL card_background_link = new URL(this.url);
			return ImageIO.read(card_background_link);
		} catch(MalformedURLException mue) {
			IO.print("Please provide a URL");
		} catch(IOException ioe) {
			IO.print("IOException has occured");
		}
		
		return null;
	}
	
	public String getURL(){
		if(this.url == null){
			this.url = "";
		}
		
		return this.url;
	}
	
	public String[] getIdentity(){
		if(this.identity == null){
			String[] identitycopy = {"", ""};
		}
		if(this.identity[0] == null){
			identity[0] = "";
		}
		if(this.identity[1] == null){
			identity[1] = "";
		}
		
		String[] identitycopy = Arrays.copyOf(identity, identity.length);
		
		return identitycopy;
	}
	
	public String[] getStats(){
		
		String[] statscopy = new String[3];
		
		if(this.stats == null){
			for(int i = 0; i < 3; i++){
				statscopy[i] = "0";
			}
		}
		if(this.stats[0] == null){
			statscopy[0] = "0";
		}
		if(this.stats[1] == null){
			statscopy[1] = "0";
		}
		if(Integer.parseInt(this.stats[2]) < 0){
			statscopy[2] = "0";
		}
		
		statscopy = Arrays.copyOf(stats, stats.length);
		
		return statscopy;
	}
	
	public String getAuthor(){
		
		String authorcopy = new String(author);
		
		return authorcopy.toLowerCase();
	}
	
	public String getSet(){
		
		String setcopy = new String(set);
		
		return setcopy.toLowerCase();
	}
	
	public int getCount(){
		return this.count;
	}
	
	/*
	 *	 The Setters
	 */
	 
	 public String setURL(String url){
		 
		try{
			URL urltest = new URL(url);
		} catch(MalformedURLException mue) {
			IO.print("Please provide a valid URL");
			return "";
		}
		
		 return url;
	 }
	 
	 public String[] setIdentity(String[] identity){
		 
		if(identity == null){
			for(int i = 0; i < identity.length; i++){
				identity[i] = "";
			}
		}
		if(identity[0] == null){
			identity[0] = "";
		}
		if(identity[1] == null){
			identity[1] = "";
		}
		 
		 return identity;
	 }
	 
	 public String[] setStats(String[] stats){
		 
		if(stats == null){
			for(int i = 0; i < stats.length; i++){
				stats[i] = "0";
			}
		}
		if(this.stats[0] == null){
			stats[0] = "0";
		}
		if(this.stats[1] == null){
			stats[1] = "0";
		}
		if(Integer.parseInt(this.stats[2]) < 0){
			stats[2] = "0";
		}
		 return stats;
	 }
	 
	 public String setAuthor(String author){
		 if(author == null){
			 author = "John Anonymous";
		 }
		 
		 return author;
	 }
	 
	 public String setSet(String set){
		 if(set == null){
			 set = "IRL";
		 }
		 
		 return set;
	 }
	 
	 public int setCount(int count){
		 if(count < 0){
			 count = 0;
		 }
		 
		 return count;
	 }
	
}
