package ce.core.test;

import ce.core.Camera;
import ce.core.Version;
import ce.core.Window;
import ce.core.graphics.GameObject;
import ce.core.graphics.Mesh;
import ce.core.input.Input;
import ce.core.input.Key;
import ce.core.input.State;
import ce.core.maths.Transform;
import ce.core.maths.Vector3f;
import ce.core.shader.Default3DShader;
import ce.core.texture.Texture;
import ce.core.texture.TextureLoader;

public class EngineTester {

	public static void main(String[] args) {
		System.out.println(Version.getEngineVersion());
		
		long window = Window.createWindow(800, 600, "[CE] CommunityEngine");
		Window.enableDepthBuffer();
		
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

		GameObject object = new GameObject(new Transform(new Vector3f(0), new Vector3f(0), new Vector3f(1))) {
			public void update() {

			}
		};
		object.setTextureID(defaultTexture.getID());

		while (Window.isCloseRequested(window)) {
			if (Input.getKey(window, Key.KEY_ESCAPE) == State.PRESS) {
				break;
			} else if (Input.getKey(window, Key.KEY_E) == State.RELEASE) {
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
