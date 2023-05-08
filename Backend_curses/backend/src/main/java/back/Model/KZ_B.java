package back.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "kz_b")
public class KZ_B {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private double time;
    @Column
    private double kz_ib;

    public String toString() {
        return "Measurment{" +
                "time=" + time +
                ", ia=" + kz_ib +
                '}';
    }

    public KZ_B(double time, double kz_ib) {
        this.time = time;
        this.kz_ib = kz_ib;
    }
}
