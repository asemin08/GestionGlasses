package eu.ensup.gestionglasses;

import eu.ensup.gestionglasses.dao.GlasseDao;
import eu.ensup.gestionglasses.domaine.Glasse;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpringDAO extends TestCase {
	private Glasse glasse;
	private GlasseDao springDao;
	private ClassPathXmlApplicationContext appContext;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		glasse = new Glasse(1, 4748, "lunette rouge soleil", 120.00);
		appContext = new ClassPathXmlApplicationContext("GlasseBeans.xml");

		springDao = (GlasseDao) appContext.getBean("glasseDao");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		glasse = null;
		appContext = null;
		springDao = null;
	}

	public void testSaveGlasse() {
		springDao.save(glasse);
	}
	/*
        public void testFindOne() {
            Employe employe = springDao.findOne(1);
            assertNotNull(employe);
        }
    */
	public void testFindByLabel() {
		List<Glasse> glasses = springDao.findByLabel(glasse.getLabel());
		for(Glasse g : glasses) {
			System.out.println(g.getLabel());
		}
		assertNotNull(glasses);
	}
}
