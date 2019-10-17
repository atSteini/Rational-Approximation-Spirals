package primes;

import java.awt.Color;

public class var {
  public static final Color bg = color(30);
  
  public static double zoom = 1;
  
  public static Particle[] particle = null;
  public static int[] prime = null;
		  
  public static boolean particlesInit = false;
  public static double scrollAdd = 0.001;

  public static int selectedPalette = 0;   
  public static String[] comboColors = { "Red", "Green", "Blue", "Vibrant", "Yellow", "Orange" };
  public static final int RED = 0, GREEN = 1, BLUE = 2, VIBRANT = 3,YELLOW = 4, ORANGE = 5;
  
  public static int selectedNumber = 0; 
  public static String[] comboNumbers = { "Primes", "All Integers", "Evens", "Odds" };
  public static final int PRIMES = 0, INTEGERS = 1, EVENS = 2, ODDS = 3;
  
  static Color color(int c) { 
	  return new Color(c, c, c); 
  }
}
