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
  private Signal releaseCap_12;
  private Signal raiseGripper_12;
  private Signal unclampBottle_12;
  private int S454 = 1;
  private int S374 = 1;
  private int S341 = 1;
  private int S347 = 1;
  private int S358 = 1;
  private int S357 = 1;
  private int S372 = 1;
  private int S363 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread664(int [] tdone, int [] ends){
        S372=1;
    S363=0;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 138, column: 7
    currsigs.addElement(gripperTurnExtend);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread663(int [] tdone, int [] ends){
        S358=1;
    S357=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread662(int [] tdone, int [] ends){
        S347=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 123, column: 7
    currsigs.addElement(cylPos5ZAxisExtend);
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread661(int [] tdone, int [] ends){
        S341=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 116, column: 7
    currsigs.addElement(cylClampBottleExtend);
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread659(int [] tdone, int [] ends){
        switch(S372){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S363){
          case 0 : 
            if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 137, column: 12
              releaseCap_12.setPresent();//sysj\controller.sysj line: 140, column: 6
              currsigs.addElement(releaseCap_12);
              S363=1;
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 143, column: 7
              currsigs.addElement(gripperTurnRetract);
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              gripperTurnExtend.setPresent();//sysj\controller.sysj line: 138, column: 7
              currsigs.addElement(gripperTurnExtend);
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 142, column: 12
              raiseGripper_12.setPresent();//sysj\controller.sysj line: 145, column: 6
              currsigs.addElement(raiseGripper_12);
              unclampBottle_12.setPresent();//sysj\controller.sysj line: 146, column: 6
              currsigs.addElement(unclampBottle_12);
              S372=0;
              active[16]=0;
              ends[16]=0;
              tdone[16]=1;
            }
            else {
              gripperTurnRetract.setPresent();//sysj\controller.sysj line: 143, column: 7
              currsigs.addElement(gripperTurnRetract);
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread658(int [] tdone, int [] ends){
        switch(S358){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S357){
          case 0 : 
            if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 129, column: 13
              S357=1;
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 132, column: 7
              currsigs.addElement(capGripperPos5Extend);
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            if(releaseCap_12.getprestatus()){//sysj\controller.sysj line: 131, column: 12
              S358=0;
              active[15]=0;
              ends[15]=0;
              tdone[15]=1;
            }
            else {
              capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 132, column: 7
              currsigs.addElement(capGripperPos5Extend);
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread657(int [] tdone, int [] ends){
        switch(S347){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        if(raiseGripper_12.getprestatus()){//sysj\controller.sysj line: 121, column: 12
          S347=0;
          active[14]=0;
          ends[14]=0;
          tdone[14]=1;
        }
        else {
          cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 123, column: 7
          currsigs.addElement(cylPos5ZAxisExtend);
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
        break;
      
    }
  }

  public void thread656(int [] tdone, int [] ends){
        switch(S341){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(unclampBottle_12.getprestatus()){//sysj\controller.sysj line: 114, column: 12
          S341=0;
          active[13]=0;
          ends[13]=0;
          tdone[13]=1;
        }
        else {
          cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 116, column: 7
          currsigs.addElement(cylClampBottleExtend);
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        break;
      
    }
  }

  public void thread654(int [] tdone, int [] ends){
        S372=1;
    S363=0;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 138, column: 7
    currsigs.addElement(gripperTurnExtend);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread653(int [] tdone, int [] ends){
        S358=1;
    S357=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread652(int [] tdone, int [] ends){
        S347=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 123, column: 7
    currsigs.addElement(cylPos5ZAxisExtend);
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread651(int [] tdone, int [] ends){
        S341=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 116, column: 7
    currsigs.addElement(cylClampBottleExtend);
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S454){
        case 0 : 
          S454=0;
          break RUN;
        
        case 1 : 
          S454=2;
          S454=2;
          releaseCap_12.setClear();//sysj\controller.sysj line: 108, column: 2
          raiseGripper_12.setClear();//sysj\controller.sysj line: 108, column: 2
          unclampBottle_12.setClear();//sysj\controller.sysj line: 108, column: 2
          S374=0;
          if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 112, column: 12
            thread651(tdone,ends);
            thread652(tdone,ends);
            thread653(tdone,ends);
            thread654(tdone,ends);
            int biggest655 = 0;
            if(ends[13]>=biggest655){
              biggest655=ends[13];
            }
            if(ends[14]>=biggest655){
              biggest655=ends[14];
            }
            if(ends[15]>=biggest655){
              biggest655=ends[15];
            }
            if(ends[16]>=biggest655){
              biggest655=ends[16];
            }
            if(biggest655 == 1){
              active[12]=1;
              ends[12]=1;
              break RUN;
            }
          }
          else {
            S374=1;
            active[12]=1;
            ends[12]=1;
            break RUN;
          }
        
        case 2 : 
          releaseCap_12.setClear();//sysj\controller.sysj line: 108, column: 2
          raiseGripper_12.setClear();//sysj\controller.sysj line: 108, column: 2
          unclampBottle_12.setClear();//sysj\controller.sysj line: 108, column: 2
          switch(S374){
            case 0 : 
              thread656(tdone,ends);
              thread657(tdone,ends);
              thread658(tdone,ends);
              thread659(tdone,ends);
              int biggest660 = 0;
              if(ends[13]>=biggest660){
                biggest660=ends[13];
              }
              if(ends[14]>=biggest660){
                biggest660=ends[14];
              }
              if(ends[15]>=biggest660){
                biggest660=ends[15];
              }
              if(ends[16]>=biggest660){
                biggest660=ends[16];
              }
              if(biggest660 == 1){
                active[12]=1;
                ends[12]=1;
                break RUN;
              }
              //FINXME code
              if(biggest660 == 0){
                S374=1;
                active[12]=1;
                ends[12]=1;
                break RUN;
              }
            
            case 1 : 
              S374=1;
              S374=0;
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 112, column: 12
                thread661(tdone,ends);
                thread662(tdone,ends);
                thread663(tdone,ends);
                thread664(tdone,ends);
                int biggest665 = 0;
                if(ends[13]>=biggest665){
                  biggest665=ends[13];
                }
                if(ends[14]>=biggest665){
                  biggest665=ends[14];
                }
                if(ends[15]>=biggest665){
                  biggest665=ends[15];
                }
                if(ends[16]>=biggest665){
                  biggest665=ends[16];
                }
                if(biggest665 == 1){
                  active[12]=1;
                  ends[12]=1;
                  break RUN;
                }
              }
              else {
                S374=1;
                active[12]=1;
                ends[12]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    releaseCap_12 = new Signal();
    raiseGripper_12 = new Signal();
    unclampBottle_12 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[12] != 0){
      int index = 12;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[12]!=0 || suspended[12]!=0 || active[12]!=1);
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
      releaseCap_12.setpreclear();
      raiseGripper_12.setpreclear();
      unclampBottle_12.setpreclear();
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
      releaseCap_12.setClear();
      raiseGripper_12.setClear();
      unclampBottle_12.setClear();
      if(paused[12]!=0 || suspended[12]!=0 || active[12]!=1);
      else{
        systemEnable.gethook();
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
      }
      runFinisher();
      if(active[12] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
