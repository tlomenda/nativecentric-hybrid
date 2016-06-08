import {Component} from "@angular/core";

import {View} from "ui/core/view";
import {TextField} from "ui/text-field";

import {LyricMgrService} from "../../shared/lyricsManager/lyric-mgr.service";

@Component({
    selector: "hello-duet-page",
    providers: [LyricMgrService],
    templateUrl: "pages/helloDuet/helloDuet.html",
    styleUrls: ["pages/helloDuet/helloDuet-common.css", "pages/helloDuet/helloDuet.css"]
})
export class HelloDuetPage {
  lyricForLionel: string;
  lyricForAdele: string;

  constructor(private _lyricsMgr: LyricMgrService) {
    this.lyricForLionel = "<Start Singing>";
    this.lyricForAdele = "<Start Singing>";
  }

  playHelloByLionel() {
    this.lyricForAdele = "...Listening";

    this.lyricForLionel = this._lyricsMgr.playLyricForLionel();
  }

  playHelloByAdele() {
    this.lyricForLionel = "...Listening";

    this.lyricForAdele = this._lyricsMgr.playLyricForAdele();
  }
}
