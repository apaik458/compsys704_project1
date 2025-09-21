package org.compsys704;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	BufferedImage arm1;
	BufferedImage arm2;
	BufferedImage p1;
	BufferedImage p2;
	BufferedImage loader;
	BufferedImage cap;
	
	// rotary turntable
	BufferedImage rotaryTable;
	
	//conveyor
	BufferedImage conveyor1;
	BufferedImage conveyor2;
	
	//filler
	BufferedImage filler;
	
	public Canvas(){
		try {
			BufferedImage bi = ImageIO.read(new File("res/arm.png"));
			arm1 = bi.getSubimage(0, 0, 64, 256);
			arm2 = bi.getSubimage(71, 0, 48, 256);
			loader = ImageIO.read(new File("res/loader.png"));
			bi = ImageIO.read(new File("res/pusher.png"));
			p1 = bi.getSubimage(0, 0, 238, 68);
			p2 = bi.getSubimage(238, 0, 172, 68);
			cap = ImageIO.read(new File("res/cap.png"));
			rotaryTable = ImageIO.read(new File("res/empty.png"));
			conveyor1 = ImageIO.read(new File("res/Conveyor_empty.png"));
			conveyor2 = ImageIO.read(new File("res/Conveyor_empty.png"));
			filler = ImageIO.read(new File("res/filler.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//default lookings
		g.drawImage(rotaryTable, 600, 100, null);
		g.drawImage(conveyor1, 240, 550, null);
		g.drawImage(conveyor2, 1480, 550, null);
		g.drawImage(loader, 1000, 0, null);
		g.drawImage(filler, 760, 220, null);
		
		if(States.CAP_ADD){g.drawImage(rotaryTable, 0, 0, null);}
	}
}
