import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Caploader extends ClockDomain{
  public Caploader(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.INPUT);
  public Signal magEmpty = new Signal("magEmpty", Signal.INPUT);
  public Signal systemEnable = new Signal("systemEnable", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public Signal magReq = new Signal("magReq", Signal.OUTPUT);
  private Signal vacOff_17;
  private int S619 = 1;
  private int S509 = 1;
  private int S465 = 1;
  private int S479 = 1;
  private int S490 = 1;
  private int S489 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread670(int [] tdone, int [] ends){
        switch(S490){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S489){
          case 0 : 
            if(WPgripped.getprestatus()){//sysj\controller.sysj line: 180, column: 13
              S489=1;
              armDest.setPresent();//sysj\controller.sysj line: 182, column: 8
              currsigs.addElement(armDest);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            if(armAtDest.getprestatus()){//sysj\controller.sysj line: 181, column: 14
              vacOff_17.setPresent();//sysj\controller.sysj line: 184, column: 7
              currsigs.addElement(vacOff_17);
              S490=0;
              active[19]=0;
              ends[19]=0;
              tdone[19]=1;
            }
            else {
              armDest.setPresent();//sysj\controller.sysj line: 182, column: 8
              currsigs.addElement(armDest);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread669(int [] tdone, int [] ends){
        switch(S479){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        if(vacOff_17.getprestatus()){//sysj\controller.sysj line: 174, column: 13
          S479=0;
          active[18]=0;
          ends[18]=0;
          tdone[18]=1;
        }
        else {
          vacOn.setPresent();//sysj\controller.sysj line: 175, column: 8
          currsigs.addElement(vacOn);
          active[18]=1;
          ends[18]=1;
          tdone[18]=1;
        }
        break;
      
    }
  }

  public void thread667(int [] tdone, int [] ends){
        S490=1;
    S489=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread666(int [] tdone, int [] ends){
        S479=1;
    vacOn.setPresent();//sysj\controller.sysj line: 175, column: 8
    currsigs.addElement(vacOn);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S619){
        case 0 : 
          S619=0;
          break RUN;
        
        case 1 : 
          S619=2;
          S619=2;
          vacOff_17.setClear();//sysj\controller.sysj line: 161, column: 2
          S509=0;
          if(bottleAtPos3.getprestatus()){//sysj\controller.sysj line: 164, column: 14
            S465=0;
            active[17]=1;
            ends[17]=1;
            break RUN;
          }
          else {
            S509=1;
            active[17]=1;
            ends[17]=1;
            break RUN;
          }
        
        case 2 : 
          vacOff_17.setClear();//sysj\controller.sysj line: 161, column: 2
          switch(S509){
            case 0 : 
              switch(S465){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\controller.sysj line: 165, column: 12
                    S465=1;
                    pusherExtend.setPresent();//sysj\controller.sysj line: 167, column: 7
                    currsigs.addElement(pusherExtend);
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                  else {
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                
                case 1 : 
                  if(pusherExtended.getprestatus()){//sysj\controller.sysj line: 166, column: 12
                    S465=2;
                    armSource.setPresent();//sysj\controller.sysj line: 171, column: 7
                    currsigs.addElement(armSource);
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                  else {
                    pusherExtend.setPresent();//sysj\controller.sysj line: 167, column: 7
                    currsigs.addElement(pusherExtend);
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(armAtSource.getprestatus()){//sysj\controller.sysj line: 170, column: 12
                    S465=3;
                    thread666(tdone,ends);
                    thread667(tdone,ends);
                    int biggest668 = 0;
                    if(ends[18]>=biggest668){
                      biggest668=ends[18];
                    }
                    if(ends[19]>=biggest668){
                      biggest668=ends[19];
                    }
                    if(biggest668 == 1){
                      active[17]=1;
                      ends[17]=1;
                      break RUN;
                    }
                  }
                  else {
                    armSource.setPresent();//sysj\controller.sysj line: 171, column: 7
                    currsigs.addElement(armSource);
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                
                case 3 : 
                  thread669(tdone,ends);
                  thread670(tdone,ends);
                  int biggest671 = 0;
                  if(ends[18]>=biggest671){
                    biggest671=ends[18];
                  }
                  if(ends[19]>=biggest671){
                    biggest671=ends[19];
                  }
                  if(biggest671 == 1){
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                  //FINXME code
                  if(biggest671 == 0){
                    S509=1;
                    active[17]=1;
                    ends[17]=1;
                    break RUN;
                  }
                
              }
              break;
            
            case 1 : 
              S509=1;
              S509=0;
              if(bottleAtPos3.getprestatus()){//sysj\controller.sysj line: 164, column: 14
                S465=0;
                active[17]=1;
                ends[17]=1;
                break RUN;
              }
              else {
                S509=1;
                active[17]=1;
                ends[17]=1;
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
    vacOff_17 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[17] != 0){
      int index = 17;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[17]!=0 || suspended[17]!=0 || active[17]!=1);
      else{
        if(!df){
          pusherRetracted.gethook();
          pusherExtended.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          bottleAtPos3.gethook();
          magEmpty.gethook();
          systemEnable.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      bottleAtPos3.setpreclear();
      magEmpty.setpreclear();
      systemEnable.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      magReq.setpreclear();
      vacOff_17.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = bottleAtPos3.getStatus() ? bottleAtPos3.setprepresent() : bottleAtPos3.setpreclear();
      bottleAtPos3.setpreval(bottleAtPos3.getValue());
      bottleAtPos3.setClear();
      dummyint = magEmpty.getStatus() ? magEmpty.setprepresent() : magEmpty.setpreclear();
      magEmpty.setpreval(magEmpty.getValue());
      magEmpty.setClear();
      dummyint = systemEnable.getStatus() ? systemEnable.setprepresent() : systemEnable.setpreclear();
      systemEnable.setpreval(systemEnable.getValue());
      systemEnable.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      magReq.sethook();
      magReq.setClear();
      vacOff_17.setClear();
      if(paused[17]!=0 || suspended[17]!=0 || active[17]!=1);
      else{
        pusherRetracted.gethook();
        pusherExtended.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        bottleAtPos3.gethook();
        magEmpty.gethook();
        systemEnable.gethook();
      }
      runFinisher();
      if(active[17] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
