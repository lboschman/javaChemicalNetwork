package chemicalNetwork;

/**
 * The ChemicalCompound class exists to provide chemical compounds with a name and an abundance
 */

public class ChemicalCompound {
    /* The compound has both a name and an abundance (concentration) */
    String name;
    double abundance;

    /**
     * A chemical compound
     *
     * @param compoundName name of the compound
     * @param compoundAbundance initial abundance or concentration of the compound
     */
    public ChemicalCompound(String compoundName, double compoundAbundance) {
        this.name = compoundName;
        this.abundance = compoundAbundance;
    }

    /**
     * Reset the abundance to 0.
     */
    public void setAbundance() {
        setAbundance(0.);
    }

    /**
     * Set a new value for the abundance.
     *
     * @param abundance the updated abundance
     */
    public void setAbundance(double abundance) {
        /* Avoid a negative abundance of the compound. */
        if (abundance > 0) {
            this.abundance = abundance;
        } else {
            this.abundance = 0;
        }
    }

}
