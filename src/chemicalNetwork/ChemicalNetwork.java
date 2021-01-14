package chemicalNetwork;

import java.util.ArrayList;

public class ChemicalNetwork {
    ArrayList<ChemicalCompound> compounds;
    ArrayList<Reaction> reactions;

    public ChemicalNetwork(){
        this.reactions = new ArrayList<>();
        this.compounds = new ArrayList<>();

    }

    public void add_reaction( Reaction reaction ) {
        // Add the reaction to the system
        this.reactions.add(reaction);

        // For every compound in the reactants, check if it is already present in the network.
        for (ChemicalCompound compound: reaction.reactants) {
            // If the compound is not present in the network, then add it
            if (!this.get_compound_names().contains(compound.name) ) {
                this.compounds.add(compound);
            }
        }
        // Repeat for the reaction products
        for (ChemicalCompound compound: reaction.reactants) {
            // If the compound is not present in the network, then add it
            if (!this.get_compound_names().contains(compound.name) ) {
                this.compounds.add(compound);
            }
        }

    }

//    Define a method to get a list of all the compound names in the chemical network
    public ArrayList<String> get_compound_names(){
        ArrayList<String> names = new ArrayList<>();

        for (ChemicalCompound compound: this.compounds) {
            names.add(compound.name);
        }

        return names;
    }

}
