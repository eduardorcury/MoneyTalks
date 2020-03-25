package application;

import javafx.collections.ListChangeListener;

public class DataCalculation extends Data {
		
		//public static ObservableList<Integer> total = FXCollections.observableArrayList();
		
		public void categoryTotal() {
			
			dataList.addListener(new ListChangeListener<Data>() {
				@Override
				public void onChanged(Change<? extends Data> c) {
					while (c.next()) {
						if (c.wasAdded()) {
							for (Data newData : c.getAddedSubList()) {
								Float total = newData.getCategory().getCategoryTotal() + newData.getAmount();
								newData.getCategory().setCategoryTotal(total);
							}
						}
					}
					
				}
				
			});
		}
}
