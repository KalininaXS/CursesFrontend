package back.Repository;

import back.Model.KZ_A;
import back.Model.KZ_B;
import back.Model.KZ_C;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class Back_Repository {
    @PersistenceContext
    private EntityManager em;


    @Transactional
    public KZ_A save_kz_a(KZ_A m){
        if (m.getId()== 0){
            em.persist(m);
            return m;
        } else {
            return em.merge(m);
        }
    }

    @Transactional
    public KZ_B save_kz_b(KZ_B m){
        if (m.getId()== 0){
            em.persist(m);
            return m;
        } else {
            return em.merge(m);
        }
    }


    @Transactional
    public KZ_C save_kz_c(KZ_C m){
        if (m.getId()== 0){
            em.persist(m);
            return m;
        } else {
            return em.merge(m);
        }
    }

}
