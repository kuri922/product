package bean;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
    private int Product_code;
    private String Product_name;
    private int price;

    public Product(){}

    public Product(String Product_name,int price) {
    	this.Product_name = Product_name;
    	this.price = price;
    }

    public Product(int Product_code,String Product_name,int price) {
    	    this(Product_name,price);
    	    this.Product_code = Product_code;

    }

    public int getProduct_code(){
        return Product_code;
    }


    public void setProduct_code(int Product_code){
        this.Product_code = Product_code;
    }

    public String getProduct_name(){
        return Product_name;
    }
    public void setProduct_name(String Product_name){
        this.Product_name = Product_name;
    }
    public int getprice(){
        return price;
    }
    public void setprice(int price){
    	this.price = price;




	}


}
