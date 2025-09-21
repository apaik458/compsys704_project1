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
  private int S462 = 1;
  private int S301 = 1;
  private int S253 = 1;
  private int S351 = 1;
  private int S309 = 1;
  private int S303 = 1;
  private int S317 = 1;
  private int S325 = 1;
  private int S333 = 1;
  private int S341 = 1;
  private int S349 = 1;
  
  private int[] ends = new int[10];
  private int[] tdone = new int[10];
  
  public void thread481(int [] tdone, int [] ends){
        switch(S349){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\SystemCoordinator.sysj line: 38, column: 24
          emptyE.setPresent();//sysj\SystemCoordinator.sysj line: 38, column: 31
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

  public void thread480(int [] tdone, int [] ends){
        switch(S341){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\SystemCoordinator.sysj line: 36, column: 24
          armAtDestE.setPresent();//sysj\SystemCoordinator.sysj line: 36, column: 35
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

  public void thread479(int [] tdone, int [] ends){
        switch(S333){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\SystemCoordinator.sysj line: 34, column: 24
          armAtSourceE.setPresent();//sysj\SystemCoordinator.sysj line: 34, column: 37
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

  public void thread478(int [] tdone, int [] ends){
        switch(S325){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\SystemCoordinator.sysj line: 32, column: 24
          WPgrippedE.setPresent();//sysj\SystemCoordinator.sysj line: 32, column: 35
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

  public void thread477(int [] tdone, int [] ends){
        switch(S317){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\SystemCoordinator.sysj line: 30, column: 24
          pusherExtendedE.setPresent();//sysj\SystemCoordinator.sysj line: 30, column: 40
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

  public void thread476(int [] tdone, int [] ends){
        switch(S309){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S303){
          case 0 : 
            S303=0;
            if(pusherRetracted.getprestatus()){//sysj\SystemCoordinator.sysj line: 28, column: 24
              pusherRetractedE.setPresent();//sysj\SystemCoordinator.sysj line: 28, column: 41
              currsigs.addElement(pusherRetractedE);
              S303=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S303=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            S303=1;
            S303=0;
            if(pusherRetracted.getprestatus()){//sysj\SystemCoordinator.sysj line: 28, column: 24
              pusherRetractedE.setPresent();//sysj\SystemCoordinator.sysj line: 28, column: 41
              currsigs.addElement(pusherRetractedE);
              S303=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S303=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread475(int [] tdone, int [] ends){
        switch(S351){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        thread476(tdone,ends);
        thread477(tdone,ends);
        thread478(tdone,ends);
        thread479(tdone,ends);
        thread480(tdone,ends);
        thread481(tdone,ends);
        int biggest482 = 0;
        if(ends[4]>=biggest482){
          biggest482=ends[4];
        }
        if(ends[5]>=biggest482){
          biggest482=ends[5];
        }
        if(ends[6]>=biggest482){
          biggest482=ends[6];
        }
        if(ends[7]>=biggest482){
          biggest482=ends[7];
        }
        if(ends[8]>=biggest482){
          biggest482=ends[8];
        }
        if(ends[9]>=biggest482){
          biggest482=ends[9];
        }
        if(biggest482 == 1){
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        //FINXME code
        if(biggest482 == 0){
          S351=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread474(int [] tdone, int [] ends){
        switch(S301){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S253){
          case 0 : 
            if(enable.getprestatus()){//sysj\SystemCoordinator.sysj line: 15, column: 9
              S253=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\SystemCoordinator.sysj line: 17, column: 4
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\SystemCoordinator.sysj line: 19, column: 9
              S253=2;
              WPgripped.setPresent();//sysj\SystemCoordinator.sysj line: 21, column: 4
              currsigs.addElement(WPgripped);
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
            if(enable.getprestatus()){//sysj\SystemCoordinator.sysj line: 20, column: 9
              S253=0;
              System.out.println("It works");//sysj\SystemCoordinator.sysj line: 16, column: 3
              armAtSource.setPresent();//sysj\SystemCoordinator.sysj line: 17, column: 4
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              WPgripped.setPresent();//sysj\SystemCoordinator.sysj line: 21, column: 4
              currsigs.addElement(WPgripped);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread471(int [] tdone, int [] ends){
        S349=1;
    if(empty.getprestatus()){//sysj\SystemCoordinator.sysj line: 38, column: 24
      emptyE.setPresent();//sysj\SystemCoordinator.sysj line: 38, column: 31
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

  public void thread470(int [] tdone, int [] ends){
        S341=1;
    if(armAtDest.getprestatus()){//sysj\SystemCoordinator.sysj line: 36, column: 24
      armAtDestE.setPresent();//sysj\SystemCoordinator.sysj line: 36, column: 35
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

  public void thread469(int [] tdone, int [] ends){
        S333=1;
    if(armAtSource.getprestatus()){//sysj\SystemCoordinator.sysj line: 34, column: 24
      armAtSourceE.setPresent();//sysj\SystemCoordinator.sysj line: 34, column: 37
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

  public void thread468(int [] tdone, int [] ends){
        S325=1;
    if(WPgripped.getprestatus()){//sysj\SystemCoordinator.sysj line: 32, column: 24
      WPgrippedE.setPresent();//sysj\SystemCoordinator.sysj line: 32, column: 35
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

  public void thread467(int [] tdone, int [] ends){
        S317=1;
    if(pusherExtended.getprestatus()){//sysj\SystemCoordinator.sysj line: 30, column: 24
      pusherExtendedE.setPresent();//sysj\SystemCoordinator.sysj line: 30, column: 40
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

  public void thread466(int [] tdone, int [] ends){
        S309=1;
    S303=0;
    if(pusherRetracted.getprestatus()){//sysj\SystemCoordinator.sysj line: 28, column: 24
      pusherRetractedE.setPresent();//sysj\SystemCoordinator.sysj line: 28, column: 41
      currsigs.addElement(pusherRetractedE);
      S303=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S303=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread465(int [] tdone, int [] ends){
        S351=1;
    thread466(tdone,ends);
    thread467(tdone,ends);
    thread468(tdone,ends);
    thread469(tdone,ends);
    thread470(tdone,ends);
    thread471(tdone,ends);
    int biggest472 = 0;
    if(ends[4]>=biggest472){
      biggest472=ends[4];
    }
    if(ends[5]>=biggest472){
      biggest472=ends[5];
    }
    if(ends[6]>=biggest472){
      biggest472=ends[6];
    }
    if(ends[7]>=biggest472){
      biggest472=ends[7];
    }
    if(ends[8]>=biggest472){
      biggest472=ends[8];
    }
    if(ends[9]>=biggest472){
      biggest472=ends[9];
    }
    if(biggest472 == 1){
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread464(int [] tdone, int [] ends){
        S301=1;
    S253=0;
    System.out.println("It works");//sysj\SystemCoordinator.sysj line: 16, column: 3
    armAtSource.setPresent();//sysj\SystemCoordinator.sysj line: 17, column: 4
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
      switch(S462){
        case 0 : 
          S462=0;
          break RUN;
        
        case 1 : 
          S462=2;
          S462=2;
          new Thread(new GUI()).start();//sysj\SystemCoordinator.sysj line: 12, column: 2
          thread464(tdone,ends);
          thread465(tdone,ends);
          int biggest473 = 0;
          if(ends[2]>=biggest473){
            biggest473=ends[2];
          }
          if(ends[3]>=biggest473){
            biggest473=ends[3];
          }
          if(biggest473 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread474(tdone,ends);
          thread475(tdone,ends);
          int biggest483 = 0;
          if(ends[2]>=biggest483){
            biggest483=ends[2];
          }
          if(ends[3]>=biggest483){
            biggest483=ends[3];
          }
          if(biggest483 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest483 == 0){
            S462=0;
            active[1]=0;
            ends[1]=0;
            S462=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
