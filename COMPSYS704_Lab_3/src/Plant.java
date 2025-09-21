import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Plant extends ClockDomain{
  public Plant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal systemEnable = new Signal("systemEnable", Signal.INPUT);
  public Signal motConveyorOnOff = new Signal("motConveyorOnOff", Signal.INPUT);
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
  private Signal removePos4_1;
  private Signal removePos2_1;
  private Signal removePos3_1;
  private long __start_thread_2;//sysj\plant.sysj line: 49, column: 29
  private long __start_thread_9;//sysj\plant.sysj line: 120, column: 3
  private long __start_thread_15;//sysj\plant.sysj line: 199, column: 31
  private int S2071 = 1;
  private int S1202 = 1;
  private int S1070 = 1;
  private int S1068 = 1;
  private int S1007 = 1;
  private int S1025 = 1;
  private int S1031 = 1;
  private int S1289 = 1;
  private int S1222 = 1;
  private int S1208 = 1;
  private int S1287 = 1;
  private int S1243 = 1;
  private int S1354 = 1;
  private int S1310 = 1;
  private int S1503 = 1;
  private int S1387 = 1;
  private int S1523 = 1;
  private int S1509 = 1;
  private int S1555 = 1;
  private int S1533 = 1;
  private int S1596 = 1;
  private int S1568 = 1;
  private int S1661 = 1;
  private int S1617 = 1;
  private int S1693 = 1;
  private int S1671 = 1;
  private int S1974 = 1;
  private int S1786 = 1;
  private int S1716 = 1;
  private int S2009 = 1;
  private int S1985 = 1;
  private int S1975 = 1;
  private int S2029 = 1;
  private int S2015 = 1;
  private int S2049 = 1;
  private int S2035 = 1;
  private int S2069 = 1;
  private int S2055 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread2122(int [] tdone, int [] ends){
        switch(S2069){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S2055){
          case 0 : 
            if(removePos2_1.getprestatus() && !moveToPos2.getprestatus()){//sysj\plant.sysj line: 274, column: 10
              S2055=1;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 275, column: 5
              currsigs.addElement(bottleAtPos2);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            S2055=1;
            S2055=0;
            if(moveToPos2.getprestatus()){//sysj\plant.sysj line: 273, column: 11
              bottleAtPos2.setPresent();//sysj\plant.sysj line: 275, column: 5
              currsigs.addElement(bottleAtPos2);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S2055=1;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2121(int [] tdone, int [] ends){
        switch(S2049){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S2035){
          case 0 : 
            if(removePos3_1.getprestatus() && !moveToPos3.getprestatus()){//sysj\plant.sysj line: 265, column: 10
              S2035=1;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              bottleAtPos3.setPresent();//sysj\plant.sysj line: 266, column: 5
              currsigs.addElement(bottleAtPos3);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            S2035=1;
            S2035=0;
            if(moveToPos3.getprestatus()){//sysj\plant.sysj line: 264, column: 11
              bottleAtPos3.setPresent();//sysj\plant.sysj line: 266, column: 5
              currsigs.addElement(bottleAtPos3);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S2035=1;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2120(int [] tdone, int [] ends){
        switch(S2029){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S2015){
          case 0 : 
            if(removePos4_1.getprestatus() && !moveToPos4.getprestatus()){//sysj\plant.sysj line: 255, column: 10
              S2015=1;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 256, column: 5
              currsigs.addElement(bottleAtPos4);
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            S2015=1;
            S2015=0;
            if(moveToPos4.getprestatus()){//sysj\plant.sysj line: 254, column: 11
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 256, column: 5
              currsigs.addElement(bottleAtPos4);
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S2015=1;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2119(int [] tdone, int [] ends){
        switch(S2009){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S1985){
          case 0 : 
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 240, column: 10
              S1985=1;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              if(tableAlignedWithSensor.getprestatus()){//sysj\plant.sysj line: 242, column: 12
                S1985=1;
                active[16]=1;
                ends[16]=1;
                tdone[16]=1;
              }
              else {
                switch(S1975){
                  case 0 : 
                    S1975=0;
                    S1975=1;
                    bottleAtPos5.setPresent();//sysj\plant.sysj line: 245, column: 7
                    currsigs.addElement(bottleAtPos5);
                    active[16]=1;
                    ends[16]=1;
                    tdone[16]=1;
                    break;
                  
                  case 1 : 
                    bottleAtPos5.setPresent();//sysj\plant.sysj line: 245, column: 7
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
            S1985=1;
            S1985=0;
            if(moveToPos5.getprestatus()){//sysj\plant.sysj line: 241, column: 13
              removePos4_1.setPresent();//sysj\plant.sysj line: 243, column: 7
              currsigs.addElement(removePos4_1);
              S1975=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S1985=1;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2118(int [] tdone, int [] ends){
        switch(S1974){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S1786){
          case 0 : 
            switch(S1716){
              case 0 : 
                if(com.systemj.Timer.getMs() - __start_thread_15 >= 100){//sysj\plant.sysj line: 199, column: 31
                  ends[15]=2;
                  ;//sysj\plant.sysj line: 199, column: 31
                  S1716=1;
                  if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 204, column: 13
                    moveToPos5.setPresent();//sysj\plant.sysj line: 205, column: 6
                    currsigs.addElement(moveToPos5);
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    S1716=2;
                    if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 211, column: 13
                      moveToPos4.setPresent();//sysj\plant.sysj line: 212, column: 6
                      currsigs.addElement(moveToPos4);
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                    else {
                      S1716=3;
                      if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 218, column: 13
                        moveToPos3.setPresent();//sysj\plant.sysj line: 219, column: 6
                        currsigs.addElement(moveToPos3);
                        active[15]=1;
                        ends[15]=1;
                        tdone[15]=1;
                      }
                      else {
                        S1716=4;
                        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 224, column: 13
                          moveToPos2.setPresent();//sysj\plant.sysj line: 225, column: 6
                          currsigs.addElement(moveToPos2);
                          active[15]=1;
                          ends[15]=1;
                          tdone[15]=1;
                        }
                        else {
                          S1716=5;
                          tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 230, column: 6
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
                removePos4_1.setPresent();//sysj\plant.sysj line: 207, column: 6
                currsigs.addElement(removePos4_1);
                S1716=2;
                if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 211, column: 13
                  moveToPos4.setPresent();//sysj\plant.sysj line: 212, column: 6
                  currsigs.addElement(moveToPos4);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1716=3;
                  if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 218, column: 13
                    moveToPos3.setPresent();//sysj\plant.sysj line: 219, column: 6
                    currsigs.addElement(moveToPos3);
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    S1716=4;
                    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 224, column: 13
                      moveToPos2.setPresent();//sysj\plant.sysj line: 225, column: 6
                      currsigs.addElement(moveToPos2);
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                    else {
                      S1716=5;
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 230, column: 6
                      currsigs.addElement(tableAlignedWithSensor);
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                  }
                }
                break;
              
              case 2 : 
                removePos3_1.setPresent();//sysj\plant.sysj line: 214, column: 6
                currsigs.addElement(removePos3_1);
                S1716=3;
                if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 218, column: 13
                  moveToPos3.setPresent();//sysj\plant.sysj line: 219, column: 6
                  currsigs.addElement(moveToPos3);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1716=4;
                  if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 224, column: 13
                    moveToPos2.setPresent();//sysj\plant.sysj line: 225, column: 6
                    currsigs.addElement(moveToPos2);
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    S1716=5;
                    tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 230, column: 6
                    currsigs.addElement(tableAlignedWithSensor);
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                }
                break;
              
              case 3 : 
                removePos2_1.setPresent();//sysj\plant.sysj line: 221, column: 6
                currsigs.addElement(removePos2_1);
                S1716=4;
                if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 224, column: 13
                  moveToPos2.setPresent();//sysj\plant.sysj line: 225, column: 6
                  currsigs.addElement(moveToPos2);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1716=5;
                  tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 230, column: 6
                  currsigs.addElement(tableAlignedWithSensor);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 4 : 
                S1716=5;
                tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 230, column: 6
                currsigs.addElement(tableAlignedWithSensor);
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
                break;
              
              case 5 : 
                if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 229, column: 11
                  S1786=1;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 230, column: 6
                  currsigs.addElement(tableAlignedWithSensor);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1786=1;
            S1786=0;
            if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 199, column: 12
              S1716=0;
              __start_thread_15 = com.systemj.Timer.getMs();//sysj\plant.sysj line: 199, column: 31
              if(com.systemj.Timer.getMs() - __start_thread_15 >= 100){//sysj\plant.sysj line: 199, column: 31
                ends[15]=2;
                ;//sysj\plant.sysj line: 199, column: 31
                S1716=1;
                if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 204, column: 13
                  moveToPos5.setPresent();//sysj\plant.sysj line: 205, column: 6
                  currsigs.addElement(moveToPos5);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1716=2;
                  if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 211, column: 13
                    moveToPos4.setPresent();//sysj\plant.sysj line: 212, column: 6
                    currsigs.addElement(moveToPos4);
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    S1716=3;
                    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 218, column: 13
                      moveToPos3.setPresent();//sysj\plant.sysj line: 219, column: 6
                      currsigs.addElement(moveToPos3);
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                    else {
                      S1716=4;
                      if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 224, column: 13
                        moveToPos2.setPresent();//sysj\plant.sysj line: 225, column: 6
                        currsigs.addElement(moveToPos2);
                        active[15]=1;
                        ends[15]=1;
                        tdone[15]=1;
                      }
                      else {
                        S1716=5;
                        tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 230, column: 6
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
              S1786=1;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2117(int [] tdone, int [] ends){
        switch(S1693){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S1671){
          case 0 : 
            if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 187, column: 11
              S1671=1;
              cylClampedBottle.setPresent();//sysj\plant.sysj line: 190, column: 6
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
            if(!cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 189, column: 12
              S1671=2;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              cylClampedBottle.setPresent();//sysj\plant.sysj line: 190, column: 6
              currsigs.addElement(cylClampedBottle);
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 2 : 
            S1671=2;
            S1671=0;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2116(int [] tdone, int [] ends){
        switch(S1661){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S1617){
          case 0 : 
            if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 171, column: 12
              S1617=1;
              if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 175, column: 13
                gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 177, column: 7
                currsigs.addElement(gripperTurnHomePos);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S1617=2;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 172, column: 7
              currsigs.addElement(gripperTurnFinalPos);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 176, column: 12
              S1617=2;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 177, column: 7
              currsigs.addElement(gripperTurnHomePos);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 2 : 
            S1617=2;
            S1617=0;
            if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 170, column: 13
              gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 172, column: 7
              currsigs.addElement(gripperTurnFinalPos);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S1617=1;
              if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 175, column: 13
                gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 177, column: 7
                currsigs.addElement(gripperTurnHomePos);
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S1617=2;
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

  public void thread2115(int [] tdone, int [] ends){
        switch(S1596){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S1568){
          case 0 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 157, column: 11
              S1568=1;
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 161, column: 6
              currsigs.addElement(gripperZAxisLowered);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 158, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 160, column: 11
              S1568=2;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 161, column: 6
              currsigs.addElement(gripperZAxisLowered);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 2 : 
            S1568=2;
            S1568=0;
            gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 158, column: 6
            currsigs.addElement(gripperZAxisLifted);
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2114(int [] tdone, int [] ends){
        switch(S1555){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1533){
          case 0 : 
            if(moveToPos4.getprestatus()){//sysj\plant.sysj line: 146, column: 11
              S1533=1;
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 148, column: 6
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
            if(moveToPos5.getprestatus()){//sysj\plant.sysj line: 147, column: 11
              S1533=2;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              bottleAtPos4.setPresent();//sysj\plant.sysj line: 148, column: 6
              currsigs.addElement(bottleAtPos4);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 2 : 
            S1533=2;
            S1533=0;
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2113(int [] tdone, int [] ends){
        switch(S1523){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1509){
          case 0 : 
            if(!vacOn.getprestatus()){//sysj\plant.sysj line: 135, column: 11
              S1509=1;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              WPgripped.setPresent();//sysj\plant.sysj line: 136, column: 6
              currsigs.addElement(WPgripped);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            S1509=1;
            S1509=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 134, column: 12
              WPgripped.setPresent();//sysj\plant.sysj line: 136, column: 6
              currsigs.addElement(WPgripped);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S1509=1;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2112(int [] tdone, int [] ends){
        switch(S1503){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S1387){
          case 0 : 
            if(pusherExtend.getprestatus()){//sysj\plant.sysj line: 121, column: 10
              S1387=1;
              __start_thread_9 = com.systemj.Timer.getMs();//sysj\plant.sysj line: 120, column: 3
              if(com.systemj.Timer.getMs() - __start_thread_9 >= (2) * 1000){//sysj\plant.sysj line: 120, column: 3
                ends[9]=2;
                ;//sysj\plant.sysj line: 120, column: 3
                S1387=2;
                pusherExtended.setPresent();//sysj\plant.sysj line: 126, column: 5
                currsigs.addElement(pusherExtended);
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
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 122, column: 5
              currsigs.addElement(pusherRetracted);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(com.systemj.Timer.getMs() - __start_thread_9 >= (2) * 1000){//sysj\plant.sysj line: 120, column: 3
              ends[9]=2;
              ;//sysj\plant.sysj line: 120, column: 3
              S1387=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 126, column: 5
              currsigs.addElement(pusherExtended);
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
          
          case 2 : 
            if(!pusherExtend.getprestatus()){//sysj\plant.sysj line: 125, column: 10
              S1387=3;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 126, column: 5
              currsigs.addElement(pusherExtended);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 3 : 
            S1387=3;
            S1387=0;
            pusherRetracted.setPresent();//sysj\plant.sysj line: 122, column: 5
            currsigs.addElement(pusherRetracted);
            active[9]=1;
            ends[9]=1;
            tdone[9]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread2111(int [] tdone, int [] ends){
        switch(S1354){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S1310){
          case 0 : 
            if(armDest.getprestatus()){//sysj\plant.sysj line: 106, column: 12
              S1310=1;
              if(armDest.getprestatus() && !armSource.getprestatus()){//sysj\plant.sysj line: 110, column: 12
                armAtDest.setPresent();//sysj\plant.sysj line: 112, column: 6
                currsigs.addElement(armAtDest);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                S1310=2;
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 107, column: 6
              currsigs.addElement(armAtSource);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(armSource.getprestatus()){//sysj\plant.sysj line: 111, column: 12
              S1310=2;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 112, column: 6
              currsigs.addElement(armAtDest);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 2 : 
            S1310=2;
            S1310=0;
            if(armSource.getprestatus() && !armDest.getprestatus()){//sysj\plant.sysj line: 105, column: 12
              armAtSource.setPresent();//sysj\plant.sysj line: 107, column: 6
              currsigs.addElement(armAtSource);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S1310=1;
              if(armDest.getprestatus() && !armSource.getprestatus()){//sysj\plant.sysj line: 110, column: 12
                armAtDest.setPresent();//sysj\plant.sysj line: 112, column: 6
                currsigs.addElement(armAtDest);
                active[8]=1;
                ends[8]=1;
                tdone[8]=1;
              }
              else {
                S1310=2;
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

  public void thread2109(int [] tdone, int [] ends){
        switch(S1287){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        switch(S1243){
          case 0 : 
            if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 87, column: 13
              S1243=1;
              if(dosUnitValveRetract.getprestatus() && !dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 91, column: 13
                dosUnitFilled.setPresent();//sysj\plant.sysj line: 93, column: 7
                currsigs.addElement(dosUnitFilled);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S1243=2;
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 88, column: 7
              currsigs.addElement(dosUnitEvac);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 92, column: 13
              S1243=2;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              dosUnitFilled.setPresent();//sysj\plant.sysj line: 93, column: 7
              currsigs.addElement(dosUnitFilled);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 2 : 
            S1243=2;
            S1243=0;
            if(dosUnitValveExtend.getprestatus() && !dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 86, column: 13
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 88, column: 7
              currsigs.addElement(dosUnitEvac);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              S1243=1;
              if(dosUnitValveRetract.getprestatus() && !dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 91, column: 13
                dosUnitFilled.setPresent();//sysj\plant.sysj line: 93, column: 7
                currsigs.addElement(dosUnitFilled);
                active[7]=1;
                ends[7]=1;
                tdone[7]=1;
              }
              else {
                S1243=2;
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

  public void thread2108(int [] tdone, int [] ends){
        switch(S1222){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        switch(S1208){
          case 0 : 
            if(!valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 75, column: 12
              S1208=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              valveInjectorActive.setPresent();//sysj\plant.sysj line: 76, column: 7
              currsigs.addElement(valveInjectorActive);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
          case 1 : 
            S1208=1;
            S1208=0;
            if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 74, column: 13
              valveInjectorActive.setPresent();//sysj\plant.sysj line: 76, column: 7
              currsigs.addElement(valveInjectorActive);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              S1208=1;
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2107(int [] tdone, int [] ends){
        switch(S1289){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        thread2108(tdone,ends);
        thread2109(tdone,ends);
        int biggest2110 = 0;
        if(ends[6]>=biggest2110){
          biggest2110=ends[6];
        }
        if(ends[7]>=biggest2110){
          biggest2110=ends[7];
        }
        if(biggest2110 == 1){
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        //FINXME code
        if(biggest2110 == 0){
          S1289=0;
          active[5]=0;
          ends[5]=0;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread2105(int [] tdone, int [] ends){
        S1031=1;
    bottleLeftPos5.setPresent();//sysj\plant.sysj line: 59, column: 8
    currsigs.addElement(bottleLeftPos5);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2104(int [] tdone, int [] ends){
        S1025=1;
    bottleAtPos1.setPresent();//sysj\plant.sysj line: 53, column: 8
    currsigs.addElement(bottleAtPos1);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2102(int [] tdone, int [] ends){
        switch(S1031){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(!motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 58, column: 13
          S1031=0;
          active[4]=0;
          ends[4]=0;
          tdone[4]=1;
        }
        else {
          bottleLeftPos5.setPresent();//sysj\plant.sysj line: 59, column: 8
          currsigs.addElement(bottleLeftPos5);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread2101(int [] tdone, int [] ends){
        switch(S1025){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(moveToPos2.getprestatus()){//sysj\plant.sysj line: 52, column: 13
          S1025=0;
          active[3]=0;
          ends[3]=0;
          tdone[3]=1;
        }
        else {
          bottleAtPos1.setPresent();//sysj\plant.sysj line: 53, column: 8
          currsigs.addElement(bottleAtPos1);
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread2099(int [] tdone, int [] ends){
        S1031=1;
    bottleLeftPos5.setPresent();//sysj\plant.sysj line: 59, column: 8
    currsigs.addElement(bottleLeftPos5);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2098(int [] tdone, int [] ends){
        S1025=1;
    bottleAtPos1.setPresent();//sysj\plant.sysj line: 53, column: 8
    currsigs.addElement(bottleAtPos1);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2096(int [] tdone, int [] ends){
        S1031=1;
    bottleLeftPos5.setPresent();//sysj\plant.sysj line: 59, column: 8
    currsigs.addElement(bottleLeftPos5);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2095(int [] tdone, int [] ends){
        S1025=1;
    bottleAtPos1.setPresent();//sysj\plant.sysj line: 53, column: 8
    currsigs.addElement(bottleAtPos1);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2094(int [] tdone, int [] ends){
        switch(S1202){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1070){
          case 0 : 
            switch(S1068){
              case 0 : 
                switch(S1007){
                  case 0 : 
                    S1007=0;
                    if(com.systemj.Timer.getMs() - __start_thread_2 >= (2) * 1000){//sysj\plant.sysj line: 49, column: 29
                      ends[2]=2;
                      ;//sysj\plant.sysj line: 49, column: 29
                      S1068=1;
                      thread2095(tdone,ends);
                      thread2096(tdone,ends);
                      int biggest2097 = 0;
                      if(ends[3]>=biggest2097){
                        biggest2097=ends[3];
                      }
                      if(ends[4]>=biggest2097){
                        biggest2097=ends[4];
                      }
                      if(biggest2097 == 1){
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S1007=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    break;
                  
                  case 1 : 
                    S1007=1;
                    S1007=0;
                    if(com.systemj.Timer.getMs() - __start_thread_2 >= (2) * 1000){//sysj\plant.sysj line: 49, column: 29
                      ends[2]=2;
                      ;//sysj\plant.sysj line: 49, column: 29
                      S1068=1;
                      thread2098(tdone,ends);
                      thread2099(tdone,ends);
                      int biggest2100 = 0;
                      if(ends[3]>=biggest2100){
                        biggest2100=ends[3];
                      }
                      if(ends[4]>=biggest2100){
                        biggest2100=ends[4];
                      }
                      if(biggest2100 == 1){
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                    }
                    else {
                      S1007=1;
                      active[2]=1;
                      ends[2]=1;
                      tdone[2]=1;
                    }
                    break;
                  
                }
                break;
              
              case 1 : 
                thread2101(tdone,ends);
                thread2102(tdone,ends);
                int biggest2103 = 0;
                if(ends[3]>=biggest2103){
                  biggest2103=ends[3];
                }
                if(ends[4]>=biggest2103){
                  biggest2103=ends[4];
                }
                if(biggest2103 == 1){
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                //FINXME code
                if(biggest2103 == 0){
                  S1070=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1070=1;
            S1070=0;
            if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 49, column: 12
              S1068=0;
              __start_thread_2 = com.systemj.Timer.getMs();//sysj\plant.sysj line: 49, column: 29
              S1007=0;
              if(com.systemj.Timer.getMs() - __start_thread_2 >= (2) * 1000){//sysj\plant.sysj line: 49, column: 29
                ends[2]=2;
                ;//sysj\plant.sysj line: 49, column: 29
                S1068=1;
                thread2104(tdone,ends);
                thread2105(tdone,ends);
                int biggest2106 = 0;
                if(ends[3]>=biggest2106){
                  biggest2106=ends[3];
                }
                if(ends[4]>=biggest2106){
                  biggest2106=ends[4];
                }
                if(biggest2106 == 1){
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
              }
              else {
                S1007=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S1070=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2092(int [] tdone, int [] ends){
        S2069=1;
    S2055=0;
    if(moveToPos2.getprestatus()){//sysj\plant.sysj line: 273, column: 11
      bottleAtPos2.setPresent();//sysj\plant.sysj line: 275, column: 5
      currsigs.addElement(bottleAtPos2);
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
    else {
      S2055=1;
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
  }

  public void thread2091(int [] tdone, int [] ends){
        S2049=1;
    S2035=0;
    if(moveToPos3.getprestatus()){//sysj\plant.sysj line: 264, column: 11
      bottleAtPos3.setPresent();//sysj\plant.sysj line: 266, column: 5
      currsigs.addElement(bottleAtPos3);
      active[18]=1;
      ends[18]=1;
      tdone[18]=1;
    }
    else {
      S2035=1;
      active[18]=1;
      ends[18]=1;
      tdone[18]=1;
    }
  }

  public void thread2090(int [] tdone, int [] ends){
        S2029=1;
    S2015=0;
    if(moveToPos4.getprestatus()){//sysj\plant.sysj line: 254, column: 11
      bottleAtPos4.setPresent();//sysj\plant.sysj line: 256, column: 5
      currsigs.addElement(bottleAtPos4);
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
    else {
      S2015=1;
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
  }

  public void thread2089(int [] tdone, int [] ends){
        S2009=1;
    S1985=0;
    if(moveToPos5.getprestatus()){//sysj\plant.sysj line: 241, column: 13
      removePos4_1.setPresent();//sysj\plant.sysj line: 243, column: 7
      currsigs.addElement(removePos4_1);
      S1975=0;
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
    else {
      S1985=1;
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
  }

  public void thread2088(int [] tdone, int [] ends){
        S1974=1;
    S1786=0;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 199, column: 12
      S1716=0;
      __start_thread_15 = com.systemj.Timer.getMs();//sysj\plant.sysj line: 199, column: 31
      if(com.systemj.Timer.getMs() - __start_thread_15 >= 100){//sysj\plant.sysj line: 199, column: 31
        ends[15]=2;
        ;//sysj\plant.sysj line: 199, column: 31
        S1716=1;
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 204, column: 13
          moveToPos5.setPresent();//sysj\plant.sysj line: 205, column: 6
          currsigs.addElement(moveToPos5);
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
        else {
          S1716=2;
          if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 211, column: 13
            moveToPos4.setPresent();//sysj\plant.sysj line: 212, column: 6
            currsigs.addElement(moveToPos4);
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
          }
          else {
            S1716=3;
            if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 218, column: 13
              moveToPos3.setPresent();//sysj\plant.sysj line: 219, column: 6
              currsigs.addElement(moveToPos3);
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S1716=4;
              if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 224, column: 13
                moveToPos2.setPresent();//sysj\plant.sysj line: 225, column: 6
                currsigs.addElement(moveToPos2);
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              else {
                S1716=5;
                tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 230, column: 6
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
      S1786=1;
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
  }

  public void thread2087(int [] tdone, int [] ends){
        S1693=1;
    S1671=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread2086(int [] tdone, int [] ends){
        S1661=1;
    S1617=0;
    if(gripperTurnExtend.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 170, column: 13
      gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 172, column: 7
      currsigs.addElement(gripperTurnFinalPos);
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
    else {
      S1617=1;
      if(gripperTurnRetract.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 175, column: 13
        gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 177, column: 7
        currsigs.addElement(gripperTurnHomePos);
        active[13]=1;
        ends[13]=1;
        tdone[13]=1;
      }
      else {
        S1617=2;
        active[13]=1;
        ends[13]=1;
        tdone[13]=1;
      }
    }
  }

  public void thread2085(int [] tdone, int [] ends){
        S1596=1;
    S1568=0;
    gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 158, column: 6
    currsigs.addElement(gripperZAxisLifted);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2084(int [] tdone, int [] ends){
        S1555=1;
    S1533=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2083(int [] tdone, int [] ends){
        S1523=1;
    S1509=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 134, column: 12
      WPgripped.setPresent();//sysj\plant.sysj line: 136, column: 6
      currsigs.addElement(WPgripped);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      S1509=1;
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread2082(int [] tdone, int [] ends){
        S1503=1;
    S1387=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 122, column: 5
    currsigs.addElement(pusherRetracted);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2081(int [] tdone, int [] ends){
        S1354=1;
    S1310=0;
    if(armSource.getprestatus() && !armDest.getprestatus()){//sysj\plant.sysj line: 105, column: 12
      armAtSource.setPresent();//sysj\plant.sysj line: 107, column: 6
      currsigs.addElement(armAtSource);
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      S1310=1;
      if(armDest.getprestatus() && !armSource.getprestatus()){//sysj\plant.sysj line: 110, column: 12
        armAtDest.setPresent();//sysj\plant.sysj line: 112, column: 6
        currsigs.addElement(armAtDest);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
      }
      else {
        S1310=2;
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
      }
    }
  }

  public void thread2079(int [] tdone, int [] ends){
        S1287=1;
    S1243=0;
    if(dosUnitValveExtend.getprestatus() && !dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 86, column: 13
      dosUnitEvac.setPresent();//sysj\plant.sysj line: 88, column: 7
      currsigs.addElement(dosUnitEvac);
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
    else {
      S1243=1;
      if(dosUnitValveRetract.getprestatus() && !dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 91, column: 13
        dosUnitFilled.setPresent();//sysj\plant.sysj line: 93, column: 7
        currsigs.addElement(dosUnitFilled);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
      }
      else {
        S1243=2;
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
      }
    }
  }

  public void thread2078(int [] tdone, int [] ends){
        S1222=1;
    S1208=0;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 74, column: 13
      valveInjectorActive.setPresent();//sysj\plant.sysj line: 76, column: 7
      currsigs.addElement(valveInjectorActive);
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
    else {
      S1208=1;
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread2077(int [] tdone, int [] ends){
        S1289=1;
    thread2078(tdone,ends);
    thread2079(tdone,ends);
    int biggest2080 = 0;
    if(ends[6]>=biggest2080){
      biggest2080=ends[6];
    }
    if(ends[7]>=biggest2080){
      biggest2080=ends[7];
    }
    if(biggest2080 == 1){
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread2075(int [] tdone, int [] ends){
        S1031=1;
    bottleLeftPos5.setPresent();//sysj\plant.sysj line: 59, column: 8
    currsigs.addElement(bottleLeftPos5);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void thread2074(int [] tdone, int [] ends){
        S1025=1;
    bottleAtPos1.setPresent();//sysj\plant.sysj line: 53, column: 8
    currsigs.addElement(bottleAtPos1);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2073(int [] tdone, int [] ends){
        S1202=1;
    S1070=0;
    if(motConveyorOnOff.getprestatus()){//sysj\plant.sysj line: 49, column: 12
      S1068=0;
      __start_thread_2 = com.systemj.Timer.getMs();//sysj\plant.sysj line: 49, column: 29
      S1007=0;
      if(com.systemj.Timer.getMs() - __start_thread_2 >= (2) * 1000){//sysj\plant.sysj line: 49, column: 29
        ends[2]=2;
        ;//sysj\plant.sysj line: 49, column: 29
        S1068=1;
        thread2074(tdone,ends);
        thread2075(tdone,ends);
        int biggest2076 = 0;
        if(ends[3]>=biggest2076){
          biggest2076=ends[3];
        }
        if(ends[4]>=biggest2076){
          biggest2076=ends[4];
        }
        if(biggest2076 == 1){
          active[2]=1;
          ends[2]=1;
          tdone[2]=1;
        }
      }
      else {
        S1007=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
    }
    else {
      S1070=1;
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
      switch(S2071){
        case 0 : 
          S2071=0;
          break RUN;
        
        case 1 : 
          S2071=2;
          S2071=2;
          removePos4_1.setClear();//sysj\plant.sysj line: 45, column: 2
          removePos2_1.setClear();//sysj\plant.sysj line: 45, column: 2
          removePos3_1.setClear();//sysj\plant.sysj line: 45, column: 2
          thread2073(tdone,ends);
          thread2077(tdone,ends);
          thread2081(tdone,ends);
          thread2082(tdone,ends);
          thread2083(tdone,ends);
          thread2084(tdone,ends);
          thread2085(tdone,ends);
          thread2086(tdone,ends);
          thread2087(tdone,ends);
          thread2088(tdone,ends);
          thread2089(tdone,ends);
          thread2090(tdone,ends);
          thread2091(tdone,ends);
          thread2092(tdone,ends);
          int biggest2093 = 0;
          if(ends[2]>=biggest2093){
            biggest2093=ends[2];
          }
          if(ends[5]>=biggest2093){
            biggest2093=ends[5];
          }
          if(ends[8]>=biggest2093){
            biggest2093=ends[8];
          }
          if(ends[9]>=biggest2093){
            biggest2093=ends[9];
          }
          if(ends[10]>=biggest2093){
            biggest2093=ends[10];
          }
          if(ends[11]>=biggest2093){
            biggest2093=ends[11];
          }
          if(ends[12]>=biggest2093){
            biggest2093=ends[12];
          }
          if(ends[13]>=biggest2093){
            biggest2093=ends[13];
          }
          if(ends[14]>=biggest2093){
            biggest2093=ends[14];
          }
          if(ends[15]>=biggest2093){
            biggest2093=ends[15];
          }
          if(ends[16]>=biggest2093){
            biggest2093=ends[16];
          }
          if(ends[17]>=biggest2093){
            biggest2093=ends[17];
          }
          if(ends[18]>=biggest2093){
            biggest2093=ends[18];
          }
          if(ends[19]>=biggest2093){
            biggest2093=ends[19];
          }
          if(biggest2093 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          removePos4_1.setClear();//sysj\plant.sysj line: 45, column: 2
          removePos2_1.setClear();//sysj\plant.sysj line: 45, column: 2
          removePos3_1.setClear();//sysj\plant.sysj line: 45, column: 2
          thread2094(tdone,ends);
          thread2107(tdone,ends);
          thread2111(tdone,ends);
          thread2112(tdone,ends);
          thread2113(tdone,ends);
          thread2114(tdone,ends);
          thread2115(tdone,ends);
          thread2116(tdone,ends);
          thread2117(tdone,ends);
          thread2118(tdone,ends);
          thread2119(tdone,ends);
          thread2120(tdone,ends);
          thread2121(tdone,ends);
          thread2122(tdone,ends);
          int biggest2123 = 0;
          if(ends[2]>=biggest2123){
            biggest2123=ends[2];
          }
          if(ends[5]>=biggest2123){
            biggest2123=ends[5];
          }
          if(ends[8]>=biggest2123){
            biggest2123=ends[8];
          }
          if(ends[9]>=biggest2123){
            biggest2123=ends[9];
          }
          if(ends[10]>=biggest2123){
            biggest2123=ends[10];
          }
          if(ends[11]>=biggest2123){
            biggest2123=ends[11];
          }
          if(ends[12]>=biggest2123){
            biggest2123=ends[12];
          }
          if(ends[13]>=biggest2123){
            biggest2123=ends[13];
          }
          if(ends[14]>=biggest2123){
            biggest2123=ends[14];
          }
          if(ends[15]>=biggest2123){
            biggest2123=ends[15];
          }
          if(ends[16]>=biggest2123){
            biggest2123=ends[16];
          }
          if(ends[17]>=biggest2123){
            biggest2123=ends[17];
          }
          if(ends[18]>=biggest2123){
            biggest2123=ends[18];
          }
          if(ends[19]>=biggest2123){
            biggest2123=ends[19];
          }
          if(biggest2123 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2123 == 0){
            S2071=0;
            active[1]=0;
            ends[1]=0;
            S2071=0;
            break RUN;
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
      removePos4_1.setClear();
      removePos2_1.setClear();
      removePos3_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        systemEnable.gethook();
        motConveyorOnOff.gethook();
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
