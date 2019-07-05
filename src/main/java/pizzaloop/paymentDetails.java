package pizzaloop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class paymentDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
   private  String card_number;
    private String Experid_Date;

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getExperid_Date() {
        return Experid_Date;
    }

    public void setExperid_Date(String experid_Date) {
        Experid_Date = experid_Date;
    }
}
