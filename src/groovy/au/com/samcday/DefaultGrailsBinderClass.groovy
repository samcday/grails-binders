package au.com.samcday

import org.codehaus.groovy.grails.commons.AbstractInjectableGrailsClass

class DefaultGrailsBinderClass extends AbstractInjectableGrailsClass implements GrailsBinderClass {

    public DefaultGrailsBinderClass(Class clazz) {
        super(clazz, BinderArtefactHandler.TYPE)

        println "created binder class"
    }
}
