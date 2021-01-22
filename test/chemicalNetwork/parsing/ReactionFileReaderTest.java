package chemicalNetwork.parsing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


class ReactionFileReaderTest {

    @Test
    void parseFile() {
        String filename = "test/resources/testReactions.txt";
        ReactionFileReader reader = new ReactionFileReader();
        ArrayList<ParseResult> result = reader.parseFile(filename);

        ParseResult firstResult = result.get(0);
        Assertions.assertTrue(
                firstResult.getReactants().contains("C")
                && firstResult.getReactants().contains("O2")
                && firstResult.getProducts().contains("CO2")
        );
        Assertions.assertEquals(firstResult.getSigma(), 1.0);
        Assertions.assertEquals(firstResult.getBarrier(), 0.25);

        ParseResult secondResult = result.get(1);
        Assertions.assertTrue(
                secondResult.getReactants().contains("CH4")
                && secondResult.getReactants().contains("O2")
                && secondResult.getProducts().contains("CO2")
                && secondResult.getProducts().contains("H2O")
        );
        Assertions.assertEquals(secondResult.getSigma(), 1.25);
        Assertions.assertEquals(secondResult.getBarrier(), 2.3);
    }

    @Test
    void getReactantsHeader() {
        ReactionFileReader reader = new ReactionFileReader();
        Assertions.assertEquals(reader.getReactantsHeader(), "Reactants");
    }

    @Test
    void setReactantsHeader() {
        ReactionFileReader reader = new ReactionFileReader();
        reader.setReactantsHeader("OtherReactants");
        Assertions.assertEquals(reader.getReactantsHeader(), "OtherReactants");
    }

    @Test
    void getProductsHeader() {
        ReactionFileReader reader = new ReactionFileReader();
        Assertions.assertEquals(reader.getProductsHeader(), "Products");
    }

    @Test
    void setProductsHeader() {
        ReactionFileReader reader = new ReactionFileReader();
        reader.setProductsHeader("OtherProducts");
        Assertions.assertEquals(reader.getProductsHeader(), "OtherProducts");
    }

    @Test
    void getSigmaHeader() {
        ReactionFileReader reader = new ReactionFileReader();
        Assertions.assertEquals(reader.getSigmaHeader(), "Sigma");
    }

    @Test
    void setSigmaHeader() {
        ReactionFileReader reader = new ReactionFileReader();
        reader.setSigmaHeader("OtherSigma");
        Assertions.assertEquals(reader.getSigmaHeader(), "OtherSigma");
    }

    @Test
    void getBarrierHeader() {
        ReactionFileReader reader = new ReactionFileReader();
        Assertions.assertEquals(reader.getBarrierHeader(), "Barrier");
    }

    @Test
    void setBarrierHeader() {
        ReactionFileReader reader = new ReactionFileReader();
        reader.setBarrierHeader("OtherBarrier");
        Assertions.assertEquals(reader.getBarrierHeader(), "OtherBarrier");
    }
}