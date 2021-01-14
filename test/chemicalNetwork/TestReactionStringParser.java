package chemicalNetwork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
