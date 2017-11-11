package ce.engine;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

public class Window {
	
	public static long createWindow(int width, int height, String title) {
		if(!GLFW.glfwInit()) {
			throw new IllegalStateException();
		}

		long window = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
		
		
		if(window == MemoryUtil.NULL) {
			System.err.println("Window returned NULL");
			System.exit(-1);
		}
		
		GLFW.glfwMakeContextCurrent(window);
		
		GLFW.glfwShowWindow(window);
		GL.createCapabilities();
		
		return window;
	}
	
	public static boolean isCloseRequested(long window) {
		return !GLFW.glfwWindowShouldClose(window);
	}
	
	public static void update(long window) {
		GLFW.glfwSwapBuffers(window);
		GLFW.glfwPollEvents();
	}
	
	public static void close(long window) {
		GLFW.glfwDestroyWindow(window);
	}
	
	public static void disposeGLFW() {
		GLFW.glfwTerminate();
	}

}
