
import peasy.*; // http://mrfeinberg.com/peasycam/#download

float x = 0.01;
float y = 0;
float z = 0;

float a = 10; // sigma
float b = 28; // rho
float c = 8.0/3.0; // beta

PeasyCam cam;

ArrayList<PVector> points = new ArrayList<PVector>();

int timeStep = 50;

void setup() {
  size(800,600, P3D);
  colorMode(HSB);
  cam = new PeasyCam(this, 500);
}

void draw() {
  background(0); 
  float dt = .01;
  
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
    
    hu+=0.1;
    if (hu > 255) hu = 0;
  }
  endShape();
  
  //println(x,y,z);
  //point(x,y,z)
  
}
