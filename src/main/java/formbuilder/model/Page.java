package formbuilder.model;

import java.util.List;

public class Page {
	private int id;
	private int pageNumber;
	private int pid; // parent form id
	private List<Block> block;
}