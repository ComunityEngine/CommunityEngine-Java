package ce.core.ui;

import static org.lwjgl.nanovg.NanoVGGL3.*;
import static org.lwjgl.nanovg.NanoVG.*;

import org.lwjgl.system.MemoryUtil;

public class NanoGui {
	
	private static boolean initialized = false;
	private static long vg = -1;
	
	private static boolean debug = false;
	
	public static void init()
	{
		if(initialized) {
			return;
		}
		vg = nvgCreate((0) | NVG_STENCIL_STROKES | NVG_DEBUG);
		
		if(vg == MemoryUtil.NULL) {
			throw new RuntimeException("Could not init nanoVG");
		}
		
		initialized = true;
		System.out.println(vg);
	}
	
	public static void enable(int windowWidth, int windowHeight)
	{
		nvgBeginFrame(vg, windowWidth, windowHeight, 1);
	}
	
	public static void disable() {
		nvgEndFrame(vg);
	}
	
	public static void enableDebug() {
		NanoGui.debug = true;
	}

	public static boolean isDebug() {
		return debug;
	}
	
	public static void dispose() {
		nvgDelete(vg);
	}

	public static long getVG() {
		return vg;
	}

}
