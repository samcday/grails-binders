package au.com.samcday

import org.codehaus.groovy.grails.commons.InjectableGrailsClass

public interface GrailsBinderClass extends InjectableGrailsClass {
    public Class getType()
    public Object doBind(String text)
    public String asText(Object val)
}
