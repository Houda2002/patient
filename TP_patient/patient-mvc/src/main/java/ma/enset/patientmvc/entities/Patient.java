package ma.enset.patientmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
