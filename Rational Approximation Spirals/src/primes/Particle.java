package primes;

import java.awt.Color;
import java.awt.Graphics2D;

public class Particle {
	int size;
	double r;
	double theta;

	Color color;
	int x;
	int y;
	
	public Particle(int size_, double r_, double theta_, Color color_) {
		this.color = Color.WHITE;

		this.size = size_;
		this.r = r_;
		this.theta = theta_;
		this.color = color_;

		calculate();
	}

	void draw(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.drawRect(this.x, this.y, this.size, this.size);
	}

	void fill(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.fillRect(this.x, this.y, this.size, this.size);
	}

	void calculate() {
		this.x = (int) Math.round(this.r * Math.cos(this.theta));
		this.y = (int) Math.round(this.r * Math.sin(this.theta));
	}

	void addToCoordinates(int i, int j) {
		this.x += i;
		this.y += j;
	}

	public String toString() {
		return "Particle[X: " + this.x + ",\tY: " + this.y + ",\t\tSize: " + this.size + ",\tDistance: " + this.r
				+ ",\tAngle: " + this.theta + "]";
	}

	public double getR() {
		return this.r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getTheta() {
		return this.theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	int getSize() {
		return this.size;
	}

	void setSize(int s_) {
		this.size = s_;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
