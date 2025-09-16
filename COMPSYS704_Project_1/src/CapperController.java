import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class CapperController extends ClockDomain{
  public CapperController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.INPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.INPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.INPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.INPUT);
  public Signal cylPos5axisExtend = new Signal("cylPos5axisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private int S247 = 1;
  private int S45 = 1;
  private int S12 = 1;
  private int S18 = 1;
  private int S25 = 1;
  private int S24 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread255(int [] tdone, int [] ends){
        switch(S25){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S24){
          case 0 : 
            if(gripperZAxisLowered.getprestatus()){//sysj\CapperController.sysj line: 29, column: 10
              S24=1;
              capGripperPos5Extend.setPresent();//sysj\CapperController.sysj line: 31, column: 5
              currsigs.addElement(capGripperPos5Extend);
              gripperTurnExtend.setPresent();//sysj\CapperController.sysj line: 32, column: 5
              currsigs.addElement(gripperTurnExtend);
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
            if(gripperTurnFinalPos.getprestatus()){//sysj\CapperController.sysj line: 30, column: 10
              gripperTurnRetract.setPresent();//sysj\CapperController.sysj line: 35, column: 4
              currsigs.addElement(gripperTurnRetract);
              S24=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              gripperTurnRetract.setPresent();//sysj\CapperController.sysj line: 35, column: 4
              currsigs.addElement(gripperTurnRetract);
              S24=2;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 2 : 
            S24=2;
            S25=0;
            active[4]=0;
            ends[4]=0;
            tdone[4]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread254(int [] tdone, int [] ends){
        switch(S18){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\CapperController.sysj line: 22, column: 10
          S18=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        else {
          cylPos5axisExtend.setPresent();//sysj\CapperController.sysj line: 23, column: 5
          currsigs.addElement(cylPos5axisExtend);
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread253(int [] tdone, int [] ends){
        switch(S12){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\CapperController.sysj line: 15, column: 10
          S12=0;
          active[2]=0;
          ends[2]=0;
          tdone[2]=1;
        }
        else {
          cylClampBottleExtend.setPresent();//sysj\CapperController.sysj line: 16, column: 5
          currsigs.addElement(cylClampBottleExtend);
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread251(int [] tdone, int [] ends){
        S25=1;
    S24=0;
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread250(int [] tdone, int [] ends){
        S18=1;
    cylPos5axisExtend.setPresent();//sysj\CapperController.sysj line: 23, column: 5
    currsigs.addElement(cylPos5axisExtend);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread249(int [] tdone, int [] ends){
        S12=1;
    cylClampBottleExtend.setPresent();//sysj\CapperController.sysj line: 16, column: 5
    currsigs.addElement(cylClampBottleExtend);
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
      switch(S247){
        case 0 : 
          S247=0;
          break RUN;
        
        case 1 : 
          S247=2;
          S247=2;
          System.out.println("CapperPlant test");//sysj\CapperController.sysj line: 7, column: 2
          S45=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S45){
            case 0 : 
              if(bottleAtPos4.getprestatus()){//sysj\CapperController.sysj line: 11, column: 9
                S45=1;
                thread249(tdone,ends);
                thread250(tdone,ends);
                thread251(tdone,ends);
                int biggest252 = 0;
                if(ends[2]>=biggest252){
                  biggest252=ends[2];
                }
                if(ends[3]>=biggest252){
                  biggest252=ends[3];
                }
                if(ends[4]>=biggest252){
                  biggest252=ends[4];
                }
                if(biggest252 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              thread253(tdone,ends);
              thread254(tdone,ends);
              thread255(tdone,ends);
              int biggest256 = 0;
              if(ends[2]>=biggest256){
                biggest256=ends[2];
              }
              if(ends[3]>=biggest256){
                biggest256=ends[3];
              }
              if(ends[4]>=biggest256){
                biggest256=ends[4];
              }
              if(biggest256 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest256 == 0){
                S45=0;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0};
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
          bottleAtPos4.gethook();
          gripperZAxisLowered.gethook();
          gripperZAxisLifted.gethook();
          gripperTurnHomePos.gethook();
          gripperTurnFinalPos.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      cylPos5axisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos4.getStatus() ? bottleAtPos4.setprepresent() : bottleAtPos4.setpreclear();
      bottleAtPos4.setpreval(bottleAtPos4.getValue());
      bottleAtPos4.setClear();
      dummyint = gripperZAxisLowered.getStatus() ? gripperZAxisLowered.setprepresent() : gripperZAxisLowered.setpreclear();
      gripperZAxisLowered.setpreval(gripperZAxisLowered.getValue());
      gripperZAxisLowered.setClear();
      dummyint = gripperZAxisLifted.getStatus() ? gripperZAxisLifted.setprepresent() : gripperZAxisLifted.setpreclear();
      gripperZAxisLifted.setpreval(gripperZAxisLifted.getValue());
      gripperZAxisLifted.setClear();
      dummyint = gripperTurnHomePos.getStatus() ? gripperTurnHomePos.setprepresent() : gripperTurnHomePos.setpreclear();
      gripperTurnHomePos.setpreval(gripperTurnHomePos.getValue());
      gripperTurnHomePos.setClear();
      dummyint = gripperTurnFinalPos.getStatus() ? gripperTurnFinalPos.setprepresent() : gripperTurnFinalPos.setpreclear();
      gripperTurnFinalPos.setpreval(gripperTurnFinalPos.getValue());
      gripperTurnFinalPos.setClear();
      cylPos5axisExtend.sethook();
      cylPos5axisExtend.setClear();
      gripperTurnRetract.sethook();
      gripperTurnRetract.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
