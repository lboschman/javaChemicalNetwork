package chemicalNetwork.parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReactionFileReader {
    private String reactantsHeader;
    private String productsHeader;
    private String sigmaHeader;
    private String barrierHeader;

    public ReactionFileReader(){
        this.reactantsHeader = "Reactants";
        this.productsHeader = "Products";
        this.sigmaHeader = "Sigma";
        this.barrierHeader = "Barrier";
    }

    private HashMap<String, Integer> parseHeading(String header) {
        HashMap<String, Integer> parseIndices = new HashMap<>();

        parseIndices.put("reactants", header.indexOf(this.getReactantsHeader()));
        parseIndices.put("products", header.indexOf(this.getProductsHeader()));
        parseIndices.put("sigma", header.indexOf(this.getSigmaHeader()));
        parseIndices.put("barrier", header.indexOf(this.getBarrierHeader()));

        return parseIndices;

    }

    public ArrayList<ParseResult> parseFile(String filename) {
        // First try and read the file
        Scanner myReader = null;

        try {
            File reactionFile = new File(filename);
            myReader = new Scanner(reactionFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        // Parse the header
        assert myReader != null;
        String header = myReader.nextLine();
        HashMap<String, Integer> parsingIndices = this.parseHeading(header);

        // Make a ReactionStringParser with the appropriate properties
        ReactionStringParser parser = new ReactionStringParser.Builder()
                .withReactantsIndex(parsingIndices.get("reactants"))
                .withProductsIndex(parsingIndices.get("products"))
                .withSigmaIndex(parsingIndices.get("sigma"))
                .withBarrierIndex(parsingIndices.get("barrier"))
                .build();

        // Parse the reaction strings
        ArrayList<ParseResult> results = new ArrayList<>();

        while (myReader.hasNextLine()) {
            String reaction = myReader.nextLine();
            results.add(parser.parseReactionString(reaction));
        }

        return results;
    }


    public String getReactantsHeader() {
        return reactantsHeader;
    }

    public void setReactantsHeader(String reactantsHeader) {
        this.reactantsHeader = reactantsHeader;
    }

    public String getProductsHeader() {
        return productsHeader;
    }

    public void setProductsHeader(String productsHeader) {
        this.productsHeader = productsHeader;
    }

    public String getSigmaHeader() {
        return sigmaHeader;
    }

    public void setSigmaHeader(String sigmaHeader) {
        this.sigmaHeader = sigmaHeader;
    }

    public String getBarrierHeader() {
        return barrierHeader;
    }

    public void setBarrierHeader(String barrierHeader) {
        this.barrierHeader = barrierHeader;
    }
}
