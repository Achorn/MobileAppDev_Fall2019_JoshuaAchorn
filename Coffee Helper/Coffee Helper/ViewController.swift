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
    
    @IBOutlet weak var cupLabel: UILabel!
    @IBOutlet weak var stopwatchLabel: UILabel!
    @IBOutlet weak var resetButton: UIButton!
    @IBOutlet weak var startstopButton: UIButton!
    @IBOutlet weak var stopButton: UIButton!
    @IBOutlet weak var cupSetterOutlet: UIStepper!
    @IBOutlet weak var ratiostepperOutlet: UIStepper!
    @IBOutlet weak var ratioLabel: UILabel!
    
    @IBAction func cupStepper(_ sender: UIStepper) {
        cupLabel.text = "\(Int(sender.value)) cup/s"
        calcButton(self)
    }
    
    @IBAction func ratioStepper(_ sender: UIStepper){
        ratioLabel.text = "1/\(Int(sender.value))"
        calcButton(self)
    }
    
    
    @IBAction func startStop(_ sender: Any) {
        print("start did tap")
        if !isTimerRunning{
            timer = Timer.scheduledTimer(timeInterval: 0.1, target: self, selector: #selector(runTimer), userInfo: nil, repeats: true)
            isTimerRunning = true
            resetButton.isEnabled = false
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
    @IBOutlet weak var waterFinal: UILabel!
    @IBOutlet weak var coffeeFinal: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        resetButton.isEnabled = false
        stopButton.isEnabled = false
        startstopButton.isEnabled = true
        stopwatchLabel.text = "00:00.00"
        resetButton.layer.cornerRadius = resetButton.frame.height/2
        resetButton.backgroundColor = UIColor.darkGray
    }


    @IBAction func calcButton(_ sender: Any) {
        let coffee = Int(coffeeValue.text!)!
        let cups = Int(cupSetterOutlet.value)
        let ratio = Int(ratiostepperOutlet.value)
        waterValue.text =  "\(coffee * ratio)"
        waterFinal.text = "\(coffee * ratio * cups) g"
        coffeeFinal.text = "\(coffee * cups) g"
        coffeeValue.resignFirstResponder()
        coffeeValue.resignFirstResponder()
    }
    
   
    
}

