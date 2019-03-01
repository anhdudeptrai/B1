package main;

public class Point2 {
	public int x, y;
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean equals(Object obj) {
		if (obj instanceof Point2) {
			Point2 another = (Point2) obj;
			if (this.x == another.x && this.y == another.y) return true;
		}
		return false;
	}
	public void printPoint() {
		System.out.print("(" + this.x + " " + this.y+ ")");
	}
	public int hashCode() {
		return x+y;
	}

}

