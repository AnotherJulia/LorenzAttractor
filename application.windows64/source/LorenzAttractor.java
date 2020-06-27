import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class LorenzAttractor extends PApplet {


 // http://mrfeinberg.com/peasycam/#download

float x = 0.01f;
float y = 0;
float z = 0;

float a = 10; // sigma
float b = 28; // rho
float c = 8.0f/3.0f; // beta

PeasyCam cam;

ArrayList<PVector> points = new ArrayList<PVector>();

int timeStep = 50;

public void setup() {
  
  colorMode(HSB);
  cam = new PeasyCam(this, 500);
}

public void draw() {
  background(0); 
  float dt = .01f;
  
  //https://nl.wikipedia.org/wiki/Lorenz-aantrekker
  float dx = (a * (y - x)) * dt;
  float dy = (x * (b - z) - y) * dt;
  float dz = (x * y - c * z) * dt;
  x = x + dx;
  y = y + dy;
  z = z + dz;
  
  points.add(new PVector(x,y,z));
  
  
  translate(0,0,-80);
  scale(3);
  
  noFill();
  
  float hu = 0;
  beginShape();
  for (PVector v : points) {
    stroke(hu, 255, 255);
    vertex(v.x, v.y, v.z);  
    
    hu+=0.1f;
    if (hu > 255) hu = 0;
  }
  endShape();
  
  //println(x,y,z);
  //point(x,y,z)
  
}
  public void settings() {  size(800,600, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "LorenzAttractor" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
