package model.parser.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.parser.DefaultParser;

public class FunctionExpression extends Expression {
    Map<String, Expression> variables;
    List<Expression> expression;

    public FunctionExpression(List<String> cmdList){
        variables = new HashMap<String, Expression>();
        expression = new ArrayList<Expression>();
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
            variables.put(cmdList.get(i).substring(1), new VariableExpression(cmdList));
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
            expression.add(DefaultParser.parse(expressionCmdList));
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

}
