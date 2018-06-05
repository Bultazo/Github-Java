/**
 * ControllerTest.java
 */
package controller;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Mock.ModelMock;
import model.IModel;
import view.IView;

/**
 * @author DELL
 *
 */
public class ControllerTest {
	private IModel model;
	private IView view;
	
	
	/**
	 * Set Up 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.model = new ModelMock();
	}

	/**
	 * Tear Down
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}

}
