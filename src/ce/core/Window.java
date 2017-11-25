package ce.core;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class Window {
	
	public long windowID;
	
	private Window(long id){
		this.windowID = id;
	}
	
	public static Window createWindow(int width, int height, String title) {
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
		
		return new Window(window);
	}
	
	public void enableDepthBuffer() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}

	public void disableDepthBuffer() {
		GL11.glDisable(GL11.GL_DEPTH_TEST);
	}
	
	public boolean isCloseRequested() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		return !GLFW.glfwWindowShouldClose(windowID);
	}
	
	public void update() {
		GLFW.glfwSwapBuffers(windowID);
		GLFW.glfwPollEvents();
	}
	
	public void close() {
		GLFW.glfwDestroyWindow(windowID);
	}
	
	public int getWidth()
	{
		IntBuffer width = BufferUtils.createIntBuffer(1);
		IntBuffer height = BufferUtils.createIntBuffer(1);
		GLFW.glfwGetWindowSize(windowID, width, height);
		return width.get();
	}
	
	public int getHeight() {
		IntBuffer width = BufferUtils.createIntBuffer(1);
		IntBuffer height = BufferUtils.createIntBuffer(1);
		GLFW.glfwGetWindowSize(windowID, width, height);

		return height.get();
	}
	
	public void disposeGLFW() {
		GLFW.glfwTerminate();
	}

}
