package org.eclipse.ice.viz.service.paraview.test;

import static org.junit.Assert.fail;

import org.eclipse.ice.viz.service.paraview.ParaViewPlot;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This class is responsible for testing the {@link ParaViewPlot}.
 * 
 * @author Jordan Deyton
 *
 */
@Ignore
public class ParaViewPlotTester {

	// TODO Implement these tests.

	/**
	 * This method checks the plot types returned by the plot.
	 * 
	 * @see ParaViewPlot#getPlotTypes()
	 */
	@Test
	public void checkPlotTypes() {
		fail("Not implemented.");
	}

	/**
	 * This method checks that the plot can be drawn correctly.
	 * 
	 * @see ParaViewPlot#draw(String, String, org.eclipse.swt.widgets.Composite)
	 */
	@Test
	public void checkDraw() {
		fail("Not implemented.");
	}

	/**
	 * This test checks the number of axes for the plot.
	 * 
	 * @see ParaViewPlot#getNumberOfAxes()
	 */
	@Test
	public void checkNumberOfAxes() {
		fail("Not implemented.");
	}

	/**
	 * This test checks methods related to the plot's properties.
	 * 
	 * @see ParaViewPlot#getProperties()
	 * @see ParaViewPlot#setProperties(java.util.Map)
	 */
	@Test
	public void checkProperties() {
		fail("Not implemented.");
	}

	/**
	 * This test checks methods related to the plot's source information.
	 * 
	 * @see ParaViewPlot#getDataSource()
	 * @see ParaViewPlot#getSourceHost()
	 * @see ParaViewPlot#isSourceRemote()
	 */
	@Test
	public void checkSource() {
		fail("Not implemented.");
	}
}
