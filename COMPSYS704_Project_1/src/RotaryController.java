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
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  public Signal sizeAdjust = new Signal("sizeAdjust", Signal.OUTPUT);
  public Signal storageAdjust = new Signal("storageAdjust", Signal.OUTPUT);
  private int S525 = 1;
  private int S418 = 1;
  private int S417 = 1;
  private int S406 = 1;
  private int S429 = 1;
  private int S428 = 1;
  private int S439 = 1;
  private int S436 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread537(int [] tdone, int [] ends){
        S439=1;
    S436=0;
    sizeAdjust.setPresent();//sysj\RotaryController.sysj line: 24, column: 4
    currsigs.addElement(sizeAdjust);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread536(int [] tdone, int [] ends){
        S429=1;
    S428=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread535(int [] tdone, int [] ends){
        S418=1;
    S417=0;
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void thread533(int [] tdone, int [] ends){
        switch(S439){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(!largeSizeEnable.getprestatus()){//sysj\RotaryController.sysj line: 23, column: 9
          S439=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        else {
          switch(S436){
            case 0 : 
              sizeAdjust.setPresent();//sysj\RotaryController.sysj line: 24, column: 4
              currsigs.addElement(sizeAdjust);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
              break;
            
            case 1 : 
              storageAdjust.setPresent();//sysj\RotaryController.sysj line: 25, column: 4
              currsigs.addElement(storageAdjust);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
              break;
            
          }
        }
        break;
      
    }
  }

  public void thread532(int [] tdone, int [] ends){
        switch(S429){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S428){
          case 0 : 
            if(enableRotaryTable.getprestatus()){//sysj\RotaryController.sysj line: 16, column: 9
              S428=1;
              rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 18, column: 4
              currsigs.addElement(rotaryTableTrigger);
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
          
          case 1 : 
            if(!enableRotaryTable.getprestatus()){//sysj\RotaryController.sysj line: 17, column: 9
              S429=0;
              active[3]=0;
              ends[3]=0;
              tdone[3]=1;
            }
            else {
              rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 18, column: 4
              currsigs.addElement(rotaryTableTrigger);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread531(int [] tdone, int [] ends){
        switch(S418){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S417){
          case 0 : 
            if(bottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 8, column: 9
              S417=1;
              S406=0;
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
            if(capOnBottleAtPos1.getprestatus() || !bottleAtPos1.getprestatus()){//sysj\RotaryController.sysj line: 9, column: 9
              S418=0;
              active[2]=0;
              ends[2]=0;
              tdone[2]=1;
            }
            else {
              switch(S406){
                case 0 : 
                  if(tableAlignedWithSensor.getprestatus()){//sysj\RotaryController.sysj line: 10, column: 10
                    S406=1;
                    rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 11, column: 4
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
                
                case 1 : 
                  rotaryTableTrigger.setPresent();//sysj\RotaryController.sysj line: 11, column: 4
                  currsigs.addElement(rotaryTableTrigger);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread529(int [] tdone, int [] ends){
        S439=1;
    S436=0;
    sizeAdjust.setPresent();//sysj\RotaryController.sysj line: 24, column: 4
    currsigs.addElement(sizeAdjust);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread528(int [] tdone, int [] ends){
        S429=1;
    S428=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread527(int [] tdone, int [] ends){
        S418=1;
    S417=0;
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
      switch(S525){
        case 0 : 
          S525=0;
          break RUN;
        
        case 1 : 
          S525=2;
          S525=2;
          thread527(tdone,ends);
          thread528(tdone,ends);
          thread529(tdone,ends);
          int biggest530 = 0;
          if(ends[2]>=biggest530){
            biggest530=ends[2];
          }
          if(ends[3]>=biggest530){
            biggest530=ends[3];
          }
          if(ends[4]>=biggest530){
            biggest530=ends[4];
          }
          if(biggest530 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread531(tdone,ends);
          thread532(tdone,ends);
          thread533(tdone,ends);
          int biggest534 = 0;
          if(ends[2]>=biggest534){
            biggest534=ends[2];
          }
          if(ends[3]>=biggest534){
            biggest534=ends[3];
          }
          if(ends[4]>=biggest534){
            biggest534=ends[4];
          }
          if(biggest534 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest534 == 0){
            thread535(tdone,ends);
            thread536(tdone,ends);
            thread537(tdone,ends);
            int biggest538 = 0;
            if(ends[2]>=biggest538){
              biggest538=ends[2];
            }
            if(ends[3]>=biggest538){
              biggest538=ends[3];
            }
            if(ends[4]>=biggest538){
              biggest538=ends[4];
            }
            if(biggest538 == 1){
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
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
