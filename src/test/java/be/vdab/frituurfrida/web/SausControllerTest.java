package be.vdab.frituurfrida.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class SausControllerTest {

	private SausController controller;
	@Before
	public void before() {
		controller = new SausController();
	}
	@Test
	public void sauzenWerktSamenMetDeJspSaus() {
		assertEquals("sauzen", controller.sauzen().getViewName());
	}
	@Test
	public void sauzenGeeftSauzenDoor() {
		assertTrue(controller.sauzen().getModel().get("sauzen") instanceof List);
	}

}
