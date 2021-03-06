package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import Exceptions.SlogoException;
import controller.TurtleCommand;

public class SetXYExpression extends TwoParameterExpression {

    public SetXYExpression (List<String> cmdList, Model model) throws SlogoException {
        super(cmdList, model);
    }
    
    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd) {

        if(!(expression1 instanceof NumberExpression) || !(expression2 instanceof NumberExpression)) {
            // Do better error checking here
            return null;
        }
        
        NumberExpression expX = (NumberExpression) expression1;
        NumberExpression expY = (NumberExpression) expression2;
        turtleCmd = new TurtleCommand(turtleCmd);
        turtleCmd.setX(expX.getNumber());
        turtleCmd.setY(expY.getNumber());
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }

}
