package au.com.samcday

import org.codehaus.groovy.grails.commons.ArtefactHandlerAdapter

class BinderArtefactHandler extends ArtefactHandlerAdapter {
    public static final String TYPE = "Binder"

    public BinderArtefactHandler() {
        super(TYPE, GrailsBinderClass, DefaultGrailsBinderClass, null)
        println "new artefact handler."
    }

    public boolean isArtefactClass(Class clazz) {
        return clazz != null && clazz.name.endsWith(TYPE)
    }
}
