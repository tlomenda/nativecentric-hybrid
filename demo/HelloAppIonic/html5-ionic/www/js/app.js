// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
angular.module('starter', ['ionic'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if(window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }

    //allows JS to respond to events sent by the native OS
    DuetHybridBridge.bindListener(NativeEventsListener.onReceivedEvent);

  });
})

.controller('MainCtrl', function($scope) {
  $scope.lyricToSing = '<Start Singing>';

  $scope.nextLyricForWeb = function() {
    // Fetch Next Lyric
    DuetHybridBridge.getNextLyricForWeb(successCallBack);
    function successCallBack(nextLyric) {
      $scope.lyricToSing = nextLyric;
      $scope.$apply();

      DuetHybridBridge.nativeWaitForLyric();

    };
  };

  $scope.nextLyricForNative = function() {
    DuetHybridBridge.nativeNextLyric();
    $scope.webWaitsToSing();
  };

  $scope.webWaitsToSing = function() {
    $scope.lyricToSing = "...Listens...";
    $scope.$apply();
  };
});
