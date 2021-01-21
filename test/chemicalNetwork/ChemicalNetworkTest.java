package chemicalNetwork;

import chemicalNetwork.parsing.ParseResult;
import chemicalNetwork.parsing.ReactionStringParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Set;

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
    public void stringAddReactionTest(){
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

    @Test
    public void parseResultAddReactionTest(){
        ChemicalNetwork network = new ChemicalNetwork();
        String reactionString = "C O2            CO2             2.2     0.3";
        ReactionStringParser parser = new ReactionStringParser.Builder().build();
        ParseResult parseResult = parser.parseReactionString(reactionString);

        network.addReaction(parseResult);

        Assertions.assertTrue(
                network.getCompoundNames().contains("C")
                && network.getCompoundNames().contains("O2")
                && network.getCompoundNames().contains("CO2")
        );
    }

    @Test
    public void readFromFileCompoundsTest(){
        ChemicalNetwork network = new ChemicalNetwork();
        String fileName = "test/chemicalNetwork/parsing/testReactions.txt";
        network.readFromFile(fileName);

        Set<String> compoundNames = network.getCompoundNames();
        Assertions.assertEquals(compoundNames.size(), 5);

        Assertions.assertTrue(
                compoundNames.contains("C")
                && compoundNames.contains("O2")
                && compoundNames.contains("CO2")
                && compoundNames.contains("CH4")
                && compoundNames.contains("H2O")
        );

    }

    @Test
    public void readFromFileReactionsTest(){
        ChemicalNetwork network = new ChemicalNetwork();
        String fileName = "test/chemicalNetwork/parsing/testReactions.txt";
        network.readFromFile(fileName);

        ArrayList<Reaction> reactions = network.reactions;
        Assertions.assertEquals(reactions.size(), 2);

        // First check the first reaction
        Reaction firstReaction = reactions.get(0);
        ChemicalCompound[] firstReactants = firstReaction.getReactants();
        Assertions.assertEquals(firstReactants[0].name, "C");
        Assertions.assertEquals(firstReactants[1].name, "O2");

        Assertions.assertEquals(firstReaction.getProducts()[0].name, "CO2");
        Assertions.assertEquals(firstReaction.getSigma(), 1.0);
        Assertions.assertEquals(firstReaction.getBarrier(), 0.25);

        // Now check the second reaction
        Reaction secondReaction = reactions.get(1);

        // Check that all the reactants have been included
        ChemicalCompound[] secondReactants = secondReaction.getReactants();
        Assertions.assertEquals(secondReactants.length, 4);
        Assertions.assertEquals(secondReactants[0].name, "CH4");
        Assertions.assertEquals(secondReactants[1].name, "O2");
        Assertions.assertEquals(secondReactants[1], secondReactants[2]);
        Assertions.assertEquals(secondReactants[1], secondReactants[3]);

        // Perform the same check for the products
        ChemicalCompound[] secondProducts = secondReaction.getProducts();
        Assertions.assertEquals(secondProducts[0].name, "CO2");
        Assertions.assertEquals(secondProducts[1].name, "H2O");
        Assertions.assertEquals(secondProducts[1], secondProducts[2]);

        // Check the numerical constants
        Assertions.assertEquals(secondReaction.getSigma(), 1.25);
        Assertions.assertEquals(secondReaction.getBarrier(), 2.3);





    }

}
