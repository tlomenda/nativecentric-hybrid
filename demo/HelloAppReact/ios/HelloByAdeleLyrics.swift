//
//  HelloByAdeleLyrics.swift
//  HelloApp
//
//  Created by Torey Lomenda on 11/13/15.
//
//

import UIKit
import AVFoundation

class HelloByAdeleLyrics: NSObject {
    var nextLyricIndex = 0
    var audioPlayer = AVAudioPlayer()
    
    let lyrics = [
        "Hello, it's me",
       
        "I was wondering if after all these years you'd like to meet",
       
        "Hello, can you hear me?"];
    
    func getNextLyric() -> String {
        if (isEndOfSong()) {
            nextLyricIndex = 0
        }
        
        playNextLyric()
        return lyrics[nextLyricIndex++]
    }
    
    func playNextLyric() {
        let filenameTemplate = "adele-hello-%d"
        let audioFileName:String = String(format: filenameTemplate, nextLyricIndex+1)
        
        playSound(audioFileName)
    }
    
    func isEndOfSong() -> Bool {
        if (nextLyricIndex == lyrics.count) {
            return true
        }
        
        return false
    }
    
    // MARK: private methods
    func playSound(soundName: String) {
        let sound = NSURL(fileURLWithPath: NSBundle.mainBundle().pathForResource(soundName, ofType: "mp3")!)
        do{
            audioPlayer = try AVAudioPlayer(contentsOfURL:sound)
            audioPlayer.prepareToPlay()
            audioPlayer.play()
        }catch {
            print("Error getting the audio file")
        }
    }
}
