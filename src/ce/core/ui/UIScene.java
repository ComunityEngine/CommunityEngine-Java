package ce.core.ui;

import ce.core.maths.Vector2f;

public class UIScene {
	
	private Vector2f location = new Vector2f();
	private Bounds clipBounds;
	
	private Parent parent = null;
	
	public UIScene(Parent parent)
	{
		this(parent, new Bounds(new Vector2f(), new Vector2f(200, 200)));
	}

	public UIScene(Parent parent, Bounds bounds) {
		clipBounds = bounds;
//		NanoGui.init();
		this.parent = parent;
	}
	
	public void update()
	{
		if(parent != null) {
			parent.update();
		}
	}
}
