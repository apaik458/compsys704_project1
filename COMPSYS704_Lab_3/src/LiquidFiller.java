import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LiquidFiller extends ClockDomain{
  public LiquidFiller(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.INPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.INPUT);
  public Signal systemEnable = new Signal("systemEnable", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  private int S404 = 1;
  private int S214 = 1;
  private int S166 = 1;
  private int S126 = 1;
  private int S131 = 1;
  private int S137 = 1;
  private int S142 = 1;
  
  private int[] ends = new int[16];
  private int[] tdone = new int[16];
  
  public void thread985(int [] tdone, int [] ends){
        switch(S142){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 76, column: 36
        currsigs.addElement(dosUnitValveExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread984(int [] tdone, int [] ends){
        switch(S137){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 76, column: 8
        currsigs.addElement(valveInletOnOff);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread982(int [] tdone, int [] ends){
        S142=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 76, column: 36
    currsigs.addElement(dosUnitValveExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread981(int [] tdone, int [] ends){
        S137=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 76, column: 8
    currsigs.addElement(valveInletOnOff);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread979(int [] tdone, int [] ends){
        switch(S131){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 73, column: 42
        currsigs.addElement(valveInjectorOnOff);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread978(int [] tdone, int [] ends){
        switch(S126){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 73, column: 8
        currsigs.addElement(dosUnitValveRetract);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread976(int [] tdone, int [] ends){
        S142=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 76, column: 36
    currsigs.addElement(dosUnitValveExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread975(int [] tdone, int [] ends){
        S137=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 76, column: 8
    currsigs.addElement(valveInletOnOff);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread973(int [] tdone, int [] ends){
        S131=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 73, column: 42
    currsigs.addElement(valveInjectorOnOff);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread972(int [] tdone, int [] ends){
        S126=1;
    dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 73, column: 8
    currsigs.addElement(dosUnitValveRetract);
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
      switch(S404){
        case 0 : 
          S404=0;
          break RUN;
        
        case 1 : 
          S404=2;
          S404=2;
          S214=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S214){
            case 0 : 
              if(systemEnable.getprestatus()){//sysj\controller.sysj line: 67, column: 9
                S214=1;
                if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 69, column: 11
                  S166=0;
                  thread972(tdone,ends);
                  thread973(tdone,ends);
                  int biggest974 = 0;
                  if(ends[4]>=biggest974){
                    biggest974=ends[4];
                  }
                  if(ends[5]>=biggest974){
                    biggest974=ends[5];
                  }
                  if(biggest974 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
                else {
                  S214=2;
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S166){
                case 0 : 
                  if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 72, column: 12
                    S166=1;
                    thread975(tdone,ends);
                    thread976(tdone,ends);
                    int biggest977 = 0;
                    if(ends[6]>=biggest977){
                      biggest977=ends[6];
                    }
                    if(ends[7]>=biggest977){
                      biggest977=ends[7];
                    }
                    if(biggest977 == 1){
                      active[3]=1;
                      ends[3]=1;
                      break RUN;
                    }
                  }
                  else {
                    thread978(tdone,ends);
                    thread979(tdone,ends);
                    int biggest980 = 0;
                    if(ends[4]>=biggest980){
                      biggest980=ends[4];
                    }
                    if(ends[5]>=biggest980){
                      biggest980=ends[5];
                    }
                    if(biggest980 == 1){
                      active[3]=1;
                      ends[3]=1;
                      break RUN;
                    }
                    //FINXME code
                    if(biggest980 == 0){
                      S166=1;
                      thread981(tdone,ends);
                      thread982(tdone,ends);
                      int biggest983 = 0;
                      if(ends[6]>=biggest983){
                        biggest983=ends[6];
                      }
                      if(ends[7]>=biggest983){
                        biggest983=ends[7];
                      }
                      if(biggest983 == 1){
                        active[3]=1;
                        ends[3]=1;
                        break RUN;
                      }
                    }
                  }
                
                case 1 : 
                  if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 75, column: 12
                    S166=2;
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                  else {
                    thread984(tdone,ends);
                    thread985(tdone,ends);
                    int biggest986 = 0;
                    if(ends[6]>=biggest986){
                      biggest986=ends[6];
                    }
                    if(ends[7]>=biggest986){
                      biggest986=ends[7];
                    }
                    if(biggest986 == 1){
                      active[3]=1;
                      ends[3]=1;
                      break RUN;
                    }
                    //FINXME code
                    if(biggest986 == 0){
                      S166=2;
                      active[3]=1;
                      ends[3]=1;
                      break RUN;
                    }
                  }
                
                case 2 : 
                  S166=2;
                  S214=2;
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                
              }
              break;
            
            case 2 : 
              S214=2;
              S214=0;
              active[3]=1;
              ends[3]=1;
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
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[3] != 0){
      int index = 3;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
      else{
        if(!df){
          bottleAtPos2.gethook();
          dosUnitEvac.gethook();
          dosUnitFilled.gethook();
          systemEnable.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      systemEnable.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos2.getStatus() ? bottleAtPos2.setprepresent() : bottleAtPos2.setpreclear();
      bottleAtPos2.setpreval(bottleAtPos2.getValue());
      bottleAtPos2.setClear();
      dummyint = dosUnitEvac.getStatus() ? dosUnitEvac.setprepresent() : dosUnitEvac.setpreclear();
      dosUnitEvac.setpreval(dosUnitEvac.getValue());
      dosUnitEvac.setClear();
      dummyint = dosUnitFilled.getStatus() ? dosUnitFilled.setprepresent() : dosUnitFilled.setpreclear();
      dosUnitFilled.setpreval(dosUnitFilled.getValue());
      dosUnitFilled.setClear();
      dummyint = systemEnable.getStatus() ? systemEnable.setprepresent() : systemEnable.setpreclear();
      systemEnable.setpreval(systemEnable.getValue());
      systemEnable.setClear();
      valveInjectorOnOff.sethook();
      valveInjectorOnOff.setClear();
      valveInletOnOff.sethook();
      valveInletOnOff.setClear();
      dosUnitValveRetract.sethook();
      dosUnitValveRetract.setClear();
      dosUnitValveExtend.sethook();
      dosUnitValveExtend.setClear();
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
        systemEnable.gethook();
      }
      runFinisher();
      if(active[3] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
