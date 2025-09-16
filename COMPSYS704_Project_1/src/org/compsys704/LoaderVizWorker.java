package org.compsys704;

import java.util.Arrays;
import java.util.List;


public class LoaderVizWorker extends Worker {

    @Override
    public void setSignal(boolean status) {
        System.out.println(signame + "  " + status);
        
        // Lid Loader Signals
        switch(signame){
            case "pusherRetracted":
                States.PUSHER_RETRACTED = status;
                States.PUSHER_EXTENDED = !status;
                break;
            case "pusherExtended":
                States.PUSHER_EXTENDED = status;
                States.PUSHER_RETRACTED = !status;
                if(status && !States.MAG_EMPTY) {
                    States.CAP_READY = true;
                }
                break;
            case "WPgripped":
                States.GRIPPED = status;
                if(States.GRIPPED && States.ARM_AT_SOURCE){
                    States.CAP_READY = false;
                }
                break;
            case "armAtSource":
                States.ARM_AT_SOURCE = status;
                States.ARM_AT_DEST = !status;
                break;
            case "armAtDest":
                States.ARM_AT_DEST = status;
                States.ARM_AT_SOURCE = !status;
                break;
            case "empty":
                States.MAG_EMPTY = status;
                if(status) {
                    States.CAP_READY = false;
                }
                break;
                
            // Filling Unit Signals
            case "valveInjectorOnOff":
                // Assuming this controls the nozzle state
                States.NOZZLE_OPEN = status;
                States.NOZZLE_CLOSED = !status;
                break;
            case "valveInletOnOff":
                // Assuming this controls liquid state
                States.LIQUID_FULL = status;
                States.LIQUID_EMPTY = !status;
                break;
            case "dosUnitValveRetract":
                // Assuming this controls pressure state
                States.PRESSURE_UP = status;
                States.PRESSURE_DOWN = !status;
                break;
            case "dosUnitValveExtend":
                // Assuming this controls pressure state
                States.PRESSURE_DOWN = status;
                States.PRESSURE_UP = !status;
                break;
                
            // Capping Unit Signals
            case "cylPos5ZaxisExtend":
                States.CAPPER_DOWN = status;
                States.CAPPER_UP = !status;
                break;
            case "gripperTurnExtend":
                States.CAPPER_TWIST = status;
                States.CAPPER_STRAIGHT = !status;
                break;
            case "gripperTurnRetract":
                States.CAPPER_STRAIGHT = status;
                States.CAPPER_TWIST = !status;
                break;
            case "capGripperPos5Extend":
                // Gripper can only be gripped when it is down
                States.CAPPER_GRIPPER = status && States.CAPPER_DOWN;
                States.CAPPER_OPEN = !status;
                break;
                
            // Conveyor Signals
            case "motConveyorOnOff":
                // Assuming this controls the initial conveyor
                // You might need separate states for initial and final conveyors
                break;
            case "motConveyorOnOff_final":
                // Assuming this controls the final conveyor
                break;
                
            // Bottle Position Signals
            case "bottleAtPos1":
            case "bottleAtPos2":
            case "bottleAtPos3":
            case "bottleAtPos4":
            case "bottleAtPos5":
                // These would typically be used to track bottle positions
                // You might want to create separate state variables for each position
                break;
                
            // Baxter Arm Signals - These would need special handling
            // For now, I'll just show the pattern for a few states
            
            // Left Arm Positions
            case "leftArmPosA":
                if(status) States.setLeftArmState(States.LeftArmState.POS_A);
                break;
            case "leftArmPosALowered":
                if(status) States.setLeftArmState(States.LeftArmState.POS_A_LOWERED);
                break;
            case "leftArmPosALoweredGripped":
                if(status) States.setLeftArmState(States.LeftArmState.POS_A_LOWERED_GRIPPED);
                break;
            case "leftArmPosAGripped":
                if(status) States.setLeftArmState(States.LeftArmState.POS_A_GRIPPED);
                break;
            // Add similar cases for all left arm positions...
                
            // Right Arm Positions
            case "rightArmPosA":
                if(status) States.setRightArmState(States.RightArmState.POS_A);
                break;
            case "rightArmPosALowered":
                if(status) States.setRightArmState(States.RightArmState.POS_A_LOWERED);
                break;
            case "rightArmPosALoweredGripped":
                if(status) States.setRightArmState(States.RightArmState.POS_A_LOWERED_GRIPPED);
                break;
            case "rightArmPosAGripped":
                if(status) States.setRightArmState(States.RightArmState.POS_A_GRIPPED);
                break;
            // Add similar cases for all right arm positions...
                
            default: 
                System.err.println("Wrong sig name : " + signame);
                // Don't exit for unknown signals as other components might have their own workers
        }
    }
    
    // Expanded list of signals
    static final List<String> signames = Arrays.asList(
        // Lid Loader Signals
        "pusherRetracted", "pusherExtended", "WPgripped", "armAtSource", "armAtDest", "empty",
        
        // Filling Unit Signals
        "valveInjectorOnOff", "valveInletOnOff", "dosUnitValveRetract", "dosUnitValveExtend",
        
        // Capping Unit Signals
        "cylPos5ZaxisExtend", "gripperTurnExtend", "gripperTurnRetract", "capGripperPos5Extend",
        
        // Conveyor Signals
        "motConveyorOnOff", "motConveyorOnOff_final",
        
        // Bottle Position Signals
        "bottleAtPos1", "bottleAtPos2", "bottleAtPos3", "bottleAtPos4", "bottleAtPos5",
        
        // Baxter Arm Signals - Left
        "leftArmPosA", "leftArmPosALowered", "leftArmPosALoweredGripped", "leftArmPosAGripped",
        "leftArmPosB", "leftArmPosBLowered", "leftArmPosBLoweredGripped", "leftArmPosBGripped",
        "leftArmPosE", "leftArmPosELowered", "leftArmPosELoweredGripped", "leftArmPosEGripped",
        
        // Baxter Arm Signals - Right
        "rightArmPosA", "rightArmPosALowered", "rightArmPosALoweredGripped", "rightArmPosAGripped",
        "rightArmPosB", "rightArmPosBLowered", "rightArmPosBLoweredGripped", "rightArmPosBGripped",
        "rightArmPosE", "rightArmPosELowered", "rightArmPosELoweredGripped", "rightArmPosEGripped",
        "rightArmPosF", "rightArmPosFLowered", "rightArmPosFLoweredGripped", "rightArmPosFGripped"
    );
    
    @Override
    public boolean hasSignal(String sn) {
        return signames.contains(sn);
    }
}