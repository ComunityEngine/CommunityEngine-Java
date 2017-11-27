package ce.core.input;

import org.lwjgl.glfw.GLFW;

public enum MouseButton {
	 MOUSE_BUTTON_LEFT (GLFW.GLFW_MOUSE_BUTTON_LEFT),
	 MOUSE_BUTTON_MIDDLE (GLFW.GLFW_MOUSE_BUTTON_MIDDLE),
	 MOUSE_BUTTON_RIGHT (GLFW.GLFW_MOUSE_BUTTON_RIGHT),
	 BUTTON_4(GLFW.GLFW_MOUSE_BUTTON_4),
	 BUTTON_5(GLFW.GLFW_MOUSE_BUTTON_5),
	 BUTTON_6(GLFW.GLFW_MOUSE_BUTTON_6),
	 BUTTON_7(GLFW.GLFW_MOUSE_BUTTON_7),
	 BUTTON_8(GLFW.GLFW_MOUSE_BUTTON_8);
	
	final int code;
	
	private MouseButton(int code)
	{
		this.code = code;
	}
	
	public int getKeyCode()
	{
		return code;
	}
}
