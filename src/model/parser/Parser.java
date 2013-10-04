package model.parser;

import java.util.List;
import model.parser.expression.Expression;

public abstract class Parser {

    public abstract List<Expression> execute(List<String> commandInput);
//    public abstract Expression parse (List<String> asList, int i);
    
//    public abstract Expression parse(List<String> commandInput);
}
