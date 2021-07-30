package com.chatting.apps;

import java.awt.Color;
import java.awt.Image;

import javax.swing.*;
/**
 * @author sakaul
 *
 */
@SuppressWarnings("serial")
public class Server extends JFrame {

	JPanel p1; // container that can store a group of components

	Server(){
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7, 94, 84));
		p1.setBounds(0, 0, 450, 70);
		add(p1);
		
		@SuppressWarnings("unused")
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting/apps/Icons/2.png"));
		Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon (i2);
		@SuppressWarnings("unused")
		JLabel l1 = new JLabel(i3); // used to display a short string or an image icon
		l1.setBounds(5, 17, 30, 30);
		p1.add(l1); //p1 is panel object
		
		@SuppressWarnings("unused")
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/chatting/apps/Icons/1.png"));
		Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon (i5);
		@SuppressWarnings("unused")
		JLabel l2 = new JLabel(i6); // used to display a short string or an image icon
		l2.setBounds(40, 5, 60, 60);
		p1.add(l2); //p1 is panel object
		
		setLayout(null); // null for avoiding default layout 
		setSize(400, 500); //frame size
		setLocation(400, 100); // frame location, default (0,0)
		setVisible(true); // makes the frame appear on the screen default (false)
	}
	
	public static void main (String[] args){
		new Server().setVisible(true);
	}
}
