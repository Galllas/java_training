package com.fdmgroup.assignment.CommandPattern;
/**
 * Invoker
 * @author gz
 *
 */
public class SimpleRemoteControl {

	Command slot;
	
	public SimpleRemoteControl(){}
	
	public void setCommand(Command command){
		
		slot = command;
	}
	
	public void onButtonWasPressed(){
		slot.execute();
	}
	
	public void offButtonWasPressed(){
		slot.undo();
	}
	
}
