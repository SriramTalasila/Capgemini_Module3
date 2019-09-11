package com.cg;

import java.util.List;

public class Triangle {

	/*
	 * private List<Point> points;
	 * 
	 * public List<Point> getPoints() { return points; }
	 * 
	 * public void setPoints(List<Point> points) { this.points = points; }
	 * 
	 * public void draw() { for (Point point : points) {
	 * System.out.println("Point (" + point.getX() + "," + point.getY() + ")"); } }
	 */

	private Point pointA;
	private Point pointB;
	private Point pointC;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Point A (" + pointA.getX() + "," + pointA.getY() + ")");
		System.out.println("Point B (" + pointB.getX() + "," + pointB.getY() + ")");
		System.out.println("Point C (" + pointC.getX() + "," + pointC.getY() + ")");
	}

	/*
	 * @Override public void afterPropertiesSet() throws Exception {
	 * System.out.println("After properties set of initializing Bean");
	 * 
	 * }
	 * 
	 * @Override public void destroy() throws Exception { // TODO Auto-generated
	 * method stub System.out.println("Disposable bean");
	 * 
	 * }
	 */

	public void onInit() {
		System.out.println("Custom Intilisation method");
	}

	public void onDestroy() {
		System.out.println("Custom destroy method");
	}
}
