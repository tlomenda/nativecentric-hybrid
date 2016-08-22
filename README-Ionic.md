# HelloApp Demo: Hybrid/Ionic

## Presentation Slides
See slides in [2016 Slides](./presentations/2016/Native-centric Hybrid Mobile Development.key) that shows how to *break away* from the traditonal **Cordova CLI** and use a custom tool [hybrid-app CLI](./cli-tool) that allows for an embedded approach.

## Running the Demo
Everything is checked in to run the demo out of the box.

* **Running on iOS via XCode**.  On CLI:
	* ```cd ./demo/HelloAppIonic/ios```
	* ```pod install```
	* ```open HelloApp.xcworkspace```
	* Launch the app from XCode.  Take time to review the code and setup in XCode.
* **Running on Android via Android Studio** 
	* Open *Android Studio* and select *Import project* option
	* navigate to ./demo/HelloAppIonic/android
	* Let the Gradle build finish (upgrade as needed) and run the app in an emulator.

## Cordova & Ionic Thoughts
* Renders using webviews on the platform.  
* Best you can do is mimic native.
* Animtions can be difficult.