package com.fdmgroup.assignment.commandpattern;

/**
 * Command abstraction
 * @author gz
 *
 */
public interface Command {

	public void execute();
	public void undo();
	
}
