package ce.core.ui;

import static org.lwjgl.nanovg.NanoVGGL3.*;
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
	private NVGPaint paint;
	
	public Node()
	{
		color = NVGColor.create();
		paint = NVGPaint.create();
	}
	
	public abstract void update();
	
	public void beginPath() {
		nvgBeginPath(NanoGui.getVG());
	}
	
	public void fillColor(float r, float g, float b) {
		fillColor(r, g, b, 1);
	}
	
	public void fillColor(float r, float g, float b, float a) {
		color.r(r);
		color.g(g);
		color.b(b);
		color.a(a);
		nvgFillColor(NanoGui.getVG(), color);
	}
	
	public void fillPaint() {
		nvgFillPaint(NanoGui.getVG(), paint);
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
