package model.painters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import model.Oblik;
import model.OblikPainter;
import model.elements.Pravougaonik;

public class PravougaonikPainter extends OblikPainter {

	private boolean isColorSet;
	private GradientPaint gradientPaint;

	public PravougaonikPainter(Oblik oblik) {
		super(oblik);
	}

	@Override
	public void paint(Graphics2D g) {

		Pravougaonik pravougaonik = (Pravougaonik) oblik;

		if (pravougaonik.color == null) {
			g.setPaint(Color.black);
		} else {
			isColorSet = true;
			g.setPaint(pravougaonik.getColor());
		}

		if (pravougaonik.stroke == null) {
			g.setStroke(new BasicStroke(5f));
			;
		} else {
			g.setStroke(pravougaonik.stroke);
		}

		g.rotate(Math.toRadians(pravougaonik.getUgao()));

		int ax = (int) pravougaonik.getPocetnaTacka().getX();
		int ay = (int) pravougaonik.getPocetnaTacka().getY();

		int bx = (int) pravougaonik.getKrajnjaTacka().getX();
		int by = (int) pravougaonik.getPocetnaTacka().getY();

		int cx = (int) pravougaonik.getPocetnaTacka().getX();
		int cy = (int) pravougaonik.getKrajnjaTacka().getY();

		int dx = (int) pravougaonik.getKrajnjaTacka().getX();
		int dy = (int) pravougaonik.getKrajnjaTacka().getY();

		g.draw(new Line2D.Double(new Point2D.Double(ax, ay), new Point2D.Double(cx, cy)));
		g.draw(new Line2D.Double(new Point2D.Double(cx, cy), new Point2D.Double(dx, dy)));
		g.draw(new Line2D.Double(new Point2D.Double(dx, dy), new Point2D.Double(bx, by)));
		g.draw(new Line2D.Double(new Point2D.Double(bx, by), new Point2D.Double(ax, ay)));

		if (isColorSet) {
			g.fillPolygon(new int[] { ax, bx, dx, cx }, new int[] { ay, by, dy, cy }, 4);
		}

	}

	@Override
	public boolean isElementAt(Point2D pos) {
		// TODO Auto-generated method stub
		return false;
	}

}
