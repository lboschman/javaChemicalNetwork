package chemicalNetwork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReactionTest {

    public Reaction makeTestReaction(double barrier){
        /* First set the compounds */
        ChemicalCompound carbon = new ChemicalCompound("C", 1.);
        ChemicalCompound oxygen = new ChemicalCompound("O", 1.);
        ChemicalCompound carbon_dioxide =  new ChemicalCompound("CO2", 0.0);

        ChemicalCompound[] reactants = {carbon, oxygen};
        ChemicalCompound[] products = {carbon_dioxide};

        /* Set some constants */
        double sigma = 1.;

        /* Make the new reaction, and return it */
        return new Reaction(reactants, products, sigma, barrier);
    }
    @Test
    public void testCalcRateUnity(){
        /* Build a reaction with zero barrier*/
        Reaction zero_reaction = makeTestReaction(0.);

        double gasTemperature = 100.;

        /* Check that the rate is exactly equal to 1.*/
        Assertions.assertEquals(zero_reaction.calcRate(gasTemperature), 1.);


//       /* The rate of a reaction without a barrier should not vary with temperature */
//        Assertions.assertEquals(zero_reaction.calcRate(low_tgas), zero_reaction.calcRate(high_tgas));

    }

    @Test
    public void testCalcRateTemperatureDependence(){
        double low_tgas = 100.;
        double high_tgas = 300.;

        Reaction reaction = makeTestReaction(1.e-21);

        Assertions.assertTrue(reaction.calcRate(low_tgas) < reaction.calcRate(high_tgas));
    }

    @Test
    public void testCalcRateBarrierDependence(){
        double lowBarrier = 1.e-21;
        double highBarrier = 3.e-21;

        double gasTemperature = 300.;

        Reaction lowBarrierReaction = makeTestReaction(lowBarrier);
        Reaction highBarrierReaction = makeTestReaction(highBarrier);

        Assertions.assertTrue(
                highBarrierReaction.calcRate(gasTemperature) < lowBarrierReaction.calcRate(gasTemperature)
        );

    }
}
