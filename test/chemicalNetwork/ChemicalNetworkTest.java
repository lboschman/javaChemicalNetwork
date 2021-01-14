package chemicalNetwork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChemicalNetworkTest {
    public ChemicalNetwork makeNetwork(){
        /* First set the compounds */
        ChemicalCompound carbon = new ChemicalCompound("C", 1.);
        ChemicalCompound oxygen = new ChemicalCompound("O", 1.);
        ChemicalCompound carbon_dioxide =  new ChemicalCompound("CO2", 0.0);

        ChemicalCompound[] reactants = {carbon, oxygen};
        ChemicalCompound[] products = {carbon_dioxide};

        Reaction reaction1 = new Reaction(reactants, products, 1., 0.);
        Reaction reaction2 = new Reaction(products, reactants, 0.5, 0.);


        ChemicalNetwork network = new ChemicalNetwork();

        network.add_reaction(reaction1);
        network.add_reaction(reaction2);
        return network;
    }

    @Test
    public void compoundsTest(){
        ChemicalNetwork network = makeNetwork();
        Assertions.assertEquals(network.get_compound_names().size(), 3);

        Assertions.assertTrue(
                network.get_compound_names().contains("C")
                && network.get_compound_names().contains("O")
                && network.get_compound_names().contains("CO2")
        );
    }

    /*Add here tests to check the chemical network*/
}
