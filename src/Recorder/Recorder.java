package Recorder;

import Product.Product;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

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

    //return recorder
    public ArrayList<Product> getRecorder() {
        return recorder;
    }

    //save the recorder into an xls file
    public void save(){
        /**get path*/
        JFileChooser chooser = new JFileChooser();
        JPanel parent = new JPanel();
        int returnVal = chooser.showOpenDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("the address：" + chooser.getSelectedFile().getPath());
        }
        String path = chooser.getSelectedFile().getPath();

        /**create a excel*/
        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        Row row = sheet.createRow(0);

        /**lable*/
        for(int cellNUm = 0;cellNUm < 6;cellNUm ++){
            Cell cell = row.createCell(cellNUm);
        }

        String str0 = "order";
        String str1 = "date";
        String str2 = "I/O";
        String str3 = "name";
        String str4 = "category";
        String str5 = "price";

        row.getCell(0).setCellValue(str0);
        row.getCell(1).setCellValue(str1);
        row.getCell(2).setCellValue(str2);
        row.getCell(3).setCellValue(str3);
        row.getCell(4).setCellValue(str4);
        row.getCell(5).setCellValue(str5);

        /**data input*/
        int rowNum = 1;
        for(Product p:this.recorder){
            /**handle data*/
            String date = p.getDate()[0] + "/" + p.getDate()[1] + "/" +p.getDate()[2];
            Row tmpRow = sheet.createRow(rowNum);

            tmpRow.createCell(0).setCellValue(rowNum);
            tmpRow.createCell(1).setCellValue(date);
            tmpRow.createCell(2).setCellValue("O");
            tmpRow.createCell(3).setCellValue(p.getName());
            tmpRow.createCell(4).setCellValue(p.getName());
            tmpRow.createCell(5).setCellValue(p.getPrice());
            rowNum ++;
        }

        /**output*/
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(path);
            workbook.write(output);
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
