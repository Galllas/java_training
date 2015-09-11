package com.fdmgroup.assignment.CommandPattern;

/**
 * Command abstraction
 * @author gz
 *
 */
public interface Command {

	public void execute();
	public void undo();
	
}
