package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import controller.Controller;
import controller.Turtle;
import viewer.Panel;

/**
 * @author FrontEnd - Alex, Adam
 */
public class DataPopupButton extends SelectableListButton {

    private static final String LABEL="View Data";
    private static final String DIALOG_MESSAGE="Please select a turtle to monitor";

    /**
     * DataPopupButton is a GUI button for users to change which turtle they view data for in the data box (top right)
     * @param controller is the controller between model and view (MVC)
     */
    public DataPopupButton(Controller controller) {
        super(new String[] {}, LABEL,DIALOG_MESSAGE, controller);
    }

    @Override
    public void buttonPushed() {
        myListModel.clear();
        myListModel.addElement("None");
        List<Turtle> turtleList=myController.getTurtles();
        for (Turtle turtle:turtleList){
            myListModel.addElement(turtle.getId());
        }
        super.buttonPushed();
        int selectedItem=myList.getSelectedIndex();
        if (selectedItem!=-1){
            myController.setTrackedTurtle((String) myListModel.get(myList.getSelectedIndex()));
        }
    }

}
