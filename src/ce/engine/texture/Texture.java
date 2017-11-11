package ce.engine.texture;

public class Texture {
	private int ID;
	private int width;
	private int height;
	
	public Texture(int ID, int width, int height) {
		this.ID = ID;
		this.width = width;
		this.height = height;
	}

	public int getID() {
		return ID;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
