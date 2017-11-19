package ce.core.texture;

import org.lwjgl.opengl.GL11;

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
	
	public void dispose() {
		GL11.glDeleteTextures(ID);
	}
}
