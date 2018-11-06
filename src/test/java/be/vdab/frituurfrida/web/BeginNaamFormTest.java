package be.vdab.frituurfrida.web;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

public class BeginNaamFormTest {
	private Validator validator;
	
	@Before
	public void before() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void beginNaamOK() {
		assertTrue(validator.validateValue(BeginNaamForm.class,  "beginnaam", "d").isEmpty());
		
	}
	@Test
	public void beginNaamMoetVerschillenVanNull() {
		assertFalse(validator.validateValue(BeginNaamForm.class,  "beginnaam", null).isEmpty());
		
	}
	@Test
	public void vanMoetMinstensEenTekenBevatten() {
		assertFalse(validator.validateValue(BeginNaamForm.class,  "beginnaam", "").isEmpty());
		
	}
	

}
