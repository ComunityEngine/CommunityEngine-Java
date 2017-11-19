package ce.core;

public class Version {
	
	
	private static final int ENGINE_MAJOR = 0;
	private static final int ENGINE_MINOR = 0;
	/**
	 * This number will increase after every build change regardless, even if the 'ENGINE_MINOR' and/or 'ENGINE_MAJOR' Changes!
	 */
	private static final int ENGINE_BUILD = 2;
	private static final String ENGINE_VERSION = "CommunityEngine Version: [" + ENGINE_MAJOR + "." + ENGINE_MINOR + "." + ENGINE_BUILD + "]";
	
	public static String getEngineVersion()
	{
		return ENGINE_VERSION;
	}
}
