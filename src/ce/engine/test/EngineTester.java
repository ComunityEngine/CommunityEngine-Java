package ce.engine.test;

import ce.engine.Window;

public class EngineTester {
	
	public static void main(String[] args) {
		long window = Window.createWindow(800, 600, "[CE] CommunityEngine");
		
		while(Window.isCloseRequested(window)) {
			Window.update(window);
		}
		
		Window.close(window);
		Window.disposeGLFW();
	}

}
