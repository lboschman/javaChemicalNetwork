package chemicalNetwork;

/**
 * The class Reaction links multiple ChemicalCompounds to a single chemical reaction.
 *
 * A gas temperature-dependent reaction rate can be calculated using the calcRate method.
 */

public class Reaction {
    private ChemicalCompound[] reactants;
    private ChemicalCompound[] products;
    private double sigma;
    private double barrier;

    private static double boltzmannConstant =  1.3806503e-23;

    /**
     * @param reactants Reacting chemical compounds
     * @param products reaction products
     * @param sigma reaction rate cross section
     * @param barrier reaction barrier
     */
    public Reaction( ChemicalCompound[] reactants, ChemicalCompound[] products, double sigma, double barrier) {
        this.setReactants(reactants);
        this.setProducts(products);
        this.setSigma(sigma);
        this.setBarrier(barrier);
    }

    /**
     * Boltzmann constant, necessary for Arrhenius kinetics, in kg m^2 s^-2 K^-1 (or J/K)
     */
    public static double getBoltzmannConstant() {
        return boltzmannConstant;
    }

    public static void setBoltzmannConstant(double boltzmannConstant) {
        Reaction.boltzmannConstant = boltzmannConstant;
    }

    /**
     * Calculate the reaction rate for a given gas temperature.
     *
     * @param tempGas gas temperature
     * @return reaction rate
     */
    public double calcRate( double tempGas) {
        double rate = this.getSigma();

        for (ChemicalCompound compound: this.getReactants()) {
            rate *= compound.getAbundance();
        }
        /* Calculate reaction rate according to Arrhenius kinetics */
        rate *= Math.exp(-this.getBarrier() / (getBoltzmannConstant() * tempGas));

        return rate;

    }

    /**
     * The ChemicalCompounds that react with each other in the reaction.
     * Their concentration will usually decrease as the reaction runs.
     */
    public ChemicalCompound[] getReactants() {
        return reactants;
    }

    public void setReactants(ChemicalCompound[] reactants) {
        this.reactants = reactants;
    }

    /**
     * The ChemicalCompounds produced in the reaction.
     * As the reaction progresses, their concentration usually increases.
     */
    public ChemicalCompound[] getProducts() {
        return products;
    }

    public void setProducts(ChemicalCompound[] products) {
        this.products = products;
    }

    /**
     * Cross section for the reaction.
     * Reaction rate scales linearly with the cross section
     */
    public double getSigma() {
        return sigma;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    /**
     * Energy barrier, creates a temperature dependence for the reaction rate, follows Arrhenius kinetics.
     */
    public double getBarrier() {
        return barrier;
    }

    public void setBarrier(double barrier) {
        this.barrier = barrier;
    }
}