/**
 * 
 */
package csc7327.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import csc7327.analysis.DataAnalyzer;

/**
 * @author luongnv89
 *
 */
public class DataAnalyzerTest {
	
	DataAnalyzer tokyoTest;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tokyoTest = new DataAnalyzer("Tokyo", "data/tokyo.txt");
	}

	/**
	 * Test method for {@link csc7327.analysis.DataAnalyzer#getCityName()}.
	 */
	@Test
	public void testGetCityName() {
		assertTrue(tokyoTest.getCityName().equals("Tokyo"));
	}

	/**
	 * Test method for {@link csc7327.analysis.DataAnalyzer#analyzer()}.
	 */
	@Test
	public void testAnalyzer() {
		tokyoTest.analyzer();
	}

}
