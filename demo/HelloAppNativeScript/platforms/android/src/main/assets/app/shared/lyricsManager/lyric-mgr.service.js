"use strict";
var core_1 = require("@angular/core");
var hello_lyrics_lionel_1 = require("./hello-lyrics-lionel");
var hello_lyrics_adele_1 = require("./hello-lyrics-adele");
var sound = require("nativescript-sound");
var lionelAudio1 = sound.create("~/audio-files/lionel-hello-1.mp3");
var lionelAudio2 = sound.create("~/audio-files/lionel-hello-2.mp3");
var lionelAudio3 = sound.create("~/audio-files/lionel-hello-3.mp3");
var adeleAudio1 = sound.create("~/audio-files/adele-hello-1.mp3");
var adeleAudio2 = sound.create("~/audio-files/adele-hello-2.mp3");
var adeleAudio3 = sound.create("~/audio-files/adele-hello-3.mp3");
var LyricMgrService = (function () {
    function LyricMgrService() {
        this.helloByLionel = new hello_lyrics_lionel_1.HelloLyricsLionel();
        this.helloByAdele = new hello_lyrics_adele_1.HelloLyricsAdele();
    }
    LyricMgrService.prototype.playLyricForLionel = function () {
        var lyric = this.helloByLionel.getNextLyric();
        var index = this.helloByLionel.indexForLyric;
        switch (index) {
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
    };
    LyricMgrService.prototype.playLyricForAdele = function () {
        var lyric = this.helloByAdele.getNextLyric();
        var index = this.helloByAdele.indexForLyric;
        switch (index) {
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
    };
    LyricMgrService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], LyricMgrService);
    return LyricMgrService;
}());
exports.LyricMgrService = LyricMgrService;
//# sourceMappingURL=lyric-mgr.service.js.map