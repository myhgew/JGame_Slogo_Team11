package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;

public class SinExpression extends OneParameterExpression {

    public SinExpression (List<String> cmdList) throws SlogoException {
        super(cmdList);
    }
    
    @Override
    public List<Expression> evaluate () {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        NumberExpression exp = (NumberExpression) expression;
        finalExpressionList.add(exp.sin());
        return finalExpressionList;
    }

}
