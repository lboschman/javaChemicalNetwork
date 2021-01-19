package chemicalNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ChemicalNetwork {
    ArrayList<Reaction> reactions;
    HashMap<String, ChemicalCompound> compounds;

    public ChemicalNetwork(){
        this.reactions = new ArrayList<>();
        this.compounds = new HashMap<>();
    }

    public void add_reaction( Reaction reaction ) {
        // Add the reaction to the system
        this.reactions.add(reaction);

        // For every compound in the reactants, check if it is already present in the network.
        for (ChemicalCompound compound: reaction.reactants) {
            // If the compound is not present in the network, then add it
            if (!this.compounds.containsKey(compound.name) ) {
                this.compounds.put(compound.name, compound);
            }
        }
        // Repeat for the reaction products
        for (ChemicalCompound compound: reaction.reactants) {
            // If the compound is not present in the network, then add it
            if (!this.compounds.containsKey(compound.name) ) {
                this.compounds.put(compound.name, compound);
            }
        }

    }

    public Set<String> get_compound_names(){
        return this.compounds.keySet();
    }

    // Add a reaction from the basic building blocks
    public void add_reaction( ArrayList<String> reactants, ArrayList<String> products, double sigma, double barrier ) {
        // Check if reactants already exist, if not, create them
        for (String reactant: reactants){
            check_add_compound(reactant);
        }

        // Check if products already exist, if not, create them
        for (String product: products) {
            check_add_compound(product);
        }

        // Make reaction from the available parameters, and add it to
        ArrayList<ChemicalCompound> compoundReactants = new ArrayList<>();
        ArrayList<ChemicalCompound> compoundProducts = new ArrayList<>();

        for (String reactant: reactants) {
            compoundReactants.add(this.compounds.get(reactant));
        }

        for (String product: products) {
            compoundProducts.add(this.compounds.get(product));
        }

//        ChemicalCompound[] reactantsArray = compoundReactants.toArray(ChemicalCompound[]::new);
//        ChemicalCompound[] productsArray = compoundProducts.toArray(ChemicalCompound[]::new);


        Reaction new_reaction = new Reaction(
                compoundReactants.toArray(ChemicalCompound[]::new),
                compoundProducts.toArray(ChemicalCompound[]::new),
                sigma, barrier
        );

        this.reactions.add(new_reaction);

    }

    private void check_add_compound(String compound_name) {
        if (!this.compounds.containsKey(compound_name)) {
            ChemicalCompound new_compound = new ChemicalCompound(compound_name, 0.0);
            this.compounds.put(compound_name, new_compound);
        }
    }

}
