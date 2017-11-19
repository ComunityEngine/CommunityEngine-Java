package ce.core;

import ce.core.maths.Matrix4f;
import ce.core.maths.Vector2f;
import ce.core.maths.Vector3f;

public class Camera {
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
	
	public Camera(long window, float fov, float z_near, float z_far) {
		this.FOV = fov;
		this.z_near = z_near;
		this.z_far = z_far;

		createProjectionMatrix(Window.getWidth(window), Window.getHeight(window));
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
