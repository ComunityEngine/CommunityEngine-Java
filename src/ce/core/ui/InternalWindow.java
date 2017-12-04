package ce.core.ui;

import static org.lwjgl.nanovg.NanoVG.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryStack;

public class InternalWindow extends Node {

	public InternalWindow(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	@Override
	public void update() {
		drawWindow();
	}

	private void drawWindow() {
		float cornerRadius = 3.0f;

		nvgSave(NanoGui.getVG());

		beginPath();
		roundedRect(x, y, width, height, cornerRadius);
		fillColor(28, 30, 34);
		fill();

		nvgRestore(NanoGui.getVG());

		nvgBoxGradient(NanoGui.getVG(), x, y + 2, width, height, cornerRadius * 2, 10, rgba(0, 0, 0, 128), rgba(0, 0, 0, 0), paint);
		beginPath();
		rect(x - 10, y - 10, width + 20, height + 30);
		roundedRect(x, y, width, height, cornerRadius);
		nvgPathWinding(NanoGui.getVG(), NVG_HOLE);
		nvgFillPaint(NanoGui.getVG(), paint);
		fill();

		nvgLinearGradient(NanoGui.getVG(), x, y, x, y + 15, rgba(255, 255, 255, 8), rgba(0, 0, 0, 16), paint);
		beginPath();
		roundedRect(x + 1, y + 1, width - 2, 30, cornerRadius - 1);
		fillPaint();
		fill();
		beginPath();
		nvgMoveTo(NanoGui.getVG(), x + 0.5f, y + 0.5f + 30);
		nvgLineTo(NanoGui.getVG(), x + 0.5f + width - 1, y + 0.5f + 30);
		strokeColor(0, 0, 0, 32);
		stroke();
		
//		nvgFontSize(vg, 18.0f);
//        nvgFontFace(vg, "sans-bold");
//        nvgTextAlign(vg, NVG_ALIGN_CENTER | NVG_ALIGN_MIDDLE);
		
//		try (MemoryStack stack = MemoryStack.stackPush()) {
//            ByteBuffer titleText = stack.ASCII(title, false);
//
//            nvgFontBlur(vg, 2);
//            nvgFillColor(vg, rgba(0, 0, 0, 128, colorA));
//            nvgText(vg, x + w / 2, y + 16 + 1, titleText);
//
//            nvgFontBlur(vg, 0);
//            nvgFillColor(vg, rgba(220, 220, 220, 160, colorA));
//            nvgText(vg, x + w / 2, y + 16, titleText);
//        }

        nvgRestore(NanoGui.getVG());
	}

}
