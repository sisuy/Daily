import Product.Food;
import Product.Product;
import Recorder.Recorder;
import  GUI.*;

import java.util.ArrayList;

public class main {
    public void dayInfor(ArrayList<Product> arrayList){


    }

    public static void main(String args[]){
        Recorder recorder = new Recorder();
        Food f = new Food("cake",50.5,new int[] {2021,2,23});
        Food f1 = new Food("cake",50.3,new int[] {2021,2,23});
        recorder.add(f);
        recorder.add(f1);


        //GUI gui = new GUI();
    }
}
