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
  public Signal systemEnable = new Signal("systemEnable", Signal.INPUT);
  public Signal motConveyorOnOff = new Signal("motConveyorOnOff", Signal.INPUT);
  public Signal motorPos1On = new Signal("motorPos1On", Signal.INPUT);
  public Signal motorPos5On = new Signal("motorPos5On", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.INPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.INPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.INPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal magReq = new Signal("magReq", Signal.INPUT);
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.INPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.INPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.INPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal bottleLeftPos5 = new Signal("bottleLeftPos5", Signal.OUTPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.OUTPUT);
  public Signal valveInjectorActive = new Signal("valveInjectorActive", Signal.OUTPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.OUTPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.OUTPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal magEmpty = new Signal("magEmpty", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.OUTPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.OUTPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.OUTPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.OUTPUT);
  public Signal cylClampedBottle = new Signal("cylClampedBottle", Signal.OUTPUT);
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.OUTPUT);
  public Signal moveToPos5 = new Signal("moveToPos5", Signal.OUTPUT);
  public Signal moveToPos4 = new Signal("moveToPos4", Signal.OUTPUT);
  public Signal moveToPos3 = new Signal("moveToPos3", Signal.OUTPUT);
  public Signal moveToPos2 = new Signal("moveToPos2", Signal.OUTPUT);
  public Signal bottleAtPos1E = new Signal("bottleAtPos1E", Signal.OUTPUT);
  public Signal bottleAtPos2E = new Signal("bottleAtPos2E", Signal.OUTPUT);
  public Signal bottleAtPos3E = new Signal("bottleAtPos3E", Signal.OUTPUT);
  public Signal bottleAtPos4E = new Signal("bottleAtPos4E", Signal.OUTPUT);
  public Signal bottleAtPos5E = new Signal("bottleAtPos5E", Signal.OUTPUT);
  public Signal bottleLeftPos5E = new Signal("bottleLeftPos5E", Signal.OUTPUT);
  private Signal removePos4_1;
  private Signal removePos2_1;
  private Signal removePos3_1;
  private long __start_thread_9;//sysj\plant.sysj line: 127, column: 3
  private long __start_thread_15;//sysj\plant.sysj line: 206, column: 31
  private int S1697 = 1;
  private int S724 = 1;
  private int S690 = 1;
  private int S681 = 1;
  private int S688 = 1;
  private int S811 = 1;
  private int S744 = 1;
  private int S730 = 1;
  private int S809 = 1;
  private int S765 = 1;
  private int S876 = 1;
  private int S832 = 1;
  private int S1025 = 1;
  private int S909 = 1;
  private int S882 = 1;
  private int S1045 = 1;
  private int S1031 = 1;
  private int S1077 = 1;
  private int S1055 = 1;
  private int S1118 = 1;
  private int S1090 = 1;
  private int S1183 = 1;
  private int S1139 = 1;
  private int S1215 = 1;
  private int S1193 = 1;
  private int S1496 = 1;
  private int S1308 = 1;
  private int S1238 = 1;
  private int S1531 = 1;
  private int S1507 = 1;
  private int S1497 = 1;
  private int S1551 = 1;
  private int S1537 = 1;
  private int S1571 = 1;
  private int S1557 = 1;
  private int S1591 = 1;
  private int S1577 = 1;
  private int S1695 = 1;
  private int S1608 = 1;
  private int S1596 = 1;
  private int S1625 = 1;
  private int S1613 = 1;
  private int S1642 = 1;
  private int S1630 = 1;
  private int S1659 = 1;
  private int S1647 = 1;
  private int S1676 = 1;
  private int S1664 = 1;
  private int S1693 = 1;
  private int S1681 = 1;
  
  private int[] ends = new int[27];
  private int[] tdone = new int[27];
  
  public void thread1757(int [] tdone, int [] ends){
        switch(S1693){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S1681){
          case 0 : 
            bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 299, column: 40
            currsigs.addElement(bottleLeftPos5E);
            active[26]=1;
            ends[26]=1;
            tdone[26]=1;
            break;
          
          case 1 : 
            S1681=1;
            S1681=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 299, column: 24
              bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 299, column: 40
              currsigs.addElement(bottleLeftPos5E);
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S1681=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1756(int [] tdone, int [] ends){
        switch(S1676){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S1664){
          case 0 : 
            bottleAtPos5E.setPresent();//sysj\plant.sysj line: 297, column: 38
            currsigs.addElement(bottleAtPos5E);
            active[25]=1;
            ends[25]=1;
            tdone[25]=1;
            break;
          
          case 1 : 
            S1664=1;
            S1664=0;
            if(bottleAtPos5.getprestatus()){//sysj\plant.sysj line: 297, column: 24
              bottleAtPos5E.setPresent();//sysj\plant.sysj line: 297, column: 38
              currsigs.addElement(bottleAtPos5E);
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              S1664=1;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1755(int [] tdone, int [] ends){
        switch(S1659){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S1647){
          case 0 : 
            bottleAtPos4E.setPresent();//sysj\plant.sysj line: 295, column: 38
            currsigs.addElement(bottleAtPos4E);
            active[24]=1;
            ends[24]=1;
            tdone[24]=1;
            break;
          
          case 1 : 
            S1647=1;
            S1647=0;
            if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 295, column: 24
              bottleAtPos4E.setPresent();//sysj\plant.sysj line: 295, column: 38
              currsigs.addElement(bottleAtPos4E);
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S1647=1;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1754(int [] tdone, int [] ends){
        switch(S1642){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S1630){
          case 0 : 
            bottleAtPos3E.setPresent();//sysj\plant.sysj line: 293, column: 38
            currsigs.addElement(bottleAtPos3E);
            active[23]=1;
            ends[23]=1;
            tdone[23]=1;
            break;
          
          case 1 : 
            S1630=1;
            S1630=0;
            if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 293, column: 24
              bottleAtPos3E.setPresent();//sysj\plant.sysj line: 293, column: 38
              currsigs.addElement(bottleAtPos3E);
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S1630=1;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1753(int [] tdone, int [] ends){
        switch(S1625){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S1613){
          case 0 : 
            bottleAtPos2E.setPresent();//sysj\plant.sysj line: 291, column: 38
            currsigs.addElement(bottleAtPos2E);
            active[22]=1;
            ends[22]=1;
            tdone[22]=1;
            break;
          
          case 1 : 
            S1613=1;
            S1613=0;
            if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 291, column: 24
              bottleAtPos2E.setPresent();//sysj\plant.sysj line: 291, column: 38
              currsigs.addElement(bottleAtPos2E);
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S1613=1;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1752(int [] tdone, int [] ends){
        switch(S1608){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S1596){
          case 0 : 
            bottleAtPos1E.setPresent();//sysj\plant.sysj line: 289, column: 38
            currsigs.addElement(bottleAtPos1E);
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
            break;
          
          case 1 : 
            S1596=1;
            S1596=0;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 289, column: 24
              bottleAtPos1E.setPresent();//sysj\plant.sysj line: 289, column: 38
              currsigs.addElement(bottleAtPos1E);
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S1596=1;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1751(int [] tdone, int [] ends){
        switch(S1695){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        thread1752(tdone,ends);
        thread1753(tdone,ends);
        thread1754(tdone,ends);
        thread1755(tdone,ends);
        thread1756(tdone,ends);
        thread1757(tdone,ends);
        int biggest1758 = 0;
        if(ends[21]>=biggest1758){
          biggest1758=ends[21];
        }
        if(ends[22]>=biggest1758){
          biggest1758=ends[22];
        }
        if(ends[23]>=biggest1758){
          biggest1758=ends[23];
        }
        if(ends[24]>=biggest1758){
          biggest1758=ends[24];
        }
        if(ends[25]>=biggest1758){
          biggest1758=ends[25];
        }
        if(ends[26]>=biggest1758){
          biggest1758=ends[26];
        }
        if(biggest1758 == 1){
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        //FINXME code
        if(biggest1758 == 0){
          S1695=0;
          active[20]=0;
          ends[20]=0;
          tdone[20]=1;
        }
        break;
      
    }
  }

  public void thread1750(int [] tdone, int [] ends){
        switch(S1591){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S1577){
          case 0 : 
            if(removePos2_1.getprestatus() && !moveToPos2.getprestatus()){//sysj\plant.sysj line: 281, column: 10
              S1577=1;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 282, column: 5
              currsigs.addElement(bottleAtPos2);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            S1577=1;
            S1577=0;
            if(moveToPos2.getprestatus()){//sysj\plant.sysj line: 280, column: 11
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 282, column: 5
              currsigs.addElement(bottleAtPos2);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S1577=1;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1749(int [] tdone, int [] ends){
        switch(S1571){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S1557){
          case 0 : 
            if(removePos3_1.getprestatus() && !moveToPos3.getprestatus()){//sysj\plant.sysj line: 272, column: 10
              S1557=1;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              bottleAtPos3.setPresent();//sysj\plant.sysj line: 273, column: 5
              currsigs.addElement(bottleAtPos3);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            S1557=1;
            S1557=0;
            if(moveToPos3.getprestatus()){//sysj\plant.sysj line: 271, column: 11
              bottleAtPos3.setPresent();//sysj\plant.sysj line: 273, column: 5
              currsigs.addElement(bottleAtPos3);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S1557=1;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1748(int [] tdone, int [] ends){
        switch(S1551){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S1537){
          case 0 : 
            if(removePos4_1.getprestatus() && !moveToPos4.getprestatus()){//sysj\plant.sysj line: 262, column: 10
              S1537=1;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 263, column: 5
              currsigs.addElement(bottleAtPos4);
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            S1537=1;
            S1537=0;
            if(moveToPos4.getprestatus()){//sysj\plant.sysj line: 261, column: 11
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 263, column: 5
              currsigs.addElement(bottleAtPos4);
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S1537=1;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1747(int [] tdone, int [] ends){
        switch(S1531){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S1507){
          case 0 : 
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 247, column: 10
              S1507=1;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              if(tableAlignedWithSensor.getprestatus()){//sysj\plant.sysj line: 249, column: 12
                S1507=1;
                active[16]=1;
                ends[16]=1;
                tdone[16]=1;
              }
              else {
                switch(S1497){
                  case 0 : 
                    S1497=0;
                    S1497=1;
                    bottleAtPos5.setPresent();//sysj\plant.sysj line: 252, column: 7
                    currsigs.addElement(bottleAtPos5);
                    active[16]=1;
                    ends[16]=1;
                    tdone[16]=1;
                    break;
                  
                  case 1 : 
                    bottleAtPos5.setPresent();//sysj\plant.sysj line: 252, column: 7
                    currsigs.addElement(bottleAtPos5);
                    active[16]=1;
                    ends[16]=1;
                    tdone[16]=1;
                    break;
                  
                }
              }
            }
            break;
          
          case 1 : 
            S1507=1;
            S1507=0;
            if(moveToPos5.getprestatus()){//sysj\plant.sysj line: 248, column: 13
              removePos4_1.setPresent();//sysj\plant.sysj line: 250, column: 7
              currsigs.addElement(removePos4_1);
              S1497=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S1507=1;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1746(int [] tdone, int [] ends){
        switch(S1496){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S1308){
          case 0 : 
            switch(S1238){
              case 0 : 
                if(com.systemj.Timer.getMs() - __start_thread_15 >= 100){//sysj\plant.sysj line: 206, column: 31
                  ends[15]=2;
                  ;//sysj\plant.sysj line: 206, column: 31
                  S1238=1;
                  if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 211, column: 13
                    moveToPos5.setPresent();//sysj\plant.sysj line: 212, column: 6
                    currsigs.addElement(moveToPos5);
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    S1238=2;
                    if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 218, column: 13
                      moveToPos4.setPresent();//sysj\plant.sysj line: 219, column: 6
                      currsigs.addElement(moveToPos4);
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                    else {
                      S1238=3;
                      if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 225, column: 13
                        moveToPos3.setPresent();//sysj\plant.sysj line: 226, column: 6
                        currsigs.addElement(moveToPos3);
                        active[15]=1;
                        ends[15]=1;
                        tdone[15]=1;
                      }
                      else {
                        S1238=4;
                        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 231, column: 13
                          moveToPos2.setPresent();//sysj\plant.sysj line: 232, column: 6
                          currsigs.addElement(moveToPos2);
                          active[15]=1;
                          ends[15]=1;
                          tdone[15]=1;
                        }
                        else {
                          S1238=5;
                          tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 237, column: 6
                          currsigs.addElement(tableAlignedWithSensor);
                          active[15]=1;
                          ends[15]=1;
                          tdone[15]=1;
                        }
                      }
                    }
                  }
                }
                else {
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 1 : 
                removePos4_1.setPresent();//sysj\plant.sysj line: 214, column: 6
                currsigs.addElement(removePos4_1);
                S1238=2;
                if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 218, column: 13
                  moveToPos4.setPresent();//sysj\plant.sysj line: 219, column: 6
                  currsigs.addElement(moveToPos4);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1238=3;
                  if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 225, column: 13
                    moveToPos3.setPresent();//sysj\plant.sysj line: 226, column: 6
                    currsigs.addElement(moveToPos3);
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    S1238=4;
                    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 231, column: 13
                      moveToPos2.setPresent();//sysj\plant.sysj line: 232, column: 6
                      currsigs.addElement(moveToPos2);
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                    else {
                      S1238=5;
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 237, column: 6
                      currsigs.addElement(tableAlignedWithSensor);
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                  }
                }
                break;
              
              case 2 : 
                removePos3_1.setPresent();//sysj\plant.sysj line: 221, column: 6
                currsigs.addElement(removePos3_1);
                S1238=3;
                if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 225, column: 13
                  moveToPos3.setPresent();//sysj\plant.sysj line: 226, column: 6
                  currsigs.addElement(moveToPos3);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1238=4;
                  if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 231, column: 13
                    moveToPos2.setPresent();//sysj\plant.sysj line: 232, column: 6
                    currsigs.addElement(moveToPos2);
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    S1238=5;
                    tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 237, column: 6
                    currsigs.addElement(tableAlignedWithSensor);
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                }
                break;
              
              case 3 : 
                removePos2_1.setPresent();//sysj\plant.sysj line: 228, column: 6
                currsigs.addElement(removePos2_1);
                S1238=4;
                if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 231, column: 13
                  moveToPos2.setPresent();//sysj\plant.sysj line: 232, column: 6
                  currsigs.addElement(moveToPos2);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1238=5;
                  tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 237, column: 6
                  currsigs.addElement(tableAlignedWithSensor);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 4 : 
                S1238=5;
                tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 237, column: 6
                currsigs.addElement(tableAlignedWithSensor);
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
                break;
              
              case 5 : 
                if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 236, column: 11
                  S1308=1;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 237, column: 6
                  currsigs.addElement(tableAlignedWithSensor);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1308=1;
            S1308=0;
            if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 206, column: 12
              S1238=0;
              __start_thread_15 = com.systemj.Timer.getMs();//sysj\plant.sysj line: 206, column: 31
              if(com.systemj.Timer.getMs() - __start_thread_15 >= 100){//sysj\plant.sysj line: 206, column: 31
                ends[15]=2;
                ;//sysj\plant.sysj line: 206, column: 31
                S1238=1;
                if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 211, column: 13
                  moveToPos5.setPresent();//sysj\plant.sysj line: 212, column: 6
                  currsigs.addElement(moveToPos5);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1238=2;
                  if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 218, column: 13
                    moveToPos4.setPresent();//sysj\plant.sysj line: 219, column: 6
                    currsigs.addElement(moveToPos4);
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    S1238=3;
                    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 225, column: 13
                      moveToPos3.setPresent();//sysj\plant.sysj line: 226, column: 6
                      currsigs.addElement(moveToPos3);
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                    else {
                      S1238=4;
                      if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 231, column: 13
                        moveToPos2.setPresent();//sysj\plant.sysj line: 232, column: 6
                        currsigs.addElement(moveToPos2);
                        active[15]=1;
                        ends[15]=1;
                        tdone[15]=1;
                      }
                      else {
                        S1238=5;
                        tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 237, column: 6
                        currsigs.addElement(tableAlignedWithSensor);
                        active[15]=1;
                        ends[15]=1;
                        tdone[15]=1;
                      }
                    }
                  }
                }
              }
              else {
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            else {
              S1308=1;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1745(int [] tdone, int [] ends){
        switch(S1215){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S1193){
          case 0 : 
            if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 194, column: 11
              S1193=1;
              cylClampedBottle.setPresent();//sysj\plant.sysj line: 197, column: 6
              currsigs.addElement(cylClampedBottle);
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            if(!cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 196, column: 12
              S1193=2;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              cylClampedBottle.setPresent();//sysj\plant.sysj line: 197, column: 6
              currsigs.addElement(cylClampedBottle);
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 2 : 
            S1193=2;
            S1193=0;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1744(int [] tdone, int [] ends){
        switch(S1183){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S1139){
          case 0 : 
            if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 178, column: 12
              S1139=1;
              if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 182, column: 13
                gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 184, column: 7
                currsigs.addElement(gripperTurnHomePos);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S1139=2;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 179, column: 7
              currsigs.addElement(gripperTurnFinalPos);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 183, column: 12
              S1139=2;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 184, column: 7
              currsigs.addElement(gripperTurnHomePos);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 2 : 
            S1139=2;
            S1139=0;
            if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 177, column: 13
              gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 179, column: 7
              currsigs.addElement(gripperTurnFinalPos);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S1139=1;
              if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 182, column: 13
                gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 184, column: 7
                currsigs.addElement(gripperTurnHomePos);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S1139=2;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1743(int [] tdone, int [] ends){
        switch(S1118){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S1090){
          case 0 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 164, column: 11
              S1090=1;
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 168, column: 6
              currsigs.addElement(gripperZAxisLowered);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 165, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 167, column: 11
              S1090=2;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 168, column: 6
              currsigs.addElement(gripperZAxisLowered);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 2 : 
            S1090=2;
            S1090=0;
            gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 165, column: 6
            currsigs.addElement(gripperZAxisLifted);
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1742(int [] tdone, int [] ends){
        switch(S1077){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1055){
          case 0 : 
            if(moveToPos4.getprestatus()){//sysj\plant.sysj line: 153, column: 11
              S1055=1;
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 155, column: 6
              currsigs.addElement(bottleAtPos4);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if(moveToPos5.getprestatus()){//sysj\plant.sysj line: 154, column: 11
              S1055=2;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 155, column: 6
              currsigs.addElement(bottleAtPos4);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 2 : 
            S1055=2;
            S1055=0;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1741(int [] tdone, int [] ends){
        switch(S1045){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1031){
          case 0 : 
            if(!vacOn.getprestatus()){//sysj\plant.sysj line: 142, column: 11
              S1031=1;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              WPgripped.setPresent();//sysj\plant.sysj line: 143, column: 6
              currsigs.addElement(WPgripped);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            S1031=1;
            S1031=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 141, column: 12
              WPgripped.setPresent();//sysj\plant.sysj line: 143, column: 6
              currsigs.addElement(WPgripped);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S1031=1;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1740(int [] tdone, int [] ends){
        switch(S1025){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S909){
          case 0 : 
            if(pusherExtend.getprestatus()){//sysj\plant.sysj line: 128, column: 10
              S909=1;
              __start_thread_9 = com.systemj.Timer.getMs();//sysj\plant.sysj line: 127, column: 3
              S882=0;
              if(com.systemj.Timer.getMs() - __start_thread_9 >= (2) * 1000){//sysj\plant.sysj line: 127, column: 3
                ends[9]=2;
                ;//sysj\plant.sysj line: 127, column: 3
                S909=2;
                pusherExtended.setPresent();//sysj\plant.sysj line: 133, column: 5
                currsigs.addElement(pusherExtended);
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
              else {
                S882=1;
                active[9]=1;
                ends[9]=1;
                tdone[9]=1;
              }
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 129, column: 5
              currsigs.addElement(pusherRetracted);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            switch(S882){
              case 0 : 
                S882=0;
                if(com.systemj.Timer.getMs() - __start_thread_9 >= (2) * 1000){//sysj\plant.sysj line: 127, column: 3
                  ends[9]=2;
                  ;//sysj\plant.sysj line: 127, column: 3
                  S909=2;
                  pusherExtended.setPresent();//sysj\plant.sysj line: 133, column: 5
                  currsigs.addElement(pusherExtended);
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
                else {
                  S882=1;
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
                break;
              
              case 1 : 
                S882=1;
                S882=0;
                if(com.systemj.Timer.getMs() - __start_thread_9 >= (2) * 1000){//sysj\plant.sysj line: 127, column: 3
                  ends[9]=2;
                  ;//sysj\plant.sysj line: 127, column: 3
                  S909=2;
                  pusherExtended.setPresent();//sysj\plant.sysj line: 133, column: 5
                  currsigs.addElement(pusherExtended);
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
                else {
                  S882=1;
                  active[9]=1;
                  ends[9]=1;
                  tdone[9]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            if(!pusherExtend.getprestatus()){//sysj\plant.sysj line: 132, column: 10
              S909=3;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 133, column: 5
              currsigs.addElement(pusherExtended);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 3 : 
            S909=3;
            S909=0;
            pusherRetracted.setPresent();//sysj\plant.sysj line: 129, column: 5
            currsigs.addElement(pusherRetracted);
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread1739(int [] tdone, int [] ends){
        switch(S876){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S832){
          case 0 : 
            if(armDest.getprestatus()){//sysj\plant.sysj line: 113, column: 12
              S832=1;
              if(armDest.getprestatus() && !armSource.getprestatus()){//sysj\plant.sysj line: 117, column: 12
                armAtDest.setPresent();//sysj\plant.sysj line: 119, column: 6
                currsigs.addElement(armAtDest);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                S832=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 114, column: 6
              currsigs.addElement(armAtSource);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(armSource.getprestatus()){//sysj\plant.sysj line: 118, column: 12
              S832=2;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 119, column: 6
              currsigs.addElement(armAtDest);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 2 : 
            S832=2;
            S832=0;
            if(armSource.getprestatus() && !armDest.getprestatus()){//sysj\plant.sysj line: 112, column: 12
              armAtSource.setPresent();//sysj\plant.sysj line: 114, column: 6
              currsigs.addElement(armAtSource);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S832=1;
              if(armDest.getprestatus() && !armSource.getprestatus()){//sysj\plant.sysj line: 117, column: 12
                armAtDest.setPresent();//sysj\plant.sysj line: 119, column: 6
                currsigs.addElement(armAtDest);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                S832=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1737(int [] tdone, int [] ends){
        switch(S809){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S765){
          case 0 : 
            if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 94, column: 13
              S765=1;
              if(dosUnitValveRetract.getprestatus() && !dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 98, column: 13
                dosUnitFilled.setPresent();//sysj\plant.sysj line: 100, column: 7
                currsigs.addElement(dosUnitFilled);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S765=2;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 95, column: 7
              currsigs.addElement(dosUnitEvac);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 99, column: 13
              S765=2;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 100, column: 7
              currsigs.addElement(dosUnitFilled);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 2 : 
            S765=2;
            S765=0;
            if(dosUnitValveExtend.getprestatus() && !dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 93, column: 13
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 95, column: 7
              currsigs.addElement(dosUnitEvac);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              S765=1;
              if(dosUnitValveRetract.getprestatus() && !dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 98, column: 13
                dosUnitFilled.setPresent();//sysj\plant.sysj line: 100, column: 7
                currsigs.addElement(dosUnitFilled);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S765=2;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1736(int [] tdone, int [] ends){
        switch(S744){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S730){
          case 0 : 
            if(!valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 82, column: 12
              S730=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              valveInjectorActive.setPresent();//sysj\plant.sysj line: 83, column: 7
              currsigs.addElement(valveInjectorActive);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S730=1;
            S730=0;
            if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 81, column: 13
              valveInjectorActive.setPresent();//sysj\plant.sysj line: 83, column: 7
              currsigs.addElement(valveInjectorActive);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S730=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1735(int [] tdone, int [] ends){
        switch(S811){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        thread1736(tdone,ends);
        thread1737(tdone,ends);
        int biggest1738 = 0;
        if(ends[6]>=biggest1738){
          biggest1738=ends[6];
        }
        if(ends[7]>=biggest1738){
          biggest1738=ends[7];
        }
        if(biggest1738 == 1){
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        //FINXME code
        if(biggest1738 == 0){
          S811=0;
          active[5]=0;
          ends[5]=0;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread1733(int [] tdone, int [] ends){
        S688=1;
    if(motorPos5On.getprestatus()){//sysj\plant.sysj line: 63, column: 14
      bottleLeftPos5.setPresent();//sysj\plant.sysj line: 65, column: 8
      currsigs.addElement(bottleLeftPos5);
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S688=0;
      active[4]=0;
      ends[4]=0;
      tdone[4]=1;
    }
  }

  public void thread1732(int [] tdone, int [] ends){
        S681=1;
    if(motorPos1On.getprestatus()){//sysj\plant.sysj line: 55, column: 14
      bottleAtPos1.setPresent();//sysj\plant.sysj line: 57, column: 8
      currsigs.addElement(bottleAtPos1);
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S681=0;
      active[3]=0;
      ends[3]=0;
      tdone[3]=1;
    }
  }

  public void thread1730(int [] tdone, int [] ends){
        switch(S688){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(!motorPos5On.getprestatus() && !motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 64, column: 13
          S688=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        else {
          bottleLeftPos5.setPresent();//sysj\plant.sysj line: 65, column: 8
          currsigs.addElement(bottleLeftPos5);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread1729(int [] tdone, int [] ends){
        switch(S681){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(moveToPos2.getprestatus()){//sysj\plant.sysj line: 56, column: 14
          S681=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        else {
          bottleAtPos1.setPresent();//sysj\plant.sysj line: 57, column: 8
          currsigs.addElement(bottleAtPos1);
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread1728(int [] tdone, int [] ends){
        switch(S724){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S690){
          case 0 : 
            thread1729(tdone,ends);
            thread1730(tdone,ends);
            int biggest1731 = 0;
            if(ends[3]>=biggest1731){
              biggest1731=ends[3];
            }
            if(ends[4]>=biggest1731){
              biggest1731=ends[4];
            }
            if(biggest1731 == 1){
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            //FINXME code
            if(biggest1731 == 0){
              S690=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            S690=1;
            S690=0;
            if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 53, column: 12
              thread1732(tdone,ends);
              thread1733(tdone,ends);
              int biggest1734 = 0;
              if(ends[3]>=biggest1734){
                biggest1734=ends[3];
              }
              if(ends[4]>=biggest1734){
                biggest1734=ends[4];
              }
              if(biggest1734 == 1){
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              //FINXME code
              if(biggest1734 == 0){
                S690=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S690=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1725(int [] tdone, int [] ends){
        S1693=1;
    S1681=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 299, column: 24
      bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 299, column: 40
      currsigs.addElement(bottleLeftPos5E);
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      S1681=1;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread1724(int [] tdone, int [] ends){
        S1676=1;
    S1664=0;
    if(bottleAtPos5.getprestatus()){//sysj\plant.sysj line: 297, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 297, column: 38
      currsigs.addElement(bottleAtPos5E);
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
    else {
      S1664=1;
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
  }

  public void thread1723(int [] tdone, int [] ends){
        S1659=1;
    S1647=0;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 295, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 295, column: 38
      currsigs.addElement(bottleAtPos4E);
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
    else {
      S1647=1;
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
  }

  public void thread1722(int [] tdone, int [] ends){
        S1642=1;
    S1630=0;
    if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 293, column: 24
      bottleAtPos3E.setPresent();//sysj\plant.sysj line: 293, column: 38
      currsigs.addElement(bottleAtPos3E);
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
    else {
      S1630=1;
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
  }

  public void thread1721(int [] tdone, int [] ends){
        S1625=1;
    S1613=0;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 291, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 291, column: 38
      currsigs.addElement(bottleAtPos2E);
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
    else {
      S1613=1;
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread1720(int [] tdone, int [] ends){
        S1608=1;
    S1596=0;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 289, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 289, column: 38
      currsigs.addElement(bottleAtPos1E);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S1596=1;
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
  }

  public void thread1719(int [] tdone, int [] ends){
        S1695=1;
    thread1720(tdone,ends);
    thread1721(tdone,ends);
    thread1722(tdone,ends);
    thread1723(tdone,ends);
    thread1724(tdone,ends);
    thread1725(tdone,ends);
    int biggest1726 = 0;
    if(ends[21]>=biggest1726){
      biggest1726=ends[21];
    }
    if(ends[22]>=biggest1726){
      biggest1726=ends[22];
    }
    if(ends[23]>=biggest1726){
      biggest1726=ends[23];
    }
    if(ends[24]>=biggest1726){
      biggest1726=ends[24];
    }
    if(ends[25]>=biggest1726){
      biggest1726=ends[25];
    }
    if(ends[26]>=biggest1726){
      biggest1726=ends[26];
    }
    if(biggest1726 == 1){
      active[20]=1;
      ends[20]=1;
      tdone[20]=1;
    }
  }

  public void thread1718(int [] tdone, int [] ends){
        S1591=1;
    S1577=0;
    if(moveToPos2.getprestatus()){//sysj\plant.sysj line: 280, column: 11
      bottleAtPos2.setPresent();//sysj\plant.sysj line: 282, column: 5
      currsigs.addElement(bottleAtPos2);
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
    else {
      S1577=1;
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
  }

  public void thread1717(int [] tdone, int [] ends){
        S1571=1;
    S1557=0;
    if(moveToPos3.getprestatus()){//sysj\plant.sysj line: 271, column: 11
      bottleAtPos3.setPresent();//sysj\plant.sysj line: 273, column: 5
      currsigs.addElement(bottleAtPos3);
      active[18]=1;
      ends[18]=1;
      tdone[18]=1;
    }
    else {
      S1557=1;
      active[18]=1;
      ends[18]=1;
      tdone[18]=1;
    }
  }

  public void thread1716(int [] tdone, int [] ends){
        S1551=1;
    S1537=0;
    if(moveToPos4.getprestatus()){//sysj\plant.sysj line: 261, column: 11
      bottleAtPos4.setPresent();//sysj\plant.sysj line: 263, column: 5
      currsigs.addElement(bottleAtPos4);
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
    else {
      S1537=1;
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
  }

  public void thread1715(int [] tdone, int [] ends){
        S1531=1;
    S1507=0;
    if(moveToPos5.getprestatus()){//sysj\plant.sysj line: 248, column: 13
      removePos4_1.setPresent();//sysj\plant.sysj line: 250, column: 7
      currsigs.addElement(removePos4_1);
      S1497=0;
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
    else {
      S1507=1;
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
  }

  public void thread1714(int [] tdone, int [] ends){
        S1496=1;
    S1308=0;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 206, column: 12
      S1238=0;
      __start_thread_15 = com.systemj.Timer.getMs();//sysj\plant.sysj line: 206, column: 31
      if(com.systemj.Timer.getMs() - __start_thread_15 >= 100){//sysj\plant.sysj line: 206, column: 31
        ends[15]=2;
        ;//sysj\plant.sysj line: 206, column: 31
        S1238=1;
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 211, column: 13
          moveToPos5.setPresent();//sysj\plant.sysj line: 212, column: 6
          currsigs.addElement(moveToPos5);
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
        else {
          S1238=2;
          if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 218, column: 13
            moveToPos4.setPresent();//sysj\plant.sysj line: 219, column: 6
            currsigs.addElement(moveToPos4);
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
          }
          else {
            S1238=3;
            if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 225, column: 13
              moveToPos3.setPresent();//sysj\plant.sysj line: 226, column: 6
              currsigs.addElement(moveToPos3);
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S1238=4;
              if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 231, column: 13
                moveToPos2.setPresent();//sysj\plant.sysj line: 232, column: 6
                currsigs.addElement(moveToPos2);
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              else {
                S1238=5;
                tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 237, column: 6
                currsigs.addElement(tableAlignedWithSensor);
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
          }
        }
      }
      else {
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
      }
    }
    else {
      S1308=1;
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
  }

  public void thread1713(int [] tdone, int [] ends){
        S1215=1;
    S1193=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread1712(int [] tdone, int [] ends){
        S1183=1;
    S1139=0;
    if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 177, column: 13
      gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 179, column: 7
      currsigs.addElement(gripperTurnFinalPos);
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
    else {
      S1139=1;
      if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 182, column: 13
        gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 184, column: 7
        currsigs.addElement(gripperTurnHomePos);
        active[13]=1;
        ends[13]=1;
        tdone[13]=1;
      }
      else {
        S1139=2;
        active[13]=1;
        ends[13]=1;
        tdone[13]=1;
      }
    }
  }

  public void thread1711(int [] tdone, int [] ends){
        S1118=1;
    S1090=0;
    gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 165, column: 6
    currsigs.addElement(gripperZAxisLifted);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread1710(int [] tdone, int [] ends){
        S1077=1;
    S1055=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread1709(int [] tdone, int [] ends){
        S1045=1;
    S1031=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 141, column: 12
      WPgripped.setPresent();//sysj\plant.sysj line: 143, column: 6
      currsigs.addElement(WPgripped);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      S1031=1;
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread1708(int [] tdone, int [] ends){
        S1025=1;
    S909=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 129, column: 5
    currsigs.addElement(pusherRetracted);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1707(int [] tdone, int [] ends){
        S876=1;
    S832=0;
    if(armSource.getprestatus() && !armDest.getprestatus()){//sysj\plant.sysj line: 112, column: 12
      armAtSource.setPresent();//sysj\plant.sysj line: 114, column: 6
      currsigs.addElement(armAtSource);
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      S832=1;
      if(armDest.getprestatus() && !armSource.getprestatus()){//sysj\plant.sysj line: 117, column: 12
        armAtDest.setPresent();//sysj\plant.sysj line: 119, column: 6
        currsigs.addElement(armAtDest);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
      }
      else {
        S832=2;
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
      }
    }
  }

  public void thread1705(int [] tdone, int [] ends){
        S809=1;
    S765=0;
    if(dosUnitValveExtend.getprestatus() && !dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 93, column: 13
      dosUnitEvac.setPresent();//sysj\plant.sysj line: 95, column: 7
      currsigs.addElement(dosUnitEvac);
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      S765=1;
      if(dosUnitValveRetract.getprestatus() && !dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 98, column: 13
        dosUnitFilled.setPresent();//sysj\plant.sysj line: 100, column: 7
        currsigs.addElement(dosUnitFilled);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
      }
      else {
        S765=2;
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
      }
    }
  }

  public void thread1704(int [] tdone, int [] ends){
        S744=1;
    S730=0;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 81, column: 13
      valveInjectorActive.setPresent();//sysj\plant.sysj line: 83, column: 7
      currsigs.addElement(valveInjectorActive);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S730=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread1703(int [] tdone, int [] ends){
        S811=1;
    thread1704(tdone,ends);
    thread1705(tdone,ends);
    int biggest1706 = 0;
    if(ends[6]>=biggest1706){
      biggest1706=ends[6];
    }
    if(ends[7]>=biggest1706){
      biggest1706=ends[7];
    }
    if(biggest1706 == 1){
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread1701(int [] tdone, int [] ends){
        S688=1;
    if(motorPos5On.getprestatus()){//sysj\plant.sysj line: 63, column: 14
      bottleLeftPos5.setPresent();//sysj\plant.sysj line: 65, column: 8
      currsigs.addElement(bottleLeftPos5);
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
    else {
      S688=0;
      active[4]=0;
      ends[4]=0;
      tdone[4]=1;
    }
  }

  public void thread1700(int [] tdone, int [] ends){
        S681=1;
    if(motorPos1On.getprestatus()){//sysj\plant.sysj line: 55, column: 14
      bottleAtPos1.setPresent();//sysj\plant.sysj line: 57, column: 8
      currsigs.addElement(bottleAtPos1);
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
    else {
      S681=0;
      active[3]=0;
      ends[3]=0;
      tdone[3]=1;
    }
  }

  public void thread1699(int [] tdone, int [] ends){
        S724=1;
    S690=0;
    if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 53, column: 12
      thread1700(tdone,ends);
      thread1701(tdone,ends);
      int biggest1702 = 0;
      if(ends[3]>=biggest1702){
        biggest1702=ends[3];
      }
      if(ends[4]>=biggest1702){
        biggest1702=ends[4];
      }
      if(biggest1702 == 1){
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      //FINXME code
      if(biggest1702 == 0){
        S690=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
    }
    else {
      S690=1;
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S1697){
        case 0 : 
          S1697=0;
          break RUN;
        
        case 1 : 
          S1697=2;
          S1697=2;
          removePos4_1.setClear();//sysj\plant.sysj line: 49, column: 2
          removePos2_1.setClear();//sysj\plant.sysj line: 49, column: 2
          removePos3_1.setClear();//sysj\plant.sysj line: 49, column: 2
          thread1699(tdone,ends);
          thread1703(tdone,ends);
          thread1707(tdone,ends);
          thread1708(tdone,ends);
          thread1709(tdone,ends);
          thread1710(tdone,ends);
          thread1711(tdone,ends);
          thread1712(tdone,ends);
          thread1713(tdone,ends);
          thread1714(tdone,ends);
          thread1715(tdone,ends);
          thread1716(tdone,ends);
          thread1717(tdone,ends);
          thread1718(tdone,ends);
          thread1719(tdone,ends);
          int biggest1727 = 0;
          if(ends[2]>=biggest1727){
            biggest1727=ends[2];
          }
          if(ends[5]>=biggest1727){
            biggest1727=ends[5];
          }
          if(ends[8]>=biggest1727){
            biggest1727=ends[8];
          }
          if(ends[9]>=biggest1727){
            biggest1727=ends[9];
          }
          if(ends[10]>=biggest1727){
            biggest1727=ends[10];
          }
          if(ends[11]>=biggest1727){
            biggest1727=ends[11];
          }
          if(ends[12]>=biggest1727){
            biggest1727=ends[12];
          }
          if(ends[13]>=biggest1727){
            biggest1727=ends[13];
          }
          if(ends[14]>=biggest1727){
            biggest1727=ends[14];
          }
          if(ends[15]>=biggest1727){
            biggest1727=ends[15];
          }
          if(ends[16]>=biggest1727){
            biggest1727=ends[16];
          }
          if(ends[17]>=biggest1727){
            biggest1727=ends[17];
          }
          if(ends[18]>=biggest1727){
            biggest1727=ends[18];
          }
          if(ends[19]>=biggest1727){
            biggest1727=ends[19];
          }
          if(ends[20]>=biggest1727){
            biggest1727=ends[20];
          }
          if(biggest1727 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          removePos4_1.setClear();//sysj\plant.sysj line: 49, column: 2
          removePos2_1.setClear();//sysj\plant.sysj line: 49, column: 2
          removePos3_1.setClear();//sysj\plant.sysj line: 49, column: 2
          thread1728(tdone,ends);
          thread1735(tdone,ends);
          thread1739(tdone,ends);
          thread1740(tdone,ends);
          thread1741(tdone,ends);
          thread1742(tdone,ends);
          thread1743(tdone,ends);
          thread1744(tdone,ends);
          thread1745(tdone,ends);
          thread1746(tdone,ends);
          thread1747(tdone,ends);
          thread1748(tdone,ends);
          thread1749(tdone,ends);
          thread1750(tdone,ends);
          thread1751(tdone,ends);
          int biggest1759 = 0;
          if(ends[2]>=biggest1759){
            biggest1759=ends[2];
          }
          if(ends[5]>=biggest1759){
            biggest1759=ends[5];
          }
          if(ends[8]>=biggest1759){
            biggest1759=ends[8];
          }
          if(ends[9]>=biggest1759){
            biggest1759=ends[9];
          }
          if(ends[10]>=biggest1759){
            biggest1759=ends[10];
          }
          if(ends[11]>=biggest1759){
            biggest1759=ends[11];
          }
          if(ends[12]>=biggest1759){
            biggest1759=ends[12];
          }
          if(ends[13]>=biggest1759){
            biggest1759=ends[13];
          }
          if(ends[14]>=biggest1759){
            biggest1759=ends[14];
          }
          if(ends[15]>=biggest1759){
            biggest1759=ends[15];
          }
          if(ends[16]>=biggest1759){
            biggest1759=ends[16];
          }
          if(ends[17]>=biggest1759){
            biggest1759=ends[17];
          }
          if(ends[18]>=biggest1759){
            biggest1759=ends[18];
          }
          if(ends[19]>=biggest1759){
            biggest1759=ends[19];
          }
          if(ends[20]>=biggest1759){
            biggest1759=ends[20];
          }
          if(biggest1759 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1759 == 0){
            S1697=0;
            active[1]=0;
            ends[1]=0;
            S1697=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    removePos4_1 = new Signal();
    removePos2_1 = new Signal();
    removePos3_1 = new Signal();
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
          systemEnable.gethook();
          motConveyorOnOff.gethook();
          motorPos1On.gethook();
          motorPos5On.gethook();
          valveInjectorOnOff.gethook();
          valveInletOnOff.gethook();
          dosUnitValveRetract.gethook();
          dosUnitValveExtend.gethook();
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          magReq.gethook();
          cylPos5ZAxisExtend.gethook();
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          rotaryTableTrigger.gethook();
          df = true;
        }
        runClockDomain();
      }
      systemEnable.setpreclear();
      motConveyorOnOff.setpreclear();
      motorPos1On.setpreclear();
      motorPos5On.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      magReq.setpreclear();
      cylPos5ZAxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      rotaryTableTrigger.setpreclear();
      bottleAtPos1.setpreclear();
      bottleAtPos5.setpreclear();
      bottleLeftPos5.setpreclear();
      dosUnitEvac.setpreclear();
      valveInjectorActive.setpreclear();
      dosUnitFilled.setpreclear();
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      magEmpty.setpreclear();
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      cylClampedBottle.setpreclear();
      tableAlignedWithSensor.setpreclear();
      capOnBottleAtPos1.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos3.setpreclear();
      moveToPos5.setpreclear();
      moveToPos4.setpreclear();
      moveToPos3.setpreclear();
      moveToPos2.setpreclear();
      bottleAtPos1E.setpreclear();
      bottleAtPos2E.setpreclear();
      bottleAtPos3E.setpreclear();
      bottleAtPos4E.setpreclear();
      bottleAtPos5E.setpreclear();
      bottleLeftPos5E.setpreclear();
      removePos4_1.setpreclear();
      removePos2_1.setpreclear();
      removePos3_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = systemEnable.getStatus() ? systemEnable.setprepresent() : systemEnable.setpreclear();
      systemEnable.setpreval(systemEnable.getValue());
      systemEnable.setClear();
      dummyint = motConveyorOnOff.getStatus() ? motConveyorOnOff.setprepresent() : motConveyorOnOff.setpreclear();
      motConveyorOnOff.setpreval(motConveyorOnOff.getValue());
      motConveyorOnOff.setClear();
      dummyint = motorPos1On.getStatus() ? motorPos1On.setprepresent() : motorPos1On.setpreclear();
      motorPos1On.setpreval(motorPos1On.getValue());
      motorPos1On.setClear();
      dummyint = motorPos5On.getStatus() ? motorPos5On.setprepresent() : motorPos5On.setpreclear();
      motorPos5On.setpreval(motorPos5On.getValue());
      motorPos5On.setClear();
      dummyint = valveInjectorOnOff.getStatus() ? valveInjectorOnOff.setprepresent() : valveInjectorOnOff.setpreclear();
      valveInjectorOnOff.setpreval(valveInjectorOnOff.getValue());
      valveInjectorOnOff.setClear();
      dummyint = valveInletOnOff.getStatus() ? valveInletOnOff.setprepresent() : valveInletOnOff.setpreclear();
      valveInletOnOff.setpreval(valveInletOnOff.getValue());
      valveInletOnOff.setClear();
      dummyint = dosUnitValveRetract.getStatus() ? dosUnitValveRetract.setprepresent() : dosUnitValveRetract.setpreclear();
      dosUnitValveRetract.setpreval(dosUnitValveRetract.getValue());
      dosUnitValveRetract.setClear();
      dummyint = dosUnitValveExtend.getStatus() ? dosUnitValveExtend.setprepresent() : dosUnitValveExtend.setpreclear();
      dosUnitValveExtend.setpreval(dosUnitValveExtend.getValue());
      dosUnitValveExtend.setClear();
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
      dummyint = magReq.getStatus() ? magReq.setprepresent() : magReq.setpreclear();
      magReq.setpreval(magReq.getValue());
      magReq.setClear();
      dummyint = cylPos5ZAxisExtend.getStatus() ? cylPos5ZAxisExtend.setprepresent() : cylPos5ZAxisExtend.setpreclear();
      cylPos5ZAxisExtend.setpreval(cylPos5ZAxisExtend.getValue());
      cylPos5ZAxisExtend.setClear();
      dummyint = gripperTurnRetract.getStatus() ? gripperTurnRetract.setprepresent() : gripperTurnRetract.setpreclear();
      gripperTurnRetract.setpreval(gripperTurnRetract.getValue());
      gripperTurnRetract.setClear();
      dummyint = gripperTurnExtend.getStatus() ? gripperTurnExtend.setprepresent() : gripperTurnExtend.setpreclear();
      gripperTurnExtend.setpreval(gripperTurnExtend.getValue());
      gripperTurnExtend.setClear();
      dummyint = capGripperPos5Extend.getStatus() ? capGripperPos5Extend.setprepresent() : capGripperPos5Extend.setpreclear();
      capGripperPos5Extend.setpreval(capGripperPos5Extend.getValue());
      capGripperPos5Extend.setClear();
      dummyint = cylClampBottleExtend.getStatus() ? cylClampBottleExtend.setprepresent() : cylClampBottleExtend.setpreclear();
      cylClampBottleExtend.setpreval(cylClampBottleExtend.getValue());
      cylClampBottleExtend.setClear();
      dummyint = rotaryTableTrigger.getStatus() ? rotaryTableTrigger.setprepresent() : rotaryTableTrigger.setpreclear();
      rotaryTableTrigger.setpreval(rotaryTableTrigger.getValue());
      rotaryTableTrigger.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      bottleAtPos5.sethook();
      bottleAtPos5.setClear();
      bottleLeftPos5.sethook();
      bottleLeftPos5.setClear();
      dosUnitEvac.sethook();
      dosUnitEvac.setClear();
      valveInjectorActive.sethook();
      valveInjectorActive.setClear();
      dosUnitFilled.sethook();
      dosUnitFilled.setClear();
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
      magEmpty.sethook();
      magEmpty.setClear();
      bottleAtPos4.sethook();
      bottleAtPos4.setClear();
      gripperZAxisLowered.sethook();
      gripperZAxisLowered.setClear();
      gripperZAxisLifted.sethook();
      gripperZAxisLifted.setClear();
      gripperTurnHomePos.sethook();
      gripperTurnHomePos.setClear();
      gripperTurnFinalPos.sethook();
      gripperTurnFinalPos.setClear();
      cylClampedBottle.sethook();
      cylClampedBottle.setClear();
      tableAlignedWithSensor.sethook();
      tableAlignedWithSensor.setClear();
      capOnBottleAtPos1.sethook();
      capOnBottleAtPos1.setClear();
      bottleAtPos2.sethook();
      bottleAtPos2.setClear();
      bottleAtPos3.sethook();
      bottleAtPos3.setClear();
      moveToPos5.sethook();
      moveToPos5.setClear();
      moveToPos4.sethook();
      moveToPos4.setClear();
      moveToPos3.sethook();
      moveToPos3.setClear();
      moveToPos2.sethook();
      moveToPos2.setClear();
      bottleAtPos1E.sethook();
      bottleAtPos1E.setClear();
      bottleAtPos2E.sethook();
      bottleAtPos2E.setClear();
      bottleAtPos3E.sethook();
      bottleAtPos3E.setClear();
      bottleAtPos4E.sethook();
      bottleAtPos4E.setClear();
      bottleAtPos5E.sethook();
      bottleAtPos5E.setClear();
      bottleLeftPos5E.sethook();
      bottleLeftPos5E.setClear();
      removePos4_1.setClear();
      removePos2_1.setClear();
      removePos3_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        systemEnable.gethook();
        motConveyorOnOff.gethook();
        motorPos1On.gethook();
        motorPos5On.gethook();
        valveInjectorOnOff.gethook();
        valveInletOnOff.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        magReq.gethook();
        cylPos5ZAxisExtend.gethook();
        gripperTurnRetract.gethook();
        gripperTurnExtend.gethook();
        capGripperPos5Extend.gethook();
        cylClampBottleExtend.gethook();
        rotaryTableTrigger.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
