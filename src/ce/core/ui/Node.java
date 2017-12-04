package ce.core.ui;

import static org.lwjgl.nanovg.NanoVG.*;

import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.nanovg.NVGPaint;

public abstract class Node {

	private boolean isVisible = true;

	protected float x;
	protected float y;
	protected float width;
	protected float height;

	private NVGColor color;
	public NVGPaint paint;

	public Node(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		color = NVGColor.create();
		paint = NVGPaint.create();
	}

	public Node() {
		this(0, 0, 100, 100);
	}

	public abstract void update();

	public void beginPath() {
		nvgBeginPath(NanoGui.getVG());
	}

	public void fillColor(float r, float g, float b) {
		fillColor(r, g, b, 1);
	}

	public void fillColor(float r, float g, float b, float a) {
		if(r > 1) {
			r = r / 255f;
		}
		
		if(g > 1) {
			g = g / 255f;
		}
		
		if(b > 1) {
			b = b / 255f;
		}
		
		if(a > 1) {
			a = a / 255f;
		}
		
		color.r(r);
		color.g(g);
		color.b(b);
		color.a(a);
		nvgFillColor(NanoGui.getVG(), color);
	}

	public void fillPaint() {
		nvgFillPaint(NanoGui.getVG(), paint);
	}
	
	public NVGColor rgba(float r, float g, float b, float a) {
		if(r > 1) {
			r = r / 255f;
		}
		
		if(g > 1) {
			g = g / 255f;
		}
		
		if(b > 1) {
			b = b / 255f;
		}
		
		if(a > 1) {
			a = a / 255f;
		}
		
		color.r(r);
		color.g(g);
		color.b(b);
		color.a(a);
		return color;
	}

	public void circle(float x, float y, float radius) {
		nvgCircle(NanoGui.getVG(), x, y, radius);
	}

	public void strokeColor(float r, float g, float b, float a) {
		color.r(r);
		color.g(g);
		color.b(b);
		color.a(a);
		nvgStrokeColor(NanoGui.getVG(), color);
	}

	public void stroke() {
		nvgStroke(NanoGui.getVG());
	}
	
	public void rect(float x, float y, float width, float height) {
		nvgRect(NanoGui.getVG(), x, y, width, height);
	}

	public void roundedRect(float x, float y, float width, float height, float cornerRadius) {
		nvgRoundedRect(NanoGui.getVG(), x, y, width, height, cornerRadius);
	}

	public void fill() {
		nvgFill(NanoGui.getVG());

		if (NanoGui.isDebug()) {
			drawBounds();
		}
	}

	private void drawBounds() {
		beginPath();
		rect(x, y, width, height);

		strokeColor(1, 0, 0, 1);
		nvgStroke(NanoGui.getVG());
	}

	public void setVisible(boolean isShowing) {
		this.isVisible = isShowing;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;

	}
}
