package chemicalNetwork;

/** The ChemicalCompound class exists to provide chemical compounds with a name and an abundance */

public class ChemicalCompound {
    /* The compound has both a name and an abundance (concentration) */
    String name;
    double abundance;

    public ChemicalCompound(String compoundName, double compoundAbundance) {
        this.name = compoundName;
        this.abundance = compoundAbundance;
    }

    public void setAbundance(double abundance) {
        /* Avoid a negative abundance of the compound. */
        if (abundance > 0) {
            this.abundance = abundance;
        } else {
            this.abundance = 0;
        }
    }

}
