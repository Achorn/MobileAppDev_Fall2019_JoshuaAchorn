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
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


    @IBAction func calcButton(_ sender: Any) {
        waterValue.text =  "\(Int(coffeeValue.text!)! * 16)"
        coffeeValue.resignFirstResponder()
    }
    
}

