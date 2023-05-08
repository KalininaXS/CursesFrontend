package back.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "kz_a")
@NoArgsConstructor
@AllArgsConstructor
public class KZ_A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private double time;
    @Column
    private double kz_ia;

    public String toString() {
        return "Measurment{" +
                "time=" + time +
                ", ia=" + kz_ia +
                '}';
    }
    public KZ_A(double time, double kz_ia){
        this.time = time;
        this.kz_ia = kz_ia;
    }

    public void kz_a(double time, double kz_ia) {
        this.time = time;
        this.kz_ia = kz_ia;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KZ_A that = (KZ_A) o;
        return time == that.time && Double.compare(that.kz_ia, kz_ia) == 0;
    }

    public int hashCode() {
        return Objects.hash(time, kz_ia);
    }

    public int hash(double x1) { return Objects.hash(x1); }
}
