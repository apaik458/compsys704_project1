import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\SystemCoordinator.sysj line: 1, column: 1

public class SystemCoordinator extends ClockDomain{
  public SystemCoordinator(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal refill = new Signal("refill", Signal.INPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.OUTPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal empty = new Signal("empty", Signal.OUTPUT);
  public Signal pusherRetractedE = new Signal("pusherRetractedE", Signal.OUTPUT);
  public Signal pusherExtendedE = new Signal("pusherExtendedE", Signal.OUTPUT);
  public Signal WPgrippedE = new Signal("WPgrippedE", Signal.OUTPUT);
  public Signal armAtSourceE = new Signal("armAtSourceE", Signal.OUTPUT);
  public Signal armAtDestE = new Signal("armAtDestE", Signal.OUTPUT);
  public Signal emptyE = new Signal("emptyE", Signal.OUTPUT);
  public Signal capAddE = new Signal("capAddE", Signal.OUTPUT);
  private Signal tester_1;
  private int S379 = 1;
  private int S252 = 1;
  private int S245 = 1;
  private int S310 = 1;
  private int S260 = 1;
  private int S254 = 1;
  private int S268 = 1;
  private int S276 = 1;
  private int S284 = 1;
  private int S292 = 1;
  private int S300 = 1;
  private int S308 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread400(int [] tdone, int [] ends){
        switch(S308){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(tester_1.getprestatus()){//sysj\SystemCoordinator.sysj line: 37, column: 24
          capAddE.setPresent();//sysj\SystemCoordinator.sysj line: 37, column: 32
          currsigs.addElement(capAddE);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread399(int [] tdone, int [] ends){
        switch(S300){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\SystemCoordinator.sysj line: 35, column: 24
          emptyE.setPresent();//sysj\SystemCoordinator.sysj line: 35, column: 31
          currsigs.addElement(emptyE);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread398(int [] tdone, int [] ends){
        switch(S292){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\SystemCoordinator.sysj line: 33, column: 24
          armAtDestE.setPresent();//sysj\SystemCoordinator.sysj line: 33, column: 35
          currsigs.addElement(armAtDestE);
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread397(int [] tdone, int [] ends){
        switch(S284){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\SystemCoordinator.sysj line: 31, column: 24
          armAtSourceE.setPresent();//sysj\SystemCoordinator.sysj line: 31, column: 37
          currsigs.addElement(armAtSourceE);
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        else {
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread396(int [] tdone, int [] ends){
        switch(S276){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\SystemCoordinator.sysj line: 29, column: 24
          WPgrippedE.setPresent();//sysj\SystemCoordinator.sysj line: 29, column: 35
          currsigs.addElement(WPgrippedE);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        break;
      
    }
  }

  public void thread395(int [] tdone, int [] ends){
        switch(S268){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\SystemCoordinator.sysj line: 27, column: 24
          pusherExtendedE.setPresent();//sysj\SystemCoordinator.sysj line: 27, column: 40
          currsigs.addElement(pusherExtendedE);
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread394(int [] tdone, int [] ends){
        switch(S260){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S254){
          case 0 : 
            S254=0;
            if(pusherRetracted.getprestatus()){//sysj\SystemCoordinator.sysj line: 25, column: 24
              pusherRetractedE.setPresent();//sysj\SystemCoordinator.sysj line: 25, column: 41
              currsigs.addElement(pusherRetractedE);
              S254=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S254=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            S254=1;
            S254=0;
            if(pusherRetracted.getprestatus()){//sysj\SystemCoordinator.sysj line: 25, column: 24
              pusherRetractedE.setPresent();//sysj\SystemCoordinator.sysj line: 25, column: 41
              currsigs.addElement(pusherRetractedE);
              S254=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S254=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread393(int [] tdone, int [] ends){
        switch(S310){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        thread394(tdone,ends);
        thread395(tdone,ends);
        thread396(tdone,ends);
        thread397(tdone,ends);
        thread398(tdone,ends);
        thread399(tdone,ends);
        thread400(tdone,ends);
        int biggest401 = 0;
        if(ends[4]>=biggest401){
          biggest401=ends[4];
        }
        if(ends[5]>=biggest401){
          biggest401=ends[5];
        }
        if(ends[6]>=biggest401){
          biggest401=ends[6];
        }
        if(ends[7]>=biggest401){
          biggest401=ends[7];
        }
        if(ends[8]>=biggest401){
          biggest401=ends[8];
        }
        if(ends[9]>=biggest401){
          biggest401=ends[9];
        }
        if(ends[10]>=biggest401){
          biggest401=ends[10];
        }
        if(biggest401 == 1){
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        //FINXME code
        if(biggest401 == 0){
          S310=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread392(int [] tdone, int [] ends){
        switch(S252){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S245){
          case 0 : 
            if(enable.getprestatus()){//sysj\SystemCoordinator.sysj line: 18, column: 9
              System.out.println("it works");//sysj\SystemCoordinator.sysj line: 19, column: 3
              S245=1;
              tester_1.setPresent();//sysj\SystemCoordinator.sysj line: 20, column: 3
              currsigs.addElement(tester_1);
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
            tester_1.setPresent();//sysj\SystemCoordinator.sysj line: 20, column: 3
            currsigs.addElement(tester_1);
            active[2]=1;
            ends[2]=1;
            tdone[2]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread389(int [] tdone, int [] ends){
        S308=1;
    if(tester_1.getprestatus()){//sysj\SystemCoordinator.sysj line: 37, column: 24
      capAddE.setPresent();//sysj\SystemCoordinator.sysj line: 37, column: 32
      currsigs.addElement(capAddE);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread388(int [] tdone, int [] ends){
        S300=1;
    if(empty.getprestatus()){//sysj\SystemCoordinator.sysj line: 35, column: 24
      emptyE.setPresent();//sysj\SystemCoordinator.sysj line: 35, column: 31
      currsigs.addElement(emptyE);
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread387(int [] tdone, int [] ends){
        S292=1;
    if(armAtDest.getprestatus()){//sysj\SystemCoordinator.sysj line: 33, column: 24
      armAtDestE.setPresent();//sysj\SystemCoordinator.sysj line: 33, column: 35
      currsigs.addElement(armAtDestE);
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread386(int [] tdone, int [] ends){
        S284=1;
    if(armAtSource.getprestatus()){//sysj\SystemCoordinator.sysj line: 31, column: 24
      armAtSourceE.setPresent();//sysj\SystemCoordinator.sysj line: 31, column: 37
      currsigs.addElement(armAtSourceE);
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread385(int [] tdone, int [] ends){
        S276=1;
    if(WPgripped.getprestatus()){//sysj\SystemCoordinator.sysj line: 29, column: 24
      WPgrippedE.setPresent();//sysj\SystemCoordinator.sysj line: 29, column: 35
      currsigs.addElement(WPgrippedE);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread384(int [] tdone, int [] ends){
        S268=1;
    if(pusherExtended.getprestatus()){//sysj\SystemCoordinator.sysj line: 27, column: 24
      pusherExtendedE.setPresent();//sysj\SystemCoordinator.sysj line: 27, column: 40
      currsigs.addElement(pusherExtendedE);
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread383(int [] tdone, int [] ends){
        S260=1;
    S254=0;
    if(pusherRetracted.getprestatus()){//sysj\SystemCoordinator.sysj line: 25, column: 24
      pusherRetractedE.setPresent();//sysj\SystemCoordinator.sysj line: 25, column: 41
      currsigs.addElement(pusherRetractedE);
      S254=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S254=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread382(int [] tdone, int [] ends){
        S310=1;
    thread383(tdone,ends);
    thread384(tdone,ends);
    thread385(tdone,ends);
    thread386(tdone,ends);
    thread387(tdone,ends);
    thread388(tdone,ends);
    thread389(tdone,ends);
    int biggest390 = 0;
    if(ends[4]>=biggest390){
      biggest390=ends[4];
    }
    if(ends[5]>=biggest390){
      biggest390=ends[5];
    }
    if(ends[6]>=biggest390){
      biggest390=ends[6];
    }
    if(ends[7]>=biggest390){
      biggest390=ends[7];
    }
    if(ends[8]>=biggest390){
      biggest390=ends[8];
    }
    if(ends[9]>=biggest390){
      biggest390=ends[9];
    }
    if(ends[10]>=biggest390){
      biggest390=ends[10];
    }
    if(biggest390 == 1){
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread381(int [] tdone, int [] ends){
        S252=1;
    S245=0;
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
      switch(S379){
        case 0 : 
          S379=0;
          break RUN;
        
        case 1 : 
          S379=2;
          S379=2;
          tester_1.setClear();//sysj\SystemCoordinator.sysj line: 14, column: 2
          new Thread(new GUI()).start();//sysj\SystemCoordinator.sysj line: 15, column: 2
          thread381(tdone,ends);
          thread382(tdone,ends);
          int biggest391 = 0;
          if(ends[2]>=biggest391){
            biggest391=ends[2];
          }
          if(ends[3]>=biggest391){
            biggest391=ends[3];
          }
          if(biggest391 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          tester_1.setClear();//sysj\SystemCoordinator.sysj line: 14, column: 2
          thread392(tdone,ends);
          thread393(tdone,ends);
          int biggest402 = 0;
          if(ends[2]>=biggest402){
            biggest402=ends[2];
          }
          if(ends[3]>=biggest402){
            biggest402=ends[3];
          }
          if(biggest402 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest402 == 0){
            S379=0;
            active[1]=0;
            ends[1]=0;
            S379=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    tester_1 = new Signal();
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
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          enable.gethook();
          refill.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      enable.setpreclear();
      refill.setpreclear();
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      pusherRetractedE.setpreclear();
      pusherExtendedE.setpreclear();
      WPgrippedE.setpreclear();
      armAtSourceE.setpreclear();
      armAtDestE.setpreclear();
      emptyE.setpreclear();
      capAddE.setpreclear();
      tester_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherExtend.getStatus() ? pusherExtend.setprepresent() : pusherExtend.setpreclear();
      pusherExtend.setpreval(pusherExtend.getValue());
      pusherExtend.setClear();
      dummyint = vacOn.getStatus() ? vacOn.setprepresent() : vacOn.setpreclear();
      vacOn.setpreval(vacOn.getValue());
      vacOn.setClear();
      dummyint = armSource.getStatus() ? armSource.setprepresent() : armSource.setpreclear();
      armSource.setpreval(armSource.getValue());
      armSource.setClear();
      dummyint = armDest.getStatus() ? armDest.setprepresent() : armDest.setpreclear();
      armDest.setpreval(armDest.getValue());
      armDest.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = refill.getStatus() ? refill.setprepresent() : refill.setpreclear();
      refill.setpreval(refill.getValue());
      refill.setClear();
      pusherRetracted.sethook();
      pusherRetracted.setClear();
      pusherExtended.sethook();
      pusherExtended.setClear();
      WPgripped.sethook();
      WPgripped.setClear();
      armAtSource.sethook();
      armAtSource.setClear();
      armAtDest.sethook();
      armAtDest.setClear();
      empty.sethook();
      empty.setClear();
      pusherRetractedE.sethook();
      pusherRetractedE.setClear();
      pusherExtendedE.sethook();
      pusherExtendedE.setClear();
      WPgrippedE.sethook();
      WPgrippedE.setClear();
      armAtSourceE.sethook();
      armAtSourceE.setClear();
      armAtDestE.sethook();
      armAtDestE.setClear();
      emptyE.sethook();
      emptyE.setClear();
      capAddE.sethook();
      capAddE.setClear();
      tester_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        enable.gethook();
        refill.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
