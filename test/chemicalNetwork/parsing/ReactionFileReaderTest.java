package chemicalNetwork.parsing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReactionFileReaderTest {

    @Test
    void parseFile() {
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