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
  private int S332 = 1;
  private int S236 = 1;
  private int S234 = 1;
  private int S194 = 1;
  private int S199 = 1;
  private int S205 = 1;
  private int S210 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread649(int [] tdone, int [] ends){
        S199=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 75, column: 42
    currsigs.addElement(valveInjectorOnOff);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread648(int [] tdone, int [] ends){
        S194=1;
    dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 75, column: 8
    currsigs.addElement(dosUnitValveRetract);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread646(int [] tdone, int [] ends){
        switch(S210){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 78, column: 36
        currsigs.addElement(dosUnitValveExtend);
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
        break;
      
    }
  }

  public void thread645(int [] tdone, int [] ends){
        switch(S205){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 78, column: 8
        currsigs.addElement(valveInletOnOff);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread643(int [] tdone, int [] ends){
        S210=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 78, column: 36
    currsigs.addElement(dosUnitValveExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread642(int [] tdone, int [] ends){
        S205=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 78, column: 8
    currsigs.addElement(valveInletOnOff);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread640(int [] tdone, int [] ends){
        switch(S199){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 75, column: 42
        currsigs.addElement(valveInjectorOnOff);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread639(int [] tdone, int [] ends){
        switch(S194){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 75, column: 8
        currsigs.addElement(dosUnitValveRetract);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread637(int [] tdone, int [] ends){
        S210=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 78, column: 36
    currsigs.addElement(dosUnitValveExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread636(int [] tdone, int [] ends){
        S205=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 78, column: 8
    currsigs.addElement(valveInletOnOff);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread634(int [] tdone, int [] ends){
        S199=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 75, column: 42
    currsigs.addElement(valveInjectorOnOff);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread633(int [] tdone, int [] ends){
        S194=1;
    dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 75, column: 8
    currsigs.addElement(dosUnitValveRetract);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S332){
        case 0 : 
          S332=0;
          break RUN;
        
        case 1 : 
          S332=2;
          S332=2;
          S236=0;
          if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 71, column: 11
            S234=0;
            thread633(tdone,ends);
            thread634(tdone,ends);
            int biggest635 = 0;
            if(ends[8]>=biggest635){
              biggest635=ends[8];
            }
            if(ends[9]>=biggest635){
              biggest635=ends[9];
            }
            if(biggest635 == 1){
              active[7]=1;
              ends[7]=1;
              break RUN;
            }
          }
          else {
            S236=1;
            active[7]=1;
            ends[7]=1;
            break RUN;
          }
        
        case 2 : 
          switch(S236){
            case 0 : 
              switch(S234){
                case 0 : 
                  if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 74, column: 12
                    S234=1;
                    thread636(tdone,ends);
                    thread637(tdone,ends);
                    int biggest638 = 0;
                    if(ends[10]>=biggest638){
                      biggest638=ends[10];
                    }
                    if(ends[11]>=biggest638){
                      biggest638=ends[11];
                    }
                    if(biggest638 == 1){
                      active[7]=1;
                      ends[7]=1;
                      break RUN;
                    }
                  }
                  else {
                    thread639(tdone,ends);
                    thread640(tdone,ends);
                    int biggest641 = 0;
                    if(ends[8]>=biggest641){
                      biggest641=ends[8];
                    }
                    if(ends[9]>=biggest641){
                      biggest641=ends[9];
                    }
                    if(biggest641 == 1){
                      active[7]=1;
                      ends[7]=1;
                      break RUN;
                    }
                    //FINXME code
                    if(biggest641 == 0){
                      S234=1;
                      thread642(tdone,ends);
                      thread643(tdone,ends);
                      int biggest644 = 0;
                      if(ends[10]>=biggest644){
                        biggest644=ends[10];
                      }
                      if(ends[11]>=biggest644){
                        biggest644=ends[11];
                      }
                      if(biggest644 == 1){
                        active[7]=1;
                        ends[7]=1;
                        break RUN;
                      }
                    }
                  }
                
                case 1 : 
                  if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 77, column: 12
                    S234=2;
                    active[7]=1;
                    ends[7]=1;
                    break RUN;
                  }
                  else {
                    thread645(tdone,ends);
                    thread646(tdone,ends);
                    int biggest647 = 0;
                    if(ends[10]>=biggest647){
                      biggest647=ends[10];
                    }
                    if(ends[11]>=biggest647){
                      biggest647=ends[11];
                    }
                    if(biggest647 == 1){
                      active[7]=1;
                      ends[7]=1;
                      break RUN;
                    }
                    //FINXME code
                    if(biggest647 == 0){
                      S234=2;
                      active[7]=1;
                      ends[7]=1;
                      break RUN;
                    }
                  }
                
                case 2 : 
                  S234=2;
                  S236=1;
                  active[7]=1;
                  ends[7]=1;
                  break RUN;
                
              }
              break;
            
            case 1 : 
              S236=1;
              S236=0;
              if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 71, column: 11
                S234=0;
                thread648(tdone,ends);
                thread649(tdone,ends);
                int biggest650 = 0;
                if(ends[8]>=biggest650){
                  biggest650=ends[8];
                }
                if(ends[9]>=biggest650){
                  biggest650=ends[9];
                }
                if(biggest650 == 1){
                  active[7]=1;
                  ends[7]=1;
                  break RUN;
                }
              }
              else {
                S236=1;
                active[7]=1;
                ends[7]=1;
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
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[7] != 0){
      int index = 7;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[7]!=0 || suspended[7]!=0 || active[7]!=1);
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
      if(paused[7]!=0 || suspended[7]!=0 || active[7]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
        systemEnable.gethook();
      }
      runFinisher();
      if(active[7] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
