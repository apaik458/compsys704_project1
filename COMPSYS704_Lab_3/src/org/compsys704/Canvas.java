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
	BufferedImage capper;
	// storage
	BufferedImage s100ml;
	BufferedImage s200ml;
	BufferedImage source100ml;
	BufferedImage source200ml;
	
	// rotary turntable
	BufferedImage rotaryTable;
	BufferedImage rotaryTable1;
	BufferedImage rotaryTable2;
	BufferedImage rotaryTable3;
	BufferedImage rotaryTable4;
	BufferedImage rotaryTable5;
	
	//conveyor
	BufferedImage conveyor1;
	BufferedImage conveyor2;
	BufferedImage conveyor1_load;
	BufferedImage conveyor2_load;
	
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
			capper = ImageIO.read(new File("res/Capper.png"));
			rotaryTable = ImageIO.read(new File("res/empty.png"));
			rotaryTable1 = ImageIO.read(new File("res/EmptyPosition1.png"));
			rotaryTable2 = ImageIO.read(new File("res/FilledPosition2.png"));
			rotaryTable3 = ImageIO.read(new File("res/LidPosition3.png"));
			rotaryTable4 = ImageIO.read(new File("res/Position4.png"));
			rotaryTable5 = ImageIO.read(new File("res/Position5.png"));
			conveyor1 = ImageIO.read(new File("res/Conveyor_empty.png"));
			conveyor2 = ImageIO.read(new File("res/Conveyor_empty.png"));
			conveyor1_load = ImageIO.read(new File("res/Conveyor_in.png"));
			conveyor2_load = ImageIO.read(new File("res/Conveyor_out.png"));
			filler = ImageIO.read(new File("res/filler.png"));
			s100ml = ImageIO.read(new File("res/100mlDest.png"));
			s200ml = ImageIO.read(new File("res/200mlDest.png"));
			source100ml = ImageIO.read(new File("res/100mlSource.png"));
			source200ml = ImageIO.read(new File("res/200mlSource.png"));
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
		g.drawImage(conveyor2, 1480, 550, null);
		g.drawImage(loader, 1000, 0, null);
		g.drawImage(filler, 760, 250, null);
		g.drawImage(capper, 1340, 250, null);
		
		if (States.LARGE_SIZE){
			g.drawImage(s200ml, 200, 0, null);
			g.drawImage(source200ml, 50, 0, null);
		}else{
			g.drawImage(s100ml, 200, 0, null);
			g.drawImage(source100ml, 50, 0, null);
		}
		
		if (States.Conveyor1){
			g.drawImage(conveyor1_load, 240, 550, null);
		}else{
			g.drawImage(conveyor1, 240, 550, null);
		}
		
		if (States.Conveyor2){
			g.drawImage(conveyor2_load, 240, 550, null);
		}else{
			g.drawImage(conveyor2, 240, 550, null);
		}
			
		
		if(States.bPos1){g.drawImage(rotaryTable1, 600, 100, null);}
		if(States.bPos2){g.drawImage(rotaryTable2, 600, 100, null);}
		if(States.bPos3){g.drawImage(rotaryTable3, 600, 100, null);}
		if(States.bPos4){g.drawImage(rotaryTable4, 600, 100, null);}
		if(States.bPos5){g.drawImage(rotaryTable5, 600, 100, null);}
	}
}
