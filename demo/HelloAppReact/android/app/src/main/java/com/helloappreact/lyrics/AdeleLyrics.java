package com.helloappreact.lyrics;

/**
 * Created by tlomenda on 11/30/15.
 */
public class AdeleLyrics {
    private int nextLyricIndex = 0;
    private String[] lyrics = {"Hello, it's me", "I was wondering if after all these years you'd like to meet", "Hello, can you hear me?"};

    public String getNextAudioFile() {
        if (isEndOfSong()) {
            nextLyricIndex = 0;
        }

        return "audio/adele-hello-" + (nextLyricIndex+1) + ".mp3";
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
