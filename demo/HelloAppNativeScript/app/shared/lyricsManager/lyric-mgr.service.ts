import {Injectable} from "@angular/core";

import {HelloLyricsLionel} from "./hello-lyrics-lionel";
import {HelloLyricsAdele} from "./hello-lyrics-adele";

var sound = require("nativescript-sound");

var lionelAudio1 = sound.create("~/audio-files/lionel-hello-1.mp3");
var lionelAudio2 = sound.create("~/audio-files/lionel-hello-2.mp3");
var lionelAudio3 = sound.create("~/audio-files/lionel-hello-3.mp3");

var adeleAudio1 = sound.create("~/audio-files/adele-hello-1.mp3");
var adeleAudio2 = sound.create("~/audio-files/adele-hello-2.mp3");
var adeleAudio3 = sound.create("~/audio-files/adele-hello-3.mp3");

@Injectable()
export class LyricMgrService {
  helloByLionel: HelloLyricsLionel = new HelloLyricsLionel();
  helloByAdele: HelloLyricsAdele = new HelloLyricsAdele();

  constructor() {
  }

  playLyricForLionel() {
    var lyric = this.helloByLionel.getNextLyric();
    var index = this.helloByLionel.indexForLyric;

    switch(index) {
      case 1:
        lionelAudio1.play();
        break;
      case 2:
        lionelAudio2.play();
        break;
      case 3:
        lionelAudio3.play();
        break;
      default:
        break;
    }

    return lyric;
  }
  playLyricForAdele() {
    var lyric = this.helloByAdele.getNextLyric();
    var index = this.helloByAdele.indexForLyric;

    switch(index) {
      case 1:
        adeleAudio1.play();
        break;
      case 2:
        adeleAudio2.play();
        break;
      case 3:
        adeleAudio3.play();
        break;
      default:
        break;
    }

    return lyric;
  }
}
