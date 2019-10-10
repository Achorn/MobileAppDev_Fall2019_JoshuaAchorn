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
    var isTimerRunning: Bool = false
    var counter = 0.0
    
    @IBOutlet weak var stopwatchLabel: UILabel!
    @IBOutlet weak var resetButton: UIButton!
    @IBOutlet weak var startstopButton: UIButton!
    @IBOutlet weak var stopButton: UIButton!
    
    @IBAction func startStop(_ sender: Any) {
        print("start did tap")
        if !isTimerRunning{
            timer = Timer.scheduledTimer(timeInterval: 0.1, target: self, selector: #selector(runTimer), userInfo: nil, repeats: true)
            isTimerRunning = true
            resetButton.isEnabled = true
            stopButton.isEnabled = true
            startstopButton.isEnabled = false
        }
    }
    
    @IBAction func stopDidTap(_ sender: Any) {
        resetButton.isEnabled = true
        startstopButton.isEnabled = true
        stopButton.isEnabled = false
        
        isTimerRunning = false
        timer.invalidate()
        
    }
    
    @objc func runTimer(){
        print("Timer updated!")
        counter += 0.1
        stopwatchLabel.text = "\(counter)"
        let flooredCounter = Int(floor(counter))
//        let hour = flooredCounter / 3600
        let minute = (flooredCounter % 3600) / 60
        var minuteString = "\(minute)"
        if minute < 10 {
            minuteString = "0\(minute)"
        }
        let second = (flooredCounter % 3600) % 60
        var secondString = "\(second)"
        if second < 10 {
            secondString = "0\(second)"
        }
        let decisecond = String(format: "%.1f",counter).components(separatedBy: ".").last!
        stopwatchLabel.text = "\(minuteString):\(secondString).\(decisecond)"
    }
    
    @IBAction func reset(_ sender: Any) {
        print("reset did tap")
        isTimerRunning = false
        counter = 0.0
        stopwatchLabel.text = "00:00.0"
        resetButton.isEnabled = false
        startstopButton.isEnabled = true
        stopButton.isEnabled = false
    }
    
    
    @IBOutlet weak var coffeeValue: UITextField!
    @IBOutlet weak var waterValue: UITextField!
    @IBOutlet weak var cupsValue: UITextField!
    @IBOutlet weak var waterFinal: UILabel!
    @IBOutlet weak var coffeeFinal: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        resetButton.isEnabled = false
        stopButton.isEnabled = false
        startstopButton.isEnabled = true
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
    
   
    
}

