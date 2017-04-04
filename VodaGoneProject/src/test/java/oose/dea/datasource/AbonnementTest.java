package oose.dea.datasource;

import oose.dea.domain.Abonnee;
import oose.dea.domain.Abonnement;
import org.junit.Test;
import org.meanbean.test.BeanTester;

public class AbonnementTest {
    @Test
    public void testGetterSetterCorrectnessAbonnement() {
        new BeanTester().testBean(Abonnement.class);
    }

    @Test
    public void testGetterSetterCorrectnessAbonnee() {
        new BeanTester().testBean(Abonnee.class);
    }
}