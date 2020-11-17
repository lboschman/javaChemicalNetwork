package chemicalNetwork;

public class Reaction {
    ChemicalCompound[] reactants;
    ChemicalCompound[] products;
    double sigma;
    double barrier;

    double boltzmannConstant =  1.3806503e-23;

    public Reaction( ChemicalCompound[] reactants, ChemicalCompound[] products, double sigma, double barrier) {
        this.reactants = reactants;
        this.products = products;
        this.sigma = sigma;
        this.barrier = barrier;
    }

    public double calcRate( double tempGas) {
        double rate = this.sigma;

        for (ChemicalCompound compound: this.reactants) {
            rate *= compound.abundance;
        }

        rate *= Math.exp(this.barrier / (boltzmannConstant * tempGas));

        return rate;

    }

}