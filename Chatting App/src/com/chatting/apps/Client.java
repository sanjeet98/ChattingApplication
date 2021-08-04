package com.chatting.apps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * @author sakaul
 *
 */
@SuppressWarnings("serial")
public class Client extends JFrame implements ActionListener{

	JPanel p1; // container that can store a group of components
	JTextField t1; // area to write text 
	JButton b1; // click to send button
	static JTextArea a1; // area to display message 
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	
	Client(){ // constructor
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7, 94, 84));
		p1.setBounds(0, 0, 450, 75);
		add(p1);
		
		@SuppressWarnings("unused")
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/chatting/apps/Icons/3.png"));
		Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon (i2);
		@SuppressWarnings("unused")
		JLabel l1 = new JLabel(i3); // used to display a short string or an image icon
		l1.setBounds(4, 18, 30, 30);
		p1.add(l1); //p1 is panel object
		
		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		@SuppressWarnings("unused")
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/chatting/apps/Icons/2.png"));
		Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon (i5);
		@SuppressWarnings("unused")
		JLabel l2 = new JLabel(i6); // used to display a short string or an image icon
		l2.setBounds(30, 5, 60, 60);
		p1.add(l2); //p1 is panel object
		
		@SuppressWarnings("unused")
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("com/chatting/apps/Icons/video.png"));
		Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon (i8);
		@SuppressWarnings("unused")
		JLabel l5 = new JLabel(i9); // used to display a short string or an image icon
		l5.setBounds(290, 20, 30, 30);
		p1.add(l5); //p1 is panel object
		
		@SuppressWarnings("unused")
		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("com/chatting/apps/Icons/phone.png"));
		Image i12 = i11.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
		ImageIcon i13 = new ImageIcon (i12);
		@SuppressWarnings("unused")
		JLabel l6 = new JLabel(i13); // used to display a short string or an image icon
		l6.setBounds(350, 20, 35, 30);
		p1.add(l6); //p1 is panel object
		
		@SuppressWarnings("unused")
		ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("com/chatting/apps/Icons/4.png"));
		Image i15 = i14.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
		ImageIcon i16 = new ImageIcon (i15);
		@SuppressWarnings("unused")
		JLabel l7 = new JLabel(i16); // used to display a short string or an image icon
		l7.setBounds(410, 20, 13, 25);
		p1.add(l7); //p1 is panel object
		
		JLabel l3 = new JLabel("Sanjeet"); 
		l3.setBounds(90, 15, 100, 18);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
		p1.add(l3);
		
		JLabel l4 = new JLabel("Active Now");
		l4.setBounds(90, 35, 100, 15);
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 12));
		p1.add(l4);
		
		a1 = new JTextArea();
		a1.setBounds(5, 80, 427, 330);
		a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		a1.setBackground(Color.PINK);
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		add(a1);
		
		t1 = new JTextField();
		t1.setBounds(5, 420, 310, 40);
		t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		add(t1);
	    
		b1 = new JButton("Send");
		b1.setBounds(310, 420, 123, 40);
		b1.setBackground(new Color(7, 94, 84));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		b1.addActionListener(this); // for action on send to display message
		add(b1);
		
		//getContentPane().setBackground(Color.WHITE);
		setLayout(null); // null for avoiding default layout 
		setSize(450, 500); // frame size
		setLocation(700, 100); // frame location, default (0,0)
		// setUndecorated(true); // to remove the default frame
		setVisible(true); // makes the frame appear on the screen default (false)
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try{
			
			String out = t1.getText();
			a1.setText(a1.getText()+ "\n\t\t\t"+out);
			dout.writeUTF(out);
			t1.setText("");
		} catch(Exception e1) {
		}
	}
	public static void main (String[] args){
		new Client().setVisible(true);
	try {
		
		s = new Socket("127.0.0.1", 6001);
		din = new DataInputStream(s.getInputStream()); // data from other side
		dout = new DataOutputStream(s.getOutputStream()); // data from this side
		
		String msginput = "";
		msginput = din.readUTF(); // string that has been encoded using a modified UTF-8 format
		a1.setText(a1.getText()+"\n"+msginput);

	} catch (Exception e) {}
}
}