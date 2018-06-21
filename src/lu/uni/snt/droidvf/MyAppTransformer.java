/**
 * 
 */
package lu.uni.snt.droidvf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import soot.Scene;
import soot.SceneTransformer;
import soot.SootClass;
import soot.SootMethod;
import soot.util.Chain;

/**
 * @author jun.gao
 *
 */
public class MyAppTransformer extends SceneTransformer{

	@Override
	protected void internalTransform(String arg0, Map<String, String> arg1) {
		Chain<SootClass> classes = Scene.v().getApplicationClasses();
		System.out.println(classes);
		for(Iterator<SootClass> iter = classes.snapshotIterator(); iter.hasNext();){
			SootClass cls = iter.next();
			String clsName = cls.getName();
			System.out.println(clsName);
			
			List<SootMethod> methods = cls.getMethods();
			for(int i=0; i < methods.size(); i++){
				SootMethod m = methods.get(i);
				String sig = m.getDeclaration();
				System.out.println(sig);
			}
		}
	}

}
