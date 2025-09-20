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
  private int S221 = 1;
  private int S60 = 1;
  private int S12 = 1;
  private int S110 = 1;
  private int S68 = 1;
  private int S62 = 1;
  private int S76 = 1;
  private int S84 = 1;
  private int S92 = 1;
  private int S100 = 1;
  private int S108 = 1;
  
  private int[] ends = new int[10];
  private int[] tdone = new int[10];
  
  public void thread240(int [] tdone, int [] ends){
        switch(S108){
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

  public void thread239(int [] tdone, int [] ends){
        switch(S100){
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

  public void thread238(int [] tdone, int [] ends){
        switch(S92){
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

  public void thread237(int [] tdone, int [] ends){
        switch(S84){
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

  public void thread236(int [] tdone, int [] ends){
        switch(S76){
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

  public void thread235(int [] tdone, int [] ends){
        switch(S68){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S62){
          case 0 : 
            S62=0;
            if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 28, column: 24
              pusherRetractedE.setPresent();//sysj\plant.sysj line: 28, column: 41
              currsigs.addElement(pusherRetractedE);
              S62=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S62=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
          case 1 : 
            S62=1;
            S62=0;
            if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 28, column: 24
              pusherRetractedE.setPresent();//sysj\plant.sysj line: 28, column: 41
              currsigs.addElement(pusherRetractedE);
              S62=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              S62=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread234(int [] tdone, int [] ends){
        switch(S110){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        thread235(tdone,ends);
        thread236(tdone,ends);
        thread237(tdone,ends);
        thread238(tdone,ends);
        thread239(tdone,ends);
        thread240(tdone,ends);
        int biggest241 = 0;
        if(ends[4]>=biggest241){
          biggest241=ends[4];
        }
        if(ends[5]>=biggest241){
          biggest241=ends[5];
        }
        if(ends[6]>=biggest241){
          biggest241=ends[6];
        }
        if(ends[7]>=biggest241){
          biggest241=ends[7];
        }
        if(ends[8]>=biggest241){
          biggest241=ends[8];
        }
        if(ends[9]>=biggest241){
          biggest241=ends[9];
        }
        if(biggest241 == 1){
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        //FINXME code
        if(biggest241 == 0){
          S110=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread233(int [] tdone, int [] ends){
        switch(S60){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S12){
          case 0 : 
            if(enable.getprestatus()){//sysj\plant.sysj line: 15, column: 9
              S12=1;
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
              S12=2;
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
              S12=0;
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

  public void thread230(int [] tdone, int [] ends){
        S108=1;
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

  public void thread229(int [] tdone, int [] ends){
        S100=1;
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

  public void thread228(int [] tdone, int [] ends){
        S92=1;
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

  public void thread227(int [] tdone, int [] ends){
        S84=1;
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

  public void thread226(int [] tdone, int [] ends){
        S76=1;
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

  public void thread225(int [] tdone, int [] ends){
        S68=1;
    S62=0;
    if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 28, column: 24
      pusherRetractedE.setPresent();//sysj\plant.sysj line: 28, column: 41
      currsigs.addElement(pusherRetractedE);
      S62=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S62=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread224(int [] tdone, int [] ends){
        S110=1;
    thread225(tdone,ends);
    thread226(tdone,ends);
    thread227(tdone,ends);
    thread228(tdone,ends);
    thread229(tdone,ends);
    thread230(tdone,ends);
    int biggest231 = 0;
    if(ends[4]>=biggest231){
      biggest231=ends[4];
    }
    if(ends[5]>=biggest231){
      biggest231=ends[5];
    }
    if(ends[6]>=biggest231){
      biggest231=ends[6];
    }
    if(ends[7]>=biggest231){
      biggest231=ends[7];
    }
    if(ends[8]>=biggest231){
      biggest231=ends[8];
    }
    if(ends[9]>=biggest231){
      biggest231=ends[9];
    }
    if(biggest231 == 1){
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread223(int [] tdone, int [] ends){
        S60=1;
    S12=0;
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
      switch(S221){
        case 0 : 
          S221=0;
          break RUN;
        
        case 1 : 
          S221=2;
          S221=2;
          new Thread(new GUI()).start();//sysj\plant.sysj line: 12, column: 2
          thread223(tdone,ends);
          thread224(tdone,ends);
          int biggest232 = 0;
          if(ends[2]>=biggest232){
            biggest232=ends[2];
          }
          if(ends[3]>=biggest232){
            biggest232=ends[3];
          }
          if(biggest232 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          thread233(tdone,ends);
          thread234(tdone,ends);
          int biggest242 = 0;
          if(ends[2]>=biggest242){
            biggest242=ends[2];
          }
          if(ends[3]>=biggest242){
            biggest242=ends[3];
          }
          if(biggest242 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest242 == 0){
            S221=0;
            active[1]=0;
            ends[1]=0;
            S221=0;
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
