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
  private Signal vacOff_13;
  private int S970 = 1;
  private int S752 = 1;
  private int S655 = 1;
  private int S669 = 1;
  private int S680 = 1;
  private int S679 = 1;
  
  private int[] ends = new int[16];
  private int[] tdone = new int[16];
  
  public void thread1001(int [] tdone, int [] ends){
        switch(S680){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S679){
          case 0 : 
            if(WPgripped.getprestatus()){//sysj\controller.sysj line: 178, column: 13
              S679=1;
              armDest.setPresent();//sysj\controller.sysj line: 180, column: 8
              currsigs.addElement(armDest);
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
            if(armAtDest.getprestatus()){//sysj\controller.sysj line: 179, column: 14
              vacOff_13.setPresent();//sysj\controller.sysj line: 182, column: 7
              currsigs.addElement(vacOff_13);
              S680=0;
              active[15]=0;
              ends[15]=0;
              tdone[15]=1;
            }
            else {
              armDest.setPresent();//sysj\controller.sysj line: 180, column: 8
              currsigs.addElement(armDest);
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1000(int [] tdone, int [] ends){
        switch(S669){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        if(vacOff_13.getprestatus()){//sysj\controller.sysj line: 172, column: 13
          S669=0;
          active[14]=0;
          ends[14]=0;
          tdone[14]=1;
        }
        else {
          vacOn.setPresent();//sysj\controller.sysj line: 173, column: 8
          currsigs.addElement(vacOn);
          active[14]=1;
          ends[14]=1;
          tdone[14]=1;
        }
        break;
      
    }
  }

  public void thread998(int [] tdone, int [] ends){
        S680=1;
    S679=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread997(int [] tdone, int [] ends){
        S669=1;
    vacOn.setPresent();//sysj\controller.sysj line: 173, column: 8
    currsigs.addElement(vacOn);
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S970){
        case 0 : 
          S970=0;
          break RUN;
        
        case 1 : 
          S970=2;
          S970=2;
          vacOff_13.setClear();//sysj\controller.sysj line: 159, column: 2
          S752=0;
          active[13]=1;
          ends[13]=1;
          break RUN;
        
        case 2 : 
          vacOff_13.setClear();//sysj\controller.sysj line: 159, column: 2
          switch(S752){
            case 0 : 
              if(systemEnable.getprestatus()){//sysj\controller.sysj line: 161, column: 9
                S752=1;
                if(bottleAtPos3.getprestatus()){//sysj\controller.sysj line: 162, column: 14
                  S655=0;
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
                else {
                  S752=2;
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
              }
              else {
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S655){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\controller.sysj line: 163, column: 12
                    S655=1;
                    pusherExtend.setPresent();//sysj\controller.sysj line: 165, column: 7
                    currsigs.addElement(pusherExtend);
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                  else {
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                
                case 1 : 
                  if(pusherExtended.getprestatus()){//sysj\controller.sysj line: 164, column: 12
                    S655=2;
                    armSource.setPresent();//sysj\controller.sysj line: 169, column: 7
                    currsigs.addElement(armSource);
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                  else {
                    pusherExtend.setPresent();//sysj\controller.sysj line: 165, column: 7
                    currsigs.addElement(pusherExtend);
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(armAtSource.getprestatus()){//sysj\controller.sysj line: 168, column: 12
                    S655=3;
                    thread997(tdone,ends);
                    thread998(tdone,ends);
                    int biggest999 = 0;
                    if(ends[14]>=biggest999){
                      biggest999=ends[14];
                    }
                    if(ends[15]>=biggest999){
                      biggest999=ends[15];
                    }
                    if(biggest999 == 1){
                      active[13]=1;
                      ends[13]=1;
                      break RUN;
                    }
                  }
                  else {
                    armSource.setPresent();//sysj\controller.sysj line: 169, column: 7
                    currsigs.addElement(armSource);
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                
                case 3 : 
                  thread1000(tdone,ends);
                  thread1001(tdone,ends);
                  int biggest1002 = 0;
                  if(ends[14]>=biggest1002){
                    biggest1002=ends[14];
                  }
                  if(ends[15]>=biggest1002){
                    biggest1002=ends[15];
                  }
                  if(biggest1002 == 1){
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                  //FINXME code
                  if(biggest1002 == 0){
                    S752=2;
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                
              }
              break;
            
            case 2 : 
              S752=2;
              S752=0;
              active[13]=1;
              ends[13]=1;
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
    vacOff_13 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[13] != 0){
      int index = 13;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
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
      vacOff_13.setpreclear();
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
      vacOff_13.setClear();
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
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
      if(active[13] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
