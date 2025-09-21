package org.compsys704;

import java.util.Arrays;
import java.util.List;

public class LoaderVizWorker extends Worker{

	@Override
	public void setSignal(boolean status) {
//		System.out.println(signame+"  "+status);
		switch(signame){
		case "pusherRetractedE":
			States.PUSHER_RETRACTED = status;
			break;
		case "pusherExtendedE":
			if(!States.MAG_EMPTY && !States.PUSHER_EXTENDED)
				States.CAP_READY = true;
			States.PUSHER_EXTENDED = status;
			break;
		case "WPgrippedE":
			States.GRIPPED = status;
			break;
		case "armAtSourceE":
			States.ARM_AT_SOURCE = status;
			break;
		case "armAtDestE":
			States.ARM_AT_DEST = status;
			break;
		case "emptyE":
			States.MAG_EMPTY = status;
			break;
		case "capAddE":
			States.CAP_ADD = status;
			break;
		default: 
			System.err.println("Wrong sig name : "+signame);
			System.exit(1);
		}
	}
	
	
	static final List<String> signames = Arrays.asList("pusherRetractedE","pusherExtendedE","WPgrippedE","armAtSourceE","armAtDestE","emptyE","capAddE");
	
	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	}

}
