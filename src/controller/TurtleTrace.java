package controller;

import java.util.ArrayList;
import java.util.List;

import jgame.JGColor;

/**
 *  Store TurtleCommand for each Turtle
 *  @author Fabio, Yuhua
 */
public class TurtleTrace {
    List<TurtleCommand> commandList;
    JGColor penColor;
 
    public TurtleTrace(){
        commandList = new ArrayList<TurtleCommand>();
        commandList.add(new TurtleCommand(0, 0, 90)); //default TurtleCommand
    }
    
    public void add(TurtleCommand turtleCommand){
        commandList.add(turtleCommand);
    }
    
    public void add(List<TurtleCommand> turtleCommands){
        for(TurtleCommand turtleCommand : turtleCommands){
            commandList.add(turtleCommand);
        }
    }
    
    public void add(TurtleTrace trace){
        List<TurtleCommand> turtleCmd = trace.getCommandList();
        for(TurtleCommand turtleCommand : turtleCmd){
            commandList.add(turtleCommand);
        }
    }
    
    public TurtleCommand getLatest() {
        if(commandList.size() == 0) {
            return new TurtleCommand(0, 0, 90);
        }
        return commandList.get(commandList.size()-1);
    }
    
    public List<TurtleCommand> getCommandList () {
        return commandList;
    }
    
    public void clearCommandList(){
        commandList.clear();
        commandList.add(new TurtleCommand(0, 0, 90));
    }
    
    public void setTurtlePenUp(){
        
    }
    
    public void setTurtlePenDown(){
        
    }
    
    public void getTurtlePenColor(){
        
    }
    
    public void setTurtlePenColor(JGColor color){
    	this.penColor = color;
    }
    
}
