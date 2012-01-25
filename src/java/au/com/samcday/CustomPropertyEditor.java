package au.com.samcday;

import java.beans.PropertyEditorSupport;

public class CustomPropertyEditor extends PropertyEditorSupport {
    DefaultGrailsBinderClass binderClass;

    @Override
    public String getAsText() {
        return this.binderClass.asText(this.getValue());
    }

    @Override
    public void setAsText(String text) {
        this.setValue(this.binderClass.bind(text));
    }
}