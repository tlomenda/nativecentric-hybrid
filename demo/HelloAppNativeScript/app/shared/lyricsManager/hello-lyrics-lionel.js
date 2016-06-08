"use strict";
var HelloLyricsLionel = (function () {
    function HelloLyricsLionel() {
        this.indexForLyric = 0;
        this.lyrics = [];
        this.lyrics.push("Hello!");
        this.lyrics.push("Is it me you're looking for?");
        this.lyrics.push("'cause I wonder where you are");
    }
    HelloLyricsLionel.prototype.getNextLyric = function () {
        if (this.isEndOfSong()) {
            this.indexForLyric = 0;
        }
        return this.lyrics[this.indexForLyric++];
    };
    HelloLyricsLionel.prototype.isEndOfSong = function () {
        if (this.indexForLyric === this.lyrics.length) {
            return true;
        }
        return false;
    };
    return HelloLyricsLionel;
}());
exports.HelloLyricsLionel = HelloLyricsLionel;
//# sourceMappingURL=hello-lyrics-lionel.js.map