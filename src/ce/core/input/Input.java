package ce.core.input;

import java.util.ArrayList;

import org.lwjgl.glfw.GLFW;

public class Input {

	private static ArrayList<Key> downKeys = new ArrayList<Key>();

	public static State getKey(long window, Key key) {
		int state = GLFW.glfwGetKey(window, key.getKeyCode());
		if (state == 0) {
			for (int i = downKeys.size() - 1; i >= 0; i--) {
				if (downKeys.get(i).equals(key)) {
					downKeys.remove(key);
					return State.CLICKED;
				}
			}
			return State.RELEASE;
		} else if (state == 1) {
			if (!downKeys.contains(key)) {
				downKeys.add(key);
			}
			return State.PRESS;
		}
		return State.UNKNOWN;

	}

	public static State getMouse(long window, Key key) {
		int state = GLFW.glfwGetMouseButton(window, key.getKeyCode());
		if (state == 0) {
			for (int i = downKeys.size() - 1; i >= 0; i--) {
				if (downKeys.get(i).equals(key)) {
					downKeys.remove(key);
					return State.CLICKED;
				}
			}
			return State.RELEASE;
		} else if (state == 1) {
			if (!downKeys.contains(key)) {
				downKeys.add(key);
			}
			return State.PRESS;
		}
		return State.UNKNOWN;
	}

}
