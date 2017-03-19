//package formbuilder.model;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class FormTest {
//	public static void main(String args[]) {
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formbuilder");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		
//		/* -------------------------
//		 * Create new dummy User
//		 * -------------------------
//		 */
////		User user = new User();
////		user.setFirstName("FirstName");
////		user.setLastName("LastName");
////		user.setRole(Role.USER);
////		user.setEmail("user@gmail.com");
////		
////		UserAddress userAddress = new UserAddress();
////		userAddress.setAddress1("123 address1");
////		userAddress.setAddress2("123 address2");
////		userAddress.setCity("Los Angeles");
////		userAddress.setState("CA");
////		userAddress.setZip("12345");
////		userAddress.setCountry("USA");
////		userAddress.setPhoneHome("123-123-1234");
////		userAddress.setPhoneWork("321-321-3214");
////		userAddress.setPhoneCell("555-555-5555");
////		
////		user.setAddress(userAddress);
//		
////		entityManager.getTransaction().begin();
////		user = entityManager.merge(user);
////		entityManager.getTransaction().commit();
//		
//		// If dummy user already exists, use entityManager to read them in
//		// In this case, the user has id# 8
//		User user = entityManager.find(User.class, 8);
//		
//		/* -------------------------
//		 * Create new dummy Form
//		 * -------------------------
//		 */
//		Form form = new Form();
//		form.setName("test_form");
//		form.setDescription("A dummy test form.");
//		form.setUser(user);
//		form.setAvailable(true);
//		form.setCreateDate(new Date());
//		form.setUpdateDate(new Date());
//		form.setIsfinished(false);
//		
//		// We'll test just one Block and one Page for now...
//		// Will need to test for multiple Blocks and multiple Pages in future.
//		List<ItemPage> pages = new ArrayList<ItemPage>();
//		List<ItemBlock> blocks = new ArrayList<ItemBlock>();
//		List<Item> formItems = new ArrayList<Item>();
//		
//		ItemPage page01 = new ItemPage();
//		page01.setBlock(blocks);
//		page01.setForm(form);
//		page01.setPageNumber(1);
//		pages.add(page01);		// add to pages list
//		form.setPages(pages);
//		
//		ItemBlock block01 = new ItemBlock();
//		block01.setName("block1");
//		block01.setDescription("block1 description");
//		block01.setPage(page01);
//		block01.setItems(formItems);
//		blocks.add(block01);	// add to blocks list
//		
//		//PdfField pdfField = new PdfField();
//		
//		// ### Questions
//		ItemText itemText01 = new ItemText();
//		ItemText itemText02 = new ItemText();
//		ItemSelection itemSelection01 = new ItemSelection();
//		ItemSelection itemSelection02 = new ItemSelection();
//		
//		itemText01.setName("First Name");
//		itemText01.setDescription("user's first name");
//		itemText01.setItemType(Item.Type.TEXT);
//		itemText01.setOrderId(1);
//		itemText01.setBlock(block01);
//		itemText01.setRequired(true);
//		itemText01.setTextLength(80);
//		
//		itemText02.setName("Last Name");
//		itemText02.setDescription("user's last name");
//		itemText02.setItemType(Item.Type.TEXT);
//		itemText02.setOrderId(2);
//		itemText02.setBlock(block01);
//		itemText02.setRequired(true);
//		itemText02.setTextLength(80);
//		
//		itemSelection01.setName("Gender");
//		itemSelection01.setDescription("indicate male or female");
//		itemSelection01.setItemType(Item.Type.RADIOBUTTON);
//		itemSelection01.setMinRequirements(1);
//		itemSelection01.setMaxSelectionNum(1);
//		itemSelection01.setOrderId(3);
//		itemSelection01.setBlock(block01);
//		itemSelection01.setRequired(false);
//		
//		itemSelection02.setName("Legal Consent Checkbox");
//		itemSelection02.setDescription("Agreement to these terms.");
//		itemSelection02.setItemType(Item.Type.CHECKBOX);
//		itemSelection01.setMinRequirements(0);
//		itemSelection01.setMaxSelectionNum(1);
//		itemSelection02.setOrderId(4);
//		itemSelection02.setBlock(block01);
//		itemSelection02.setRequired(true);
//				
//		// add to formitems list
//		formItems.add(itemText01);
//		formItems.add(itemText02);
//		formItems.add(itemSelection01);
//		formItems.add(itemSelection02);
//		
//		entityManager.getTransaction().begin();
//		form = entityManager.merge(form);
//		entityManager.getTransaction().commit();
//				
//		entityManager.close();
//		entityManagerFactory.close();
//		
//		System.out.println("FormTest completed.");
//	}
//}