package org.compsys704;

import java.util.Arrays;
import java.util.List;

public class LoaderVizWorker extends Worker {

    @Override
    public void setSignal(boolean status) {
        System.out.println(signame + "  " + status);
        
        // Lid Loader Signals
        switch(signame){
            case "pusherRetracted_gui":
                States.PUSHER_RETRACTED = status;
                States.PUSHER_EXTENDED = !status;
                break;
            case "pusherExtended_gui":
                States.PUSHER_EXTENDED = status;
                States.PUSHER_RETRACTED = !status;
                if(status && !States.MAG_EMPTY) {
                    States.CAP_READY = true;
                }
                break;
            case "WPgripped_gui":
                States.GRIPPED = status;
                if(States.GRIPPED && States.ARM_AT_SOURCE){
                    States.CAP_READY = false;
                }
                break;
            case "armAtSource_gui":
                States.ARM_AT_SOURCE = status;
                States.ARM_AT_DEST = !status;
                break;
            case "armAtDest_gui":
                States.ARM_AT_DEST = status;
                States.ARM_AT_SOURCE = !status;
                break;
            case "empty_gui":
                States.MAG_EMPTY = status;
                if(status) {
                    States.CAP_READY = false;
                }
                break;
                
            // Filling Unit Signals
            case "valveInjectorOnOff_gui":
                // Assuming this controls the nozzle state
                States.NOZZLE_OPEN = status;
                States.NOZZLE_CLOSED = !status;
                break;
            case "valveInletOnOff_gui":
                // Assuming this controls liquid state
                States.LIQUID_FULL = status;
                States.LIQUID_EMPTY = !status;
                break;
            case "dosUnitValveRetract_gui":
                // Assuming this controls pressure state
                States.PRESSURE_UP = status;
                States.PRESSURE_DOWN = !status;
                break;
            case "dosUnitValveExtend_gui":
                // Assuming this controls pressure state
                States.PRESSURE_DOWN = status;
                States.PRESSURE_UP = !status;
                break;
                
            // Capping Unit Signals
            case "cylPos5ZaxisExtend_gui":
                States.CAPPER_DOWN = status;
                States.CAPPER_UP = !status;
                break;
            case "gripperTurnExtend_gui":
                States.CAPPER_TWIST = status;
                States.CAPPER_STRAIGHT = !status;
                break;
            case "gripperTurnRetract_gui":
                States.CAPPER_STRAIGHT = status;
                States.CAPPER_TWIST = !status;
                break;
            case "capGripperPos5Extend_gui":
                // Gripper can only be gripped when it is down
                States.CAPPER_GRIPPER = status && States.CAPPER_DOWN;
                States.CAPPER_OPEN = !status;
                break;
                
            // Conveyor Signals
            case "motConveyorOnOff_gui":
                // Assuming this controls the initial conveyor
                break;
            case "motConveyorOnOff_final_gui":
                // Assuming this controls the final conveyor
                break;
                
            // Bottle Position Signals
            case "bottleAtPos1_gui":
            case "bottleAtPos2_gui":
            case "bottleAtPos3_gui":
            case "bottleAtPos4_gui":
            case "bottleAtPos5_gui":
                // These would typically be used to track bottle positions
                break;
                
            // System Status Signals
            case "systemStatus_gui":
            case "currentBatch_gui":
            case "orderProgress_gui":
            case "faultStatus_gui":
                // These would be used for system status display
                break;
                
            // Arm position signals - we'll need to handle these differently
            // For valued signals like arm states, we'll need to use a different approach
            default: 
                // Handle arm position signals
                if (signame.startsWith("leftArm_")) {
                    handleLeftArmSignal(signame, status);
                } else if (signame.startsWith("rightArm_")) {
                    handleRightArmSignal(signame, status);
                } else {
                    System.err.println("Unknown signal name: " + signame);
                }
        }
    }
    
    // Helper method to handle left arm signals
    private void handleLeftArmSignal(String signalName, boolean status) {
        if (!status) return; // Only process when signal is true
        
        switch(signalName) {
            case "leftArm_POS_A_gui":
                States.setLeftArmState(States.LeftArmState.POS_A);
                break;
            case "leftArm_POS_A_LOWERED_gui":
                States.setLeftArmState(States.LeftArmState.POS_A_LOWERED);
                break;
            case "leftArm_POS_A_LOWERED_GRIPPED_gui":
                States.setLeftArmState(States.LeftArmState.POS_A_LOWERED_GRIPPED);
                break;
            case "leftArm_POS_A_GRIPPED_gui":
                States.setLeftArmState(States.LeftArmState.POS_A_GRIPPED);
                break;
            case "leftArm_POS_B_gui":
                States.setLeftArmState(States.LeftArmState.POS_B);
                break;
            case "leftArm_POS_B_LOWERED_gui":
                States.setLeftArmState(States.LeftArmState.POS_B_LOWERED);
                break;
            case "leftArm_POS_B_LOWERED_GRIPPED_gui":
                States.setLeftArmState(States.LeftArmState.POS_B_LOWERED_GRIPPED);
                break;
            case "leftArm_POS_B_GRIPPED_gui":
                States.setLeftArmState(States.LeftArmState.POS_B_GRIPPED);
                break;
            case "leftArm_POS_E_gui":
                States.setLeftArmState(States.LeftArmState.POS_E);
                break;
            case "leftArm_POS_E_LOWERED_gui":
                States.setLeftArmState(States.LeftArmState.POS_E_LOWERED);
                break;
            case "leftArm_POS_E_LOWERED_GRIPPED_gui":
                States.setLeftArmState(States.LeftArmState.POS_E_LOWERED_GRIPPED);
                break;
            case "leftArm_POS_E_GRIPPED_gui":
                States.setLeftArmState(States.LeftArmState.POS_E_GRIPPED);
                break;
            default:
                System.err.println("Unknown left arm signal: " + signalName);
        }
    }
    
