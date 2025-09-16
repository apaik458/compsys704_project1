import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class FillerController extends ClockDomain{
  public FillerController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.INPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  private int S381 = 1;
  private int S331 = 1;
  private int S312 = 1;
  private int S319 = 1;
  private int S318 = 1;
  
  private int[] ends = new int[4];
  private int[] tdone = new int[4];
  
  public void thread387(int [] tdone, int [] ends){
        switch(S319){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S318){
          case 0 : 
            if(dosUnitFilled.getprestatus()){//sysj\FillerController.sysj line: 21, column: 10
              S318=1;
              valveInletOnOff.setPresent();//sysj\FillerController.sysj line: 23, column: 5
              currsigs.addElement(valveInletOnOff);
              dosUnitValveExtend.setPresent();//sysj\FillerController.sysj line: 24, column: 5
              currsigs.addElement(dosUnitValveExtend);
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
            if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 22, column: 10
              S319=0;
              active[3]=0;
              ends[3]=0;
              tdone[3]=1;
            }
            else {
              S319=0;
              active[3]=0;
              ends[3]=0;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread386(int [] tdone, int [] ends){
        switch(S312){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\FillerController.sysj line: 12, column: 10
          S312=0;
          active[2]=0;
          ends[2]=0;
          tdone[2]=1;
        }
        else {
          S312=0;
          active[2]=0;
          ends[2]=0;
          tdone[2]=1;
        }
        break;
      
    }
  }

  public void thread384(int [] tdone, int [] ends){
        S319=1;
    S318=0;
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread383(int [] tdone, int [] ends){
        S312=1;
    valveInjectorOnOff.setPresent();//sysj\FillerController.sysj line: 13, column: 5
    currsigs.addElement(valveInjectorOnOff);
    dosUnitValveRetract.setPresent();//sysj\FillerController.sysj line: 14, column: 5
    currsigs.addElement(dosUnitValveRetract);
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
      switch(S381){
        case 0 : 
          S381=0;
          break RUN;
        
        case 1 : 
          S381=2;
          S381=2;
          S331=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S331){
            case 0 : 
              if(bottleAtPos2.getprestatus()){//sysj\FillerController.sysj line: 8, column: 9
                S331=1;
                thread383(tdone,ends);
                thread384(tdone,ends);
                int biggest385 = 0;
                if(ends[2]>=biggest385){
                  biggest385=ends[2];
                }
                if(ends[3]>=biggest385){
                  biggest385=ends[3];
                }
                if(biggest385 == 1){
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
              thread386(tdone,ends);
              thread387(tdone,ends);
              int biggest388 = 0;
              if(ends[2]>=biggest388){
                biggest388=ends[2];
              }
              if(ends[3]>=biggest388){
                biggest388=ends[3];
              }
              if(biggest388 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest388 == 0){
                S331=0;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0};
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
          bottleAtPos2.gethook();
          dosUnitEvac.gethook();
          dosUnitFilled.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
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
      valveInjectorOnOff.sethook();
      valveInjectorOnOff.setClear();
      valveInletOnOff.sethook();
      valveInletOnOff.setClear();
      dosUnitValveRetract.sethook();
      dosUnitValveRetract.setClear();
      dosUnitValveExtend.sethook();
      dosUnitValveExtend.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
