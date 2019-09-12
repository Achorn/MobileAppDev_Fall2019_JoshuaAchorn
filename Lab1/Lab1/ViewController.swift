//
//  ViewController.swift
//  Lab1
//
//  Created by Joshua Achorn on 9/11/19.
//  Copyright © 2019 Joshua Achorn. All rights reserved.
//

import UIKit

class ViewController: UIViewController{
    @IBOutlet weak var viewImage: UIImageView!
    
    @IBOutlet weak var titletop: UILabel!
    
    @IBAction func chooseArt(_ sender: UIButton) {
        if sender.tag == 1{
            viewImage.image = UIImage(named:"bailee")
            titletop.text = "My Friend Bailee!"
        }
        else if sender.tag == 2{
            viewImage.image = UIImage(named:"kamiar")
            titletop.text = "My Friend Kamiar!"

        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    @IBOutlet weak var check: UIImageView!
    
}

