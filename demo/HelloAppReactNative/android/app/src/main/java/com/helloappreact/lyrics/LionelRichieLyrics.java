package com.helloappreact.lyrics;

/**
 * Created by tlomenda on 11/30/15.
 */
public class LionelRichieLyrics {

    private int nextLyricIndex = 0;
    private String[] lyrics = {"Hello!","Is it me you're looking for?","'cause I wonder where you are"};

    public String getNextAudioFile() {
        if (isEndOfSong()) {
            nextLyricIndex = 0;
        }

        return "audio/lionel-hello-" + (nextLyricIndex+1) + ".mp3";
    }

    public String getNextLyric() {
        if (isEndOfSong()) {
            nextLyricIndex = 0;
        }

        return lyrics[nextLyricIndex++];
    }

    private boolean isEndOfSong() {
        if (nextLyricIndex == lyrics.length) {
            return true;
        }

        return false;
    }
}
