//
//  MainViewController.swift
//  MobConApp
//
//  Created by Torey Lomenda on 8/21/15.
//
//

import UIKit

class MainViewController: UIViewController {
    var htmlViewController:CDVViewController!

    @IBOutlet weak var nextLyricLabel: UILabel!
    
    @IBOutlet weak var buttonIOSSings: UIButton!
    @IBOutlet weak var buttonWebSings: UIButton!
    
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
        
        // Setup the Cordova Web View
        self.htmlViewController = CDVViewController()

        // Defaults for Cordova
        htmlViewController.wwwFolderName = "www"
        htmlViewController.startPage = "webSrc/index.html"

        // Add the embedded web view
        self.view.addSubview(htmlViewController.view)
        
        // Add button events
        buttonIOSSings.addTarget(self, action: "iosSingsTapped:", forControlEvents: UIControlEvents.TouchUpInside)
        buttonWebSings.addTarget(self, action: "webSingsTapped:", forControlEvents: UIControlEvents.TouchUpInside)
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
    
    // MARK:  Private Methods
    func resizeView() {
        let bounds = self.view.bounds
        
       self.htmlViewController.view.frame = CGRectMake(0, bounds.height/2, bounds.width, bounds.height/2)
    }
    
    // MARK: Private Button Events
    func iosSingsTapped(sender:UIButton) {
        nextLyricLabel.text = (UIApplication.sharedApplication().delegate as! AppDelegate).helloByLionelRitchie.getNextLyric()
        
        webWaitsToSing()
    }
    
    func webSingsTapped(sender:UIButton) {
        dispatch_async(dispatch_get_main_queue(), {
            // let the JS know to fetch the next Lyric
            let bridge:DuetHybridBridge = self.htmlViewController.pluginObjects.objectForKey("DuetHybridBridge") as! DuetHybridBridge
            let dict:NSDictionary = ["eventType": "showNextLyricForWeb"]
            bridge.reportEvent(dict)
        })
    }
    
    func webWaitsToSing() {
        dispatch_async(dispatch_get_main_queue(), {
            // let the JS know to fetch the next Lyric
            let bridge:DuetHybridBridge = self.htmlViewController.pluginObjects.objectForKey("DuetHybridBridge") as! DuetHybridBridge
            let dict:NSDictionary = ["eventType": "webWaitsToSing"]
            bridge.reportEvent(dict)
        })
    }
}
