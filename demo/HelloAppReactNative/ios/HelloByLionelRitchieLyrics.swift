//
//  HelloLionelRitchie.swift
//  HelloApp
//
//  Created by Torey Lomenda on 11/13/15.
//
//

import UIKit
import AVFoundation

class HelloByLionelRitchieLyrics: NSObject {
    var nextLyricIndex = 0
    var audioPlayer = AVAudioPlayer()
    
    let lyrics = [
    "Hello!",
    
    "Is it me you're looking for?",
    
    "'cause I wonder where you are"];
    
    func getNextLyric() -> String {
        if (isEndOfSong()) {
            nextLyricIndex = 0
        }
        
        playNextLyric()
      
        let index = nextLyricIndex
        nextLyricIndex += 1
        
        return lyrics[index]
    }
  
    func playNextLyric() {
        let filenameTemplate = "lionel-hello-%d"
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
