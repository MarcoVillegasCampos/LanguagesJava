package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Language;
import com.codingdojo.mvc.repositories.LanguageRepository;


@Service
public class LanguageService {
	 // adding the book repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the books
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a book
    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    // retrieves a book
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    // deletes a book
    
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    	}
    
    	
    	
   
    
    //updates a book 
    

   
   public Language updateLanguage(Language language) {
		 Language updatedLanguage=new Language();
		 
		 
		 updatedLanguage.setId(language.getId());
		 updatedLanguage.setName(language.getName());
		 updatedLanguage.setCreator(language.getCreator());
		 updatedLanguage.setVersion(language.getVersion());
		
		 
		 
		 
		languageRepository.save(language);
		 
		 return language;
		 
	   }

}
