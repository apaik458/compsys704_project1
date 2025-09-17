import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RotaryController extends ClockDomain{
  public RotaryController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.INPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.INPUT);
  public Signal largeSizeEnable = new Signal("largeSizeEnable", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal enableRotaryTable = new Signal("enableRotaryTable", Signal.INPUT);
  public Signal bottleAtPos2Done = new Signal("bottleAtPos2Done", Signal.INPUT);
  public Signal bottleAtPos3Done = new Signal("bottleAtPos3Done", Signal.INPUT);
  public Signal bottleAtPos4Done = new Signal("bottleAtPos4Done", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  public Signal sizeAdjust = new Signal("sizeAdjust", Signal.OUTPUT);
  public Signal storageAdjust = new Signal("storageAdjust", Signal.OUTPUT);
  private int S694 = 1;
  private int S626 = 1;
  private int S615 = 1;
  private int S632 = 1;
  private int S638 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread706(int [] tdone, int [] ends){
        S638=1;
    sizeAdjust.setPresent();//sysj\RotaryController.sysj line: 25, column: 5
    currsigs.addElement(sizeAdjust);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread705(int [] tdone, int [] ends){
        S632=1;
    storageAdjust.setPresent();//sysj\RotaryController.sysj line: 19, column: 5
    currsigs.addElement(storageAdjust);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread704(int [] tdone, int [] ends){
        S626=1;
    S615=0;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void thread702(int [] tdone, int [] ends){
        switch(S638){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(!largeSizeEnable.getprestatus()){//sysj\RotaryController.sysj line: 24, column: 10
          S638=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        else {
          sizeAdjust.setPresent();//sysj\RotaryController.sysj line: 25, column: 5
          currsigs.addElement(sizeAdjust);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread701(int [] tdone, int [] ends){
        switch(S632){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(!largeSizeEnable.getprestatus()){//sysj\RotaryController.sysj line: 18, column: 10
          S632=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        else {
          storageAdjust.setPresent();//sysj\RotaryController.sysj line: 19, column: 5
          currsigs.addElement(storageAdjust);
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread700(int [] tdone, int [] ends){
        switch(S626){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S615){
          case 0 : 
            if(bottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 9, column: 10
              S615=1;
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
            if(!capOnBottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 10, column: 10
              S615=2;
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
          
          case 2 : 
            if(!bottleAtPos5.getprestatus()){//sysj\RotaryController.sysj line: 11, column: 10
              S615=3;
              rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 13, column: 14
              currsigs.addElement(rotaryTableTrigger);
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
          
          case 3 : 
            if(tableAlignedWithSensor.getprestatus()){//sysj\RotaryController.sysj line: 12, column: 10
              S626=0;
              active[2]=0;
              ends[2]=0;
              tdone[2]=1;
            }
            else {
              rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 13, column: 14
              currsigs.addElement(rotaryTableTrigger);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread698(int [] tdone, int [] ends){
        S638=1;
    sizeAdjust.setPresent();//sysj\RotaryController.sysj line: 25, column: 5
    currsigs.addElement(sizeAdjust);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread697(int [] tdone, int [] ends){
        S632=1;
    storageAdjust.setPresent();//sysj\RotaryController.sysj line: 19, column: 5
    currsigs.addElement(storageAdjust);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread696(int [] tdone, int [] ends){
        S626=1;
    S615=0;
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
      switch(S694){
        case 0 : 
          S694=0;
          break RUN;
        
        case 1 : 
          S694=2;
          S694=2;
          thread696(tdone,ends);
          thread697(tdone,ends);
          thread698(tdone,ends);
          int biggest699 = 0;
          if(ends[2]>=biggest699){
            biggest699=ends[2];
          }
          if(ends[3]>=biggest699){
            biggest699=ends[3];
          }
          if(ends[4]>=biggest699){
            biggest699=ends[4];
          }
          if(biggest699 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread700(tdone,ends);
          thread701(tdone,ends);
          thread702(tdone,ends);
          int biggest703 = 0;
          if(ends[2]>=biggest703){
            biggest703=ends[2];
          }
          if(ends[3]>=biggest703){
            biggest703=ends[3];
          }
          if(ends[4]>=biggest703){
            biggest703=ends[4];
          }
          if(biggest703 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest703 == 0){
            thread704(tdone,ends);
            thread705(tdone,ends);
            thread706(tdone,ends);
            int biggest707 = 0;
            if(ends[2]>=biggest707){
              biggest707=ends[2];
            }
            if(ends[3]>=biggest707){
              biggest707=ends[3];
            }
            if(ends[4]>=biggest707){
              biggest707=ends[4];
            }
            if(biggest707 == 1){
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
          tableAlignedWithSensor.gethook();
          bottleAtPos5.gethook();
          capOnBottleAtPos1.gethook();
          largeSizeEnable.gethook();
          bottleAtPos1.gethook();
          enableRotaryTable.gethook();
          bottleAtPos2Done.gethook();
          bottleAtPos3Done.gethook();
          bottleAtPos4Done.gethook();
          df = true;
        }
        runClockDomain();
      }
      tableAlignedWithSensor.setpreclear();
      bottleAtPos5.setpreclear();
      capOnBottleAtPos1.setpreclear();
      largeSizeEnable.setpreclear();
      bottleAtPos1.setpreclear();
      enableRotaryTable.setpreclear();
      bottleAtPos2Done.setpreclear();
      bottleAtPos3Done.setpreclear();
      bottleAtPos4Done.setpreclear();
      rotaryTableTrigger.setpreclear();
      sizeAdjust.setpreclear();
      storageAdjust.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = tableAlignedWithSensor.getStatus() ? tableAlignedWithSensor.setprepresent() : tableAlignedWithSensor.setpreclear();
      tableAlignedWithSensor.setpreval(tableAlignedWithSensor.getValue());
      tableAlignedWithSensor.setClear();
      dummyint = bottleAtPos5.getStatus() ? bottleAtPos5.setprepresent() : bottleAtPos5.setpreclear();
      bottleAtPos5.setpreval(bottleAtPos5.getValue());
      bottleAtPos5.setClear();
      dummyint = capOnBottleAtPos1.getStatus() ? capOnBottleAtPos1.setprepresent() : capOnBottleAtPos1.setpreclear();
      capOnBottleAtPos1.setpreval(capOnBottleAtPos1.getValue());
      capOnBottleAtPos1.setClear();
      dummyint = largeSizeEnable.getStatus() ? largeSizeEnable.setprepresent() : largeSizeEnable.setpreclear();
      largeSizeEnable.setpreval(largeSizeEnable.getValue());
      largeSizeEnable.setClear();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      dummyint = enableRotaryTable.getStatus() ? enableRotaryTable.setprepresent() : enableRotaryTable.setpreclear();
      enableRotaryTable.setpreval(enableRotaryTable.getValue());
      enableRotaryTable.setClear();
      dummyint = bottleAtPos2Done.getStatus() ? bottleAtPos2Done.setprepresent() : bottleAtPos2Done.setpreclear();
      bottleAtPos2Done.setpreval(bottleAtPos2Done.getValue());
      bottleAtPos2Done.setClear();
      dummyint = bottleAtPos3Done.getStatus() ? bottleAtPos3Done.setprepresent() : bottleAtPos3Done.setpreclear();
      bottleAtPos3Done.setpreval(bottleAtPos3Done.getValue());
      bottleAtPos3Done.setClear();
      dummyint = bottleAtPos4Done.getStatus() ? bottleAtPos4Done.setprepresent() : bottleAtPos4Done.setpreclear();
      bottleAtPos4Done.setpreval(bottleAtPos4Done.getValue());
      bottleAtPos4Done.setClear();
      rotaryTableTrigger.sethook();
      rotaryTableTrigger.setClear();
      sizeAdjust.sethook();
      sizeAdjust.setClear();
      storageAdjust.sethook();
      storageAdjust.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        tableAlignedWithSensor.gethook();
        bottleAtPos5.gethook();
        capOnBottleAtPos1.gethook();
        largeSizeEnable.gethook();
        bottleAtPos1.gethook();
        enableRotaryTable.gethook();
        bottleAtPos2Done.gethook();
        bottleAtPos3Done.gethook();
        bottleAtPos4Done.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
