package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;
import model.Model;
import controller.TurtleCommand;

public class PenUpExpression extends ZeroParameterExpression {

    public PenUpExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd) {

        turtleCmd = new TurtleCommand(turtleCmd);
        turtleCmd.setPenDown(false);
        
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }
    
}
