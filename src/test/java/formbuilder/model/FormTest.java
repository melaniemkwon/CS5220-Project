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

		Form form = new Form();	//form to be saved to DB
	
		form.setTitle("test_form");
		form.setDescription("A dummy test form.");
		form.setCreator(user);
		
		
		// Create two dummy text form items		
//		Item textItem1 = form.addTextItem();
//		textItem1.setTitle("TextItem TEST");
//		textItem1.setDescription("This is a description for text form field.");
//		textItem1.setAvailable(true);
//		textItem1.setIndex(0);
//		
//		Item textItem2 = form.addTextItem();
//		textItem2.setTitle("TextItem TEST2");
//		textItem2.setDescription("This is a description for text form field.");
//		textItem2.setAvailable(true);
//		textItem2.setIndex(1);
//		
//		form.addItem(textItem1);
//		form.addItem(textItem2);
		
		// Create two dummy checkbox form items
		Item checkboxItem1 = form.addCheckboxItem();
		checkboxItem1.setTitle("CheckboxItem TEST1");
		checkboxItem1.setDescription("This is a description for checkbox form field.");
		checkboxItem1.setAvailable(true);
		checkboxItem1.setIndex(0);
		checkboxItem1.addSelection( checkboxItem1.createSelection("Checkbox choice1", 1) );
		checkboxItem1.addSelection( checkboxItem1.createSelection("Checkbox choice2", 2) );
		checkboxItem1.addSelection( checkboxItem1.createSelection("Checkbox choice3", 3) );	
		
		Item checkboxItem2 = form.addCheckboxItem();
		checkboxItem2.setTitle("CheckboxItem TEST2");
		checkboxItem2.setDescription("This is a description for checkbox form field.");
		checkboxItem2.setAvailable(true);
		checkboxItem2.setIndex(0);
		checkboxItem2.addSelection( checkboxItem2.createSelection("Checkbox choice1", 1) );
		checkboxItem2.addSelection( checkboxItem2.createSelection("Checkbox choice2", 2) );
		checkboxItem2.addSelection( checkboxItem2.createSelection("Checkbox choice3", 3) );	
		
		form.addItem(checkboxItem1);
		form.addItem(checkboxItem2);
		
//		for (Item item : form.getItems() ) {
//			System.out.println("\nformId: " + form.getTitle());
//			System.out.println("item name: " + item.title);
//			System.out.println("description: " + item.description);
//			System.out.println("type: " + item.getItemType());
//			System.out.println("index: " + item.index);
//		}
		
		entityManager.getTransaction().begin();
		form = entityManager.merge(form);	//save form to DB
		entityManager.getTransaction().commit();
		
		// Get form and its items from DB
		long id = 13; //NOTE: this has to be type long, not int.
		Form getForm = entityManager.find(Form.class, id);	
		for (Item item : getForm.getItems() ) {
			System.out.println("\nformId: " + getForm.getTitle());
			System.out.println("item name: " + item.title);
			System.out.println("description: " + item.description);
			System.out.println("type: " + item.getItemType());
			System.out.println("index: " + item.index);
			for ( Selection s : item.getSelections()) {
				System.out.println("Selection: " + s.getValue());
			}
		}
				
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("\nFormTest completed.");
	}
}