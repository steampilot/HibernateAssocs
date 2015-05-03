package test;

import bo.Company;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import bo.City;
import bo.Employee;

public class HibernateTest {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	private Session session;
	Transaction trans = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Configuration conf = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				conf.getProperties()).buildServiceRegistry();
		sessionFactory = conf.buildSessionFactory(serviceRegistry);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		 serviceRegistry = null;
		 sessionFactory = null;
	}

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void test() {
		City city = new City("Basel", "4000");
		City city2 = new City("Zürich", "8000");
		Company company = new Company("Google", city);
		Company company2 = new Company("Google", city2);
		Employee employee = new Employee("Müller", "HauptStrasse 4");
		Employee employee2 = new Employee("Schmid", "Kirchgasse 1");
		employee.setCity(city);
		employee2.setCity(city);
		employee.setCompany(company);
		employee2.setCompany(company2);

		city.addEmployee(employee);
		city.addEmployee(employee2);
		city.addCompany(company);
		city2.addCompany(company2);

		try {
			trans = session.beginTransaction();

			session.save(city);
			session.save(city2);
			trans.commit();

		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
				e.printStackTrace();
			}
		}
		assertTrue(city.getCityId() > 0);
		assertTrue(company.getCity().getCityId() == city.getCityId());
		
	}
}
