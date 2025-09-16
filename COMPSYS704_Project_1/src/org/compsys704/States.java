package org.compsys704;

public class States {
    
    // Lid Loader
    public static volatile boolean ARM_AT_DEST = true;
    public static volatile boolean ARM_AT_SOURCE = !ARM_AT_DEST;
    public static volatile boolean PUSHER_RETRACTED = true;
    public static volatile boolean PUSHER_EXTENDED = !PUSHER_RETRACTED;
    public static volatile boolean GRIPPED = false;
    public static volatile boolean MAG_EMPTY = false;
    public static volatile boolean CAP_READY = false;
    
    // Filling Unit
    public static volatile boolean NOZZLE_OPEN = false;
    public static volatile boolean NOZZLE_CLOSED = !NOZZLE_OPEN;
    public static volatile boolean PRESSURE_UP = false;
    public static volatile boolean PRESSURE_DOWN = !PRESSURE_UP;
    public static volatile boolean LIQUID_FULL = false;
    public static volatile boolean LIQUID_EMPTY = !LIQUID_FULL;
    
    // Capping Unit
    public static volatile boolean CAPPER_UP = false;
    public static volatile boolean CAPPER_DOWN = !CAPPER_UP;
    public static volatile boolean CAPPER_OPEN = false;
    public static volatile boolean CAPPER_GRIPPER = !CAPPER_OPEN;
    public static volatile boolean CAPPER_STRAIGHT = false;
    public static volatile boolean CAPPER_TWIST = !CAPPER_STRAIGHT;
    
    // Baxter Arm States - Using enums for mutual exclusion
    public enum LeftArmState {
        POS_A, POS_A_LOWERED, POS_A_LOWERED_GRIPPED, POS_A_GRIPPED,
        POS_B, POS_B_LOWERED, POS_B_LOWERED_GRIPPED, POS_B_GRIPPED,
        POS_E, POS_E_LOWERED, POS_E_LOWERED_GRIPPED, POS_E_GRIPPED
    }
    
    public enum RightArmState {
        POS_A, POS_A_LOWERED, POS_A_LOWERED_GRIPPED, POS_A_GRIPPED,
        POS_B, POS_B_LOWERED, POS_B_LOWERED_GRIPPED, POS_B_GRIPPED,
        POS_E, POS_E_LOWERED, POS_E_LOWERED_GRIPPED, POS_E_GRIPPED,
        POS_F, POS_F_LOWERED, POS_F_LOWERED_GRIPPED, POS_F_GRIPPED
    }
    
    // Current states for left and right arms
    public static volatile LeftArmState leftArmState = LeftArmState.POS_A;
    public static volatile RightArmState rightArmState = RightArmState.POS_A;
    
    // Methods to set arm states with mutual exclusion
    public static void setLeftArmState(LeftArmState newState) {
        leftArmState = newState;
    }
    
    public static void setRightArmState(RightArmState newState) {
        rightArmState = newState;
    }
    
    // Helper methods to check specific states
    public static boolean isLeftArmAtPosA() {
        return leftArmState == LeftArmState.POS_A;
    }
    
    public static boolean isLeftArmAtPosALowered() {
        return leftArmState == LeftArmState.POS_A_LOWERED;
    }
    
    public static boolean isLeftArmAtPosALoweredGripped() {
        return leftArmState == LeftArmState.POS_A_LOWERED_GRIPPED;
    }
    
    // Add similar helper methods for all left arm states...
    
    public static boolean isRightArmAtPosA() {
        return rightArmState == RightArmState.POS_A;
    }
    
    public static boolean isRightArmAtPosALowered() {
        return rightArmState == RightArmState.POS_A_LOWERED;
    }
    
    public static boolean isRightArmAtPosALoweredGripped() {
        return rightArmState == RightArmState.POS_A_LOWERED_GRIPPED;
    }
    
    // Add similar helper methods for all right arm states...
}