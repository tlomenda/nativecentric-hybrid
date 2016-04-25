# Hybrid App CLI Tool
This README provides details to setup the *hybrid-app* CLI tool located in [./cli-tool](./cli-tool).

## Get Started
Before using the *hybrid-app* CLI tool to enable a native-centric project you need to install the pre-requisite software and packages.

###Essential Tools
* Homebrew ([Details Here](http://brew.sh/)) 
* CocoaPods 0.39.0 ([Follow Install Here](https://cocoapods.org/)) 
* Node 5.10.1 and NPM 3.8.3 ([Install via Homebrew](http://blog.teamtreehouse.com/install-node-js-npm-mac))
* Cordova 6.1.1 ([Install via npm](https://cordova.apache.org/)]
	* Plugman 1.2.1 (```npm -g install plugman```]
	* Platform iOS 4.1.1 (download from [here](http://archive.apache.org/dist/cordova/platforms/))
	* Platform Android 5.1.1 (download from [here](http://archive.apache.org/dist/cordova/platforms/))
* Ionic 1.7.14 ([Install via npm](http://ionicframework.com/getting-started/)]

**RECOMMENDATION**

Add *$CORDOVA_IOS_HOME* and *$CORDOVA_ANDROID_HOME* environment variables for *Platform iOS* and *Platform Android* and configure the following aliases in your *.profile* so these platforms can be used as CLI outside of Cordova:

```
alias cordova-ios-create="$CORDOVA_IOS_HOME/bin/create"
alias cordova-ios-update="$CORDOVA_IOS_HOME/bin/update"
alias cordova-ios-update-xproj="$CORDOVA_IOS_HOME/bin/update_cordova_subproject"

alias cordova-android-create="$CORDOVA_ANDROID_HOME/bin/create"
alias cordova-android-update="$CORDOVA_ANDROID_HOME/bin/update"
```

##Nice to Have Tools
* Ionic 2-beta is out there.  If you want to live dangerously:

```
$ npm -g install ionic@beta
```

##CLI Tool On the PATH
Place the files in [./cli-tool](./cli-tool) into a *bin* on your *Path* and make sure the *hybrid-app* script is executable (chmod 755).

##Try It Out
Open a Terminal/Command Line, cd to a working directory and do the following:

```
$ hybrid-app ionic blank com.sample.MyApp MyApp
$ cd MyApp 
```

###Run in Xcode Simulator
```
$ open ./ios/MyApp.xcworkspace
```