package many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAmazonOrder {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Item  item1 = new Item();
		item1.setName("laptop");
		item1.setPrice(40000);
		item1.setQuantity(5);
		
		Item  item2 = new Item();
		item2.setName("Moblie");
		item2.setPrice(50000);
		item2.setQuantity(2);
		
		Item  item3 = new Item();
		item3.setName("Tab");
		item3.setPrice(20000);
		item3.setQuantity(1);
		
		AmazonOrder amazonOrder = new AmazonOrder();
		amazonOrder.setAddress("BTM LAYOUT");
		amazonOrder.setName("Office items");
		amazonOrder.setStatus("Getting prepared");
		item1.setAmazonOrder(amazonOrder);
		item2.setAmazonOrder(amazonOrder);
		item3.setAmazonOrder(amazonOrder);
		
		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityManager.persist(item1);
		entityManager.persist(item2);
		entityManager.persist(item3);
		entityTransaction.commit();
	}

}
