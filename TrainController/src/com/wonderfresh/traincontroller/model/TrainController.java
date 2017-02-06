/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wonderfresh.traincontroller.model;

/**
 *
 * @author Austin
 */
public class TrainController {

  public TrainController(int trainID, int routeID) {
    this.trainID = trainID;
    this.routeID = routeID;
    setPointSpeed = 0;
    setAuthority = 0;
    setSpeed = 0;
    realSpeed = 0;
    lights = 0;
    doorsLeft = 0;
    doorsRight = 0;
    airConditioning = 0;
    heating = 0;
    tempSet = 70;
    tempCurrent = 70;
    brakeService = false;
    brakeEmergency = false;
    gainProportional = 0;
    gainIntegral = 0;
  }    

  
  public int trainID;
  public int routeID;
  public int setPointSpeed;
  public int setAuthority;
  public int setSpeed;
  public int realSpeed;
  public int lights;
  public int doorsLeft;
  public int doorsRight;
  public int airConditioning;
  public int heating;
  public int tempSet;
  public int tempCurrent;
  public boolean brakeService;
  public boolean brakeEmergency;
  public double gainProportional;
  public double gainIntegral;
  
}
