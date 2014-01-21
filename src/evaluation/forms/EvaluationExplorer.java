package evaluation.forms;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class EvaluationExplorer extends JFrame {

	public EvaluationExplorer()
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
		setTitle("Evaluation 1616");
		buildMenu();
		buildFrames();
		setVisible(true);
	}
    
	/**
	 * Build menu items for Explorer frame
	 */
	private void buildMenu()
	{
		
	}
	/**
	 * Builds viewing panes for Explorer frame
	 */
	private void buildFrames()
	{
		
	}
	
}
