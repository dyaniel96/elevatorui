import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class hw1 extends PApplet {


ControlP5 gui;
  PImage TOPUI;
  PImage BOTUI;
  PImage LeftDoor;
  PImage RightDoor;
  int lx = 0;
  int rx = 325;
  boolean doorclosed = true;
  boolean paused = true;
public void setup() {
  
  noStroke();
  frameRate(60);
  
  // Load the image into the program 
  TOPUI = loadImage("TOPUI.png"); 
  BOTUI = loadImage("BOTUI.png");
  LeftDoor = loadImage("EDoor.png");
  RightDoor = loadImage("EDoor.png");
  gui = new ControlP5(this);
  // change font and size
  ControlFont fontconfig = new ControlFont(createFont("Arial",30));
  // creat buttons for interaction
  createButton("Open",680,400,color(0), fontconfig);
  createButton("Close",820,400,color(0), fontconfig);
  //creat google buttons for floor
  gui.addToggle("     ")//5
     .setPosition(760, 164)
     .setSize(127, 42);
  gui.addToggle("    ")//4
     .setPosition(760, 210)
     .setSize(127, 42);
  gui.addToggle("   ")//3
     .setPosition(760, 255)
     .setSize(127, 42);
  gui.addToggle("  ")//2
     .setPosition(760, 302)
     .setSize(127, 42);
  gui.addToggle(" ")//1
     .setPosition(760, 348)
     .setSize(127, 42);
}

//creat button commad
public Button createButton(String theName, int theX, int theY, int theColor, ControlFont theFont) {
  Button b = gui.addButton(theName,1,theX,theY,120,39);
  b.setColorActive(theColor); // color for mouse-over
  b.setColorBackground(color(theColor)); // default color
  b.setCaptionLabel(theName).setFont(theFont);
  return b;
}

//open door conditions
public void Open(){
paused = false;
doorclosed = true;
}

//close door conditions
public void Close(){
doorclosed = false; 
paused = true;
}

//door animation
public void draw() {
  background(50);
  if(paused == false)
  {  
    if(lx > -320)
    {
      lx -= 5;
      rx += 5;
    }
  }
  if(lx < 0)
  {
    if(doorclosed == false)
    {
      lx += 5;
      rx -= 5;
    }
  }
  image(LeftDoor, lx, 0);
  image(RightDoor, rx, 0);
  image(TOPUI, 650, 0);
  image(BOTUI, 650, 160);


}
  public void settings() {  size(1000, 500);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "hw1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
