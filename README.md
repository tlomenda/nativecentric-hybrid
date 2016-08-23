# Native-Centric Hybrid Approach
The essence of a *native-centric* development approach is since Users expect an **intimate UX**, Developers should get **intimate with the platforms** they are targeting while striving to **maximize code reuse**.

This README contains important information about setting up the demo apps described and demo'ed during the Tech Talk.

To get started clone this repository:

```
$ git clone https://github.com/tlomenda/nativecentric-hybrid.git
```
## Mac:  Pre-requisites to Run Demo Apps

* OS X Mavericks or later
	* The latest Node.js 0.10.x, 0.12.x, 4.x, 5.x, or 6.x stable official release
	* For iOS development
		* Latest Xcode
		* Command-line tools for Xcode
		* xcodeproj ruby gem
		* CocoaPods (version 0.39.0)
		* (Optional) xcproj command line tool
	* For Android development
		* JDK 8 or a later stable official release
		* Android SDK 22 or a later stable official release
		* Local Maven repository for Support Libraries
		* Android SDK Build-tools 23.0.3 or a later stable official release
		* (Optional) Genymotion to expand your testing options
		* You must also have the following two environment variables setup for Android development:

```
JAVA_HOME
ANDROID_HOME
```

* Install **Homebrew**

```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```
* OR Update **Homebrew**
 
```
brew update
```
* **React Native** Installation
	* ```brew install node```
	* ```brew install watchman```
	* ```npm install -g react-native-cli``` 
	* At the time of writing the *react native* versions were:
	
	```
	react-native-cli: 1.0.0
	react-native: 0.30.0
	```
* **NativeScript**
	* ```npm i -g nativescript```
	* At the time of writing the *nativescript* version was *2.2.1*.

* **Cordova/Ionic**
	* ```npm install -g cordova```.  NOTE:  version 5.4.0 at time of writing.
	* ```npm install -g ionic```.  NOTE:  version 1.7.0 at time of writing.

*NOTE:  The hybrid app has not been tested with the 6.x or higher of Cordova OR Ionic 2.x*.

## Demo App Wth Ionic
Details on getting started with the Cordova/Ionic Demo can be found at [Ionic Demo Setup](README-Ionic.md).

###Installing hybrid-app CLI script

## Demo App with React Native
[React Native Demo Setup](README-ReactNative.md).

## Demo App with NativeScript
[NativeScript Demo Setup](README-NativeScript.md).


##Conclusions of Hybrid Mobile

###Pros
* Gives you freedom of choice.

###Cons
* Adds complexity.
* Greater responsibility.
* Need to know multiple programming languages (Swift, Java, JavaScript) and mobile platforms.
