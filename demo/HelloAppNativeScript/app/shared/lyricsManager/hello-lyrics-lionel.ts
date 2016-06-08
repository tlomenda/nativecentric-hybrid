export class HelloLyricsLionel {
  indexForLyric: number = 0;
  lyrics: Array<string> = [];

  constructor() {
    this.lyrics.push("Hello!");
    this.lyrics.push("Is it me you're looking for?");
    this.lyrics.push("'cause I wonder where you are");
  }

  getNextLyric() {
    if (this.isEndOfSong()) {
      this.indexForLyric = 0;
    }

    return this.lyrics[this.indexForLyric++];
  }

  isEndOfSong() {
    if (this.indexForLyric === this.lyrics.length) {
      return true;
    }

    return false;
  }
}
