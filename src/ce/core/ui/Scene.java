package ce.core.ui;

import ce.core.maths.Vector2f;

public class Scene {
	
	private Vector2f location = new Vector2f();
	private Bounds clipBounds;
	
	public Scene(Parent parent)
	{
		this(parent, new Bounds(new Vector2f(), new Vector2f(200, 200)));
	}

	public Scene(Parent parent, Bounds bounds) {
		clipBounds = bounds;
		NanoGui.init();
	}
}
