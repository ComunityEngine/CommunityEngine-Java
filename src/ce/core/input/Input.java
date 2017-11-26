package ce.core.input;

import java.util.ArrayList;

import org.lwjgl.glfw.GLFW;

public class Input {

	// private static ArrayList<Key> downKeys = new ArrayList<Key>();
	//
	//
	// public static State getKey(Window window, Key key) {
	// int state = GLFW.glfwGetKey(window.windowID, key.getKeyCode());
	// if (state == 0) {
	// for (int i = downKeys.size() - 1; i >= 0; i--) {
	// if (downKeys.get(i).equals(key)) {
	// downKeys.remove(key);
	// return State.CLICKED;
	// }
	// }
	// return State.RELEASE;
	// } else if (state == 1) {
	// if (!downKeys.contains(key)) {
	// downKeys.add(key);
	// }
	// return State.PRESS;
	// }
	// return State.UNKNOWN;
	//
	// }
	//
	// public static State getMouse(Window window, Key key) {
	// int state = GLFW.glfwGetMouseButton(window.windowID, key.getKeyCode());
	// if (state == 0) {
	// for (int i = downKeys.size() - 1; i >= 0; i--) {
	// if (downKeys.get(i).equals(key)) {
	// downKeys.remove(key);
	// return State.CLICKED;
	// }
	// }
	// return State.RELEASE;
	// } else if (state == 1) {
	// if (!downKeys.contains(key)) {
	// downKeys.add(key);
	// }
	// return State.PRESS;
	// }
	// return State.UNKNOWN;
	// }

	private static ArrayList<KeyState> keyStates = new ArrayList<KeyState>();

	/**
	 * clears all the key states from the last frame (This method is called
	 * automatically in Window.update();)
	 */
	public static void clearFrame() {
		System.out.println(keyStates.size());
		keyStates.clear();
	}

	public static boolean isMouseClicked(Key key) {
		for (int i = 0; i < keyStates.size(); i++) {
			if (keyStates.get(i).key == key.getKeyCode() && keyStates.get(i).action == GLFW.GLFW_PRESS) {
				return true;
			}
		}
		return false;
	}

	public static boolean isKeyPressed(Key key) {
		for (int i = 0; i < keyStates.size(); i++) {
			if (keyStates.get(i).key == key.getKeyCode() && keyStates.get(i).action == GLFW.GLFW_PRESS) {
				return true;
			}
		}
		return false;
	}

	public static boolean isKeyDown(Key key) {
		for (int i = 0; i < keyStates.size(); i++) {
			if (keyStates.get(i).key == key.getKeyCode()) {
				return true;
			}
		}
		return false;
	}

	public static boolean isKeyReleased(Key key) {
		for (int i = 0; i < keyStates.size(); i++) {
			if (keyStates.get(i).key == key.getKeyCode() && keyStates.get(i).action == GLFW.GLFW_RELEASE) {
				return true;
			}
		}
		return false;
	}

	public static void setKey(int key, int scancode, int action, int mods) {
		System.out.println("Key: " + key + " scancode: " + scancode + " action: " + action + " mods: " + mods);
		keyStates.add(new KeyState(key, scancode, action, mods));
	}

}
