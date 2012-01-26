package au.com.samcday;

import groovy.lang.Closure;
import org.codehaus.groovy.grails.commons.AbstractInjectableGrailsClass;

class DefaultGrailsBinderClass extends AbstractInjectableGrailsClass implements GrailsBinderClass {
    static String TYPE_PROPERTY = "type";

    static String BIND_CLOSURE = "bind";
    static String AS_TEXT_CLOSURE = "asText";

    public DefaultGrailsBinderClass(Class clazz) {
        super(clazz, BinderArtefactHandler.TYPE);
    }

    @Override
    public Class getType() {
        Object obj = getPropertyValue(TYPE_PROPERTY);
        if(obj == null || !(obj instanceof Class)) return null;

        return (Class)obj;
    }

    @Override
    public Object bind(String text) {
        return getMetaClass().invokeMethod(getReferenceInstance(), BIND_CLOSURE, new Object[] {text});
    }

    @Override
    public String asText(Object val) {
        Closure c = (Closure)getPropertyOrStaticPropertyOrFieldValue(AS_TEXT_CLOSURE, Closure.class);
        if(c != null) {
            Object result = c.call(val);

            if(result != null) {
                return result.toString();
            }
        }

        // Fallback is to just call .toString() on the value, or null if value is null.
        return val != null ? val.toString() : null;
    }
}
