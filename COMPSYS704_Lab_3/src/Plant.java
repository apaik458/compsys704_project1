import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\plant.sysj line: 1, column: 1

public class Plant extends ClockDomain{
  public Plant(String name){super(name);}
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
  private int S242 = 1;
  private int S81 = 1;
  private int S33 = 1;
  private int S131 = 1;
  private int S89 = 1;
  private int S83 = 1;
  private int S97 = 1;
  private int S105 = 1;
  private int S113 = 1;
  private int S121 = 1;
  private int S129 = 1;
  
  private int[] ends = new int[10];
  private int[] tdone = new int[10];
  
  public void thread261(int [] tdone, int [] ends){
        switch(S129){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\plant.sysj line: 38, column: 24
          emptyE.setPresent();//sysj\plant.sysj line: 38, column: 31
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

  public void thread260(int [] tdone, int [] ends){
        switch(S121){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\plant.sysj line: 36, column: 24
          armAtDestE.setPresent();//sysj\plant.sysj line: 36, column: 35
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

  public void thread259(int [] tdone, int [] ends){
        switch(S113){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\plant.sysj line: 34, column: 24
          armAtSourceE.setPresent();//sysj\plant.sysj line: 34, column: 37
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

  public void thread258(int [] tdone, int [] ends){
        switch(S105){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\plant.sysj line: 32, column: 24
          WPgrippedE.setPresent();//sysj\plant.sysj line: 32, column: 35
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

  public void thread257(int [] tdone, int [] ends){
        switch(S97){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 30, column: 24
          pusherExtendedE.setPresent();//sysj\plant.sysj line: 30, column: 40
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

  public void thread256(int [] tdone, int [] ends){
        switch(S89){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S83){
          case 0 : 
            S83=0;
            if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 28, column: 24
              pusherRetractedE.setPresent();//sysj\plant.sysj line: 28, column: 41
              currsigs.addElement(pusherRetractedE);
              S83=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S83=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            S83=1;
            S83=0;
            if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 28, column: 24
              pusherRetractedE.setPresent();//sysj\plant.sysj line: 28, column: 41
              currsigs.addElement(pusherRetractedE);
              S83=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S83=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread255(int [] tdone, int [] ends){
        switch(S131){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        thread256(tdone,ends);
        thread257(tdone,ends);
        thread258(tdone,ends);
        thread259(tdone,ends);
        thread260(tdone,ends);
        thread261(tdone,ends);
        int biggest262 = 0;
        if(ends[4]>=biggest262){
          biggest262=ends[4];
        }
        if(ends[5]>=biggest262){
          biggest262=ends[5];
        }
        if(ends[6]>=biggest262){
          biggest262=ends[6];
        }
        if(ends[7]>=biggest262){
          biggest262=ends[7];
        }
        if(ends[8]>=biggest262){
          biggest262=ends[8];
        }
        if(ends[9]>=biggest262){
          biggest262=ends[9];
        }
        if(biggest262 == 1){
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        //FINXME code
        if(biggest262 == 0){
          S131=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread254(int [] tdone, int [] ends){
        switch(S81){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S33){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 15, column: 9
              S33=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 17, column: 4
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 19, column: 9
              S33=2;
              WPgripped.setPresent();//sysj\plant.sysj line: 21, column: 4
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
            if(enable.getprestatus()){//sysj\plant.sysj line: 20, column: 9
              S33=0;
              System.out.println("It works");//sysj\plant.sysj line: 16, column: 3
              armAtSource.setPresent();//sysj\plant.sysj line: 17, column: 4
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              WPgripped.setPresent();//sysj\plant.sysj line: 21, column: 4
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

  public void thread251(int [] tdone, int [] ends){
        S129=1;
    if(empty.getprestatus()){//sysj\plant.sysj line: 38, column: 24
      emptyE.setPresent();//sysj\plant.sysj line: 38, column: 31
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

  public void thread250(int [] tdone, int [] ends){
        S121=1;
    if(armAtDest.getprestatus()){//sysj\plant.sysj line: 36, column: 24
      armAtDestE.setPresent();//sysj\plant.sysj line: 36, column: 35
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

  public void thread249(int [] tdone, int [] ends){
        S113=1;
    if(armAtSource.getprestatus()){//sysj\plant.sysj line: 34, column: 24
      armAtSourceE.setPresent();//sysj\plant.sysj line: 34, column: 37
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

  public void thread248(int [] tdone, int [] ends){
        S105=1;
    if(WPgripped.getprestatus()){//sysj\plant.sysj line: 32, column: 24
      WPgrippedE.setPresent();//sysj\plant.sysj line: 32, column: 35
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

  public void thread247(int [] tdone, int [] ends){
        S97=1;
    if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 30, column: 24
      pusherExtendedE.setPresent();//sysj\plant.sysj line: 30, column: 40
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

  public void thread246(int [] tdone, int [] ends){
        S89=1;
    S83=0;
    if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 28, column: 24
      pusherRetractedE.setPresent();//sysj\plant.sysj line: 28, column: 41
      currsigs.addElement(pusherRetractedE);
      S83=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S83=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread245(int [] tdone, int [] ends){
        S131=1;
    thread246(tdone,ends);
    thread247(tdone,ends);
    thread248(tdone,ends);
    thread249(tdone,ends);
    thread250(tdone,ends);
    thread251(tdone,ends);
    int biggest252 = 0;
    if(ends[4]>=biggest252){
      biggest252=ends[4];
    }
    if(ends[5]>=biggest252){
      biggest252=ends[5];
    }
    if(ends[6]>=biggest252){
      biggest252=ends[6];
    }
    if(ends[7]>=biggest252){
      biggest252=ends[7];
    }
    if(ends[8]>=biggest252){
      biggest252=ends[8];
    }
    if(ends[9]>=biggest252){
      biggest252=ends[9];
    }
    if(biggest252 == 1){
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread244(int [] tdone, int [] ends){
        S81=1;
    S33=0;
    System.out.println("It works");//sysj\plant.sysj line: 16, column: 3
    armAtSource.setPresent();//sysj\plant.sysj line: 17, column: 4
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
      switch(S242){
        case 0 : 
          S242=0;
          break RUN;
        
        case 1 : 
          S242=2;
          S242=2;
          new Thread(new GUI()).start();//sysj\plant.sysj line: 12, column: 2
          thread244(tdone,ends);
          thread245(tdone,ends);
          int biggest253 = 0;
          if(ends[2]>=biggest253){
            biggest253=ends[2];
          }
          if(ends[3]>=biggest253){
            biggest253=ends[3];
          }
          if(biggest253 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread254(tdone,ends);
          thread255(tdone,ends);
          int biggest263 = 0;
          if(ends[2]>=biggest263){
            biggest263=ends[2];
          }
          if(ends[3]>=biggest263){
            biggest263=ends[3];
          }
          if(biggest263 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest263 == 0){
            S242=0;
            active[1]=0;
            ends[1]=0;
            S242=0;
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
