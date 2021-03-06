package viewer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.Controller;

/**
 * @author FrontEnd - Alex, Adam
 */
public class CommandEntryBox extends Panel implements ActionListener{
    JTextField myTextField;
    Controller myController;
    PastCommandBox myPastCommandBox;
    
    /**
     * CommandEntryBox is the GUI element where a user may type commands to SLogo
     */
    public CommandEntryBox(int width, int height,PastCommandBox pastcommandbox, Controller controller){
        super(width,height);
        myTextField=new JTextField();
        add(myTextField);
        myTextField.addActionListener(this);
        myController=controller;
        myPastCommandBox=pastcommandbox;
        myTextField.setPreferredSize(new Dimension(width,height-5));
    }

    @Override
    public void actionPerformed (ActionEvent action) {
        String text = myTextField.getText();
        myController.addCommand(text);
        myTextField.setText("");
    }
}
