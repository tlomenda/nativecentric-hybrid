"use strict";
var core_1 = require("@angular/core");
var lyric_mgr_service_1 = require("../../shared/lyricsManager/lyric-mgr.service");
var HelloDuetPage = (function () {
    function HelloDuetPage(_lyricsMgr) {
        this._lyricsMgr = _lyricsMgr;
        this.lyricForLionel = "<Start Singing>";
        this.lyricForAdele = "<Start Singing>";
    }
    HelloDuetPage.prototype.playHelloByLionel = function () {
        this.lyricForAdele = "...Listening";
        this.lyricForLionel = this._lyricsMgr.playLyricForLionel();
    };
    HelloDuetPage.prototype.playHelloByAdele = function () {
        this.lyricForLionel = "...Listening";
        this.lyricForAdele = this._lyricsMgr.playLyricForAdele();
    };
    HelloDuetPage = __decorate([
        core_1.Component({
            selector: "hello-duet-page",
            providers: [lyric_mgr_service_1.LyricMgrService],
            templateUrl: "pages/helloDuet/helloDuet.html",
            styleUrls: ["pages/helloDuet/helloDuet-common.css", "pages/helloDuet/helloDuet.css"]
        }), 
        __metadata('design:paramtypes', [lyric_mgr_service_1.LyricMgrService])
    ], HelloDuetPage);
    return HelloDuetPage;
}());
exports.HelloDuetPage = HelloDuetPage;
//# sourceMappingURL=helloDuet.component.js.map