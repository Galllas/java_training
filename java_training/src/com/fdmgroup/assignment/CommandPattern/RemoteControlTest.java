package com.fdmgroup.assignment.CommandPattern;

public class RemoteControlTest {

	public static void main(String[] args) {
		
		SimpleRemoteControl remote = new SimpleRemoteControl();
		
		Light light = new Light();
		
		LightOnCommand lightOn = new LightOnCommand(light);
		
		remote.setCommand(lightOn);
		
		remote.onButtonWasPressed();
		remote.offButtonWasPressed();
		
		System.out.println(" ");
		remote.onButtonWasPressed();
		remote.offButtonWasPressed();
	}

}
