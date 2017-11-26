package ce.core;

import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorEnterCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWWindowPosCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

import ce.core.input.Input;
import ce.core.maths.Vector2f;

public class Window {
	
	public long windowID;
	
	private final GLFWWindowPosCallback posCallback;
	private final Vector2f windowPos = new Vector2f();
	
	private final GLFWWindowSizeCallback sizeCallback;
	private final Vector2f windowSize = new Vector2f();
	
	private final GLFWCursorEnterCallback cursorEnterCallback;
	private boolean cursorEnter = false;
	
	private final GLFWCursorPosCallback cursorPosCallback;
	private final Vector2f cursorPos = new Vector2f();
	
	private final GLFWMouseButtonCallback mouseButtonCallback;
	
	private final GLFWKeyCallback keyCallback;
	
	private Window(long id){
		this.windowID = id;
		posCallback = new GLFWWindowPosCallback() {
			public void invoke(long window, int xpos, int ypos) {
				windowPos.set(xpos, ypos);
			}
		};
		GLFW.glfwSetWindowPosCallback(windowID, posCallback);
		
		sizeCallback = new GLFWWindowSizeCallback() {
			public void invoke(long window, int width, int height) {
				windowSize.set(width, height);
			}
		};
		GLFW.glfwSetWindowSizeCallback(windowID, sizeCallback);
		
		cursorEnterCallback = new GLFWCursorEnterCallback() {
			public void invoke(long window, boolean entered) {
				cursorEnter = entered;
			}
		};
		GLFW.glfwSetCursorEnterCallback(windowID, cursorEnterCallback);
		
		cursorPosCallback = new GLFWCursorPosCallback() {
			public void invoke(long window, double xpos, double ypos) {
				cursorPos.set((float)xpos, (float)ypos);
			}
		};
		GLFW.glfwSetCursorPosCallback(windowID, cursorPosCallback);
		
		mouseButtonCallback = new GLFWMouseButtonCallback() {
			public void invoke(long window, int button, int action, int mods) {
				Input.setKey(button, -1, action, mods);
			}
		};
		GLFW.glfwSetMouseButtonCallback(windowID, mouseButtonCallback);
		
		keyCallback = new GLFWKeyCallback() {
			public void invoke(long window, int key, int scancode, int action, int mods) {
				Input.setKey(key, scancode, action, mods);
			}
		};
		GLFW.glfwSetKeyCallback(windowID, keyCallback);
		
		IntBuffer width = BufferUtils.createIntBuffer(1);
		IntBuffer height = BufferUtils.createIntBuffer(1);
		GLFW.glfwGetWindowSize(windowID, width, height);
		windowSize.set(width.get(), height.get());
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
	
	/**
	 * Checks if the window has been set to close
	 * @return
	 */
	public boolean isCloseRequested() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		return !GLFW.glfwWindowShouldClose(windowID);
	}
	
	public void update() {
		Input.clearFrame();
		GLFW.glfwSwapBuffers(windowID);
		GLFW.glfwPollEvents();
	}
	
	public void close() {
		GLFW.glfwDestroyWindow(windowID);
	}
	
	/**
	 * checks if the cursor is on top and within bounds of the window
	 * @return
	 */
	public boolean getCursorOnWindow()
	{
		return cursorEnter;
	}
	
	public int getXpos()
	{
		return (int)Math.floor(windowPos.x);
	}
	
	public int getYpos()
	{
		return (int)Math.floor(windowPos.y);
	}
	
	public float getMouseX()
	{
		return cursorPos.x;
	}
	
	public float getMouseY() {
		return cursorPos.y;
	}
	
	/**
	 * returns the position of the mouse on the Window
	 * @return
	 */
	public Vector2f getMousePos()
	{
		return cursorPos;
	}
	
	/**
	 * returns the location of the Window on your screen
	 * @return
	 */
	public Vector2f getPos() {
		return windowPos;
	}
	
	public int getWidth()
	{
		return (int) Math.floor(windowSize.x);
	}
	
	public int getHeight() {
		return (int) Math.floor(windowSize.y);
	}
	
	/**
	 * returns the size of the Window
	 * @return
	 */
	public Vector2f getSize()
	{
		return windowSize;
	}
	
	public void disposeGLFW() {
		Callbacks.glfwFreeCallbacks(windowID);
		GLFW.glfwTerminate();
	}

}
