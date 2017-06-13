package nz.co.midori.backend.core.model;

/**
 * Created by djunigari on 21/05/17.
 */
public enum FundingType {
    FUNDED("Funded"), NOT_FUNDED("Not Funded");

    FundingType(String name){
        this.name = name;
    }

    private String name;

}
