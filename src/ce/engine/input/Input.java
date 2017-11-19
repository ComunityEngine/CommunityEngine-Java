package ce.engine.input;

import org.lwjgl.glfw.GLFW;

public class Input {
	
	public static State getKey(long window, Key key) {
		int state = GLFW.glfwGetKey(window, key.getKeyCode());
		if(state == 0) {
			return State.RELEASE;
		}else if(state == 1) {
			return State.PRESS;
		}
		return State.UNKNOWN;
		
	}

}
