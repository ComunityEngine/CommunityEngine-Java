package ce.core.maths;

public class Transform {
	
	public Vector3f position;
	public Vector3f rotation;
	public Vector3f scale;
	
	public Transform() {
		this(0, 0, 1);
	}
	
	/**
	 * create a new Transform and create a new Vector for each argument 
	 * @param position 'sets float argument to - new Vector3f(position, position, position)'
	 * @param rotation 'sets float argument to - new Vector3f(rotation, rotation, rotation)'
	 * @param scale 'sets float argument to - new Vector3f(scale, scale, scale)'
	 */
	public Transform(float position, float rotation, float scale) {
		this(new Vector3f(position), new Vector3f(rotation), new Vector3f(scale));
	}
	
	public Transform(Vector3f position, Vector3f rotation, Vector3f scale) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	public Vector3f getScale() {
		return scale;
	}

	public void setScale(Vector3f scale) {
		this.scale = scale;
	}
}
