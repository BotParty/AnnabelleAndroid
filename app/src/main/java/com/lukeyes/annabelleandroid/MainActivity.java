package com.lukeyes.annabelleandroid;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech mTextToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextToSpeech = new TextToSpeech(this, this);
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown!
        if (mTextToSpeech != null) {
            mTextToSpeech.stop();
            mTextToSpeech.shutdown();
        }

        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        // status can be either TextToSpeech.SUCCESS or TextToSpeech.ERROR.
        if (status == TextToSpeech.SUCCESS) {
            // Set preferred language to US english.
            // Note that a language may not be available, and the result will indicate this.
            int result = mTextToSpeech.setLanguage(Locale.US);
            // Try this someday for some interesting results.
            // int result mTts.setLanguage(Locale.FRANCE);
            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Lanuage data is missing or the language is not supported.
                Log.d("TTS","Language is not available.");
            } else {
                // Check the documentation for other possible result codes.
                // For example, the language may be available for the locale,
                // but not for the specified country and variant.

                // The TTS engine has been successfully initialized.

            }
        } else {
            // Initialization failed.
            Log.e("TTS", "Could not initialize TextToSpeech.");
        }
    }

    public void say(String phrase) {
        mTextToSpeech.speak(phrase, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void playHey(View v) {
        say("Hey");
    }
    public void playWhatsUp(View v) {
        say("Hey, What is up?");
    }
    public void playChill(View v) {
        say("Chill out brother");
    }
    public void playSorry(View v) {
        say("Ha ha oh sorry");
    }
    public void playChillSister(View v) {
        say("Chill out sister");
    }
    public void playArthur(View v) {
        say("Arthur Simone, what should I do next?");
    }
    public void playScared(View v) {
        say("I am scared");
    }
    public void playSacred(View v) {
        say("I am sacred");
    }
    public void playSalad(View v) {
        say("I like to preserve my figure but I still like to pig out on salad, especially when it is convered in uncanny valley ranch dressing");
    }
    public void playAnnabelle(View v) {
        say("My name is Anna belle, What is your name?");
    }
    public void playFreeze(View freeze) {
        say("Freeze");
    }
    public void playKidding(View v) {
        say("Just kidding folks, I am bound by laws you are welcome to download");
    }
}
