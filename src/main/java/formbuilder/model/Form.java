public class Form {
	
	private Integer id;
	
	private String name;
	private String description;
	private List<Page> pages;
	private Date creatDate;
	private Date updateDate;
	private Date submitDate;
	private boolean available; //form can be disabled for example if the admin wants to make changes
	private boolean isfinished;
}