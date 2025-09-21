import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RotaryTable extends ClockDomain{
  public RotaryTable(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.INPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.INPUT);
  public Signal systemEnable = new Signal("systemEnable", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  private int S189 = 1;
  private int S167 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S189){
        case 0 : 
          S189=0;
          break RUN;
        
        case 1 : 
          S189=2;
          S189=2;
          S167=0;
          active[6]=1;
          ends[6]=1;
          break RUN;
        
        case 2 : 
          switch(S167){
            case 0 : 
              if(!capOnBottleAtPos1.getprestatus()){//sysj\controller.sysj line: 48, column: 16
                S167=1;
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 51, column: 17
                currsigs.addElement(rotaryTableTrigger);
                active[6]=1;
                ends[6]=1;
                break RUN;
              }
              else {
                active[6]=1;
                ends[6]=1;
                break RUN;
              }
            
            case 1 : 
              if(tableAlignedWithSensor.getprestatus()){//sysj\controller.sysj line: 50, column: 19
                S167=2;
                active[6]=1;
                ends[6]=1;
                break RUN;
              }
              else {
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 51, column: 17
                currsigs.addElement(rotaryTableTrigger);
                active[6]=1;
                ends[6]=1;
                break RUN;
              }
            
            case 2 : 
              S167=2;
              S167=0;
              active[6]=1;
              ends[6]=1;
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
    while(active[6] != 0){
      int index = 6;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[6]!=0 || suspended[6]!=0 || active[6]!=1);
      else{
        if(!df){
          tableAlignedWithSensor.gethook();
          capOnBottleAtPos1.gethook();
          systemEnable.gethook();
          df = true;
        }
        runClockDomain();
      }
      tableAlignedWithSensor.setpreclear();
      capOnBottleAtPos1.setpreclear();
      systemEnable.setpreclear();
      rotaryTableTrigger.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = tableAlignedWithSensor.getStatus() ? tableAlignedWithSensor.setprepresent() : tableAlignedWithSensor.setpreclear();
      tableAlignedWithSensor.setpreval(tableAlignedWithSensor.getValue());
      tableAlignedWithSensor.setClear();
      dummyint = capOnBottleAtPos1.getStatus() ? capOnBottleAtPos1.setprepresent() : capOnBottleAtPos1.setpreclear();
      capOnBottleAtPos1.setpreval(capOnBottleAtPos1.getValue());
      capOnBottleAtPos1.setClear();
      dummyint = systemEnable.getStatus() ? systemEnable.setprepresent() : systemEnable.setpreclear();
      systemEnable.setpreval(systemEnable.getValue());
      systemEnable.setClear();
      rotaryTableTrigger.sethook();
      rotaryTableTrigger.setClear();
      if(paused[6]!=0 || suspended[6]!=0 || active[6]!=1);
      else{
        tableAlignedWithSensor.gethook();
        capOnBottleAtPos1.gethook();
        systemEnable.gethook();
      }
      runFinisher();
      if(active[6] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
