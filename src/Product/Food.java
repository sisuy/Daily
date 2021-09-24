package Product;

public class Food implements Product{
    String name;
    double price;
    int[] date;

    public Food(String name,double price,int[] date){
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public void  information(){
        System.out.println("name: " + this.name);
        System.out.println("price:" + price);
        System.out.println("date: " + date[0] + "/" + date[1] + "/" +date[2]);
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int[] getDate(){
        return this.date;
    }

    public void setDate(int[] date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
