package cn.edu.jsu.tm.vo;

public class FoodClass {
private int id;
private String foodname;
private int foodprice;
private int storage;
private String data;
private int quality;
public FoodClass() {}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFoodname() {
	return foodname;
}
public void setFoodname(String foodname) {
	this.foodname = foodname;
}
public int getFoodprice() {
	return foodprice;
}
public void setFoodprice(int foodprice) {
	this.foodprice = foodprice;
}
public int getStorage() {
	return storage;
}
public void setStorage(int storage) {
	this.storage = storage;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public int getQuality() {
	return quality;
}
public void setQuality(int quality) {
	this.quality = quality;
}
@Override
public String toString() {
	return "FoodClass [id=" + id + ", foodname=" + foodname + ", foodprice=" + foodprice + ", storage=" + storage
			+ ", data=" + data + ", quality=" + quality + "]";
}

}
