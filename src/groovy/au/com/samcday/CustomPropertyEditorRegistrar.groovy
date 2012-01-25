package au.com.samcday

import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry

class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    def grailsApplication

    public CustomPropertyEditorRegistrar() {
    }

    @Override
    void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        grailsApplication.binderClasses.each {
            println "registering custom handler for ${it.type}"
            propertyEditorRegistry.registerCustomEditor(it.type, new CustomPropertyEditor(binderClass: it))
        }
    }
}
