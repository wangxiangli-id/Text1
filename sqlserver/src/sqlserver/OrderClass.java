package sqlserver;

public class OrderClass {
      private String ordernumber;
      private String foodnumber;
      private int foodsale;
      public  OrderClass() {}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getFoodnumber() {
		return foodnumber;
	}
	public void setFoodnumber(String foodnumber) {
		this.foodnumber = foodnumber;
	}
	public int getFoodsale() {
		return foodsale;
	}
	public void setFoodsale(int foodsale) {
		this.foodsale = foodsale;
	}
	@Override
	public String toString() {
		return "OrderClass [ordernumber=" + ordernumber + ", foodnumber=" + foodnumber + ", foodsale=" + foodsale + "]";
	}

}
