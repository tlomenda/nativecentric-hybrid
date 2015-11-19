/* Cordova/native bridging functionality */
var DuetHybridBridge = (function () {
  var PLUGIN_NAME = "DuetHybridBridge";
  var ACTION_BIND_LISTENER = "ACTION_BIND_LISTENER";
  var JS_TO_NATIVE_NEXTLYRIC = "JS_TO_NATIVE_NEXTLYRIC";
  var JS_TO_NATIVE_WAITFORLYRIC = "JS_TO_NATIVE_WAITFORLYRIC";
  var GET_NEXTLYRIC_FOR_WEB = "GET_NEXTLYRIC_FOR_WEB";

  var cordova = window.cordova;

  this.bindListener = function (listener) {
    cordova.exec(listener, listener, PLUGIN_NAME, ACTION_BIND_LISTENER, []);
  };

  this.nativeNextLyric = function () {
    cordova.exec(null, null, PLUGIN_NAME, JS_TO_NATIVE_NEXTLYRIC, []);
  };
  this.nativeWaitForLyric = function () {
    cordova.exec(null, null, PLUGIN_NAME, JS_TO_NATIVE_WAITFORLYRIC, []);
  };

  this.getNextLyricForWeb = function (successCallBack) {
    cordova.exec(successCallBack, failureCallBack, PLUGIN_NAME,
      GET_NEXTLYRIC_FOR_WEB, []);

    function failureCallBack(e) {
      console.log("Failure attempting to get next lyric.");
    }
  };

  return this;

}());
