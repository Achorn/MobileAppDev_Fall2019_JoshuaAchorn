//
//  ViewController.swift
//  Coffee Helper
//
//  Created by Joshua Achorn on 9/30/19.
//  Copyright © 2019 Joshua Achorn. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var coffeeValue: UITextField!
    @IBOutlet weak var waterValue: UITextField!
    @IBOutlet weak var cupsValue: UITextField!
    @IBOutlet weak var waterFinal: UILabel!
    @IBOutlet weak var coffeeFinal: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
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

