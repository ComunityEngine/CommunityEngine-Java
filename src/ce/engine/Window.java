package ce.engine;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
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
		GLFW.glfwSwapInterval(1);
		
		return window;
	}
	
	public static boolean isCloseRequested(long window) {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		return !GLFW.glfwWindowShouldClose(window);
	}
	
	public static void update(long window) {
		GLFW.glfwSwapBuffers(window);
		GLFW.glfwPollEvents();
	}
	
	public static void close(long window) {
		GLFW.glfwDestroyWindow(window);
	}
	
	public static int getWidth(long window)
	{
		IntBuffer width = BufferUtils.createIntBuffer(1);
		IntBuffer height = BufferUtils.createIntBuffer(1);
		GLFW.glfwGetWindowSize(window, width, height);
		return width.get();
	}
	
	public static int getHeight(long window) {
		IntBuffer width = BufferUtils.createIntBuffer(1);
		IntBuffer height = BufferUtils.createIntBuffer(1);
		GLFW.glfwGetWindowSize(window, width, height);

		return height.get();
	}
	
	public static void disposeGLFW() {
		GLFW.glfwTerminate();
	}

}
