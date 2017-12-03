package ce.core.ui;

import ce.core.maths.Vector2f;

public class Bounds {

	private Vector2f startBounds;
	private Vector2f endBounds;

	public Bounds(Vector2f startBounds, Vector2f endBounds) {
		super();
		this.startBounds = startBounds;
		this.endBounds = endBounds;
	}

	public Vector2f getStartBounds() {
		return startBounds;
	}

	public void setStartBounds(Vector2f startBounds) {
		this.startBounds = startBounds;
	}

	public Vector2f getEndBounds() {
		return endBounds;
	}

	public void setEndBounds(Vector2f endBounds) {
		this.endBounds = endBounds;
	}
}
