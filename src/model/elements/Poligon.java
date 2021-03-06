package model.elements;

import java.awt.Color;
import java.awt.Stroke;

import model.Oblik;
import model.Pozicija;
import model.painters.PoligonPainter;

public class Poligon extends Oblik {
	
	private int[] xTacke;
	private int[] yTacke;
	private int brojIvica;
	
	public Poligon(Color color, Stroke stroke, double ugao,
			int[] xTacke, int[] yTacke, int brojIvica) {
		super(color, stroke, ugao);
		this.xTacke = xTacke;
		this.yTacke = yTacke;
		this.brojIvica = brojIvica;
		this.oblikPainter = new PoligonPainter(this);
	}
	
	public int[] getxTacke() {
		return xTacke;
	}
	
	public void setxTacke(int[] xTacke) {
		this.xTacke = xTacke;
	}
	
	public int[] getyTacke() {
		return yTacke;
	}
	
	public void setyTacke(int[] yTacke) {
		this.yTacke = yTacke;
	}
	
	public int getBrojIvica() {
		return brojIvica;
	}
	
	public void setBrojIvica(int brojIvica) {
		this.brojIvica = brojIvica;
	}
	
	public double getSirina() {
		double minX = Double.MAX_VALUE;
		double maxX = -Double.MAX_VALUE;

		int[] tacke = getxTacke();
		
		for(int i = 0; i < tacke.length; i++) {
		    double x = tacke[i];
		    minX = Math.min(minX, x);
		    maxX = Math.max(maxX, x); 
		}

		double sirina = maxX - minX;
		
		return sirina;
	}
	
	public double getVisina() {
		double minY = Double.MAX_VALUE;
		double maxY = -Double.MAX_VALUE;
		
		int[] tacke = getyTacke();

		for(int i = 0; i < tacke.length; i++) {
		    double y = tacke[i];
		    minY = Math.min(minY, y);
		    maxY = Math.max(maxY, y);    
		}
		
		double visina = maxY - minY;
		
		return visina;
	}
}
