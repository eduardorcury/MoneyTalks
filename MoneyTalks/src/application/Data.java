package application;

import java.util.Date;

public class Data {
	
	Double amount;
	Category category;
	Date date;
	
	public Data(Double amount, Category category, Date date) {
		
		this.amount = amount;
		this.category = category;
		
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
