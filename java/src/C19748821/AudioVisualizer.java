package C19748821;

public class AudioVisualizer {
    
}
package C19748821;


import ddf.minim.AudioInput;
import ddf.minim.AudioOutput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import java.io.File;
import javax.swing.JFrame;

import ie.tudublin.Visual;
import processing.awt.PSurfaceAWT.SmoothCanvas;
import processing.core.*;
import static processing.core.PConstants.HSB;



@SuppressWarnings("serial")
public class AudioVisualizer extends Visual {
    public static int screenWidth = 1280, screenHeight = 720;

    @Override
    public void settings() {
        size(screenWidth, screenHeight);
    }


    String song;
    int circleCount = 10;
    Circle[] circles = new Circle[circleCount];
    boolean playIt = false;
    PImage backgroundImage;

    @Override
    public void setup(){

        //setting color mode to hsb
        colorMode(HSB);

        //starting minim
        startMinim();
        song = "heroplanet.mp3";
        loadAudio(song);

        //starting the song
        getAudioPlayer().play();
        backgroundImage = loadImage("background.jpg");

        //initializing the array of circles randomly and giving each circle random attributes
        for(int i = 0; i < circles.length; i++){
            circles[i] = new Circle(this);
            circles[i].speed = random(1, 3);
            circles[i].angle = random(360);
            circles[i].roundRadius = random(10, height/8);
            circles[i].radius = random(10, height/30);
            circles[i].fillCircle = 1;
        }

    }