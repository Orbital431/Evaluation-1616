package evaluation.forms;

import java.awt.BorderLayout;
import java.io.File;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import evaluation.database.EvaluationDatabase;

@SuppressWarnings("serial")
public class EvaluationExplorer extends JFrame {

	private EvaluationDatabase _currentCollection;
	
	private static String _driver = "org.sqlite.JDBC";
	private static String _url = "jdbc:sqlite:src/evaluation/database/storage/";
	private static String user, pass;
	
	public EvaluationExplorer()
	{
		user = "orbital431";
		pass = "arrigato";
		
		String db_file = "test123.db";
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
		setTitle("Evaluation 1616");
		buildMenu();
		buildFrames();
		
		_currentCollection = new EvaluationDatabase(_driver, _url + db_file, user, pass);
		
		ResultSet r = _currentCollection.getTables();
		while (r.next())
		{
			
		}
		
		setVisible(true);
	}
    
	/**
	 * Build menu items for Explorer frame
	 * 		Menu bar: basic menu bar w/ items
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
	 * Builds viewing panes for Explorer frame.
	 * 	 Split frame: TOP explorer window  BOTTOM evaluation listing
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
