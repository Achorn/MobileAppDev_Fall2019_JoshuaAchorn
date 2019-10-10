//
//  ViewController.swift
//  Coffee Helper
//
//  Created by Joshua Achorn on 9/30/19.
//  Copyright © 2019 Joshua Achorn. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    var timer = Timer()
    var minutes: Int = 0
    var seconds: Int = 0
    var fractions: Int = 0
    
    var stopwatchString: String = ""
    var startStopWatch: Bool = true
    
    
    @IBOutlet weak var stopwatchLabel: UILabel!
    @IBOutlet weak var resetButton: UIButton!
    @IBOutlet weak var startstopButton: UIButton!
    
    
    @IBAction func startStop(_ sender: AnyObject) {
        if startStopWatch == true{
            timer = Timer.scheduledTimer(timeInterval: 0.01, target: self, selector: Selector(("updateStopwatch")), userInfo: nil, repeats: true)
            startStopWatch = false
            startstopButton.setTitle("Stop", for: .normal)
        }else{
            timer.invalidate()
            startStopWatch = true
            startstopButton.setTitle("Start", for: .normal)
        }
    }
    
    @IBAction func reset(_ sender: Any) {
        fractions = 0
        seconds = 0
        minutes = 0
        stopwatchString = "00:00.00"
    }
    
    func updateStopWatch(){
        fractions += 1
        if fractions == 100{
            seconds += 1
            fractions = 0
        }
        if seconds == 60{
            minutes += 1
            seconds = 0
        }
        let fractionsString = fractions > 9 ? "\(fractions)" : "0\(fractions)"
        let secondsString = seconds > 9 ? "\(seconds)" : "0\(seconds)"
        let minutesString = minutes > 9 ? "\(minutes)" : "0\(minutes)"
        
        stopwatchString = "\(minutesString):\(secondsString).\(fractionsString)"
        stopwatchLabel.text = stopwatchString
    }
    
    
    @IBOutlet weak var coffeeValue: UITextField!
    @IBOutlet weak var waterValue: UITextField!
    @IBOutlet weak var cupsValue: UITextField!
    @IBOutlet weak var waterFinal: UILabel!
    @IBOutlet weak var coffeeFinal: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        stopwatchLabel.text = "00:00.00"
    }


    @IBAction func calcButton(_ sender: Any) {
        let coffee = Int(coffeeValue.text!)!
        let cups = Int(cupsValue.text!)!
        waterValue.text =  "\(coffee * 16)"
        waterFinal.text = "\(coffee * 16 * cups) g"
        coffeeFinal.text = "\(coffee * cups) g"
        coffeeValue.resignFirstResponder()
        coffeeValue.resignFirstResponder()
    }
    
    //Table View methods
//    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
//        var cell = UITableViewCell(style: UITableViewCellStyle.Value1, reuseIdentifier: "Cell")
//    }
//    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
//        return 3
//    }
    
}

