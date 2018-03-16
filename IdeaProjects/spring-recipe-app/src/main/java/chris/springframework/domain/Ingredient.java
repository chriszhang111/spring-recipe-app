package chris.springframework.domain;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String discription;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;


    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.discription = description;
        this.amount = amount;
        this.uom = uom;
    }
    public Ingredient(String discription, BigDecimal amount, UnitOfMeasure uom,Recipe recipe) {
        this.discription = discription;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id);
    }
}
