package com.example.theupdatedbouldercoffeerec;

public class CoffeeShop {
    private String coffeeShopName;
    private String coffeeShopURL;

    private void setCoffeeInfo(Integer coffeeCrowd){
        switch (coffeeCrowd){
            case 0: //popular
                coffeeShopName="Starbucks";
                coffeeShopURL="https://www.starbucks.com";
                break;
            case 1: //cycling
                coffeeShopName="Rapha";
                coffeeShopURL="https://www.rapha.cc/us/en_US/clubhouses/boulder";
                break;
            case 2: //hipster
                coffeeShopName="Boxcar";
                coffeeShopURL="https://www.boxcarcoffeeroasters.com/";
                break;
            case 3: //tea
                coffeeShopName="Dushanbe";
                coffeeShopURL="https://www.boulderteahouse.com/";
                break;
            case 4: //hippie
                coffeeShopName="Trident";
                coffeeShopURL="http://www.tridentcafe.com";
                break;
            default:
                coffeeShopName="none";
                coffeeShopURL="https://www.google.com/search?q=boulder+coffee+shops&ie=utf-8&oe=utf-8";
        }
    }

    public String getCoffeeShopName(){
        return coffeeShopName;
    }

    public String getCoffeeShopURL(){
        return coffeeShopURL;
    }

    public void setCoffeeShopName(Integer coffeeCrowd){
        setCoffeeInfo(coffeeCrowd);
    }

    public void setCoffeeShopURL(Integer coffeeCrowd){
        setCoffeeInfo(coffeeCrowd);
    }

}
