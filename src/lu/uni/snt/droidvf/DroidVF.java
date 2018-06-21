/**
 * 
 */
package lu.uni.snt.droidvf;

import soot.G;
import soot.PackManager;
import soot.Transform;

/**
 * @author jun.gao
 *
 */
public class DroidVF {
	private static final String ANDROID_JAR = "/Users/jun.gao/Documents/work/tools/android-platforms";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DroidVF.setup(args[0]);

	}
	
	private static void setup(String input) {
		String[] args = {
				"-process-dir", input,
				"-android-jars", DroidVF.ANDROID_JAR,
				"-ire",
				"-allow-phantom-refs",
				"-src-prec", "apk",
				"-w",
				"-p", "cg", "enabled:false",
				"-p", "jop.cpf", "enabled:true",
				"-output-format", "n"
		};
		G.reset();
		MyAppTransformer myTransformer = new MyAppTransformer();
		PackManager.v().getPack("wjtp").add(new Transform("wjtp.MyAppTransformer", myTransformer));
		soot.Main.main(args);
	}

}
