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

/**
 *
 * @author Majey
 */
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
        song = "infraction.mp3";
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

    @Override
    public void keyReleased() {

        //using tab key for play/pause
        if (key == TAB) {
            if (!playIt) {
                etAudioPlayer().play();
                playIt = true;
            }else{
                getAudioPlayer().pause();
                playIt = false;
            }
        }
    }

    @Override
    public void draw(){
        translate(screenWidth/2, screenHeight/2);
        background(backgroundImage);
        stroke(255);

        //getting values of mix and frequencies from the audio player
        float mixSound = getAudioPlayer().mix.get(2);
        float radiusSoundFreq = getAudioPlayer().left.get(2);
        float speedSoundFreq = getAudioPlayer().right.get(2);
        float radiusSoundFreqSpeed = 200;
        float speedSoundFreqSpeed = 1;

        for(Circle circle : circles){
            circle.update(circles, getAudioPlayer().mix.get(2));

            //changing circle's radius and speed based on frequency of sound
            circle.radius = (radiusSoundFreq * radiusSoundFreqSpeed);
            circle.speed = circle.speed + ((speedSoundFreq * speedSoundFreqSpeed) / 4);

            //setting stroke based on the mix
            float hue = map(mixSound * 1000, -400, 300, 0, 255);
            stroke(hue, 255, 255);
            strokeWeight(2);

            //drawing lines from center to the circle
            line(0, 0, circle.xPos, circle.yPos);
            strokeWeight(1);
        }
    }

    @Override
    public void stop(){
        // always close Minim audio classes when you finish with them
        getAudioPlayer().close();

        super.stop();
    }

}
