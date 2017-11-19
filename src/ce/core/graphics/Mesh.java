package ce.core.graphics;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import ce.core.Camera;
import ce.core.Util;
import ce.core.maths.Matrix4f;
import ce.core.maths.Transform;
import ce.core.maths.Vector3f;
import ce.core.shader.Shader;

public class Mesh {

	private int vao;
	private int vbo;
	private int vboTexture;
	private int vboi;

	private int indicesSize;

	public Mesh() {
		vao = GL30.glGenVertexArrays();
		vbo = GL15.glGenBuffers();
		vboTexture = GL15.glGenBuffers();
		vboi = GL15.glGenBuffers();
	}

	public void add(float[] vertices, float[] texCoords, int[] indices) {
		indicesSize = indices.length;

		GL30.glBindVertexArray(vao);

		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, Util.flip(vertices), GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboTexture);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, Util.flip(texCoords), GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(1, 2, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

		GL30.glBindVertexArray(0);

		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboi);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, Util.flip(indices), GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
	}

	public void enable() {
		GL30.glBindVertexArray(vao);
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboi);
	}

	public void render(Shader shader, int modelMatrix, GameObject object, Camera camera) {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, object.getTextureID());
		Matrix4f transformationMatrix = createTransformationMatrix(object.getTransform());
		shader.loadMatrix(modelMatrix, transformationMatrix);
		object.update();
		GL11.glDrawElements(GL11.GL_TRIANGLES, indicesSize, GL11.GL_UNSIGNED_INT, 0);
	}

	private Matrix4f createTransformationMatrix(Transform transform) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(transform.position, matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(transform.rotation.x), new Vector3f(1, 0, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(transform.rotation.y), new Vector3f(0, 1, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(transform.rotation.z), new Vector3f(0, 0, 1), matrix, matrix);
		Matrix4f.scale(new Vector3f(transform.scale.x, transform.scale.y, transform.scale.z), matrix, matrix);
		return matrix;
	}

	public void disable() {
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL30.glBindVertexArray(0);
	}

	public void dispose() {
		GL30.glBindVertexArray(0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL15.glDeleteBuffers(vbo);
		GL15.glDeleteBuffers(vboTexture);
		GL15.glDeleteBuffers(vboi);
		GL30.glDeleteVertexArrays(vao);
	}

}
