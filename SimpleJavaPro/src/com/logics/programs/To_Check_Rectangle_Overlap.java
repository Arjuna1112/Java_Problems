package com.logics.programs;

public class To_Check_Rectangle_Overlap {

	public static void main(String[] args) {
		Point l1 = new Point(0,10), r1 = new Point(10,0);
	    Point l2 = new Point(5,5), r2 = new Point(15,0);
	    if (doOverlap(l1, r1, l2, r2))
	        System.out.println("Rectangles Overlap");
	    else
	    	System.out.println("Rectangles Don't Overlap");
	}
	
	static boolean doOverlap(Point l1, Point r1, Point l2, Point r2)
	{
	    //If one rectangle is left side of other
		if(l1.x > r2.x || l2.x > r1.x) return false;
		//If one rectangle is top of other
		if(l1.y < r2.y || l2.y < r1.y) return false;
		
		return true;
	}

	static class Point{
		int x,y;
		
		public Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
