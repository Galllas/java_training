package com.fdmgroup.assignment.CommandPattern;
/**
 * ConcreteCommand
 * @author gz
 *
 */
public class LightCommand implements Command {

	Light light;
	
	public LightCommand(Light light){
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();	
	}

}
