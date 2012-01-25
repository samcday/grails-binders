package au.com.samcday

import java.beans.PropertyEditorSupport

class CustomPropertyEditor extends PropertyEditorSupport {
    DefaultGrailsBinderClass binderClass

    @Override
    String getAsText() {
        this.binderClass.asText(this.value)
    }

    @Override
    void setAsText(String text) {
        this.binderClass.doBind(text)
        //this.value = this.binderClass.doBind(text)
    }
}
