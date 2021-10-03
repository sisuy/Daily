import Product.Food;
import Product.Product;
import Recorder.Recorder;

import java.util.*;

import  GUI.*;

import java.io.InputStream;
import java.util.Scanner;

public class main {
    public static void dayInfor(int[] arr,Recorder recorder){
                int year = arr[0];
                int month = arr[1];
                int day = arr[2];

                for(Product product : recorder.searchDay(new int[] {year,month,day}).getRecorder()){
                    product.information();
                    System.out.println();
                }
    }

    public static void list(){
        System.out.println("---------------------------------------------------------");
        System.out.println("1. add prodcut");
        System.out.println("2. get daily record");
        System.out.println("3. get the sum");
        System.out.println("4. search product record");
        System.out.println("5. save");
        System.out.println("6. load");
        System.out.println("7. exit");
        System.out.println("---------------------------------------------------------");
    }


    public static void main(String args[]){
        Recorder recorder = new Recorder();
        //recorder.save();

        while(true){
            list();
            Scanner scan = new Scanner(System.in);
            switch  (scan.nextInt()){
                case 1:
                    try{
                        /**add product*/
                        System.out.println("Please enter the product name");
                        String name = scan.next();

                        System.out.println("Please enter the product price");
                        double price = scan.nextDouble();

                        System.out.println("Please enter the date");

                        System.out.println("Year:");
                        int year = scan.nextInt();
                        System.out.println("Month:");
                        int month = scan.nextInt();
                        System.out.println("Day:");
                        int day = scan.nextInt();

                        Product p =  new Food(name,price,new int[] {year,month,day});
                        recorder.add(p);
                        p.information();
                        System.out.println("add finised");

                    }catch(InputMismatchException e){
                        System.out.println("wrong input");
                    }
                    break;
                case 2:
                    try{
                        /**Search day*/
                        System.out.println("Please enter the date");

                        System.out.println("Year:");
                        int year = scan.nextInt();
                        System.out.println("Month:");
                        int month = scan.nextInt();
                        System.out.println("Day:");
                        int day = scan.nextInt();

                        dayInfor(new int[] {year,month,day},recorder);
                    }catch(InputMismatchException e){
                        System.out.println("wrong input");
                    }
                    break;

                case 3:
                    /**get the sum*/
                    System.out.println("sum : " + recorder.sum() + ".\n");
                    HashMap<Product,Integer> map = new HashMap();
                    for(Product p:recorder.getRecorder()){
                        if(map.keySet().contains(p)){
                            int time = map.get(p) + 1;
                            map.replace(p,time);
                        }else{
                            map.put(p,1);
                        }
                    }
                    for(Product p : map.keySet()){
                        System.out.println(p.getName() + " price :" + p.getPrice());
                        System.out.println("times: " + map.get(p) + "\n");
                    }
                    break;

                case 4:
                    /**search product record*/
                    /**add product*/
                    System.out.println("Please enter the product name");
                    String name = scan.next();

                    Recorder tmp =  recorder.search(name);
                    for(Product p: recorder.getRecorder()){
                        p.information();
                    }

                    System.out.println("finished search");
                    break;

                case 5:
                    /**save*/
                    recorder.save();
                    System.out.println("save finished");
                    break;


                case 6:
                    /**load data*/
                    recorder.load();
                case 7:

                    break;
            }


        }

        //GUI gui = new GUI();
    }
}
