package org.compsys704;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    // Original images (keep for reference)
    BufferedImage arm1;
    BufferedImage arm2;
    BufferedImage p1;
    BufferedImage p2;
    BufferedImage loader;
    BufferedImage cap;
    
    // New images (all positioned at 0,0 in 1920x1080 canvas)
    BufferedImage Background;
    BufferedImage Baxter;
    BufferedImage Conveyors;
    BufferedImage RotaryTable;
    BufferedImage LoadingUnit;
    BufferedImage LoadingUnitArmDest;
    BufferedImage LoadingUnitArmSource;
    BufferedImage LoadingUnitPusherPushed;
    BufferedImage LoadingUnitPusherIdle;
    BufferedImage LoadingUnitCaps;
    BufferedImage FillingUnit;
    BufferedImage FillingUnitNozzle;
    BufferedImage FillingUnitLiquid;
    BufferedImage FillingUnitPressure;
    BufferedImage CappingUnitUp;
    BufferedImage CappingUnitDown;
    BufferedImage CappingUnitTwist;
    BufferedImage CappingUnitGrippedStraight;
    BufferedImage CappingUnitGrippedTwist;
    BufferedImage DiscardDest;
    BufferedImage _100mlSource;
    BufferedImage _100mlDest;
    BufferedImage _100mlEmpty;
    BufferedImage _100mlChocolate;
    BufferedImage _100mlMatcha;
    BufferedImage _200mlSource;
    BufferedImage _200mlDest;
    BufferedImage _200mlEmpty;
    BufferedImage _200mlChocolate;
    BufferedImage _200mlMatcha;
    
    // Baxter arm images
    BufferedImage BaxterLeftArmPosA;
    BufferedImage BaxterLeftArmPosALowered;
    BufferedImage BaxterLeftArmPosALoweredGripped;
    BufferedImage BaxterLeftArmPosAGripped;
    BufferedImage BaxterLeftArmPosB;
    BufferedImage BaxterLeftArmPosBLowered;
    BufferedImage BaxterLeftArmPosBLoweredGripped;
    BufferedImage BaxterLeftArmPosBGripped;
    BufferedImage BaxterLeftArmPosE;
    BufferedImage BaxterLeftArmPosELowered;
    BufferedImage BaxterLeftArmPosELoweredGripped;
    BufferedImage BaxterLeftArmPosEGripped;
    
    BufferedImage BaxterRightArmPosA;
    BufferedImage BaxterRightArmPosALowered;
    BufferedImage BaxterRightArmPosALoweredGripped;
    BufferedImage BaxterRightArmPosAGripped;
    BufferedImage BaxterRightArmPosB;
    BufferedImage BaxterRightArmPosBLowered;
    BufferedImage BaxterRightArmPosBLoweredGripped;
    BufferedImage BaxterRightArmPosBGripped;
    BufferedImage BaxterRightArmPosE;
    BufferedImage BaxterRightArmPosELowered;
    BufferedImage BaxterRightArmPosELoweredGripped;
    BufferedImage BaxterRightArmPosEGripped;
    BufferedImage BaxterRightArmPosF;
    BufferedImage BaxterRightArmPosFLowered;
    BufferedImage BaxterRightArmPosFLoweredGripped;
    BufferedImage BaxterRightArmPosFGripped;
    
    public Canvas(){
        try {
            // Load original images (keep for reference)
            BufferedImage bi = ImageIO.read(new File("res/arm.png"));
            arm1 = bi.getSubimage(0, 0, 64, 256);
            arm2 = bi.getSubimage(71, 0, 48, 256);
            loader = ImageIO.read(new File("res/loader.png"));
            bi = ImageIO.read(new File("res/pusher.png"));
            p1 = bi.getSubimage(0, 0, 238, 68);
            p2 = bi.getSubimage(238, 0, 172, 68);
            cap = ImageIO.read(new File("res/cap.png"));
            
            // Load new images (all positioned at 0,0 in 1920x1080 canvas)
            Background = ImageIO.read(new File("res/Background.png"));
            Baxter = ImageIO.read(new File("res/Baxter.png"));
            Conveyors = ImageIO.read(new File("res/Conveyors.png"));
            RotaryTable = ImageIO.read(new File("res/RotaryTable.png"));
            LoadingUnit = ImageIO.read(new File("res/LoadingUnit.png"));
            LoadingUnitArmDest = ImageIO.read(new File("res/ArmDest.png"));
            LoadingUnitArmSource = ImageIO.read(new File("res/ArmSource.png"));
            LoadingUnitPusherPushed = ImageIO.read(new File("res/PusherPushed.png"));
            LoadingUnitPusherIdle = ImageIO.read(new File("res/PusherIdle.png"));
            LoadingUnitCaps = ImageIO.read(new File("res/LoadingUnitCaps.png"));
            FillingUnit = ImageIO.read(new File("res/FillingUnit.png"));
            FillingUnitNozzle = ImageIO.read(new File("res/FillingUnitNozzle.png"));
            FillingUnitLiquid = ImageIO.read(new File("res/FillingUnitLiquid.png"));
            FillingUnitPressure = ImageIO.read(new File("res/FillingUnitPressure.png"));
            CappingUnitUp = ImageIO.read(new File("res/CappingUnitUp.png"));
            CappingUnitDown = ImageIO.read(new File("res/CappingUnitDown.png"));
            CappingUnitTwist = ImageIO.read(new File("res/CappingUnitTwist.png"));
            CappingUnitGrippedTwist = ImageIO.read(new File("res/CappingGrippedTwist.png"));
            CappingUnitGrippedStraight = ImageIO.read(new File("res/CappingGrippedStraight.png"));
            DiscardDest = ImageIO.read(new File("res/DiscardDest.png"));
            _100mlSource = ImageIO.read(new File("res/100mlSource.png"));
            _100mlDest = ImageIO.read(new File("res/100mlDest.png"));
            _100mlEmpty = ImageIO.read(new File("res/100mlEmpty.png"));
            _100mlChocolate = ImageIO.read(new File("res/100mlChocolate.png"));
            _100mlMatcha = ImageIO.read(new File("res/100mlMatcha.png"));
            _200mlSource = ImageIO.read(new File("res/200mlSource.png"));
            _200mlDest = ImageIO.read(new File("res/200mlDest.png"));
            _200mlEmpty = ImageIO.read(new File("res/200mlEmpty.png"));
            _200mlChocolate = ImageIO.read(new File("res/200mlChocolate.png"));
            _200mlMatcha = ImageIO.read(new File("res/200mlMatcha.png"));
            
            // Load Baxter arm images
            BaxterLeftArmPosA = ImageIO.read(new File("res/BaxterLeftArmPosA.png"));
            BaxterLeftArmPosALowered = ImageIO.read(new File("res/BaxterLeftArmPosALowered.png"));
            BaxterLeftArmPosALoweredGripped = ImageIO.read(new File("res/BaxterLeftArmPosALoweredGripped.png"));
            BaxterLeftArmPosAGripped = ImageIO.read(new File("res/BaxterLeftArmPosAGripped.png"));
            BaxterLeftArmPosB = ImageIO.read(new File("res/BaxterLeftArmPosB.png"));
            BaxterLeftArmPosBLowered = ImageIO.read(new File("res/BaxterLeftArmPosBLowered.png"));
            BaxterLeftArmPosBLoweredGripped = ImageIO.read(new File("res/BaxterLeftArmPosBLoweredGripped.png"));
            BaxterLeftArmPosBGripped = ImageIO.read(new File("res/BaxterLeftArmPosBGripped.png"));
            BaxterLeftArmPosE = ImageIO.read(new File("res/BaxterLeftArmPosE.png"));
            BaxterLeftArmPosELowered = ImageIO.read(new File("res/BaxterLeftArmPosELowered.png"));
            BaxterLeftArmPosELoweredGripped = ImageIO.read(new File("res/BaxterLeftArmPosELoweredGripped.png"));
            BaxterLeftArmPosEGripped = ImageIO.read(new File("res/BaxterLeftArmPosEGripped.png"));
            
            BaxterRightArmPosA = ImageIO.read(new File("res/BaxterRightArmPosA.png"));
            BaxterRightArmPosALowered = ImageIO.read(new File("res/BaxterRightArmPosALowered.png"));
            BaxterRightArmPosALoweredGripped = ImageIO.read(new File("res/BaxterRightArmPosALoweredGripped.png"));
            BaxterRightArmPosAGripped = ImageIO.read(new File("res/BaxterRightArmPosAGripped.png"));
            BaxterRightArmPosB = ImageIO.read(new File("res/BaxterRightArmPosB.png"));
            BaxterRightArmPosBLowered = ImageIO.read(new File("res/BaxterRightArmPosBLowered.png"));
            BaxterRightArmPosBLoweredGripped = ImageIO.read(new File("res/BaxterRightArmPosBLoweredGripped.png"));
            BaxterRightArmPosBGripped = ImageIO.read(new File("res/BaxterRightArmPosBGripped.png"));
            BaxterRightArmPosE = ImageIO.read(new File("res/BaxterRightArmPosE.png"));
            BaxterRightArmPosELowered = ImageIO.read(new File("res/BaxterRightArmPosELowered.png"));
            BaxterRightArmPosELoweredGripped = ImageIO.read(new File("res/BaxterRightArmPosELoweredGripped.png"));
            BaxterRightArmPosEGripped = ImageIO.read(new File("res/BaxterRightArmPosEGripped.png"));
            BaxterRightArmPosF = ImageIO.read(new File("res/BaxterRightArmPosF.png"));
            BaxterRightArmPosFLowered = ImageIO.read(new File("res/BaxterRightArmPosFLowered.png"));
            BaxterRightArmPosFLoweredGripped = ImageIO.read(new File("res/BaxterRightArmPosFLoweredGripped.png"));
            BaxterRightArmPosFGripped = ImageIO.read(new File("res/BaxterRightArmPosFGripped.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        // Set the preferred size of the panel to 1920x1080
        setPreferredSize(new java.awt.Dimension(1920, 1080));
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        // Draw background and static elements first
        if (Background != null) g.drawImage(Background, 0, 0, null);
        if (Baxter != null) g.drawImage(Baxter, 0, 0, null);
        if (Conveyors != null) g.drawImage(Conveyors, 0, 0, null);
        if (RotaryTable != null) g.drawImage(RotaryTable, 0, 0, null);
        if (DiscardDest != null) g.drawImage(DiscardDest, 0, 0, null);
        if (_100mlSource != null) g.drawImage(_100mlSource, 0, 0, null);
        if (_100mlDest != null) g.drawImage(_100mlDest, 0, 0, null);
        if (_200mlSource != null) g.drawImage(_200mlSource, 0, 0, null);
        if (_200mlDest != null) g.drawImage(_200mlDest, 0, 0, null);
        
        // Lid Loader Logic
        if (LoadingUnit != null) g.drawImage(LoadingUnit, 0, 0, null);        
        
        // Draw pusher position based on state
        if (States.PUSHER_RETRACTED && LoadingUnitPusherIdle != null) {
            g.drawImage(LoadingUnitPusherIdle, 0, 0, null);
        } else if (States.PUSHER_EXTENDED && LoadingUnitPusherPushed != null) {
            g.drawImage(LoadingUnitPusherPushed, 0, 0, null);
            g.setColor(Color.black);
            // Adjust these coordinates based on where you want the circle
            g.fillOval(1040, 186, 30, 30); // Example position
        }
        
        // Draw caps only if magazine is not empty
        if (!States.MAG_EMPTY && LoadingUnitCaps != null) {
            g.drawImage(LoadingUnitCaps, 0, 0, null);
        }
        
        // Draw cap ready indicator if applicable
        if (States.CAP_READY && !States.MAG_EMPTY && States.PUSHER_RETRACTED) {
            g.setColor(Color.black);
            // Adjust these coordinates based on where you want the circle
            g.fillOval(1083, 186, 30, 30); // Example position
        }
        
        // Draw arm position based on state
        if (States.ARM_AT_SOURCE && LoadingUnitArmSource != null) {
            g.drawImage(LoadingUnitArmSource, 0, 0, null);
        } else if (States.ARM_AT_DEST && LoadingUnitArmDest != null) {
            g.drawImage(LoadingUnitArmDest, 0, 0, null);
        }
        
        // Filling Unit Logic
        if (FillingUnit != null) g.drawImage(FillingUnit, 0, 0, null);
        
        // Draw nozzle only if open
        if (States.NOZZLE_OPEN && FillingUnitNozzle != null) {
            g.drawImage(FillingUnitNozzle, 0, 0, null);
        }
        
        // Draw pressure only if up
        if (States.PRESSURE_UP && FillingUnitPressure != null) {
            g.drawImage(FillingUnitPressure, 0, 0, null);
        }
        
        // Draw liquid only if full
        if (States.LIQUID_FULL && FillingUnitLiquid != null) {
            g.drawImage(FillingUnitLiquid, 0, 0, null);
        }
        
        // Capping Unit Logic
        // Draw capper up or down
        if (States.CAPPER_UP && CappingUnitUp != null) {
            g.drawImage(CappingUnitUp, 0, 0, null);
        } else if (States.CAPPER_DOWN && CappingUnitDown != null) {
            g.drawImage(CappingUnitDown, 0, 0, null);
            
            // If capper is down, draw gripper state
            if (States.CAPPER_GRIPPER) {
                if (States.CAPPER_STRAIGHT && CappingUnitGrippedStraight != null) {
                    g.drawImage(CappingUnitGrippedStraight, 0, 0, null);
                } else if (States.CAPPER_TWIST && CappingUnitGrippedTwist != null) {
                    g.drawImage(CappingUnitGrippedTwist, 0, 0, null);
                }
            } else if (States.CAPPER_OPEN && CappingUnitTwist != null) {
                // Draw twist unit when open (if applicable)
                g.drawImage(CappingUnitTwist, 0, 0, null);
            }
        }
        
        // Draw Baxter arm images
        // Draw left arm based on state
        switch (States.leftArmState) {
            case POS_A:
                if (BaxterLeftArmPosA != null) g.drawImage(BaxterLeftArmPosA, 0, 0, null);
                break;
            case POS_A_LOWERED:
                if (BaxterLeftArmPosALowered != null) g.drawImage(BaxterLeftArmPosALowered, 0, 0, null);
                break;
            case POS_A_LOWERED_GRIPPED:
                if (BaxterLeftArmPosALoweredGripped != null) g.drawImage(BaxterLeftArmPosALoweredGripped, 0, 0, null);
                break;
            case POS_A_GRIPPED:
                if (BaxterLeftArmPosAGripped != null) g.drawImage(BaxterLeftArmPosAGripped, 0, 0, null);
                break;
            case POS_B:
                if (BaxterLeftArmPosB != null) g.drawImage(BaxterLeftArmPosB, 0, 0, null);
                break;
            case POS_B_LOWERED:
                if (BaxterLeftArmPosBLowered != null) g.drawImage(BaxterLeftArmPosBLowered, 0, 0, null);
                break;
            case POS_B_LOWERED_GRIPPED:
                if (BaxterLeftArmPosBLoweredGripped != null) g.drawImage(BaxterLeftArmPosBLoweredGripped, 0, 0, null);
                break;
            case POS_B_GRIPPED:
                if (BaxterLeftArmPosBGripped != null) g.drawImage(BaxterLeftArmPosBGripped, 0, 0, null);
                break;
            case POS_E:
                if (BaxterLeftArmPosE != null) g.drawImage(BaxterLeftArmPosE, 0, 0, null);
                break;
            case POS_E_LOWERED:
                if (BaxterLeftArmPosELowered != null) g.drawImage(BaxterLeftArmPosELowered, 0, 0, null);
                break;
            case POS_E_LOWERED_GRIPPED:
                if (BaxterLeftArmPosELoweredGripped != null) g.drawImage(BaxterLeftArmPosELoweredGripped, 0, 0, null);
                break;
            case POS_E_GRIPPED:
                if (BaxterLeftArmPosEGripped != null) g.drawImage(BaxterLeftArmPosEGripped, 0, 0, null);
                break;
        }
        
        // Draw right arm based on state
        switch (States.rightArmState) {
            case POS_A:
                if (BaxterRightArmPosA != null) g.drawImage(BaxterRightArmPosA, 0, 0, null);
                break;
            case POS_A_LOWERED:
                if (BaxterRightArmPosALowered != null) g.drawImage(BaxterRightArmPosALowered, 0, 0, null);
                break;
            case POS_A_LOWERED_GRIPPED:
                if (BaxterRightArmPosALoweredGripped != null) g.drawImage(BaxterRightArmPosALoweredGripped, 0, 0, null);
                break;
            case POS_A_GRIPPED:
                if (BaxterRightArmPosAGripped != null) g.drawImage(BaxterRightArmPosAGripped, 0, 0, null);
                break;
            case POS_B:
                if (BaxterRightArmPosB != null) g.drawImage(BaxterRightArmPosB, 0, 0, null);
                break;
            case POS_B_LOWERED:
                if (BaxterRightArmPosBLowered != null) g.drawImage(BaxterRightArmPosBLowered, 0, 0, null);
                break;
            case POS_B_LOWERED_GRIPPED:
                if (BaxterRightArmPosBLoweredGripped != null) g.drawImage(BaxterRightArmPosBLoweredGripped, 0, 0, null);
                break;
            case POS_B_GRIPPED:
                if (BaxterRightArmPosBGripped != null) g.drawImage(BaxterRightArmPosBGripped, 0, 0, null);
                break;
            case POS_E:
                if (BaxterRightArmPosE != null) g.drawImage(BaxterRightArmPosE, 0, 0, null);
                break;
            case POS_E_LOWERED:
                if (BaxterRightArmPosELowered != null) g.drawImage(BaxterRightArmPosELowered, 0, 0, null);
                break;
            case POS_E_LOWERED_GRIPPED:
                if (BaxterRightArmPosELoweredGripped != null) g.drawImage(BaxterRightArmPosELoweredGripped, 0, 0, null);
                break;
            case POS_E_GRIPPED:
                if (BaxterRightArmPosEGripped != null) g.drawImage(BaxterRightArmPosEGripped, 0, 0, null);
                break;
            case POS_F:
                if (BaxterRightArmPosF != null) g.drawImage(BaxterRightArmPosF, 0, 0, null);
                break;
            case POS_F_LOWERED:
                if (BaxterRightArmPosFLowered != null) g.drawImage(BaxterRightArmPosFLowered, 0, 0, null);
                break;
            case POS_F_LOWERED_GRIPPED:
                if (BaxterRightArmPosFLoweredGripped != null) g.drawImage(BaxterRightArmPosFLoweredGripped, 0, 0, null);
                break;
            case POS_F_GRIPPED:
                if (BaxterRightArmPosFGripped != null) g.drawImage(BaxterRightArmPosFGripped, 0, 0, null);
                break;
                
             // Draw bottles (to be implemented later)
             // You'll need to add logic here based on bottle states
        }
        
        // Keep the original logic for reference (commented out)
        /*
        g.drawImage(loader, 0, 100, null);
        
        if(States.ARM_AT_DEST)
            g.drawImage(arm1, 0, 0, null);
        else
            g.drawImage(arm2, 30, 0, null);
        
        if(States.GRIPPED){
            if(States.ARM_AT_DEST){
                g.setColor(Color.black);
                g.fillOval(10, 11, 30, 30);
                g.setColor(Color.red);
                g.fillOval(10, 11, 15, 15);
            }
            else{
                g.setColor(Color.black);
                g.fillOval(40, 243, 30, 30);
                g.setColor(Color.red);
                g.fillOval(35, 232, 15, 15);
            }
            g.setColor(Color.black);
        }
        
        if(States.CAP_READY){
            g.setColor(Color.black);
            g.fillOval(40, 243, 30, 30);
        }
        
        if(States.PUSHER_RETRACTED){
            g.drawImage(p1, 90, 225, null);
            if(!States.MAG_EMPTY){
                g.setColor(Color.black);
                g.fillOval(154, 243, 30, 30);
            }
        }
        else{
            g.drawImage(p2, 90, 225, null);
        }
        
        if(!States.MAG_EMPTY){
            g.drawImage(cap, 152, 155, null);
        }
        */
    }
}