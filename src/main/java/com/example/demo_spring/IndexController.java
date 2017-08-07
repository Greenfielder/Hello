package com.example.demo_spring;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@GetMapping("/")
    public ModelAndView index() {
        Map<String, String> model = new HashMap<String, String>();
        model.put("name", "Dmtry");
        model.put("name1", "The Rock");
        
        Visit visit = new Visit();
        visit.description = String.format("Visited at %s", LocalDateTime.now());
        visitsRepository.save(visit);
        
        return new ModelAndView("index", model);
    }
	
	final VisitsRepository visitsRepository;

    public IndexController(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }
    
}
