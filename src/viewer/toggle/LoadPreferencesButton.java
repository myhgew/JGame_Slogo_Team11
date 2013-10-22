package viewer.toggle;

import controller.Controller;
import controller.TurtleCommand;

public class LoadPreferencesButton extends SelectableListButton {

	private static final String BUTTON_TITLE = "Load Preferences";
	private static final String DIALOG_MESSAGE = "Please select preferences to load.";
<<<<<<< HEAD
	private static final String[] PREFERENCES = {"1", "2", "3"};
=======
	protected static String[] PREFERENCES = {};
>>>>>>> 9bb52308dd1d1f0b6745ac7f530473cc36cf303a
	//protected TurtleCommand turtleCmd;
	
//	public LoadPreferencesButton(Controller controller, TurtleCommand turtleCmd) {
//		super(PREFERENCES, PREFERENCES, COMMAND, BUTTON_TITLE, DIALOG_MESSAGE, controller);
//		this.turtleCmd = turtleCmd;
//	}
	public LoadPreferencesButton(Controller controller) {
		super(PREFERENCES, PREFERENCES, BUTTON_TITLE, DIALOG_MESSAGE, controller);
	}
	
<<<<<<< HEAD
	private String[] getAllPreferenceNames() {
		String[] preferenceNames = new String[myController.getAllPreferences().size()];
		for (Integer i = 0; i < preferenceNames.length; i++) {
			preferenceNames[i] = i.toString();
		}
		//return preferenceNames;
		return PREFERENCES;
=======
	private int getAllPreferenceNames() {
//		int[] preferenceNames = new int[this.myController.getAllPreferences().size()];
//		for (Integer i = 0; i < preferenceNames.length; i++) {
//			preferenceNames[i] = i;
//		}
		return this.myController.getAllPreferences().size();
//		return preferenceNames.length;
>>>>>>> 9bb52308dd1d1f0b6745ac7f530473cc36cf303a
	}
	
	@Override
	public void buttonPushed() {
		this.myListModel.clear();
		int numOptions = getAllPreferenceNames();
		for (int i = 0; i < numOptions; i++) {
			myListModel.addElement(String.valueOf(i));
			System.out.println(i);
		}
		super.buttonPushed();
		if (!myListModel.isEmpty()) {
			System.out.println(numOptions);
			int selected = myList.getSelectedIndex();
			if (selected > -1) {
			    this.myController.loadPreferences(selected);				
			}
		}
	}
}
