package application;

import java.util.Date;

public class Data {
	
	Float amount;
	Category category;
	Date date;
	
	public Data(Float amount, Category category, Date date) {
		
		this.amount = amount;
		this.category = category;
		
	}
	
	public Data() {}

	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
