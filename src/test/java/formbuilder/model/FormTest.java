package formbuilder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormTest {
	public static void main(String args[]) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formbuilder");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		/* -------------------------
		 * Create new dummy User
		 * -------------------------
		 */
//		User user = new User();
//		user.setFirstName("FirstName3");
//		user.setLastName("LastName3");
//		user.setRole(Role.ADMIN);
//		user.setEmail("admin@gmail.com");
//		user.setActive(true);
//		
//		UserAddress userAddress = new UserAddress();
//		userAddress.setAddress1("123 address1");
//		userAddress.setAddress2("123 address2");
//		userAddress.setCity("Los Angeles");
//		userAddress.setState("CA");
//		userAddress.setZip("12345");
//		userAddress.setCountry("USA");
//		userAddress.setPhoneHome("123-123-1234");
//		userAddress.setPhoneWork("321-321-3214");
//		userAddress.setPhoneCell("555-555-5555");
//		
//		user.setAddress(userAddress);
//		
//		entityManager.getTransaction().begin();
//		user = entityManager.merge(user);
//		entityManager.getTransaction().commit();
//		
//		// If dummy user already exists, use entityManager to read them in
//		// In this case, the user has id# 8
		User user = entityManager.find(User.class, 1);
//		
//		/* -------------------------
//		 * Create new dummy Form
//		 * -------------------------
//		 */
		int pageId = 0, blockId = 0;
		Form form = new Form();
		for ( ItemPage page : form.getPages() ) {
			pageId = page.getId();
			System.out.println("page id: " + pageId);
			
			for ( ItemBlock block : page.getBlocks() ) {				
				blockId = block.getId();
				System.out.println("block id: " + blockId);
			}
		}
		
		form.setName("test_form");
		form.setDescription("A dummy test form.");
		form.setCreator(user);
		
		
		// Create two dummy text form items		
		Item textItem1 = new TextItem();
		textItem1.setName("TextItem TEST");
		textItem1.setDescription("This is a description for text form field.");
		textItem1.setAvailable(true);
		textItem1.setIndex(0);
		
		Item textItem2 = new TextItem();
		textItem2.setName("TextItem TEST2");
		textItem2.setDescription("This is a description for text form field.");
		textItem2.setAvailable(true);
		textItem2.setIndex(1);
		
//		Item checkboxItem1 = new CheckboxItem();
		
		
		form.getPageById(pageId).getBlockById(blockId).addItem(textItem1);
		form.getPageById(pageId).getBlockById(blockId).addItem(textItem2);
		
		List<Item> itemList = form.getPageById(pageId).getBlockById(blockId).getItems();
		for (Item item : itemList) {
			System.out.println("\nformId: " + form.getName());
			System.out.println("page: " + form.getPageById(pageId).getName());
			System.out.println("Block: " + form.getPageById(pageId).getBlockById(blockId).getName());
			System.out.println("name: " + item.name);
			System.out.println("description: " + item.description);
			System.out.println("index: " + item.index);
		}
		
		entityManager.getTransaction().begin();
		form = entityManager.merge(form);
		entityManager.getTransaction().commit();
				
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("\nFormTest completed.");
	}
}