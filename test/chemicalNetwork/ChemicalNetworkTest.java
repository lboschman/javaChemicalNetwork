package chemicalNetwork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

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

        network.addReaction(reaction1);
        network.addReaction(reaction2);
        return network;
    }

    @Test
    public void compoundsTest(){
        ChemicalNetwork network = makeNetwork();
        Assertions.assertEquals(network.getCompoundNames().size(), 3);

        Assertions.assertTrue(
                network.getCompoundNames().contains("C")
                && network.getCompoundNames().contains("O")
                && network.getCompoundNames().contains("CO2")
        );
    }

    /*Add here tests to check the chemical network*/

    @Test
    public void stringReactionTest(){
        ChemicalNetwork network = new ChemicalNetwork();

        ArrayList<String> reactantList = new ArrayList<>();
        ArrayList<String> productList = new ArrayList<>();
        reactantList.add("Sugar");
        reactantList.add("Oxygen");
        productList.add("CO2");
        productList.add("Energy");

        network.addReaction(reactantList, productList, 0.25, 0.0);

        Assertions.assertTrue(
                network.getCompoundNames().contains("Sugar")
                        && network.getCompoundNames().contains("Oxygen")
                        && network.getCompoundNames().contains("CO2")
                        && network.getCompoundNames().contains("Energy")

        );

    }
}
