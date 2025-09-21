import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\SystemCoordinator.sysj line: 1, column: 1

public class SystemCoordinator extends ClockDomain{
  public SystemCoordinator(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal refill = new Signal("refill", Signal.INPUT);
  public Signal liquid1Val = new Signal("liquid1Val", Signal.INPUT);
  public Signal liquid2Val = new Signal("liquid2Val", Signal.INPUT);
  public Signal bottleAmount = new Signal("bottleAmount", Signal.INPUT);
  public Signal largeSize = new Signal("largeSize", Signal.INPUT);
  public Signal stop = new Signal("stop", Signal.INPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.OUTPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal empty = new Signal("empty", Signal.OUTPUT);
  public Signal pusherRetractedE = new Signal("pusherRetractedE", Signal.OUTPUT);
  public Signal pusherExtendedE = new Signal("pusherExtendedE", Signal.OUTPUT);
  public Signal WPgrippedE = new Signal("WPgrippedE", Signal.OUTPUT);
  public Signal armAtSourceE = new Signal("armAtSourceE", Signal.OUTPUT);
  public Signal armAtDestE = new Signal("armAtDestE", Signal.OUTPUT);
  public Signal emptyE = new Signal("emptyE", Signal.OUTPUT);
  public Signal systemEnable = new Signal("systemEnable", Signal.OUTPUT);
  public Signal largeSizeE = new Signal("largeSizeE", Signal.OUTPUT);
  public Signal capAdd = new Signal("capAdd", Signal.OUTPUT);
  public Signal capAddE = new Signal("capAddE", Signal.OUTPUT);
  private int S2303 = 1;
  private int S2155 = 1;
  private int S2133 = 1;
  private int S2163 = 1;
  private int S2195 = 1;
  private int S2173 = 1;
  private int S2212 = 1;
  private int S2200 = 1;
  
  private int[] ends = new int[6];
  private int[] tdone = new int[6];
  
  public void thread2313(int [] tdone, int [] ends){
        switch(S2212){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S2200){
          case 0 : 
            capAddE.setPresent();//sysj\SystemCoordinator.sysj line: 58, column: 32
            currsigs.addElement(capAddE);
            active[5]=1;
            ends[5]=1;
            tdone[5]=1;
            break;
          
          case 1 : 
            S2200=1;
            S2200=0;
            if(capAdd.getprestatus()){//sysj\SystemCoordinator.sysj line: 58, column: 24
              capAddE.setPresent();//sysj\SystemCoordinator.sysj line: 58, column: 32
              currsigs.addElement(capAddE);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              S2200=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2312(int [] tdone, int [] ends){
        switch(S2195){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S2173){
          case 0 : 
            if(largeSize.getprestatus()){//sysj\SystemCoordinator.sysj line: 47, column: 10
              S2173=1;
              largeSizeE.setPresent();//sysj\SystemCoordinator.sysj line: 51, column: 5
              currsigs.addElement(largeSizeE);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            if(!largeSize.getprestatus()){//sysj\SystemCoordinator.sysj line: 48, column: 10
              S2173=0;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              largeSizeE.setPresent();//sysj\SystemCoordinator.sysj line: 51, column: 5
              currsigs.addElement(largeSizeE);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2311(int [] tdone, int [] ends){
        switch(S2163){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(enable.getprestatus()){//sysj\SystemCoordinator.sysj line: 37, column: 10
          System.out.println((liquid1Val.getpreval() == null ? null : ((Integer)liquid1Val.getpreval())));//sysj\SystemCoordinator.sysj line: 38, column: 4
          System.out.println((liquid2Val.getpreval() == null ? null : ((Integer)liquid2Val.getpreval())));//sysj\SystemCoordinator.sysj line: 39, column: 4
          System.out.println((bottleAmount.getpreval() == null ? null : ((Integer)bottleAmount.getpreval())));//sysj\SystemCoordinator.sysj line: 40, column: 4
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread2310(int [] tdone, int [] ends){
        switch(S2155){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2133){
          case 0 : 
            if(enable.getprestatus()){//sysj\SystemCoordinator.sysj line: 28, column: 10
              S2133=1;
              systemEnable.setPresent();//sysj\SystemCoordinator.sysj line: 30, column: 4
              currsigs.addElement(systemEnable);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(stop.getprestatus()){//sysj\SystemCoordinator.sysj line: 29, column: 10
              S2133=0;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              systemEnable.setPresent();//sysj\SystemCoordinator.sysj line: 30, column: 4
              currsigs.addElement(systemEnable);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2308(int [] tdone, int [] ends){
        S2212=1;
    S2200=0;
    if(capAdd.getprestatus()){//sysj\SystemCoordinator.sysj line: 58, column: 24
      capAddE.setPresent();//sysj\SystemCoordinator.sysj line: 58, column: 32
      currsigs.addElement(capAddE);
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      S2200=1;
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread2307(int [] tdone, int [] ends){
        S2195=1;
    S2173=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2306(int [] tdone, int [] ends){
        S2163=1;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2305(int [] tdone, int [] ends){
        S2155=1;
    S2133=0;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2303){
        case 0 : 
          S2303=0;
          break RUN;
        
        case 1 : 
          S2303=2;
          S2303=2;
          new Thread(new GUI()).start();//sysj\SystemCoordinator.sysj line: 24, column: 2
          thread2305(tdone,ends);
          thread2306(tdone,ends);
          thread2307(tdone,ends);
          thread2308(tdone,ends);
          int biggest2309 = 0;
          if(ends[2]>=biggest2309){
            biggest2309=ends[2];
          }
          if(ends[3]>=biggest2309){
            biggest2309=ends[3];
          }
          if(ends[4]>=biggest2309){
            biggest2309=ends[4];
          }
          if(ends[5]>=biggest2309){
            biggest2309=ends[5];
          }
          if(biggest2309 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread2310(tdone,ends);
          thread2311(tdone,ends);
          thread2312(tdone,ends);
          thread2313(tdone,ends);
          int biggest2314 = 0;
          if(ends[2]>=biggest2314){
            biggest2314=ends[2];
          }
          if(ends[3]>=biggest2314){
            biggest2314=ends[3];
          }
          if(ends[4]>=biggest2314){
            biggest2314=ends[4];
          }
          if(ends[5]>=biggest2314){
            biggest2314=ends[5];
          }
          if(biggest2314 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2314 == 0){
            S2303=0;
            active[1]=0;
            ends[1]=0;
            S2303=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          enable.gethook();
          refill.gethook();
          liquid1Val.gethook();
          liquid2Val.gethook();
          bottleAmount.gethook();
          largeSize.gethook();
          stop.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      enable.setpreclear();
      refill.setpreclear();
      liquid1Val.setpreclear();
      liquid2Val.setpreclear();
      bottleAmount.setpreclear();
      largeSize.setpreclear();
      stop.setpreclear();
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      pusherRetractedE.setpreclear();
      pusherExtendedE.setpreclear();
      WPgrippedE.setpreclear();
      armAtSourceE.setpreclear();
      armAtDestE.setpreclear();
      emptyE.setpreclear();
      systemEnable.setpreclear();
      largeSizeE.setpreclear();
      capAdd.setpreclear();
      capAddE.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherExtend.getStatus() ? pusherExtend.setprepresent() : pusherExtend.setpreclear();
      pusherExtend.setpreval(pusherExtend.getValue());
      pusherExtend.setClear();
      dummyint = vacOn.getStatus() ? vacOn.setprepresent() : vacOn.setpreclear();
      vacOn.setpreval(vacOn.getValue());
      vacOn.setClear();
      dummyint = armSource.getStatus() ? armSource.setprepresent() : armSource.setpreclear();
      armSource.setpreval(armSource.getValue());
      armSource.setClear();
      dummyint = armDest.getStatus() ? armDest.setprepresent() : armDest.setpreclear();
      armDest.setpreval(armDest.getValue());
      armDest.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = refill.getStatus() ? refill.setprepresent() : refill.setpreclear();
      refill.setpreval(refill.getValue());
      refill.setClear();
      dummyint = liquid1Val.getStatus() ? liquid1Val.setprepresent() : liquid1Val.setpreclear();
      liquid1Val.setpreval(liquid1Val.getValue());
      liquid1Val.setClear();
      dummyint = liquid2Val.getStatus() ? liquid2Val.setprepresent() : liquid2Val.setpreclear();
      liquid2Val.setpreval(liquid2Val.getValue());
      liquid2Val.setClear();
      dummyint = bottleAmount.getStatus() ? bottleAmount.setprepresent() : bottleAmount.setpreclear();
      bottleAmount.setpreval(bottleAmount.getValue());
      bottleAmount.setClear();
      dummyint = largeSize.getStatus() ? largeSize.setprepresent() : largeSize.setpreclear();
      largeSize.setpreval(largeSize.getValue());
      largeSize.setClear();
      dummyint = stop.getStatus() ? stop.setprepresent() : stop.setpreclear();
      stop.setpreval(stop.getValue());
      stop.setClear();
      pusherRetracted.sethook();
      pusherRetracted.setClear();
      pusherExtended.sethook();
      pusherExtended.setClear();
      WPgripped.sethook();
      WPgripped.setClear();
      armAtSource.sethook();
      armAtSource.setClear();
      armAtDest.sethook();
      armAtDest.setClear();
      empty.sethook();
      empty.setClear();
      pusherRetractedE.sethook();
      pusherRetractedE.setClear();
      pusherExtendedE.sethook();
      pusherExtendedE.setClear();
      WPgrippedE.sethook();
      WPgrippedE.setClear();
      armAtSourceE.sethook();
      armAtSourceE.setClear();
      armAtDestE.sethook();
      armAtDestE.setClear();
      emptyE.sethook();
      emptyE.setClear();
      systemEnable.sethook();
      systemEnable.setClear();
      largeSizeE.sethook();
      largeSizeE.setClear();
      capAdd.sethook();
      capAdd.setClear();
      capAddE.sethook();
      capAddE.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        enable.gethook();
        refill.gethook();
        liquid1Val.gethook();
        liquid2Val.gethook();
        bottleAmount.gethook();
        largeSize.gethook();
        stop.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
