package formgenerator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class main {

	public static void main(String[] args) {
		
		Form doc = new Form(11,"Pizza order","");
		
		ItemText itemName = new ItemText(101,"Customer Name","(Last, First, Middle)", 11);
		itemName.setType("text");
		
		//for boolean selection, ex genders
		ItemSelection itemGender = new ItemSelection(102,"Gender:","", 11);
		itemGender.setType("boolean");
		ArrayList<Selection> selectGender = new ArrayList();
		selectGender.add(new Selection(0,"F","F",102));
		selectGender.add(new Selection(0,"M","M",102));
		
		itemGender.setSelections(selectGender);
		itemGender.setMinSelectionNum(1);
		itemGender.setMaxSelectionNum(1);
		List<Item> items = new ArrayList<>();
		
		
		//check box for multiple choices
		ItemSelection topping = new  ItemSelection(103,"Toppings","", 11);
		itemGender.setType("checkbox");
		ArrayList<Selection> toplist = new ArrayList<>();
		toplist.add(new Selection(0,"cheese","cheese",103));
		toplist.add(new Selection(1,"Italian sausage","Italian sausage",103));
		toplist.add(new Selection(2,"pepperoni","pepperoni",103));
		toplist.add(new Selection(3,"vegetable","vegetable",103));
		
		topping.setSelections(toplist);
		topping.setMinSelectionNum(1);
		topping.setMaxSelectionNum(4);
		
		//checkbox for a single box
		Item newCustomer = new Item(104,"A New customer?","", 11);
		itemGender.setType("checkbox");
		
		items.add(itemName);
		items.add(itemGender);
		items.add(topping);
		doc.setItems(items);
		
		//--------------------------------------------------
		//answer
		//user selected "Italian sausage" as topping
		User user = new User(1,"Yan","Yan","yan@calstatela.edu");
		//select * from selections where pid=103
		Selection selection = new Selection(1003,"Italian sausage","Italian sausage",103);
		ItemSelectionAnswer answer = new ItemSelectionAnswer(1001, selection, true, user);
		
		
	}

}
