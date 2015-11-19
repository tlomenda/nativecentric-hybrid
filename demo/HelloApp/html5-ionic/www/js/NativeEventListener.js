/*
 * Taken from https://github.com/antonal80/HybridScreensDemoProject
 */
var NativeEventsListener = (function () {

  var logger = console;
  logger.log("Initializing");

  this.onReceivedEvent = function (eventData) {
    if (eventData) {
      logger.log("onReceivedEvent :: eventData :: " + JSON.stringify(eventData));

      var eventHandler = function () {
      };

      switch (eventData.eventType) {
        case "showNextLyricForWeb":
          eventHandler = showNextLyricForWeb;
          break;
        case "webWaitsToSing":
          eventHandler = webWaitsToSing;
          break;
        default:
          logger.log("onReceivedEvent :: unrecognized eventType");
      }
      eventHandler(eventData);
    }
  };

  function showNextLyricForWeb(eventData) {
    angular.element(document.getElementById('webSingApp')).scope().nextLyricForWeb();
  };
  function webWaitsToSing(eventData) {
    angular.element(document.getElementById('webSingApp')).scope().webWaitsToSing();
  };

  return this;
}());
