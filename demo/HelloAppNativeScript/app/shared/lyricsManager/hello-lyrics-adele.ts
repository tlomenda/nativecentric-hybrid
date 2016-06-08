export class HelloLyricsAdele {
  indexForLyric: number = 0;
  lyrics: Array<string> = [];

  constructor() {
    this.lyrics.push("Hello, it's me");
    this.lyrics.push("I was wondering if after all these years you'd like to meet");
    this.lyrics.push("Hello, can you hear me?");
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
