package ce.engine.test;

import org.lwjgl.glfw.GLFW;

import ce.engine.Camera;
import ce.engine.Window;
import ce.engine.graphics.GameObject;
import ce.engine.graphics.Mesh;
import ce.engine.input.Input;
import ce.engine.input.Key;
import ce.engine.input.State;
import ce.engine.maths.Vector3f;
import ce.engine.shader.Default3DShader;
import ce.engine.texture.Texture;
import ce.engine.texture.TextureLoader;

public class EngineTester {

	public static void main(String[] args) {
		long window = Window.createWindow(800, 600, "[CE] CommunityEngine");
		Camera camera = new Camera(window, 70f, 0.1f, 1000f);
		camera.setPosition(new Vector3f(0, 0, 2));
		Default3DShader shader = new Default3DShader();
		shader.bind();
		shader.loadMatrix(shader.getProjectionMatrix(), camera.getProjectionMatrix());
		shader.unbind();

		Texture defaultTexture = TextureLoader.loadTexture("res/textures/default.png");

		float[] vertices = {
				//
				-0.5f, 0.5f, 0f, //
				-0.5f, -0.5f, 0f, //
				0.5f, -0.5f, 0f, //
				0.5f, 0.5f, 0f //
		};

		float[] texCoords = { 0, 0, //
				0, 1, //
				1, 1, //
				1, 0, //
		};

		int[] indices = {
				//
				0, 1, 2, //
				2, 3, 0//
		};

		Mesh mesh = new Mesh();
		mesh.add(vertices, texCoords, indices);

		GameObject object = new GameObject(new Vector3f(0), new Vector3f(0), new Vector3f(1)) {
			public void update() {

			}
		};
		object.setTextureID(defaultTexture.getID());

		while (Window.isCloseRequested(window)) {
//			int state = GLFW.glfwGetKey(window, GLFW.GLFW_KEY_E);
//			System.out.println(state);
//			if(state == GLFW.GLFW_PRESS) {
//				System.out.println("PRESS");
//			}
//			if(state == GLFW.GLFW_RELEASE) {
//				System.out.println("RELEASE");
//			}
			
			if(Input.getKey(window, Key.KEY_E) == State.PRESS) {
				System.out.println("PRESS");
			}else if(Input.getKey(window, Key.KEY_E) == State.RELEASE) {
				System.out.println("Release");
			}else if(Input.getKey(window, Key.KEY_UNKNOWN) == State.UNKNOWN) {
				System.out.println("UNKNOWN");
			}
			
			shader.bind();
			shader.loadViewMatrix(camera);
			{
				mesh.enable();
				{
					mesh.render(shader, shader.getModelMatrix(), object, camera);
				}
				mesh.disable();
			}
			shader.unbind();
			Window.update(window);
		}

		defaultTexture.dispose();
		mesh.disable();
		mesh.dispose();
		shader.unbind();
		shader.dispose();
		Window.close(window);
		Window.disposeGLFW();
	}

}
