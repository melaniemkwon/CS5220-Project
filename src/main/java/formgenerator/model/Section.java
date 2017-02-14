package formgenerator.model;

import java.util.List;

public class Section {
	private int id;
	private String name;
	private String description;
	private int pid; //parent form page id
	private List<Item> items;
}
