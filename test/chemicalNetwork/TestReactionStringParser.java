package chemicalNetwork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestReactionStringParser {

    @Test
    public void testDefaultIndices(){
        ReactionStringParser parser = new ReactionStringParser.Builder().build();

        Assertions.assertEquals(parser.reactantsIndex, 0);
        Assertions.assertEquals(parser.productsIndex, 16);
        Assertions.assertEquals(parser.sigmaIndex, 32);
        Assertions.assertEquals(parser.barrierIndex, 40);
    }

    @Test
    public void testUpdatedIndices(){
        int newReactantsIndex = 2;
        int newProductsIndex = 2;
        int newSigmaIndex = 2;
        int newBarrierIndex = 2;

        ReactionStringParser parser = new ReactionStringParser.Builder()
                .withProductsIndex(newProductsIndex)
                .withReactantsIndex(newReactantsIndex)
                .withSigmaIndex(newSigmaIndex)
                .withBarrierIndex(newBarrierIndex).build();

        Assertions.assertEquals(parser.reactantsIndex, newReactantsIndex);
        Assertions.assertEquals(parser.productsIndex, newProductsIndex);
        Assertions.assertEquals(parser.sigmaIndex, newSigmaIndex);
        Assertions.assertEquals(parser.barrierIndex, newBarrierIndex);

    }

    @Test
    public void testParseReactionString(){
        String reactionString = "C O2            CO2             2.2     0.3";
        ReactionStringParser parser = new ReactionStringParser.Builder().build();
        ParseResult parseResult = parser.parseReactionString(reactionString);

        Assertions.assertTrue(parseResult.getReactants().contains("C"));
        Assertions.assertTrue(parseResult.getReactants().contains("O2"));
        Assertions.assertTrue(parseResult.getProducts().contains("CO2"));
        Assertions.assertEquals(parseResult.getSigma(), 2.2);
        Assertions.assertEquals(parseResult.getBarrier(), 0.3);
    }
}
