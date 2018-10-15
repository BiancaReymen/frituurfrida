package be.vdab.frituurfrida.web;

import java.util.Arrays;
import java.util.List;
import be.vdab.frituurfrida.valueobjects.Saus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sauzen")

public class SausController {
	private static final String SAUZEN_VIEW = "sauzen";
	private final List<Saus> sauzen = Arrays.asList(
	 	new Saus(1L, "cocktail", Arrays.asList("mayonaise", "ketchup")),
		new Saus(2L, "mayonaise", Arrays.asList("ei", "mosterd", "olie")),
		new Saus(3L, "mosterd", Arrays.asList("mosterzaad")),
		new Saus(4L, "tartare", Arrays.asList("ei", "mosterd", "olie", "bieslook")),
		new Saus(5L, "vinaigrette", Arrays.asList("mosterd", "olie", "honing")));
	
	@GetMapping
	ModelAndView sauzen() {
			return new ModelAndView(SAUZEN_VIEW, "sauzen", sauzen);
		}

}



