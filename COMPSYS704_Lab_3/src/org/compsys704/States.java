package org.compsys704;

public class States {
	
	public static volatile boolean ARM_AT_DEST = true;
	public static volatile boolean ARM_AT_SOURCE = !ARM_AT_DEST;
	public static volatile boolean PUSHER_RETRACTED = true;
	public static volatile boolean PUSHER_EXTENDED = !PUSHER_RETRACTED;
	public static volatile boolean GRIPPED = false;
	public static volatile boolean MAG_EMPTY = false;
	
	public static volatile boolean CAP_READY = false;
	
	//storage
	public static volatile boolean LARGE_SIZE = false;
	// conveyor
	public static volatile boolean Conveyor1 = false;
	public static volatile boolean Conveyor2 = false;
	// cap loader
	public static volatile boolean CAP_ADD = false;
	
	public static volatile boolean bPos1 = false;
	public static volatile boolean bPos2 = false;
	public static volatile boolean bPos3 = false;
	public static volatile boolean bPos4 = false;
	public static volatile boolean bPos5 = false;
}
