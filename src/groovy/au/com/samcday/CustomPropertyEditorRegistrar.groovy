package au.com.samcday

import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry

class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    def grailsApplication

    @Override
    void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        grailsApplication.binderClasses.each {
            Class type = it.type

            if(type != null) {
                propertyEditorRegistry.registerCustomEditor(it.type, new CustomPropertyEditor(binderClass: it))
            }
        }
    }
}
