package chemicalNetwork;

/**
 * The class Reaction links multiple ChemicalCompounds to a single chemical reaction.
 *
 * A gas temperature-dependent reaction rate can be calculated using the calcRate method.
 */

public class Reaction {
    /**
     * The ChemicalCompounds that react with each other in the reaction.
     * Their concentration will usually decrease as the reaction runs.
     */
    ChemicalCompound[] reactants;
    /**
     * The ChemicalCompounds produced in the reaction.
     * As the reaction progresses, their concentration usually increases.
     */
    ChemicalCompound[] products;
    /**
     * Cross section for the reaction.
     * Reaction rate scales linearly with the cross section
     */
    double sigma;
    /**
     * Energy barrier, creates a temperature dependence for the reaction rate, follows Arrhenius kinetics.
     */
    double barrier;

    /**
     * Boltzmann constant, necessary for Arrhenius kinetics, in kg m^2 s^-2 K^-1 (or J/K)
     */
    static double boltzmannConstant =  1.3806503e-23;

    /**
     * @param reactants Reacting chemical compounds
     * @param products reaction products
     * @param sigma reaction rate cross section
     * @param barrier reaction barrier
     */
    public Reaction( ChemicalCompound[] reactants, ChemicalCompound[] products, double sigma, double barrier) {
        this.reactants = reactants;
        this.products = products;
        this.sigma = sigma;
        this.barrier = barrier;
    }

    /**
     * Calculate the reaction rate for a given gas temperature.
     *
     * @param tempGas gas temperature
     * @return reaction rate
     */
    public double calcRate( double tempGas) {
        double rate = this.sigma;

        for (ChemicalCompound compound: this.reactants) {
            rate *= compound.abundance;
        }
        /* Calculate reaction rate according to Arrhenius kinetics */
        rate *= Math.exp(- this.barrier / (boltzmannConstant * tempGas));

        return rate;

    }

}