import java.net.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
import java.awt.font.*;

// https://docs.oracle.com/javase/tutorial/2d/images/drawonimage.html referencing java tutorial
// https://docs.oracle.com/javase/tutorial/2d/images/saveimage.html

public class CardEngine{
	void main(){
		String[] teststats = {"2", "2", "2"};
		String[] testidentity = {"Test", "TestType"};
		
		Card test = new Card(testidentity, teststats, "This card does nothing. And nothing is nothing but doing nothing", "Joshua Tenbusch", "TS", 0, "https://drive.google.com/uc?export=download&id=1HMHhPj290ICULgHcH0mLeWA_t8DeEYvT");
		
		test.outputCardImage();
		
	}
	
}
