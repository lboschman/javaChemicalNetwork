package chemicalNetwork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChemicalCompoundTest {
    @Test
    public void testProperties(){
        /* First make and check the basic object*/
        ChemicalCompound carbon = new ChemicalCompound("C", 0.01);
        Assertions.assertEquals(carbon.getAbundance(), 0.01);
        Assertions.assertEquals(carbon.getName(), "C");
    }

    @Test
    public void testSetAbundance(){
        /* First make and check the basic object*/
        ChemicalCompound carbon = new ChemicalCompound("C", 0.01);

        /* Change the abundance, and check the change.*/
        double new_abundance = 12.01;
        carbon.setAbundance(new_abundance);
        Assertions.assertEquals(carbon.getAbundance(), new_abundance);
    }

    @Test
    public void testSetAbundanceNegative(){
        /* First make and check the basic object*/
        ChemicalCompound carbon = new ChemicalCompound("C", 0.01);

        /* Check that a negative abundance results in a 0 abundance*/
        carbon.setAbundance(-2.5);
        Assertions.assertEquals(carbon.getAbundance(), 0);

    }

    @Test
    void testSetAbundanceToZero() {
        ChemicalCompound carbon = new ChemicalCompound("C", 0.01);
        Assertions.assertEquals(carbon.getAbundance(), 0.01);

        carbon.setAbundance();
        Assertions.assertEquals(carbon.getAbundance(), 0.0);

    }

}
