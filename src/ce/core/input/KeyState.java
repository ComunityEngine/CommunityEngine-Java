package ce.core.input;

public class KeyState {
	
	public final int key;
	public final int scancode;
	public final int action;
	public final int mods;
	
	public KeyState(int key, int scancode, int action, int mods) {
		this.key = key;
		this.scancode = scancode;
		this.action = action;
		this.mods = mods;
	}

	public int getKey() {
		return key;
	}

	public int getScancode() {
		return scancode;
	}

	public int getAction() {
		return action;
	}

	public int getMods() {
		return mods;
	}
}
