package ce.core;

import org.lwjgl.opengl.GL11;

public class Scene {
	
	private boolean glInitilized = false;
	
	private int width;
	private int height;
	
	public Scene(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void setClearColor(float red, float green, float blue, float alpha) {
		if(!glInitilized) {
			return;
		}
		GL11.glClearColor(red, green, blue, alpha);
	}
	
	protected void setGLinitilized()
	{
		glInitilized = true;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
