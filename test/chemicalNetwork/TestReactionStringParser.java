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
}
