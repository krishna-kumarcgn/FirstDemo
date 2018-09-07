package com.test.app.custom.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class IsbnEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            setValue(new IsbnModel(text.trim()));
        } else {
            setValue(null);
        }
    }
 
    @Override
    public String getAsText() {
    	IsbnModel isbn = (IsbnModel) getValue();
        if (isbn != null) {
            return isbn.getIsbn();
        } else {
            return "";
        }
    }
}