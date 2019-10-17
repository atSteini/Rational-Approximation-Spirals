package primes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JPanel;

public class Panel extends JPanel implements MouseWheelListener {
	public static int w;
	public static int h;
	boolean init;
	static Random rng = new Random();

	static int sizeP = 1;
	static int numP = 1;
	static int start = 0, add = 1;

	public Panel() {
		this.init = false;
		addMouseWheelListener(this);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		if (!this.init) {
			init();
		}

		w = getWidth();
		h = getHeight();

		g2d.setBackground(var.bg);
		g2d.clearRect(0, 0, w, h);

		g2d.setColor(randomColor(var.selectedPalette));
		g2d.drawRect(0, 0, w - 1, h - 1);

		makeParticles(var.selectedNumber);

		drawParticles(g2d);
	}

	private void drawParticles(Graphics2D g2d) {
		if(var.selectedNumber == var.PRIMES) {
			for (int i = start; i < var.particle.length; i += add) {
				if(ArrayOperations.isPrime(i)) {
					var.particle[i].fill(g2d);
				}
			}
		}else {
			for (int i = start; i < var.particle.length; i += add) {
				var.particle[i].fill(g2d);
			}
		}
	}

	public static void makeParticles(int selector) {
		switch (selector) {
		case var.PRIMES:
			start = 0;
			add = 1;
			break;
		case var.INTEGERS:
			start = 0;
			add = 1;
			break;
		case var.EVENS:
			start = 0;
			add = 2;
			break;
		case var.ODDS:
			start = 1;
			add = 2;
			break;
		default:
			System.err.println("Could not set the Particle Number Palette.");
			break;
		}

		if (!var.particlesInit) {
			update();
			// System.out.println(String.valueOf(start) + " " + add + " " + numP);
			generateParticles(start, add);
		} else {
			updateParticles(start, add);
		}
	}

	static void generateParticles(int start, int add) {
		var.particle = new Particle[numP];

		for (int i = start; i < var.particle.length; i += add) {
			var.particle[i] = new Particle(sizeP, i * var.zoom, i, randomColor(var.selectedPalette));

			var.particle[i].addToCoordinates(w / 2, h / 2);
		}
		
		var.particlesInit = true;
	}

	static void updateParticles(int start, int add) {
		for (int i = start; i < var.particle.length; i += add) {
			var.particle[i].setSize(sizeP);

			var.particle[i].calculate();
			var.particle[i].addToCoordinates(w / 2, h / 2);
		}
	}

	static void update() {
		if (var.zoom >= 1.0) {
			sizeP = (int) Math.round(var.zoom);
		} else {
			sizeP = 1;
		}

		numP = (int) Math.round(Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2)) / var.zoom);
	}

	static Color randomColor(int selector) {
		Color[] possible = null;
		switch (selector) {
		case 0:
			possible = new Color[1];
			possible[0] = new Color(248, 54, 40);

			return selectRandom(possible);
		case 1:
			possible = new Color[1];
			possible[0] = new Color(116, 248, 40);
			return selectRandom(possible);
		case 2:
			possible = new Color[1];
			possible[0] = new Color(60, 117, 141);
			return selectRandom(possible);
		case 3:
			possible = new Color[5];
			possible[0] = new Color(248, 116, 40);
			possible[1] = new Color(116, 248, 40);
			possible[2] = new Color(248, 54, 40);
			possible[3] = new Color(140, 63, 200);
			possible[4] = new Color(60, 117, 141);
			return selectRandom(possible);
		case 4:
			possible = new Color[1];
			possible[0] = new Color(248, 248, 40);
			return selectRandom(possible);
		case 5:
			possible = new Color[1];
			possible[0] = new Color(236, 105, 30);
			return selectRandom(possible);
		}
		System.out.println("Could not get a random Color. Error: Selector missing or wrong");
		return selectRandom(possible);
	}

	static Color selectRandom(Color[] c) {
		if (c != null) {
			return c[rng.nextInt(c.length)];
		}
		return null;
	}

	void init() {
		w = getWidth();
		h = getHeight();
		
		this.init = true;
		repaint();
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		var.scrollAdd = 1.0 / ((double) numP / 35.0);
		
		if (e.getWheelRotation() > 0 && var.zoom - var.scrollAdd > 0.0) {
			var.zoom -= var.scrollAdd;
		} else {
			var.zoom += var.scrollAdd;
		}
		
		var.particlesInit = false;
		repaint();
	}

	private boolean isBetween(int num, int i, int j) {
		return (num >= i && num < j);
	}
}
