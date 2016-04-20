//
//  AppDelegate.swift
//  HelloAppReact
//
//  Created by Torey Lomenda on 4/19/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
  
  let helloByLionelRitchie = HelloByLionelRitchieLyrics()
  let helloByAdele = HelloByAdeleLyrics()

  /**
   * Loading JavaScript code - uncomment the one you want.
   *
   * OPTION 1
   * Load from development server. Start the server from the repository root:
   *
   * $ npm start
   *
   * To run on device, change `localhost` to the IP address of your computer
   * (you can get this by typing `ifconfig` into the terminal and selecting the
   * `inet` value under `en0:`) and make sure your computer and iOS device are
   * on the same Wi-Fi network.
   */
  let jsCodeLocation:NSURL = NSURL(string: "http://localhost:8081/index.ios.bundle?platform=ios&dev=true")!
  
  /**
   * OPTION 2
   * Load from pre-bundled file on disk. The static bundle is automatically
   * generated by the "Bundle React Native code and images" build step when
   * running the project on an actual device or running the project on the
   * simulator in the "Release" build configuration.
   */
  //let jsCodeLocation:NSURL = NSBundle.mainBundle().URLForResource("main", withExtension: "jsbundle")
  
  var window: UIWindow?
  
  override init() {
    super.init()
  }
  
  func application(application: UIApplication, didFinishLaunchingWithOptions launchOptions: [NSObject: AnyObject]?) -> Bool {
    let mainVC = MainViewController(nibName:"MainView", bundle:nil)
    self.window = UIWindow(frame: UIScreen.mainScreen().bounds)
    
    self.window?.rootViewController = mainVC
    self.window?.makeKeyAndVisible()
    
    return true
  }
}
