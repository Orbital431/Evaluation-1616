package evaluation.forms;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class EvaluationExplorer extends JFrame {

	File _currentCollection;
	File _targetSave;
	
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
		JMenu _menu;
		JMenuItem _item;
		JMenuBar _menubar = new JMenuBar();
		
		_menu = new JMenu("File");
			_menubar.add(_menu);
			_item = new JMenuItem("New Collection");
				_menu.add(_item);
			_item = new JMenuItem("Open Collection");
				_menu.add(_item);
		_menu.addSeparator();
			_item = new JMenuItem("Save Collection");
				_menu.add(_item);
			_item = new JMenuItem("Save Collection As...");
				_menu.add(_item);
		_menu.addSeparator();
			_item = new JMenuItem("Close");
			_menu.add(_item);
			
		_menu = new JMenu("About");
			_menubar.add(_menu);
			_item = new JMenuItem("About Evaluation 1616");
				_menu.add(_item);
			
		setJMenuBar(_menubar);
	}
	/**
	 * Builds viewing panes for Explorer frame
	 */
	private void buildFrames()
	{
		double proportionalLoc = 0.33;

			
		JPanel _upperPanel = new JPanel();
		JTextArea _textarea = new JTextArea("Upper panel");
		_upperPanel.add(_textarea);
		
		JPanel _lowerPanel = new JPanel();
		_textarea = new JTextArea("Lower panel");
		_lowerPanel.add(_textarea);
		
		
		JSplitPane _pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, _upperPanel, _lowerPanel);
		//_pane.setOneTouchExpandable(true);
		_pane.setResizeWeight(proportionalLoc);
		//_pane.setDividerLocation(proportionalLoc);
		
		add(_pane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setVisible(true);
		//pack();
	}
}
