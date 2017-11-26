package ce.core;

import java.nio.DoubleBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;

import ce.core.input.Input;
import ce.core.input.Key;
import ce.core.input.State;
import ce.core.maths.Matrix4f;
import ce.core.maths.Vector2f;
import ce.core.maths.Vector3f;

public class Camera {

	private Window window;

	public float y_height = 0;
	private Vector3f position = new Vector3f(0, y_height, 0);
	private float pitch = 0;
	private float yaw = 0;
	private float roll = 0;
	private float pitch_min = -90;
	private float pitch_max = 90;

	private float FOV;
	private float z_near;
	private float z_far;

	private float sensitivity = 0.07f;
	private boolean mouseGrabbed = false;
	private Vector2f previousPos = new Vector2f(-1, -1);
	private Vector2f curPos = new Vector2f(0, 0);

	private Matrix4f projectionMatrix;

	public Camera(Window window, float fov, float z_near, float z_far) {
		this.window = window;
		this.FOV = fov;
		this.z_near = z_near;
		this.z_far = z_far;

		createProjectionMatrix(window.getWidth(), window.getHeight());
	}

	protected void createProjectionMatrix(int width, int height) {
		// width / height
		float aspectRatio = (float) width / height;
		float y_scale = 1f / (float) Math.tan(Math.toRadians(FOV / 2f)) * aspectRatio;
		float x_scale = y_scale / aspectRatio;
		float frustum_length = z_far - z_near;

		projectionMatrix = new Matrix4f();
		projectionMatrix.m00 = x_scale;
		projectionMatrix.m11 = y_scale;
		projectionMatrix.m22 = -((z_far + z_near) / frustum_length);
		projectionMatrix.m23 = -1;
		projectionMatrix.m32 = -((2 * z_near * z_far) / frustum_length);
		projectionMatrix.m33 = 0;
	}
	
	public void update() {
		float speed = 0.01f;
		float x = 0;
		float z = 0;
//		float y = 0;
		

		if (Input.isMouseClicked(Key.MOUSE_BUTTON_LEFT)) {
			if(!mouseGrabbed)
			{
				grabCursor();
			}else{
				releaseCursor();
			}
		}
		curPos = getCursorPos();
		if (mouseGrabbed) {
			double dx = curPos.x - previousPos.x;
			double dy = curPos.y - previousPos.y;
			yaw += dx * sensitivity;
			pitch += dy * sensitivity;
		}
		previousPos.x = curPos.x;
		previousPos.y = curPos.y;
		
		if (getPitch() > pitch_max) {
			setPitch(pitch_max);
		} else if (getPitch() < pitch_min) {
			setPitch(pitch_min);
		}
		if(yaw > 360)
		{
			yaw = 0;
		}else if(yaw < 0){
			yaw = 360;
		}
	}

	private Vector2f getCursorPos() {
		DoubleBuffer xpos = BufferUtils.createDoubleBuffer(1);
		DoubleBuffer ypos = BufferUtils.createDoubleBuffer(1);
		xpos.rewind();
		xpos.rewind();
		GLFW.glfwGetCursorPos(window.windowID, xpos, ypos);

		double x = xpos.get();
		double y = ypos.get();

		xpos.clear();
		ypos.clear();
		Vector2f result = new Vector2f((float) x, (float) y);
		return result;
	}

	private void grabCursor() {
		mouseGrabbed = true;
		GLFW.glfwSetInputMode(window.windowID, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_DISABLED);
	}

	private void releaseCursor() {
		mouseGrabbed = false;
		GLFW.glfwSetInputMode(window.windowID, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_NORMAL);
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	public float getRoll() {
		return roll;
	}

	public void setRoll(float roll) {
		this.roll = roll;
	}

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Matrix4f getProjectionMatrix() {
		return projectionMatrix;
	}

}
