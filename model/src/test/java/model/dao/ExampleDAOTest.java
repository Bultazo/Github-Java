/**
 * ExampleDAOTest.java
 */
package model.dao;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author DELL
 *
 */
public class ExampleDAOTest {
	
	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void whenGettingElementsByAStrangeID() throws SQLException {
		int id = -1;
		ResultSet rset = ExampleDAO.getElementById(id);
		assertEquals(false, rset.first());
	}
	@Test
	public void whenGettingElementsByAStrangeName() throws SQLException {
		String Name = "Qué?";
		ResultSet rset = ExampleDAO.getElementByName(Name);
		assertEquals(false, rset.first());
	}

}
