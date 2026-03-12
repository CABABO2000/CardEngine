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
	private int[] stats = new int[3];
	
	public Card(){
		url = "https://drive.google.com/uc?export=download&id=1HMHhPj290ICULgHcH0mLeWA_t8DeEYvT";
		String[] identity = {"NAME", "SPECIES"};
		int[] stats = {0, 0, 0};
	}
	
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
	
}
