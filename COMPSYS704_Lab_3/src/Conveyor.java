import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Conveyor extends ClockDomain{
  public Conveyor(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal bottleLeftPos5 = new Signal("bottleLeftPos5", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.INPUT);
  public Signal systemEnable = new Signal("systemEnable", Signal.INPUT);
  public Signal motConveyorOnOff = new Signal("motConveyorOnOff", Signal.OUTPUT);
  public Signal motorPos1On = new Signal("motorPos1On", Signal.OUTPUT);
  public Signal motorPos5On = new Signal("motorPos5On", Signal.OUTPUT);
  private int S157 = 1;
  private int S15 = 1;
  private int S7 = 1;
  private int S12 = 1;
  private int S20 = 1;
  private int S25 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread631(int [] tdone, int [] ends){
        switch(S25){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        motorPos1On.setPresent();//sysj\controller.sysj line: 29, column: 38
        currsigs.addElement(motorPos1On);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread630(int [] tdone, int [] ends){
        switch(S20){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        motConveyorOnOff.setPresent();//sysj\controller.sysj line: 29, column: 7
        currsigs.addElement(motConveyorOnOff);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread628(int [] tdone, int [] ends){
        S25=1;
    motorPos1On.setPresent();//sysj\controller.sysj line: 29, column: 38
    currsigs.addElement(motorPos1On);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread627(int [] tdone, int [] ends){
        S20=1;
    motConveyorOnOff.setPresent();//sysj\controller.sysj line: 29, column: 7
    currsigs.addElement(motConveyorOnOff);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread625(int [] tdone, int [] ends){
        switch(S12){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        motorPos5On.setPresent();//sysj\controller.sysj line: 19, column: 38
        currsigs.addElement(motorPos5On);
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread624(int [] tdone, int [] ends){
        switch(S7){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        motConveyorOnOff.setPresent();//sysj\controller.sysj line: 19, column: 7
        currsigs.addElement(motConveyorOnOff);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread622(int [] tdone, int [] ends){
        S25=1;
    motorPos1On.setPresent();//sysj\controller.sysj line: 29, column: 38
    currsigs.addElement(motorPos1On);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread621(int [] tdone, int [] ends){
        S20=1;
    motConveyorOnOff.setPresent();//sysj\controller.sysj line: 29, column: 7
    currsigs.addElement(motConveyorOnOff);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S157){
        case 0 : 
          S157=0;
          break RUN;
        
        case 1 : 
          S157=2;
          S157=2;
          S15=0;
          motConveyorOnOff.setPresent();//sysj\controller.sysj line: 13, column: 3
          currsigs.addElement(motConveyorOnOff);
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S15){
            case 0 : 
              motConveyorOnOff.setPresent();//sysj\controller.sysj line: 13, column: 3
              currsigs.addElement(motConveyorOnOff);
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 1 : 
              if(bottleLeftPos5.getprestatus()){//sysj\controller.sysj line: 18, column: 11
                S15=2;
                if(!bottleAtPos1.getprestatus() && !bottleAtPos5.getprestatus() && !bottleLeftPos5.getprestatus()){//sysj\controller.sysj line: 25, column: 12
                  thread621(tdone,ends);
                  thread622(tdone,ends);
                  int biggest623 = 0;
                  if(ends[4]>=biggest623){
                    biggest623=ends[4];
                  }
                  if(ends[5]>=biggest623){
                    biggest623=ends[5];
                  }
                  if(biggest623 == 1){
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
                else {
                  S15=3;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                thread624(tdone,ends);
                thread625(tdone,ends);
                int biggest626 = 0;
                if(ends[2]>=biggest626){
                  biggest626=ends[2];
                }
                if(ends[3]>=biggest626){
                  biggest626=ends[3];
                }
                if(biggest626 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest626 == 0){
                  S15=2;
                  if(!bottleAtPos1.getprestatus() && !bottleAtPos5.getprestatus() && !bottleLeftPos5.getprestatus()){//sysj\controller.sysj line: 25, column: 12
                    thread627(tdone,ends);
                    thread628(tdone,ends);
                    int biggest629 = 0;
                    if(ends[4]>=biggest629){
                      biggest629=ends[4];
                    }
                    if(ends[5]>=biggest629){
                      biggest629=ends[5];
                    }
                    if(biggest629 == 1){
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    S15=3;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
              }
            
            case 2 : 
              if(bottleAtPos1.getprestatus()){//sysj\controller.sysj line: 27, column: 11
                S15=3;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                thread630(tdone,ends);
                thread631(tdone,ends);
                int biggest632 = 0;
                if(ends[4]>=biggest632){
                  biggest632=ends[4];
                }
                if(ends[5]>=biggest632){
                  biggest632=ends[5];
                }
                if(biggest632 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest632 == 0){
                  S15=3;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 3 : 
              S15=3;
              S15=0;
              motConveyorOnOff.setPresent();//sysj\controller.sysj line: 13, column: 3
              currsigs.addElement(motConveyorOnOff);
              active[1]=1;
              ends[1]=1;
              break RUN;
            
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
          bottleAtPos1.gethook();
          bottleLeftPos5.gethook();
          bottleAtPos5.gethook();
          systemEnable.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos1.setpreclear();
      bottleLeftPos5.setpreclear();
      bottleAtPos5.setpreclear();
      systemEnable.setpreclear();
      motConveyorOnOff.setpreclear();
      motorPos1On.setpreclear();
      motorPos5On.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      dummyint = bottleLeftPos5.getStatus() ? bottleLeftPos5.setprepresent() : bottleLeftPos5.setpreclear();
      bottleLeftPos5.setpreval(bottleLeftPos5.getValue());
      bottleLeftPos5.setClear();
      dummyint = bottleAtPos5.getStatus() ? bottleAtPos5.setprepresent() : bottleAtPos5.setpreclear();
      bottleAtPos5.setpreval(bottleAtPos5.getValue());
      bottleAtPos5.setClear();
      dummyint = systemEnable.getStatus() ? systemEnable.setprepresent() : systemEnable.setpreclear();
      systemEnable.setpreval(systemEnable.getValue());
      systemEnable.setClear();
      motConveyorOnOff.sethook();
      motConveyorOnOff.setClear();
      motorPos1On.sethook();
      motorPos1On.setClear();
      motorPos5On.sethook();
      motorPos5On.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos1.gethook();
        bottleLeftPos5.gethook();
        bottleAtPos5.gethook();
        systemEnable.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
