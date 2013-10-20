package model.expression;

import Exceptions.SlogoException;
import model.Model;
import controller.Controller;
import controller.ControllerToModelInterface;

public class HeadingExpression extends QueryExpression {

    public HeadingExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.heading();
    }

}
