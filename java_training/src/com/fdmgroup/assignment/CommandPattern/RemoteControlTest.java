package com.fdmgroup.assignment.CommandPattern;

public class RemoteControlTest {

	public static void main(String[] args) {
		
		SimpleRemoteControl remote = new SimpleRemoteControl();
		
		Light light = new Light();
		
		LightCommand lightOn = new LightCommand(light);
		
		remote.setCommand(lightOn);
		
		remote.onButtonWasPressed();
		remote.offButtonWasPressed();
		
		System.out.println(" ");
		remote.onButtonWasPressed();
		remote.offButtonWasPressed();
	}

}
