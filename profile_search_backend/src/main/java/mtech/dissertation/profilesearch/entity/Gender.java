package mtech.dissertation.profilesearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Gender entity class.
 * 
 * @author Abhijit.Daund
 */
@Data
@Entity(name = "gender")
@Table(name = "gender_lkp")
public class Gender {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "gender_name")
    private String genderName;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Gender))
            return false;
        final Gender other = (Gender) obj;
        if (id != other.id)
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
}
