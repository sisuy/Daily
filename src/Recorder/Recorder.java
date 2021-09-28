package Recorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import Product.*;

public class Recorder {
    //field
    ArrayList<Product> recorder =  new ArrayList<Product>();


    //add the product into the recorder
    public void add(Product p){
        recorder.add(p);
        System.out.println("record finished");
    }

    //get the size of the recorder
    public int getSize(){
        int ret= 0;

        for(Product p: recorder){
            ret ++;
        }

        return ret;
    }

    //get the total cost
    public double sum(){
        double ret = 0;
        for(Product p : recorder){
            ret += p.getPrice();
        }
        return  ret;
    }

    //get the daily cost
    public double average(){
        return this.sum()/this.getSize();
    }

    //search day
    public Recorder searchDay(int[] date){
        Recorder ret = new Recorder();
        try{
            for(Product p: recorder){
                if(Arrays.equals(p.getDate(), date)){
                    ret.add(p);
                }
            }
        }catch(NoSuchElementException e){
            System.out.println("no record in that dat");
        }
        return ret;
    }

    //search the list of a product
    public Recorder search(String name){
        Recorder ret = new Recorder();
        for(Product p: recorder){
            if(p.getName() == name){
                ret.add(p);
            }
        }
        return ret;
    }

    public ArrayList<Product> getRecorder() {
        return recorder;
    }
}
