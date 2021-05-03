package C19748821;

import processing.core.PApplet;
import static processing.core.PApplet.map;

public class Circle{
    float speed;
    float angle;
    float xPos;
    float yPos;

    float width;
    float height;

    float xVel;
    float yVel;

    float roundRadius;
    float radius;

    int fillCircle = 0;

    PApplet gfx;
    public Circle(PApplet gfx){
        this.gfx = gfx;

        width = gfx.width;
        height = gfx.height;
    }

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
    }
}