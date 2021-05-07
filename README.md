# Music Visualiser Project 2021

Name: Ali Ananzeh

Student Number: C19748821

# Assignment Discription
![image](https://user-images.githubusercontent.com/72251197/117396434-dfcc6d80-aef1-11eb-8377-96548bf43ef2.png)


Created a audio visualizer, for the intent purpose to test what I have learned within the course. This is a java based code that uses shapes and graphics in java to create a moving array of shapes and colors that stimulate the senses, The graphics interact to the musics frequencies. The speed also alternates to the speed of the music. This hopefully will be a barrage of wonderful colors. 


# Instructions
-Open the folder in your compiler with all the necessary files which is in :MusicVisuals\java inside here there is the java file you need to execute.
- You can execute the code from the file AudioVisualizer.java fouind in :MusicVisuals\java\src\c19748821

# How the program works
[image](https://user-images.githubusercontent.com/72251197/117396517-07233a80-aef2-11eb-94f9-08c61048241a.png)](https://www.youtube.com/watch?v=H9v1E1FZ_U0)

Above is a showcase video.

The way my music visualizer works is by calculating the values of fft bands and drawing circles with attributes based on those. The circles are connected with the center and each other by straight lines. The speed and radius of circles change as the song plays and it’s frequency changes. 
The circle class contains attributes like xpos, ypos, speed, radius, etc and contains an update method which draws a cirlce. Circles are drawn in the draw method of AudioVisualizer class. There is an array of circles in AudioVisualizer class which contains all the circles to be drawn.
The end product is that a mesh is produced which rotates and changes it’s size based on frequency of the music that’s playing. I went for a keliedoscope background to match my theme.

```Java
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


```

```Java

 void update(Circle[] balls, float soundValue){
        float hue = map(soundValue*500, -400, 400, 0, 255);

        angle += speed;

        //determining the x and y pos of circle based on the sound frequency value
        xPos = (float) Math.cos(PApplet.radians(angle)) * roundRadius * 5f;
        yPos = (float) Math.sin(PApplet.radians(angle)) * roundRadius * 3f;

        for (Circle ball : balls) {
            if (ball != this) {

                //this code draws lines from each circle to every other circle, creating a mesh
                gfx.stroke(hue, 100, 100);
                gfx.line(xPos, yPos, ball.xPos, ball.yPos);
            }
        }

        gfx.noStroke();
        gfx.fill(hue, 255, 255);
        gfx.circle(xPos, yPos, radius);
        
```

# Proud accoplishment
Getting a better understanding go git, understanding the effectivness of committing and the ability to use  git a lot better.
Creating a Mesh like structure around in my code to make this intricate design.

![image](https://user-images.githubusercontent.com/72251197/117396468-f246a700-aef1-11eb-88a0-1752c094ed25.png)



|Some stuff | Some more stuff in this column |

