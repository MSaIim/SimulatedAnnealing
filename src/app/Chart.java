package app;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

import algo.Results;

@SuppressWarnings("serial")
public class Chart extends ApplicationFrame
{
	private ArrayList<Results> resultList;
	
	public Chart(String title, ArrayList<Results> resultList)
	{
		super(title);
		this.resultList = resultList;
	}
	
	// Create the chart with the dataset
	private void createChart(String title, String[] labels, CategoryDataset dataset)
	{
		// Set window title
		setTitle(title);
		
		JFreeChart barChart = ChartFactory.createLineChart(title, labels[0], labels[1], dataset, PlotOrientation.VERTICAL, true, true, false);
		barChart.setPadding(new RectangleInsets(20f, 20f, 20f, 20f));
		
		ChartPanel chartPanel = new ChartPanel(barChart);        
	    chartPanel.setPreferredSize(new java.awt.Dimension(840, 600));
	    
	    setContentPane(chartPanel);
	    
	    pack();
	    RefineryUtilities.centerFrameOnScreen(this);
	    setResizable(false);
	    setVisible(true);
	}
	
	public void createStepCostChart(String title)
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for(int i = 0; i < this.resultList.size(); i++)
		{
			for(int j = 0; j < this.resultList.get(i).getStepCost().size(); j++)
			{
				// Get the step cost and time
				double cost = this.resultList.get(i).getStepCost().get(j);
				double time = this.resultList.get(0).getStepTemp().get(j);
				
				dataset.addValue(cost, ("C25_" + (i+1)), Double.toString(time));
			}
		}
		
		// Create chart
		this.createChart(title, new String[] {"Elapsed Time", "Distance"}, dataset);
	}
}
