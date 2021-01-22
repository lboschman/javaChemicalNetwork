package chemicalNetwork;

import chemicalNetwork.parsing.ParseResult;
import chemicalNetwork.parsing.ReactionFileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ChemicalNetwork {
    private ArrayList<Reaction> reactions;
    private HashMap<String, ChemicalCompound> compounds;

    public ChemicalNetwork(){
        this.setCompounds(new HashMap<>());
        this.setReactions(new ArrayList<>());
    }

    public Set<String> getCompoundNames(){
        return this.getCompounds().keySet();
    }

    private void checkAddCompound(String compound_name) {
        if (!this.getCompounds().containsKey(compound_name)) {
            ChemicalCompound new_compound = new ChemicalCompound(compound_name, 0.0);
            this.compounds.put(compound_name, new_compound);
        }
    }

    public void addReaction(Reaction reaction ) {
        // Add the reaction to the system
        this.reactions.add(reaction);

        // For every compound in the reactants, check if it is already present in the network.
        for (ChemicalCompound compound: reaction.getReactants()) {
            // If the compound is not present in the network, then add it
            if (!this.getCompounds().containsKey(compound.getName()) ) {
                this.getCompounds().put(compound.getName(), compound);
            }
        }
        // Repeat for the reaction products
        for (ChemicalCompound compound: reaction.getReactants()) {
            // If the compound is not present in the network, then add it
            if (!this.getCompounds().containsKey(compound.getName()) ) {
                this.getCompounds().put(compound.getName(), compound);
            }
        }

    }

    // Add a reaction from the basic building blocks
    public void addReaction(ArrayList<String> reactants, ArrayList<String> products, double sigma, double barrier ) {
        // Check if reactants already exist, if not, create them
        for (String reactant: reactants){
            checkAddCompound(reactant);
        }

        // Check if products already exist, if not, create them
        for (String product: products) {
            checkAddCompound(product);
        }

        // Make reaction from the available parameters, and add it to
        ArrayList<ChemicalCompound> compoundReactants = new ArrayList<>();
        ArrayList<ChemicalCompound> compoundProducts = new ArrayList<>();

        for (String reactant: reactants) {
            compoundReactants.add(this.getCompounds().get(reactant));
        }

        for (String product: products) {
            compoundProducts.add(this.getCompounds().get(product));
        }

        Reaction new_reaction = new Reaction(
                compoundReactants.toArray(ChemicalCompound[]::new),
                compoundProducts.toArray(ChemicalCompound[]::new),
                sigma, barrier
        );

        this.getReactions().add(new_reaction);

    }

    public void addReaction(ParseResult result) {
        ArrayList<String> reactants = result.getReactants();
        ArrayList<String> products = result.getProducts();
        double sigma = result.getSigma();
        double barrier = result.getBarrier();

        this.addReaction(reactants, products, sigma, barrier);

    }

    public void readFromFile(String filename) {
        ReactionFileReader fileReader = new ReactionFileReader();
        ArrayList<ParseResult> parseResults = fileReader.parseFile(filename);

        for (ParseResult result: parseResults) {
            this.addReaction(result);
        }
    }

    public ArrayList<Reaction> getReactions() {
        return reactions;
    }

    private void setReactions(ArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }

    public HashMap<String, ChemicalCompound> getCompounds() {
        return compounds;
    }

    private void setCompounds(HashMap<String, ChemicalCompound> compounds) {
        this.compounds = compounds;
    }
}
