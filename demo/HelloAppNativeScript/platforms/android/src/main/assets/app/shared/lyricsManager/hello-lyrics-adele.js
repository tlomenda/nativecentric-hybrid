"use strict";
var HelloLyricsAdele = (function () {
    function HelloLyricsAdele() {
        this.indexForLyric = 0;
        this.lyrics = [];
        this.lyrics.push("Hello, it's me");
        this.lyrics.push("I was wondering if after all these years you'd like to meet");
        this.lyrics.push("Hello, can you hear me?");
    }
    HelloLyricsAdele.prototype.getNextLyric = function () {
        if (this.isEndOfSong()) {
            this.indexForLyric = 0;
        }
        return this.lyrics[this.indexForLyric++];
    };
    HelloLyricsAdele.prototype.isEndOfSong = function () {
        if (this.indexForLyric === this.lyrics.length) {
            return true;
        }
        return false;
    };
    return HelloLyricsAdele;
}());
exports.HelloLyricsAdele = HelloLyricsAdele;
//# sourceMappingURL=hello-lyrics-adele.js.map