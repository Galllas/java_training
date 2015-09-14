package com.fdmgroup.assignment.commandpattern;
/**
 * Client
 * @author gz
 *
 */
public class RemoteControlTest {

	public static void main(String[] args) {
		
		//Invoker
		SimpleRemoteControl remote = new SimpleRemoteControl();
		
		//Receiver
		Light light = new Light();
		
		//Concrete Command
		LightCommand lightOnAndOff = new LightCommand(light);
		
		remote.setCommand(lightOnAndOff);
		
		remote.onButtonWasPressed();
		remote.offButtonWasPressed();
		
		System.out.println(" ");
		remote.onButtonWasPressed();
		remote.offButtonWasPressed();
	}

}
