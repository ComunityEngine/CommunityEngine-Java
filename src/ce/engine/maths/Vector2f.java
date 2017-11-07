package ce.engine.maths;

public class Vector2f {
	
	public float x;
	public float y;
	
	public Vector2f()
	{
		this(0, 0);
	}
	
	public Vector2f(float value) {
		this(value, value);
	}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2f(Vector2f vector) {
		this(vector.x, vector.y);
	}
	
	public float length()
	{
		return (float) Math.sqrt((x * x) + (y * y));
	}
	
	public void normalize()
	{
		this.x = x / length();
		this.y = y / length();
	}
	
	public void set(float value) {
		this.x = value;
		this.y = value;
	}
	
	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Vector2f vector) {
		this.x = vector.x;
		this.y = vector.y;
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
}
