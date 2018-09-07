package com.test.app.controller;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.app.custom.editor.IsbnEditor;
import com.test.app.custom.editor.IsbnModel;

@Controller
public class HomeEditorController {

	private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	 
    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET)
    public String getBook(@PathVariable IsbnModel isbn, Map<String, Object> model)
    {
        LOGGER.info("You searched for book with ISBN :: " + isbn.getIsbn());
        model.put("isbn", isbn);
        return "index";
    }
     
    @InitBinder
    public void initBinder(WebDataBinder binder) {
      binder.registerCustomEditor(IsbnModel.class, new IsbnEditor());
    }
}
