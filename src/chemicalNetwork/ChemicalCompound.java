package chemicalNetwork;

public class ChemicalCompound {
    String name;
    double abundance;

    public ChemicalCompound(String compoundName, double compoundAbundance) {
        this.name = compoundName;
        this.abundance = compoundAbundance;
    }

    public void setAbundance(double abundance) {
        if (abundance > 0) {
            this.abundance = abundance;
        } else {
            this.abundance = 0;
        }
    }

}
