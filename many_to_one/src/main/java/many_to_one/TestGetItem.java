package many_to_one;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetItem {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	
		Item item = entityManager.find(Item.class, 1);
		
		System.out.println("--------------");
		System.out.println("Name is "+item.getName());
		System.out.println("Price is "+item.getPrice());
		System.out.println("Quantity is "+item.getQuantity());
		System.out.println("--------------");
	
		AmazonOrder amazonOrder = item.getAmazonOrder();
		System.out.println(amazonOrder.getId());
		}
		
	}

