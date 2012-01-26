package au.com.samcday.grails.plugins.binders;

import org.codehaus.groovy.grails.commons.InjectableGrailsClass;

public interface GrailsBinderClass extends InjectableGrailsClass {
    public Class getType();
    public Object bind(String text);
    public String asText(Object val);
}