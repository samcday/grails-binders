package au.com.samcday

import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry

class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    def grailsApplication

    public CustomPropertyEditorRegistrar() {
    }

    @Override
    void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {

    }
}
