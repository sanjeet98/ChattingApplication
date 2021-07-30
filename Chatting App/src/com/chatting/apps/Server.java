package com.chatting.apps;

import javax.swing.*;
/**
 * @author sakaul
 *
 */
public class Server extends JFrame {

	Server(){

		setSize(400, 500); //frame size
		setLocation(400, 100); // frame location, default (0,0)
		setVisible(true); // makes the frame appear on the screen default (false)
	}
	
	public static void main (String[] args){
		new Server().setVisible(true);
	}
}
