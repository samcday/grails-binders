import org.codehaus.groovy.grails.compiler.injection.test.TestForTransformation

eventTestCompileStart = {
    try {
        Class mixinClass = classLoader.loadClass("au.com.samcday.grails.plugins.binders.BinderUnitTestMixin")
        TestForTransformation.artefactTypeToTestMap.put("Binder", mixinClass)
    }
    catch(Throwable e) {
        e.printStackTrace()
    }
}
