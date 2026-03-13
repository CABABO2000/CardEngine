import java.net.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;
import java.util.*;
import java.awt.font.*;
import java.io.*;

// User Zach Scrivena(https://stackoverflow.com/users/20029/zach-scrivena) posted a response to this thread: https://stackoverflow.com/questions/500891/generating-an-image-with-data-fields-using-java
// which I've used as a reference and a starting point.


// "https://drive.google.com/uc?export=download&id=1HMHhPj290ICULgHcH0mLeWA_t8DeEYvT" URL for card background.
public class Card{
	
	private String urlart = new String("");
	private String urlback = new String("");
	private String[] identity = new String[2];
	private String[] stats = new String[3];
	private String text = new String("");
	private String author = new String("");
	private String set = new String("");
	private Font textfont = new Font("", 0, 0);
	private Font typefont = new Font("", 0, 0);
	private Font statsfont = new Font("", 0, 0);
	private Font namefont = new Font("", 0, 0);
	private int count = 0;
	
	public Card(){
		this(null, null, null, null, null, 0, null);
	}
	
	public Card(String[] identity, String[] stats, String text, String author, String set, int count, String url){
		
		setURLBack(url);
		setIdentity(identity);
		setStats(stats);
		setText(text);
		setAuthor(author);
		setSet(set);
		setCount(count);
		setTextFont();
		setStatsFont();
		setNameFont();
		setTypeFont();
		
	}
	
	// a primitive text wrap adapted to be used in outputCard
	
	public String[] correctText(String text){
		
		Scanner scan = new Scanner(text);
		
		String[] newtext = {"", "", "", "", "", ""};
		String line = "";
		String at = "";
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(j < text.length()){
			while(j < text.length() && i < 41){
				at = text.charAt(j) + "";
				line = line + at;
				i++;
				j++;
			}
			newtext[k] = line;
			line = "";
			i = 0;
			k++;
		}
		
		return newtext;
	}
	
	// Outputs an image representing the card for use in tabletop simulator
	// font to be fixed
	// card art to be added.
	
	public void outputCardImage(){
		
		BufferedImage bi = getCardBackgroundImage();
		Graphics2D g2 = bi.createGraphics();
		
		g2.setFont(getTextFont());
		g2.setColor(new Color(0, 0, 0));
		for(int i = 0; i < 6; i++){
			g2.drawString(correctText(getText())[i], 235, 853 + (i * 45));
		}
		
		g2.setFont(getTypeFont());
		g2.drawString(getIdentity()[1], 110, 120);
		
		g2.setFont(getNameFont());
		g2.drawString(getIdentity()[0], 70, 78);
		
		g2.setFont(getStatsFont());
		g2.drawString(getStats()[0], 88, 920);
		g2.drawString(getStats()[0], 88, 1090);
		g2.drawString(getStats()[0], 88, 1260);
		
		try{
			ImageIO.write(bi, "png", new File("output/" + getIdentity()[0] + ".png"));
		}catch(IOException ioe){
		
		}
			
	}
	
	/*
	*	The Getters
	*/
	
	public BufferedImage getCardBackgroundImage(){
		
		try{
			URL card_background_link = new URL(this.urlback);
			return ImageIO.read(card_background_link);
		} catch(MalformedURLException mue) {
			IO.print("Please provide a URL");
		} catch(IOException ioe) {
			IO.print("IOException has occured");
		}
		
		return null;
	}

	public Font getTextFont(){
		return this.textfont;
	}
	
	public Font getStatsFont(){
		return this.statsfont;
	}
	
	public Font getNameFont(){
		return this.namefont;
	}
	
	public Font getTypeFont(){
		return this.typefont;
	}
	
	public String getURLBack(){
		if(this.urlback == null){
			this.urlback = "";
		}
		
		return this.urlback;
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
	
	public String getText(){
		
		String textcopy = new String(text);
		
		return textcopy.toLowerCase();
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
	 
	public void setURLBack(String url){
		 
		try{
			URL urltest = new URL(url);
		} catch(MalformedURLException mue) {
			IO.print("Please provide a valid URL");
		}
		
		 this.urlback = url;
	 }
	 
	public void setIdentity(String[] identity){
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
		 this.identity = identity;
	 }
	 
	public void setStats(String[] stats){
		 
		if(stats == null){
			for(int i = 0; i < stats.length; i++){
				stats[i] = "0";
			}
		}
		if(stats[0] == null){
			stats[0] = "0";
		}
		if(stats[1] == null){
			stats[1] = "0";
		}
		if(stats[2] == null || Integer.parseInt(stats[2]) < 0){
			stats[2] = "0";
		}
		 this.stats = stats;
	 }
	 
	public void setStats(int atk, int hp, String bld){
		
		if(hp > 0){
			hp = 0;
		}
		if(atk > 0){
			atk = 0;
		}
		if(bld == null){
			bld = "0";
		}
		
		this.stats[0] = "" + atk;
		this.stats[1] = "" + hp;
		this.stats[2] = bld;
	 }
	 
	public void setText(String text){
		 if(text == null){
			 text = "This card does nothing.";
		 }
		 
		 this.text = text;
	 }
	 
	public void setAuthor(String author){
		 if(author == null){
			 author = "John Anonymous";
		 }
		 
		 this.author = author;
	 }
	 
	public void setSet(String set){
		 if(set == null){
			 set = "IRL";
		 }
		 
		 this.set = set;
	 }
	 
	public void setCount(int count){
		 if(count < 0){
			 count = 0;
		 }
		 
		 this.count = count;
	 }
	 
	// https://docs.oracle.com/javase/tutorial/2d/text/textattributes.html
	public void setTextFont(){
		Map<TextAttribute, Object> fontmap = new Hashtable<TextAttribute, Object>();
		
		// Attributes to put on
		fontmap.put(TextAttribute.SIZE, 40);
		fontmap.put(TextAttribute.FAMILY, "SANS");
		
		this.textfont = textfont.deriveFont(fontmap);
	}
	
	public void setTypeFont(){
		Map<TextAttribute, Object> fontmap = new Hashtable<TextAttribute, Object>();
		
		// Attributes to put on
		fontmap.put(TextAttribute.SIZE, 20);
		fontmap.put(TextAttribute.FAMILY, "SANS");
		
		this.typefont = typefont.deriveFont(fontmap);
	}
	
	public void setStatsFont(){
		Map<TextAttribute, Object> fontmap = new Hashtable<TextAttribute, Object>();
		
		// Attributes to put on
		fontmap.put(TextAttribute.SIZE, 100);
		fontmap.put(TextAttribute.FAMILY, "SANS");
		
		this.statsfont = statsfont.deriveFont(fontmap);
	}
	 
	public void setNameFont(){
		Map<TextAttribute, Object> fontmap = new Hashtable<TextAttribute, Object>();
		
		// Attributes to put on
		fontmap.put(TextAttribute.SIZE, 60);
		fontmap.put(TextAttribute.FAMILY, "SANS");
		
		this.namefont = namefont.deriveFont(fontmap);
	}
	
	public String toString(){
		
		return identity[0] + " : -Type; " + identity[1] + " -Stats; (" + this.stats[0] + ", " + this.stats[1] + ", " + this.stats[2] + ") -Text; " + this.text + " -Author; " + this.author + " -Set; " + set + " -Count; " + count;
		
	}
	
}
