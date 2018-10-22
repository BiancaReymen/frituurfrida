package be.vdab.frituurfrida.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import be.vdab.frituurfrida.services.SausService;

@RunWith(MockitoJUnitRunner.class)
public class SausControllerTest {

	@Mock
	private SausService sausService;
	private SausController controller;
	
	@Before
	public void before() {
		controller = new SausController(sausService);
	}
	@Test
	public void sauzenWerktSamenMetDeJspSaus() {
		assertEquals("sauzen", controller.sauzen().getViewName());
	}
	@Test
	public void sauzenGeeftSauzenDoor() {
		assertTrue(controller.sauzen().getModel().get("sauzen") instanceof List);
	}
	@Test
	public void sauzenGeeftJuisteDataAanJSP() {
		assertTrue(controller.sauzen().getModel().containsKey("sauzen"));
		verify(sausService).findAll();
	}

}
