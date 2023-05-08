package back.Service;

import back.Model.KZ_A;
import back.Model.KZ_B;
import back.Model.KZ_C;
import back.Repository.Back_Repository;
import back.Repository.Finder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Back_Service {
    @Autowired
    private Back_Repository backRepository;
    @Autowired
    private Finder finder;

    @SneakyThrows
    public void parser(MultipartFile file){
        //double kz = 0.434758;
        double kza = 0.21;
        double kzb = 0.21;
        double kzc = 0.21;


        InputStream inputStream = file.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line = bufferedReader.readLine();
        line = bufferedReader.readLine();
        double for_kza = -1;
        double for_kzb = -1;
        double for_kzc = -1;

        double max_ia = 0;
        double max_ib = 0;
        double max_ic = 0;

        double ust_ia = 0;
        double ust_ib = 0;
        double ust_ic = 0;


        boolean flag_kza = false;
        boolean flag_kzb = false;
        boolean flag_kzc = false;

        boolean flag_first_run_a = true;
        boolean flag_first_run_b = true;
        boolean flag_first_run_c = true;

        boolean flag_up_a = false;
        boolean flag_up_b = false;
        boolean flag_up_c = false;


        while (line != null){
            String[] stringParts = line.split(",");
            if (stringParts.length > 3){
                String time = stringParts[0];
                String ia = stringParts[1];
                String ib = stringParts[2];
                String ic = stringParts[3];
                log.info("Time = {} , ia ={}, ib ={}, ic={}", time, ia,ib,ic);
                double time1 = Double.parseDouble(time);
                double ia1 = Double.parseDouble(ia);
                double ib1 = Double.parseDouble(ib);
                double ic1 = Double.parseDouble(ic);
                double deistv_ia = Math.abs(ia1)/Math.sqrt(2);
                double deistv_ib = Math.abs(ib1)/Math.sqrt(2);
                double deistv_ic = Math.abs(ic1)/Math.sqrt(2);

                log.info("{}, {}, {}", deistv_ia, deistv_ib, deistv_ic);

                if (flag_first_run_a && (for_kza != -1)){
                    if (for_kza < deistv_ia){
                        flag_up_a = true;
                    }

                }
                if (flag_first_run_a && flag_up_a && (for_kza != -1)){
                    if (for_kza > deistv_ia){
                        ust_ia = for_kza;
                        flag_first_run_a = false;
                        log.info("{}", ust_ia);
                    }
                }




                if (flag_first_run_b && (for_kzb != -1)){
                    if (for_kzb < deistv_ib){
                        flag_up_b = true;
                    }

                }
                if (flag_first_run_b && flag_up_b && (for_kzb != -1)){
                    if (for_kzb > deistv_ib){
                        ust_ib = for_kzb;
                        flag_first_run_b = false;
                        log.info("{}", ust_ib);
                    }
                }




                if (flag_first_run_c && (for_kzc != -1)){
                    if (for_kzc < deistv_ic){
                        flag_up_c = true;
                    }

                }
                if (flag_first_run_c && flag_up_c && (for_kzc != -1)){
                    if (for_kzc > deistv_ic){
                        max_ic = for_kzc;
                        flag_first_run_c = false;
                        log.info("{}", ust_ic);
                    }
                }





                if ((for_kza < deistv_ia) && (flag_kza)){
                    max_ia = for_kza;
                    if (max_ia < (kza * 1.01)){
                        flag_kza = false;
                    }
                }

                if ((for_kzb < deistv_ib) && flag_kzb){
                    max_ib = for_kzb;
                    if (max_ib < (kzb * 1.01)){
                        flag_kzb = false;
                    }
                }

                if ((for_kzc < deistv_ic) && flag_kzc){
                    max_ic = for_kzc;
                    if (max_ia < (kzc * 1.01)){
                        flag_kzc = false;
                    }
                }


                if ((deistv_ia>kza) || flag_kza){
                    flag_kza = true;
                    KZ_A kzA = new KZ_A(time1, ia1);
                    backRepository.save_kz_a(kzA);
                }
                if ((deistv_ib>kzb) || flag_kzb){
                    flag_kzb = true;
                    KZ_B kzB = new KZ_B(time1, ib1);
                    backRepository.save_kz_b(kzB);
                }
                if ((deistv_ic>kzc) || flag_kzc){
                    flag_kzc = true;
                    KZ_C kzC = new KZ_C(time1, ic1);
                    backRepository.save_kz_c(kzC);
                }


                for_kza = deistv_ia;
                for_kzb = deistv_ib;
                for_kzc = deistv_ic;


            }

            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        log.info("FIle read successfully");
    }

    @SneakyThrows
    public List<KZ_A> findAllA(){
        return finder.FindKZA();
    }

    @SneakyThrows
    public List<KZ_B> findAllB(){
        return finder.FindKZB();
    }

    @SneakyThrows
    public List<KZ_C> findAllC(){
        return finder.FindKZC();
    }

    @SneakyThrows
    public List<Double> findKZA() { return finder.findKZA();}

    @SneakyThrows
    public List<Double> findTimeKZA() { return finder.findTimeKZA();}

    @SneakyThrows
    public List<Double> findKZB() { return finder.findKZB();}

    @SneakyThrows
    public List<Double> findTimeKZB() { return finder.findTimeKZB();}

    @SneakyThrows
    public List<Double> findKZC() { return finder.findKZC();}

    @SneakyThrows
    public List<Double> findTimeKZC() { return finder.findTimeKZC();}
}
