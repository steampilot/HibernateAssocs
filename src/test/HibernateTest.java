package test;


import bo.Lang;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import bo.City;
import bo.Employee;

import java.util.List;

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

	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void test() {
		City city = new City("Basel", "4000");
		City city2 = new City("Zürich", "8000");

		Employee employee = new Employee("Müller", "HauptStrasse 4");
		Employee employee2 = new Employee("Schmid", "Kirchgasse 1");
		employee.setCity(city);
		employee2.setCity(city);


		city.addEmployee(employee);
		city.addEmployee(employee2);


        Lang lang = new Lang("de-CH", "Swiss German");
        Lang lang2 = new Lang ("en-US", "American English");

        employee.addLanguage(lang);
        employee.addLanguage(lang2);
        lang.addEmployee(employee);
        lang2.addEmployee(employee);
        session = sessionFactory.openSession();
		try {
			trans = session.beginTransaction();

            session.save(lang);
            session.save(lang2);
            session.save(city);
            session.save(city2);


			trans.commit();

		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
				e.printStackTrace();
			}
		} finally {
            session.close();
        }
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Employee as e where e.City.CityId = :cityId");
        query.setParameter("cityId", 1L);
        List<Employee> emp = query.list();

        session.close();

        employee.setName("NotMüller");

        session = sessionFactory.openSession();
		try {
			trans = session.beginTransaction();
            session.update(city);


			trans.commit();

		} catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
				e.printStackTrace();
			}
		} finally {
            session.close();
        }

        session = sessionFactory.openSession();
        query = session.createQuery("from Employee as e where e.City.CityId = :cityId");
        query.setParameter("cityId", 1L);
        List<Employee> emp2 = query.list();

        System.out.println(emp);
        System.out.println(emp2);
        //assertEquals(emp,emp2);
	}
}
