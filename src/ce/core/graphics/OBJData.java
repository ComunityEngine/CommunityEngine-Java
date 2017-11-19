package ce.core.graphics;

public class OBJData {
	
	public final float[] vertices;
	public final float[] texCoords;
	public final float[] normals;
	public final int[] indices;
	
	public OBJData(float[] vertices, float[] texCoords, float[] normals, int[] indices) {
		this.vertices = vertices;
		this.texCoords = texCoords;
		this.normals = normals;
		this.indices = indices;
	}

	public float[] getVertices() {
		return vertices;
	}

	public float[] getTexCoords() {
		return texCoords;
	}

	public float[] getNormals() {
		return normals;
	}

	public int[] getIndices() {
		return indices;
	}
}
