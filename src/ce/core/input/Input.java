package ce.core.input;

import java.util.ArrayList;

public class Input {
	private ArrayList<InputData> downKeys = new ArrayList<InputData>();
	private ArrayList<InputData> releasedKeys = new ArrayList<InputData>();
	private ArrayList<InputData> pressedKeys = new ArrayList<InputData>();
	
	public Input() {
	}

	public void setKeyDown(int key) {
		downKeys.add(new InputData(key));
	}

	public void setKeyUp(int key) {
		for (int i = downKeys.size() - 1; i >= 0; i--) {
			int value = downKeys.get(i).getValue();
			if (value == key) {
				releasedKeys.add(downKeys.get(i));
				downKeys.remove(i);
				break;
			}
		}

		for (int i = pressedKeys.size() - 1; i >= 0; i--) {
			if (pressedKeys.get(i).getValue() == key) {
				pressedKeys.remove(i);
			}
		}
	}

	public boolean isKeyDown(Key key) {
		for (int i = downKeys.size() - 1; i >= 0; i--) {
			if (downKeys.get(i).getValue() == key.getKeyCode()) {
				return true;
			}
		}

		return false;
	}

	public boolean isKeyReleased(Key key) {
		for (int i = releasedKeys.size() - 1; i >= 0; i--) {
			if (releasedKeys.get(i).getValue() == key.getKeyCode()) {
				releasedKeys.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean isKeyPressed(Key key) {
		if (isKeyDown(key)) {
			for (int i = pressedKeys.size() - 1; i >= 0; i--) {
				if (pressedKeys.get(i).getValue() == key.getKeyCode()) {
					return false;
				}
			}
			pressedKeys.add(new InputData(key.getKeyCode()));
			return true;
		}
		return false;
	}

	public boolean isMouseClicked(MouseButton button) {
		if (isMouseDown(button)) {
			for (int i = pressedKeys.size() - 1; i >= 0; i--) {
				if (pressedKeys.get(i).getValue() == button.getKeyCode()) {
					return false;
				}
			}
			pressedKeys.add(new InputData(button.getKeyCode()));
			return true;
		}
		return false;
	}
	
	public boolean isMouseDown(MouseButton button)
	{
		for (int i = downKeys.size() - 1; i >= 0; i--) {
			if (downKeys.get(i).getValue() == button.getKeyCode()) {
				return true;
			}
		}

		return false;
	}
	
	public boolean isMouseReleased(MouseButton button) {
		for (int i = releasedKeys.size() - 1; i >= 0; i--) {
			if (releasedKeys.get(i).getValue() == button.getKeyCode()) {
				releasedKeys.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * clears all the released key states which would keep increasing if the released method wastn't called manually from the last frame (This method is called
	 * automatically in Window.update();)
	 */
	public void reset() {
		releasedKeys.clear();
	}

}
