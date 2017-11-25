package ce.core.shader;

import ce.core.Camera;
import ce.core.maths.Matrix4f;

public class Default3DShader extends Shader {
	
	private final static String VERTEX_SHADER = "#version 400\n"
			+ "uniform mat4 projectionMatrix;\n"
			+ "uniform mat4 viewMatrix;\n"
			+ "uniform mat4 modelMatrix;\n"
			+ "\n"
			+ "in vec3 position;\n"
			+ "in vec2 texCoords;\n"
			+ "\n"
			+ "out vec2 pass_texCoords;\n"
			+ "\n"
			+ "void main(){\n"
			+ "vec4 worldPos = modelMatrix * vec4(position, 1.0);\n"
			+ "gl_Position = projectionMatrix * viewMatrix * worldPos;\n"
			+ "pass_texCoords = texCoords;\n"
			+ "}\n";
	
	private final static String FRAGMENT_SHADER = "#version 400\n"
			+ "in vec2 pass_texCoords;\n"
			+ "out vec4 out_color;\n"
			+ "uniform sampler2D texture_image;\n"
			+ "\n"
			+ "void main(){\n"
			+ "vec4 textureColor = texture(texture_image, pass_texCoords);\n"
			+ "out_color = textureColor;\n"
			+ "}\n";
	
	private int viewMatrix, modelMatrix, projectionMatrix;

	public Default3DShader() {
		super(VERTEX_SHADER, FRAGMENT_SHADER);
		
		bindAttribLocation(0, "position");
		linkAndValidate();
		
		modelMatrix = getUniformLocation("modelMatrix");
		projectionMatrix = getUniformLocation("projectionMatrix");
		viewMatrix = getUniformLocation("viewMatrix");
	}
	
	public void loadViewMatrix(Camera camera) {
		Matrix4f matrix = createViewMatrix(camera);
		loadMatrix(viewMatrix, matrix);
	}
	
	public int getViewMatrix() {
		return viewMatrix;
	}

	public int getModelMatrix() {
		return modelMatrix;
	}

	public int getProjectionMatrix() {
		return projectionMatrix;
	}

}
