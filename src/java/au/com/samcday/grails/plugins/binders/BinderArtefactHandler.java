package au.com.samcday.grails.plugins.binders;

import org.codehaus.groovy.grails.commons.ArtefactHandlerAdapter;

public class BinderArtefactHandler extends ArtefactHandlerAdapter {
    public static final String TYPE = "Binder";

    public BinderArtefactHandler() {
        super(TYPE, GrailsBinderClass.class, DefaultGrailsBinderClass.class, null);
    }

    public boolean isArtefactClass(Class clazz) {
        return clazz != null && clazz.getName().endsWith(TYPE);
    }
}
