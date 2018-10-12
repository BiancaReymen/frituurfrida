package be.vdab.frituurfrida.web;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")

class IndexController {
	@GetMapping
	ModelAndView index() {
		String OpenGesloten;
		String dag = LocalDate.now().getDayOfWeek().name();
		if (dag == "MONDAY" | dag == "THURSDAY") {
			OpenGesloten = "gesloten";
		} else {
			OpenGesloten = "open";
		}
		return new ModelAndView ("index", "OpenGesloten", OpenGesloten);
	}
}
