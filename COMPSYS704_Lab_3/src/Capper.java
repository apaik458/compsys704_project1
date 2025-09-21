import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Capper extends ClockDomain{
  public Capper(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal systemEnable = new Signal("systemEnable", Signal.INPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.INPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.INPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.INPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.INPUT);
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private Signal releaseCap_8;
  private Signal raiseGripper_8;
  private Signal unclampBottle_8;
  private int S643 = 1;
  private int S485 = 1;
  private int S414 = 1;
  private int S420 = 1;
  private int S431 = 1;
  private int S430 = 1;
  private int S445 = 1;
  private int S436 = 1;
  
  private int[] ends = new int[16];
  private int[] tdone = new int[16];
  
  public void thread995(int [] tdone, int [] ends){
        switch(S445){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S436){
          case 0 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 135, column: 12
              releaseCap_8.setPresent();//sysj\controller.sysj line: 138, column: 6
              currsigs.addElement(releaseCap_8);
              S436=1;
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 141, column: 7
              currsigs.addElement(gripperTurnRetract);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              gripperTurnExtend.setPresent();//sysj\controller.sysj line: 136, column: 7
              currsigs.addElement(gripperTurnExtend);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 140, column: 12
              raiseGripper_8.setPresent();//sysj\controller.sysj line: 143, column: 6
              currsigs.addElement(raiseGripper_8);
              unclampBottle_8.setPresent();//sysj\controller.sysj line: 144, column: 6
              currsigs.addElement(unclampBottle_8);
              S445=0;
              active[12]=0;
              ends[12]=0;
              tdone[12]=1;
            }
            else {
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 141, column: 7
              currsigs.addElement(gripperTurnRetract);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread994(int [] tdone, int [] ends){
        switch(S431){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S430){
          case 0 : 
            if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 127, column: 13
              S430=1;
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 130, column: 7
              currsigs.addElement(capGripperPos5Extend);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if(releaseCap_8.getprestatus()){//sysj\controller.sysj line: 129, column: 12
              S431=0;
              active[11]=0;
              ends[11]=0;
              tdone[11]=1;
            }
            else {
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 130, column: 7
              currsigs.addElement(capGripperPos5Extend);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread993(int [] tdone, int [] ends){
        switch(S420){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(raiseGripper_8.getprestatus()){//sysj\controller.sysj line: 119, column: 12
          S420=0;
          active[10]=0;
          ends[10]=0;
          tdone[10]=1;
        }
        else {
          cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 121, column: 7
          currsigs.addElement(cylPos5ZAxisExtend);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread992(int [] tdone, int [] ends){
        switch(S414){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(unclampBottle_8.getprestatus()){//sysj\controller.sysj line: 112, column: 12
          S414=0;
          active[9]=0;
          ends[9]=0;
          tdone[9]=1;
        }
        else {
          cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 114, column: 7
          currsigs.addElement(cylClampBottleExtend);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread990(int [] tdone, int [] ends){
        S445=1;
    S436=0;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 136, column: 7
    currsigs.addElement(gripperTurnExtend);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread989(int [] tdone, int [] ends){
        S431=1;
    S430=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread988(int [] tdone, int [] ends){
        S420=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 121, column: 7
    currsigs.addElement(cylPos5ZAxisExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread987(int [] tdone, int [] ends){
        S414=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 114, column: 7
    currsigs.addElement(cylClampBottleExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S643){
        case 0 : 
          S643=0;
          break RUN;
        
        case 1 : 
          S643=2;
          S643=2;
          releaseCap_8.setClear();//sysj\controller.sysj line: 106, column: 2
          raiseGripper_8.setClear();//sysj\controller.sysj line: 106, column: 2
          unclampBottle_8.setClear();//sysj\controller.sysj line: 106, column: 2
          S485=0;
          active[8]=1;
          ends[8]=1;
          break RUN;
        
        case 2 : 
          releaseCap_8.setClear();//sysj\controller.sysj line: 106, column: 2
          raiseGripper_8.setClear();//sysj\controller.sysj line: 106, column: 2
          unclampBottle_8.setClear();//sysj\controller.sysj line: 106, column: 2
          switch(S485){
            case 0 : 
              if(systemEnable.getprestatus()){//sysj\controller.sysj line: 108, column: 9
                S485=1;
                if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 110, column: 12
                  thread987(tdone,ends);
                  thread988(tdone,ends);
                  thread989(tdone,ends);
                  thread990(tdone,ends);
                  int biggest991 = 0;
                  if(ends[9]>=biggest991){
                    biggest991=ends[9];
                  }
                  if(ends[10]>=biggest991){
                    biggest991=ends[10];
                  }
                  if(ends[11]>=biggest991){
                    biggest991=ends[11];
                  }
                  if(ends[12]>=biggest991){
                    biggest991=ends[12];
                  }
                  if(biggest991 == 1){
                    active[8]=1;
                    ends[8]=1;
                    break RUN;
                  }
                }
                else {
                  S485=2;
                  active[8]=1;
                  ends[8]=1;
                  break RUN;
                }
              }
              else {
                active[8]=1;
                ends[8]=1;
                break RUN;
              }
            
            case 1 : 
              thread992(tdone,ends);
              thread993(tdone,ends);
              thread994(tdone,ends);
              thread995(tdone,ends);
              int biggest996 = 0;
              if(ends[9]>=biggest996){
                biggest996=ends[9];
              }
              if(ends[10]>=biggest996){
                biggest996=ends[10];
              }
              if(ends[11]>=biggest996){
                biggest996=ends[11];
              }
              if(ends[12]>=biggest996){
                biggest996=ends[12];
              }
              if(biggest996 == 1){
                active[8]=1;
                ends[8]=1;
                break RUN;
              }
              //FINXME code
              if(biggest996 == 0){
                S485=2;
                active[8]=1;
                ends[8]=1;
                break RUN;
              }
            
            case 2 : 
              S485=2;
              S485=0;
              active[8]=1;
              ends[8]=1;
              break RUN;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    releaseCap_8 = new Signal();
    raiseGripper_8 = new Signal();
    unclampBottle_8 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[8] != 0){
      int index = 8;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[8]!=0 || suspended[8]!=0 || active[8]!=1);
      else{
        if(!df){
          systemEnable.gethook();
          bottleAtPos4.gethook();
          gripperZAxisLowered.gethook();
          gripperZAxisLifted.gethook();
          gripperTurnHomePos.gethook();
          gripperTurnFinalPos.gethook();
          df = true;
        }
        runClockDomain();
      }
      systemEnable.setpreclear();
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      cylPos5ZAxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      releaseCap_8.setpreclear();
      raiseGripper_8.setpreclear();
      unclampBottle_8.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = systemEnable.getStatus() ? systemEnable.setprepresent() : systemEnable.setpreclear();
      systemEnable.setpreval(systemEnable.getValue());
      systemEnable.setClear();
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
      cylPos5ZAxisExtend.sethook();
      cylPos5ZAxisExtend.setClear();
      gripperTurnRetract.sethook();
      gripperTurnRetract.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      releaseCap_8.setClear();
      raiseGripper_8.setClear();
      unclampBottle_8.setClear();
      if(paused[8]!=0 || suspended[8]!=0 || active[8]!=1);
      else{
        systemEnable.gethook();
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
      }
      runFinisher();
      if(active[8] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
