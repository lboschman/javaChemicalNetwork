package chemicalNetwork;

import chemicalNetwork.parsing.ParseResult;
import chemicalNetwork.parsing.ReactionFileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Initiates and runs a chemical network
 */
public class ChemicalNetwork {
    private ArrayList<Reaction> reactions;
    private HashMap<String, ChemicalCompound> compounds;

    /**
     * Initialize a chemical network without compounds and reactions.
     */
    public ChemicalNetwork(){
        this.setCompounds(new HashMap<>());
        this.setReactions(new ArrayList<>());
    }

    /**
     * @return the names of all the chemical compounds in the network.
     */
    public Set<String> getCompoundNames(){
        return this.getCompounds().keySet();
    }

    /**
     * Check if a compound with this name already exists, if not, create one and add to the network.
     *
     * @param compound_name The name of the compound
     */
    private void checkAddCompound(String compound_name) {
        if (!this.getCompounds().containsKey(compound_name)) {
            ChemicalCompound new_compound = new ChemicalCompound(compound_name, 0.0);
            this.compounds.put(compound_name, new_compound);
        }
    }

    /**
     * Add a reaction to the network.
     *
     * @param reaction Reaction object to be added to the network.
     */
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

    /**
     * Add a reaction to the network.
     *
     * @param reactants Names of the reacting chemicals
     * @param products Names of the reaction products
     * @param sigma Reaction cross section
     * @param barrier Reaction barrier
     */
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

        this.reactions.add(new_reaction);
    }

    /**
     * Add a reaction to the network
     *
     * @param result the result of parsing a single reaction line
     */
    public void addReaction(ParseResult result) {
        ArrayList<String> reactants = result.getReactants();
        ArrayList<String> products = result.getProducts();
        double sigma = result.getSigma();
        double barrier = result.getBarrier();

        this.addReaction(reactants, products, sigma, barrier);
    }

    /**
     * Read chemical reactions from a file, and load them into the network.
     *
     * @param filename name of the file with the chemical reactions
     */
    public void readFromFile(String filename) {
        ReactionFileReader fileReader = new ReactionFileReader();
        ArrayList<ParseResult> parseResults = fileReader.parseFile(filename);

        for (ParseResult result: parseResults) {
            this.addReaction(result);
        }
    }

    /**
     * @return The reactions of the network
     */
    public ArrayList<Reaction> getReactions() {
        return this.reactions;
    }

    /**
     * @param reactions The reactions to set.
     */
    private void setReactions(ArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }

    /**
     * @return The compounds of the network
     */
    public HashMap<String, ChemicalCompound> getCompounds() {
        return this.compounds;
    }

    /**
     * @param compounds The compounds that the network consists of
     */
    private void setCompounds(HashMap<String, ChemicalCompound> compounds) {
        this.compounds = compounds;
    }
}
