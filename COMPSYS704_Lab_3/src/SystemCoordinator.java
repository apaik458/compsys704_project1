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
  public Signal capAdd = new Signal("capAdd", Signal.OUTPUT);
  public Signal pusherRetractedE = new Signal("pusherRetractedE", Signal.OUTPUT);
  public Signal pusherExtendedE = new Signal("pusherExtendedE", Signal.OUTPUT);
  public Signal WPgrippedE = new Signal("WPgrippedE", Signal.OUTPUT);
  public Signal armAtSourceE = new Signal("armAtSourceE", Signal.OUTPUT);
  public Signal armAtDestE = new Signal("armAtDestE", Signal.OUTPUT);
  public Signal emptyE = new Signal("emptyE", Signal.OUTPUT);
  public Signal capAddE = new Signal("capAddE", Signal.OUTPUT);
  private Signal tester_1;
  private int S497 = 1;
  private int S302 = 1;
  private int S254 = 1;
  private int S369 = 1;
  private int S310 = 1;
  private int S304 = 1;
  private int S318 = 1;
  private int S326 = 1;
  private int S334 = 1;
  private int S342 = 1;
  private int S350 = 1;
  private int S367 = 1;
  private int S355 = 1;
  
  private int[] ends = new int[11];
  private int[] tdone = new int[11];
  
  public void thread518(int [] tdone, int [] ends){
        switch(S367){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S355){
          case 0 : 
            capAddE.setPresent();//sysj\SystemCoordinator.sysj line: 44, column: 32
            currsigs.addElement(capAddE);
            active[10]=1;
            ends[10]=1;
            tdone[10]=1;
            break;
          
          case 1 : 
            S355=1;
            S355=0;
            if(capAdd.getprestatus()){//sysj\SystemCoordinator.sysj line: 44, column: 24
              capAddE.setPresent();//sysj\SystemCoordinator.sysj line: 44, column: 32
              currsigs.addElement(capAddE);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S355=1;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread517(int [] tdone, int [] ends){
        switch(S350){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\SystemCoordinator.sysj line: 42, column: 24
          emptyE.setPresent();//sysj\SystemCoordinator.sysj line: 42, column: 31
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

  public void thread516(int [] tdone, int [] ends){
        switch(S342){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\SystemCoordinator.sysj line: 40, column: 24
          armAtDestE.setPresent();//sysj\SystemCoordinator.sysj line: 40, column: 35
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

  public void thread515(int [] tdone, int [] ends){
        switch(S334){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\SystemCoordinator.sysj line: 38, column: 24
          armAtSourceE.setPresent();//sysj\SystemCoordinator.sysj line: 38, column: 37
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

  public void thread514(int [] tdone, int [] ends){
        switch(S326){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\SystemCoordinator.sysj line: 36, column: 24
          WPgrippedE.setPresent();//sysj\SystemCoordinator.sysj line: 36, column: 35
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

  public void thread513(int [] tdone, int [] ends){
        switch(S318){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\SystemCoordinator.sysj line: 34, column: 24
          pusherExtendedE.setPresent();//sysj\SystemCoordinator.sysj line: 34, column: 40
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

  public void thread512(int [] tdone, int [] ends){
        switch(S310){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S304){
          case 0 : 
            S304=0;
            if(pusherRetracted.getprestatus()){//sysj\SystemCoordinator.sysj line: 32, column: 24
              pusherRetractedE.setPresent();//sysj\SystemCoordinator.sysj line: 32, column: 41
              currsigs.addElement(pusherRetractedE);
              S304=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S304=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            S304=1;
            S304=0;
            if(pusherRetracted.getprestatus()){//sysj\SystemCoordinator.sysj line: 32, column: 24
              pusherRetractedE.setPresent();//sysj\SystemCoordinator.sysj line: 32, column: 41
              currsigs.addElement(pusherRetractedE);
              S304=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S304=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread511(int [] tdone, int [] ends){
        switch(S369){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        thread512(tdone,ends);
        thread513(tdone,ends);
        thread514(tdone,ends);
        thread515(tdone,ends);
        thread516(tdone,ends);
        thread517(tdone,ends);
        thread518(tdone,ends);
        int biggest519 = 0;
        if(ends[4]>=biggest519){
          biggest519=ends[4];
        }
        if(ends[5]>=biggest519){
          biggest519=ends[5];
        }
        if(ends[6]>=biggest519){
          biggest519=ends[6];
        }
        if(ends[7]>=biggest519){
          biggest519=ends[7];
        }
        if(ends[8]>=biggest519){
          biggest519=ends[8];
        }
        if(ends[9]>=biggest519){
          biggest519=ends[9];
        }
        if(ends[10]>=biggest519){
          biggest519=ends[10];
        }
        if(biggest519 == 1){
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        //FINXME code
        if(biggest519 == 0){
          S369=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread510(int [] tdone, int [] ends){
        switch(S302){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S254){
          case 0 : 
            if(enable.getprestatus()){//sysj\SystemCoordinator.sysj line: 19, column: 10
              S254=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\SystemCoordinator.sysj line: 21, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\SystemCoordinator.sysj line: 23, column: 10
              S254=2;
              capAdd.setPresent();//sysj\SystemCoordinator.sysj line: 25, column: 5
              currsigs.addElement(capAdd);
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
            if(enable.getprestatus()){//sysj\SystemCoordinator.sysj line: 24, column: 10
              S254=0;
              System.out.println("It works");//sysj\SystemCoordinator.sysj line: 20, column: 4
              armAtSource.setPresent();//sysj\SystemCoordinator.sysj line: 21, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              capAdd.setPresent();//sysj\SystemCoordinator.sysj line: 25, column: 5
              currsigs.addElement(capAdd);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread507(int [] tdone, int [] ends){
        S367=1;
    S355=0;
    if(capAdd.getprestatus()){//sysj\SystemCoordinator.sysj line: 44, column: 24
      capAddE.setPresent();//sysj\SystemCoordinator.sysj line: 44, column: 32
      currsigs.addElement(capAddE);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      S355=1;
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread506(int [] tdone, int [] ends){
        S350=1;
    if(empty.getprestatus()){//sysj\SystemCoordinator.sysj line: 42, column: 24
      emptyE.setPresent();//sysj\SystemCoordinator.sysj line: 42, column: 31
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

  public void thread505(int [] tdone, int [] ends){
        S342=1;
    if(armAtDest.getprestatus()){//sysj\SystemCoordinator.sysj line: 40, column: 24
      armAtDestE.setPresent();//sysj\SystemCoordinator.sysj line: 40, column: 35
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

  public void thread504(int [] tdone, int [] ends){
        S334=1;
    if(armAtSource.getprestatus()){//sysj\SystemCoordinator.sysj line: 38, column: 24
      armAtSourceE.setPresent();//sysj\SystemCoordinator.sysj line: 38, column: 37
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

  public void thread503(int [] tdone, int [] ends){
        S326=1;
    if(WPgripped.getprestatus()){//sysj\SystemCoordinator.sysj line: 36, column: 24
      WPgrippedE.setPresent();//sysj\SystemCoordinator.sysj line: 36, column: 35
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

  public void thread502(int [] tdone, int [] ends){
        S318=1;
    if(pusherExtended.getprestatus()){//sysj\SystemCoordinator.sysj line: 34, column: 24
      pusherExtendedE.setPresent();//sysj\SystemCoordinator.sysj line: 34, column: 40
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

  public void thread501(int [] tdone, int [] ends){
        S310=1;
    S304=0;
    if(pusherRetracted.getprestatus()){//sysj\SystemCoordinator.sysj line: 32, column: 24
      pusherRetractedE.setPresent();//sysj\SystemCoordinator.sysj line: 32, column: 41
      currsigs.addElement(pusherRetractedE);
      S304=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S304=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread500(int [] tdone, int [] ends){
        S369=1;
    thread501(tdone,ends);
    thread502(tdone,ends);
    thread503(tdone,ends);
    thread504(tdone,ends);
    thread505(tdone,ends);
    thread506(tdone,ends);
    thread507(tdone,ends);
    int biggest508 = 0;
    if(ends[4]>=biggest508){
      biggest508=ends[4];
    }
    if(ends[5]>=biggest508){
      biggest508=ends[5];
    }
    if(ends[6]>=biggest508){
      biggest508=ends[6];
    }
    if(ends[7]>=biggest508){
      biggest508=ends[7];
    }
    if(ends[8]>=biggest508){
      biggest508=ends[8];
    }
    if(ends[9]>=biggest508){
      biggest508=ends[9];
    }
    if(ends[10]>=biggest508){
      biggest508=ends[10];
    }
    if(biggest508 == 1){
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread499(int [] tdone, int [] ends){
        S302=1;
    S254=0;
    System.out.println("It works");//sysj\SystemCoordinator.sysj line: 20, column: 4
    armAtSource.setPresent();//sysj\SystemCoordinator.sysj line: 21, column: 5
    currsigs.addElement(armAtSource);
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
      switch(S497){
        case 0 : 
          S497=0;
          break RUN;
        
        case 1 : 
          S497=2;
          S497=2;
          tester_1.setClear();//sysj\SystemCoordinator.sysj line: 14, column: 2
          new Thread(new GUI()).start();//sysj\SystemCoordinator.sysj line: 15, column: 2
          thread499(tdone,ends);
          thread500(tdone,ends);
          int biggest509 = 0;
          if(ends[2]>=biggest509){
            biggest509=ends[2];
          }
          if(ends[3]>=biggest509){
            biggest509=ends[3];
          }
          if(biggest509 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          tester_1.setClear();//sysj\SystemCoordinator.sysj line: 14, column: 2
          thread510(tdone,ends);
          thread511(tdone,ends);
          int biggest520 = 0;
          if(ends[2]>=biggest520){
            biggest520=ends[2];
          }
          if(ends[3]>=biggest520){
            biggest520=ends[3];
          }
          if(biggest520 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest520 == 0){
            S497=0;
            active[1]=0;
            ends[1]=0;
            S497=0;
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
      capAdd.setpreclear();
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
      capAdd.sethook();
      capAdd.setClear();
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
