package au.com.samcday

import org.codehaus.groovy.grails.commons.AbstractInjectableGrailsClass

class DefaultGrailsBinderClass extends AbstractInjectableGrailsClass implements GrailsBinderClass {
    static TYPE_PROPERTY = "type"

    static BIND_CLOSURE = "bind"
    static AS_TEXT_CLOSURE = "bind"

    public DefaultGrailsBinderClass(Class clazz) {
        super(clazz, BinderArtefactHandler.TYPE)

        println "created binder class ${clazz}"
    }

    @Override
    Class getType() {
        Object obj = getPropertyValue(TYPE_PROPERTY)
        if(obj == null || !(obj instanceof Class)) return null

        return (Class)obj
    }

    @Override
    Object doBind(String text) {
        println "gogo bind!"
        return metaClass.invokeMethod(referenceInstance, BIND_CLOSURE, [text] as Object[])
    }

    @Override
    String asText(Object val) {
        if(metaClass.respondsTo(referenceInstance, AS_TEXT_CLOSURE)) {
            return metaClass.invokeMethod(referenceInstance, AS_TEXT_CLOSURE, [val] as Object[])
        }
        
        return val.toString()
    }
}
