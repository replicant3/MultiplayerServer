package com.arcxesgames.main;
import javax.swing.JFrame;
import com.arcxesgames.packets.AddConnectionPacket;
import com.arcxesgames.packets.RemoveConnectionPacket;

public class EventListener {
	private JFrame frame = new JFrame("Frame");
	private GameKeyListener controller;
	private int player = 1;
	
	public void received(Object p) {
		if(p instanceof AddConnectionPacket) {
			AddConnectionPacket packet = (AddConnectionPacket)p;
			ConnectionHandler.connections.put(packet.id,new Connection(packet.id));
			//System.out.println(packet.id + " has connected");
			System.out.println("Player: " + player);
			controller = new GameKeyListener();
			frame.addKeyListener(controller);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			player++;
			
		}else if(p instanceof RemoveConnectionPacket) {
			RemoveConnectionPacket packet = (RemoveConnectionPacket)p;
			System.out.println("Connection: " + packet.id + " has disconnected");
			ConnectionHandler.connections.remove(packet.id);
			//frame.setVisible(false);
		}
	}
}
