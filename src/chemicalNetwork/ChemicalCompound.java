package chemicalNetwork;

/**
 * The ChemicalCompound class exists to provide chemical compounds with a name and an abundance
 */

public class ChemicalCompound {
    private String name;
    private double abundance;

    /**
     * A chemical compound
     *
     * @param compoundName name of the compound
     * @param compoundAbundance initial abundance or concentration of the compound
     */
    public ChemicalCompound(String compoundName, double compoundAbundance) {
        this.setName(compoundName);
        this.setAbundance(compoundAbundance);
    }


    /**
     * Name of the compound.
     *
     * @return the compounds name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name for the compound.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Concentration of the compound.
     *
     * @return the abundance
     */
    public double getAbundance() {
        return abundance;
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
