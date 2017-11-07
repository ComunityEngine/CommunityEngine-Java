package ce.engine.maths;

public class Vector3f {
	
	public float x;
	public float y;
	public float z;
	
	public Vector3f()
	{
		this(0, 0, 0);
	}
	
	public Vector3f(float value) {
		this(value, value, value);
	}
	
	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3f(Vector3f vector) {
		this(vector.x, vector.y, vector.z);
	}
	
	public float length()
	{
		return (float) Math.sqrt((x * x) + (y * y) + (z * z));
	}
	
	public void normalize()
	{
		this.x = x / length();
		this.y = y / length();
		this.z = z / length();
	}
	
	public void set(float value) {
		this.x = value;
		this.y = value;
		this.z = value;
	}
	
	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void set(Vector3f vector) {
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
}
