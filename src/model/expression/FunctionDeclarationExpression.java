package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import controller.TurtleCommand;
import model.parser.*;

public class FunctionDeclarationExpression extends Expression {
//    Map<String, Expression> variables;
    List<Expression> variables;
    List<Expression> expressions;

    public FunctionDeclarationExpression(List<String> cmdList){
//        variables = new HashMap<String, Expression>();
        variables = new ArrayList<Expression>();
        expressions = new ArrayList<Expression>();
        convert(cmdList);
    }

    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0);

        /*
         * to dash [ :count ]
            [
              repeat :count 
              [
                pu fd 4 pd fd 4
              ]      
            ]
         * 
         */

        int openBracketIndex = -1;
        int closeBracketIndex = -1;
        int bracketNumber = 0;

        for(int i = 0; i < cmdList.size(); i++){
            if(cmdList.get(i).equals("[")){
                if(openBracketIndex == -1){
                    openBracketIndex = i;
                }
                bracketNumber++;
            }else if(cmdList.get(i).equals("]")){
                bracketNumber--;
                if(bracketNumber == 0){
                    closeBracketIndex = i;
                    break;
                }
            }
        }

        //Within [ :count ]
        for(int i = openBracketIndex+1; i < closeBracketIndex; i++){
            variables.add(new VariableExpression(cmdList.subList(i, closeBracketIndex)));
//            variables.put(cmdList.get(i).substring(1), new VariableExpression(cmdList));
        }
        

        //Remove [ :count ]
        for(int i = openBracketIndex; i < closeBracketIndex; i++){
            cmdList.remove(0);
        }

        openBracketIndex = -1;
        closeBracketIndex = -1;
        bracketNumber = 0;

        //With [ ... ]
        for(int i = 0; i < cmdList.size(); i++){
            if(cmdList.get(i).equals("[")){
                if(openBracketIndex == -1){
                    openBracketIndex = i;
                }
                bracketNumber++;
            }else if(cmdList.get(i).equals("]")){
                bracketNumber--;
                if(bracketNumber == 0){
                    closeBracketIndex = i;
                    break;
                }
            }
        }

        List<String> expressionCmdList = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!expressionCmdList.isEmpty()){
            expressions.add(DefaultParser.parse(expressionCmdList));
        }

        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }

    }

    @Override
    public List<Expression> evaluate () {
        // TODO Auto-generated method stub
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        return finalExpressionList;
    }
    
    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCommand) {
        return new ArrayList<TurtleCommand>();
    }
    
    public int numberOfVariables() {
        return variables.size();
    }

}
