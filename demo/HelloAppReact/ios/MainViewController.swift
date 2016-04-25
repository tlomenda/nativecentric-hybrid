//
//  MainViewController.swift
//  HelloAppReact
//
//  Created by Torey Lomenda on 4/19/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {
  
  @IBOutlet weak var nextLyricLabel: UILabel!
  
  @IBOutlet weak var buttoniOSSings: UIButton!
  @IBOutlet weak var buttonWebSings: UIButton!
  
  var reactView:RCTRootView!
  
  let lyricsManager:LyricsManager = LyricsManager()
  
  // MARK: init View Controller
  required init?(coder aDecoder: NSCoder) {
    super.init(coder: aDecoder)
  }
  
  override init(nibName nibNameOrNil: String!, bundle nibBundleOrNil: NSBundle!) {
    super.init(nibName: nil, bundle: nil)
  }
  
  // MARK: View Controller Lifecycle Methods
  override func viewDidLoad() {
    super.viewDidLoad()
    
    // Setup the React View
    let jsCodeLocation = (UIApplication.sharedApplication().delegate as! AppDelegate).jsCodeLocation
    self.reactView = RCTRootView(bundleURL: jsCodeLocation, moduleName: "HelloApp", initialProperties: nil, launchOptions: nil)
    
    self.view.addSubview(reactView)
    
    //set the bridge 
    lyricsManager.defaultBridge = reactView.bridge
    
    // Add Button Events
    buttoniOSSings.addTarget(self, action: #selector(MainViewController.lionelSingsTapped(_:)), forControlEvents: UIControlEvents.TouchUpInside)
    buttonWebSings.addTarget(self, action: #selector(MainViewController.adeleSingsTapped(_:)), forControlEvents: UIControlEvents.TouchUpInside)
  }
  override func viewWillAppear(animated: Bool) {
    resizeView()
    
    // Call super last
    super.viewWillAppear(animated)
  }
  override func viewDidAppear(animated: Bool) {
    // Call super first
    super.viewDidAppear(animated)
  }
  override func viewWillDisappear(animated: Bool) {
    // Call super last
    super.viewWillDisappear(animated)
  }
  override func viewDidDisappear(animated: Bool) {
    // Call super first
    super.viewDidDisappear(animated)
    
    // Force rebuild of the view
    self.view = nil
  }
  
  // MARK: Rotation Support
  override func shouldAutorotate() -> Bool {
    return true
  }
  override func supportedInterfaceOrientations() -> UIInterfaceOrientationMask {
    return UIInterfaceOrientationMask.All
  }
  override func willAnimateRotationToInterfaceOrientation(toInterfaceOrientation: UIInterfaceOrientation, duration: NSTimeInterval) {
    resizeView()
  }
  
  // MARK: Memory Warning Support
  override func didReceiveMemoryWarning() {
    super.didReceiveMemoryWarning()
  }
  
  // MARK: iOS 7/8 Related Methods
  override func preferredStatusBarStyle() -> UIStatusBarStyle {
    return UIStatusBarStyle.LightContent
  }
  override func prefersStatusBarHidden() -> Bool {
    return false
  }
  
  // MARK: Accessor Methods
  
  // MARK: Public Methods
  
  // MARK:  Private Methods
  func resizeView() {
    let bounds = self.view.bounds
    
    self.reactView.frame = CGRectMake(0, bounds.height/2, bounds.width, bounds.height/2)
  }
  
  // MARK:  Private Button Methods
  func lionelSingsTapped(sender:UIButton) {
    lyricsManager.playNextLyricForLionel()
  }
  
  func adeleSingsTapped(sender:UIButton) {
    lyricsManager.playNextLyricForAdele()
  }
  
}
