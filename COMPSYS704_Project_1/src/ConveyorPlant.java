import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class ConveyorPlant extends ClockDomain{
  public ConveyorPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal motConveyorOnOff = new Signal("motConveyorOnOff", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal bottleLeftPos5 = new Signal("bottleLeftPos5", Signal.OUTPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  private int S306 = 1;
  private int S294 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S306){
        case 0 : 
          S306=0;
          break RUN;
        
        case 1 : 
          S306=2;
          S306=2;
          System.out.println("ConveyorPlant running...");//sysj\ConveyorPlant.sysj line: 6, column: 2
          S294=0;
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          switch(S294){
            case 0 : 
              if(motConveyorOnOff.getprestatus()){//sysj\ConveyorPlant.sysj line: 10, column: 9
                bottleAtPos1.setPresent();//sysj\ConveyorPlant.sysj line: 13, column: 3
                currsigs.addElement(bottleAtPos1);
                System.out.println("Bottle arrived at Pos1");//sysj\ConveyorPlant.sysj line: 14, column: 3
                S294=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              else {
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
            case 1 : 
              S294=1;
              S294=2;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 2 : 
              S294=2;
              bottleAtPos5.setPresent();//sysj\ConveyorPlant.sysj line: 18, column: 3
              currsigs.addElement(bottleAtPos5);
              System.out.println("Bottle moved to Pos5");//sysj\ConveyorPlant.sysj line: 19, column: 3
              S294=3;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 3 : 
              S294=3;
              S294=4;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 4 : 
              S294=4;
              bottleLeftPos5.setPresent();//sysj\ConveyorPlant.sysj line: 23, column: 3
              currsigs.addElement(bottleLeftPos5);
              System.out.println("Bottle left Pos5");//sysj\ConveyorPlant.sysj line: 24, column: 3
              S294=5;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
            case 5 : 
              S294=5;
              S294=0;
              active[1]=1;
              ends[1]=1;
              break RUN;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1};
    char [] paused1 = {0, 0};
    char [] suspended1 = {0, 0};
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
          motConveyorOnOff.gethook();
          df = true;
        }
        runClockDomain();
      }
      motConveyorOnOff.setpreclear();
      bottleAtPos1.setpreclear();
      bottleLeftPos5.setpreclear();
      bottleAtPos5.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = motConveyorOnOff.getStatus() ? motConveyorOnOff.setprepresent() : motConveyorOnOff.setpreclear();
      motConveyorOnOff.setpreval(motConveyorOnOff.getValue());
      motConveyorOnOff.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      bottleLeftPos5.sethook();
      bottleLeftPos5.setClear();
      bottleAtPos5.sethook();
      bottleAtPos5.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        motConveyorOnOff.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
