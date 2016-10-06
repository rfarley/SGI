import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by Ryan on 10/6/2016.
 */

/* This annotation ignores the "date1" and "date2" fields from the data.
   The data was generated using mockaroo.com and these fields were needed
   in order to ensure death_date was always after birth_date.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Person {
    String first_name;
    String last_name;
    Date birth_date;
    Date death_date;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Date getDeath_date() {
        return death_date;
    }

    public void setDeath_date(Date death_date) {
        this.death_date = death_date;
    }
}
