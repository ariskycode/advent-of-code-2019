package co.ariskycode.adventOfCode;

import java.util.Objects;

/**
 * Helper class for Day 3
 * 
 * @author <a href="https://github.com/ariskycode">ariskycode</a>
 *
 */
public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int X, int Y) {
		super();
		x = X;
		y = Y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
}
