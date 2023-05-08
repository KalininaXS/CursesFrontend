package back.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "kz_c")
public class KZ_C {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private double time;
    @Column
    private double kz_ic;


    public String toString() {
        return "Measurment{" +
                "time=" + time +
                ", ia=" + kz_ic +
                '}';
    }

    public KZ_C(double time, double kz_ic) {
        this.time = time;
        this.kz_ic = kz_ic;
    }
}
