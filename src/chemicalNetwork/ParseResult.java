package chemicalNetwork;

import java.util.ArrayList;

public class ParseResult {
    private ArrayList<String> reactants;
    private ArrayList<String> products;
    private double sigma;
    private double barrier;

    public ParseResult(){
//        this.reactants = new ArrayList<String>();
//        this.products = new ArrayList<String>();
//        this.sigma = 0.;
//        this.barrier = 0.;
    }


    public ArrayList<String> getReactants() {
        return reactants;
    }

    public void setReactants(ArrayList<String> reactants) {
        this.reactants = reactants;
    }


    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }

    public double getSigma() {
        return sigma;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    public double getBarrier() {
        return barrier;
    }

    public void setBarrier(double barrier) {
        this.barrier = barrier;
    }

}
