package ce.engine.maths;

import java.nio.FloatBuffer;

public class Matrix4f {
	
	public float m00, m01, m02, m03;
	public float m10, m11, m12, m13;
	public float m20, m21, m22, m23;
	public float m30, m31, m32, m33;
	
	public Matrix4f() {
		setIdentity();
	}

	public void setIdentity() {
		m00 = 1f;
		m01 = 0f;
		m02 = 0f;
		m03 = 0f;
		
		m10 = 0f;
		m11 = 1f;
		m12 = 0f;
		m13 = 0f;
		
		m20 = 0f;
		m21 = 0f;
		m22 = 1f;
		m23 = 0f;
		
		m30 = 0f;
		m31 = 0f;
		m32 = 0f;
		m33 = 1f;
	}
	
	public void setZero() {
		m00 = 0f;
		m01 = 0f;
		m02 = 0f;
		m03 = 0f;
		
		m10 = 0f;
		m11 = 0f;
		m12 = 0f;
		m13 = 0f;
		
		m20 = 0f;
		m21 = 0f;
		m22 = 0f;
		m23 = 0f;
		
		m30 = 0f;
		m31 = 0f;
		m32 = 0f;
		m33 = 0f;
	}
	
	public void setOne() {
		m00 = 1f;
		m01 = 1f;
		m02 = 1f;
		m03 = 1f;
		
		m10 = 1f;
		m11 = 1f;
		m12 = 1f;
		m13 = 1f;
		
		m20 = 1f;
		m21 = 1f;
		m22 = 1f;
		m23 = 1f;
		
		m30 = 1f;
		m31 = 1f;
		m32 = 1f;
		m33 = 1f;
	}
	
	public Matrix4f store(FloatBuffer buffer) {
		buffer.put(m00);
		buffer.put(m01);
		buffer.put(m02);
		buffer.put(m03);
		
		buffer.put(m10);
		buffer.put(m11);
		buffer.put(m12);
		buffer.put(m13);
		
		buffer.put(m20);
		buffer.put(m21);
		buffer.put(m22);
		buffer.put(m23);
		
		buffer.put(m30);
		buffer.put(m31);
		buffer.put(m32);
		buffer.put(m33);
		return this;
	}

}
