package ce.core.ui;

public class Rectangle extends Node{
	
	public Rectangle(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public void update() {
		beginPath();
		rect(x, y, width, height);
		fillColor(255, 162, 29);
		fill();
	}

}
