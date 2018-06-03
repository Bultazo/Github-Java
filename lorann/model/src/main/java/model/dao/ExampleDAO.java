package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Example;

/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class ExampleDAO extends AbstractDAO {

	/** The sql example by id. */
	private static String sqlExampleById = "{call GetElementById(?)}";

	/** The sql example by name. */
	private static String sqlExampleByName = "{call GetElementByName(?)}";

	/** The sql all examples. */
	private static String sqlAllExamples = "{call GetAllExamples()}";

	/** The id column index. */
	private static int idColumnIndex = 1;

	/** The name column index. */
	private static int nameColumnIndex = 2;

	/**
	 * Gets the example by id.
	 *
	 * @param id
	 *            the id
	 * @return the example by id
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static ResultSet getElementById(final int id) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlExampleById);
		callStatement.setInt(1, id);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			return result;
		}
		return null;
	}

	/**
	 * Gets the example by name.
	 *
	 * @param name
	 *            the name
	 * @return the example by name
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static ResultSet getElementByName(final String name) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlExampleByName);
		callStatement.setString(1, name);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			return result;
		}
		return null;
	}

	/**
	 * Gets the all examples.
	 *
	 * @return the all examples
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static ResultSet getAllElements() throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlAllExamples);
		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			result.close();
			
		}
		return null;
	}
}
