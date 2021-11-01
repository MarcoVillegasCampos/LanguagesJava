package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Language;
import com.codingdojo.mvc.services.LanguageService;


@Controller
public class LanguagesController {
	
	private final LanguageService languageService;
    
    public LanguagesController (LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @RequestMapping("/languages")
    public String index(Model model,@ModelAttribute("form") Language languages) {
        List<Language> languages1 = languageService.allLanguages();
        model.addAttribute("languages", languages1);
        return "/index.jsp";
    }
    
  
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("form") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/languages/{id}")
    public String show(Model model,@PathVariable("id")Long id) {
       Language language = languageService.findLanguage(id);
        
        
        
        model.addAttribute("language", language);
        return "show.jsp";
    }
    
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
       Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    

}