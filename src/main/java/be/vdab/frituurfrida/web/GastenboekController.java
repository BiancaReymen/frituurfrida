package be.vdab.frituurfrida.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.entities.GastenboekEntry;
import be.vdab.frituurfrida.services.GastenboekService;

@Controller
@RequestMapping("gastenboek")
public class GastenboekController {
	private final GastenboekService gastenboekService;
	
	GastenboekController (GastenboekService gastenboekService) {
		this.gastenboekService = gastenboekService;
	}
	private static final String VIEW = "gastenboek";
	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView (VIEW, "gastenboek", gastenboekService.findAll());
	}
	@GetMapping("toevoegen")
	ModelAndView findAllMetToevoegenOnderdeel() {
		return new ModelAndView (VIEW, "gastenboek", gastenboekService.findAll())
				.addObject(new GastenboekEntry());
	}
	private static final String REDIRECT_NA_CREATE = "redirect:/gastenboek";
	@PostMapping
	ModelAndView create(@Valid GastenboekEntry entry, BindingResult bindingResult) {
		System.out.print("in postmapping" + bindingResult.getAllErrors());
		if (bindingResult.hasErrors()) {
			return new ModelAndView (VIEW, "gastenboek", gastenboekService.findAll());
		}
		gastenboekService.create(entry);
		return new ModelAndView(REDIRECT_NA_CREATE);
	
	}
	private static final String REDIRECT_NA_DELETE = "redirect:/gastenboek";
	@PostMapping(path="verwijderen", params = "verwijderid")
	String delete(long[] verwijderid) {
		System.out.print("in postmapping verwijderd");
		if (verwijderid != null) {
			gastenboekService.delete(verwijderid);
		}
		return REDIRECT_NA_DELETE;
	}
}
