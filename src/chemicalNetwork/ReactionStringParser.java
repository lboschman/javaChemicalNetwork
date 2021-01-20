package chemicalNetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ReactionStringParser {
    // declare variables
    int reactantsIndex;
    int productsIndex;
    int sigmaIndex;
    int barrierIndex;

    public static class Builder {
        // define default values as class variable
        private static final int DEFAULT_REACTANTS_INDEX = 0;
        private static final int DEFAULT_PRODUCTS_INDEX = 16;
        private static final int DEFAULT_SIGMA_INDEX = 32;
        private static final int DEFAULT_BARRIER_INDEX = 40;

        // assign default values to variables
        private int reactantsIndex = DEFAULT_REACTANTS_INDEX;
        private int productsIndex = DEFAULT_PRODUCTS_INDEX;
        private int sigmaIndex = DEFAULT_SIGMA_INDEX;
        private int barrierIndex = DEFAULT_BARRIER_INDEX;

        public Builder () {}

        public ReactionStringParser.Builder withReactantsIndex (int val) {
            reactantsIndex = val;
            return this;
        }

        public ReactionStringParser.Builder withProductsIndex (int val) {
            productsIndex = val;
            return this;
        }

        public ReactionStringParser.Builder withSigmaIndex (int val) {
            sigmaIndex = val;
            return this;
        }

        public ReactionStringParser.Builder withBarrierIndex (int val) {
            barrierIndex = val;
            return this;
        }

        public ReactionStringParser build() {
            ReactionStringParser parser = new ReactionStringParser();

            parser.reactantsIndex = this.reactantsIndex;
            parser.productsIndex = this.productsIndex;
            parser.sigmaIndex = this.sigmaIndex;
            parser.barrierIndex = this.barrierIndex;

            return parser;
        }
    }

    private ReactionStringParser() {

    }

    private ArrayList<String> parseComponentString(String componentString) {
        String[] strList = componentString.split("\\s+");
        return new ArrayList<>(Arrays.asList(strList));
    }


    public ParseResult parseReactionString(String reactionString) {
        ParseResult reactionComponents = new ParseResult();

//        First retrieve the reactants
        ArrayList<String> reactants = this.parseComponentString(
                reactionString.substring(this.reactantsIndex, this.productsIndex)
        );
        ArrayList<String> products = this.parseComponentString(
                reactionString.substring(this.productsIndex, this.sigmaIndex)
        );

        double sigma = Double.parseDouble(
                reactionString.substring(this.sigmaIndex, this.barrierIndex).trim()
        );

        double barrier = Double.parseDouble(
                reactionString.substring(this.barrierIndex).trim()
        );

        reactionComponents.setReactants(reactants);
        reactionComponents.setProducts(products);
        reactionComponents.setSigma(sigma);
        reactionComponents.setBarrier(barrier);

        return reactionComponents;

    }


}
