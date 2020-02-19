package application;

import java.time.LocalDate;

public class Data extends Category {
	
	private Float amount;
	private Category category;
	private LocalDate date;
	
	public Data(Float amount, Category category, LocalDate date) {
		
		this.amount = amount;
		this.category = category;
		this.date = date;
		
	}
	
	public Data(Float amount, String comboBoxValue, LocalDate date) {
		
		this.amount = amount;
		this.date = date;
		//Look for the category name and select its category
		for (int i = 0; i < categories.size(); i++) {
			if (comboBoxValue.equals(categories.get(i).getCategoryName())) {
				this.category = categories.get(i);
				System.out.println(categories.get(i).getCategoryName());
			}
		}
		
		
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
