package example;

import ie.tudublin.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;

    public void settings()
    {
        size(1024, 500);

    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("infraction.mp3");

        
        // Call this instead to read audio from the microphone
        //startListening();
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();
        wf.render();
        abv.render();
    }
}