package chemicalNetwork.parsing;

import chemicalNetwork.parsing.ParseResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ParseResultTest {
    @Test
    public void testReactants() {
        ParseResult result = new ParseResult();
        ArrayList<String> reactants = new ArrayList<>();
        reactants.add("C");
        reactants.add("O2");

        result.setReactants(reactants);

        Assertions.assertTrue(result.getReactants().contains("C"));
        Assertions.assertTrue(result.getReactants().contains("O2"));
    }

    @Test
    public void testProducts() {
        ParseResult result = new ParseResult();
        ArrayList<String> products = new ArrayList<>();
        products.add("C");
        products.add("O2");

        result.setProducts(products);

        Assertions.assertTrue(result.getProducts().contains("C"));
        Assertions.assertTrue(result.getProducts().contains("O2"));
    }

    @Test
    public void testSigma() {
        ParseResult result = new ParseResult();
        result.setSigma(0.3);

        Assertions.assertEquals(result.getSigma(), 0.3);
    }

    @Test
    public void testBarrier() {
        ParseResult result = new ParseResult();
        result.setBarrier(0.4);

        Assertions.assertEquals(result.getBarrier(), 0.4);
    }
}