    // Helper method to handle right arm signals
    private void handleRightArmSignal(String signalName, boolean status) {
        if (!status) return; // Only process when signal is true
        
        switch(signalName) {
            case "rightArm_POS_A_gui":
                States.setRightArmState(States.RightArmState.POS_A);
                break;
            case "rightArm_POS_A_LOWERED_gui":
                States.setRightArmState(States.RightArmState.POS_A_LOWERED);
                break;
            case "rightArm_POS_A_LOWERED_GRIPPED_gui":
                States.setRightArmState(States.RightArmState.POS_A_LOWERED_GRIPPED);
                break;
            case "rightArm_POS_A_GRIPPED_gui":
                States.setRightArmState(States.RightArmState.POS_A_GRIPPED);
                break;
            case "rightArm_POS_B_gui":
                States.setRightArmState(States.RightArmState.POS_B);
                break;
            case "rightArm_POS_B_LOWERED_gui":
                States.setRightArmState(States.RightArmState.POS_B_LOWERED);
                break;
            case "rightArm_POS_B_LOWERED_GRIPPED_gui":
                States.setRightArmState(States.RightArmState.POS_B_LOWERED_GRIPPED);
                break;
            case "rightArm_POS_B_GRIPPED_gui":
                States.setRightArmState(States.RightArmState.POS_B_GRIPPED);
                break;
            case "rightArm_POS_E_gui":
                States.setRightArmState(States.RightArmState.POS_E);
                break;
            case "rightArm_POS_E_LOWERED_gui":
                States.setRightArmState(States.RightArmState.POS_E_LOWERED);
                break;
            case "rightArm_POS_E_LOWERED_GRIPPED_gui":
                States.setRightArmState(States.RightArmState.POS_E_LOWERED_GRIPPED);
                break;
            case "rightArm_POS_E_GRIPPED_gui":
                States.setRightArmState(States.RightArmState.POS_E_GRIPPED);
                break;
            case "rightArm_POS_F_gui":
                States.setRightArmState(States.RightArmState.POS_F);
                break;
            case "rightArm_POS_F_LOWERED_gui":
                States.setRightArmState(States.RightArmState.POS_F_LOWERED);
                break;
            case "rightArm_POS_F_LOWERED_GRIPPED_gui":
                States.setRightArmState(States.RightArmState.POS_F_LOWERED_GRIPPED);
                break;
            case "rightArm_POS_F_GRIPPED_gui":
                States.setRightArmState(States.RightArmState.POS_F_GRIPPED);
                break;
            default:
                System.err.println("Unknown right arm signal: " + signalName);
        }
    }
    
    // Expanded list of signals with _gui suffix
    static final List<String> signames = Arrays.asList(
        // Lid Loader Signals
        "pusherRetracted_gui", "pusherExtended_gui", "WPgripped_gui", 
        "armAtSource_gui", "armAtDest_gui", "empty_gui",
        
        // Filling Unit Signals
        "valveInjectorOnOff_gui", "valveInletOnOff_gui", 
        "dosUnitValveRetract_gui", "dosUnitValveExtend_gui",
        
        // Capping Unit Signals
        "cylPos5ZaxisExtend_gui", "gripperTurnExtend_gui", 
        "gripperTurnRetract_gui", "capGripperPos5Extend_gui",
        
        // Conveyor Signals
        "motConveyorOnOff_gui", "motConveyorOnOff_final_gui",
        
        // Bottle Position Signals
        "bottleAtPos1_gui", "bottleAtPos2_gui", "bottleAtPos3_gui", 
        "bottleAtPos4_gui", "bottleAtPos5_gui",
        
        // System Status Signals
        "systemStatus_gui", "currentBatch_gui", "orderProgress_gui", "faultStatus_gui",
        
        // Left Arm Signals
        "leftArm_POS_A_gui", "leftArm_POS_A_LOWERED_gui", "leftArm_POS_A_LOWERED_GRIPPED_gui", "leftArm_POS_A_GRIPPED_gui",
        "leftArm_POS_B_gui", "leftArm_POS_B_LOWERED_gui", "leftArm_POS_B_LOWERED_GRIPPED_gui", "leftArm_POS_B_GRIPPED_gui",
        "leftArm_POS_E_gui", "leftArm_POS_E_LOWERED_gui", "leftArm_POS_E_LOWERED_GRIPPED_gui", "leftArm_POS_E_GRIPPED_gui",
        
        // Right Arm Signals
        "rightArm_POS_A_gui", "rightArm_POS_A_LOWERED_gui", "rightArm_POS_A_LOWERED_GRIPPED_gui", "rightArm_POS_A_GRIPPED_gui",
        "rightArm_POS_B_gui", "rightArm_POS_B_LOWERED_gui", "rightArm_POS_B_LOWERED_GRIPPED_gui", "rightArm_POS_B_GRIPPED_gui",
        "rightArm_POS_E_gui", "rightArm_POS_E_LOWERED_gui", "rightArm_POS_E_LOWERED_GRIPPED_gui", "rightArm_POS_E_GRIPPED_gui",
        "rightArm_POS_F_gui", "rightArm_POS_F_LOWERED_gui", "rightArm_POS_F_LOWERED_GRIPPED_gui", "rightArm_POS_F_GRIPPED_gui"
    );
    
    @Override
    public boolean hasSignal(String sn) {
        return signames.contains(sn);
    }
}