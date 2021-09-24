import Product.Food;
import Product.Product;
import Recorder.Recorder;
import  GUI.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void dayInfor(Recorder recorder){
        Scanner sn = new Scanner(System.in);
        try{
            System.out.println("Please enter year:");
            int year = sn.nextInt();
            System.out.println("Please enter month:");
            int month = sn.nextInt();
            System.out.println("Please enter day:");
            int day = sn.nextInt();
            for(Product product : recorder.searchDay(new int[] {year,month,day}).getRecorder()){
                product.information();
                System.out.println();
            }
            sn.close();
        }catch (InputMismatchException e){
            System.out.println("you have to input integer");
        }
    }

    public static void main(String args[]){
        Recorder recorder = new Recorder();
        Food f = new Food("cake",50.5,new int[] {2021,2,23});
        Food f1 = new Food("cake",50.3,new int[] {2021,2,23});
        recorder.add(f);
        recorder.add(f1);

        dayInfor(recorder);
        //GUI gui = new GUI();
    }
}
