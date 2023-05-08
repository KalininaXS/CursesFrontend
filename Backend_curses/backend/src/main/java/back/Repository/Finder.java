package back.Repository;

import back.Model.KZ_A;
import back.Model.KZ_B;
import back.Model.KZ_C;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class Finder {
    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public Finder(NamedParameterJdbcOperations namedParameterJdbcOperations)
    {
        this.jdbc = namedParameterJdbcOperations.getJdbcOperations();
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    public List<KZ_A> FindKZA(){
        return jdbc.query("select * from kz_a", new Finder.MapperA());
    }

    public List<KZ_B> FindKZB(){
        return jdbc.query("select * from kz_b", new Finder.MapperB());
    }

    public List<KZ_C> FindKZC(){
        return jdbc.query("select * from kz_c", new Finder.MapperC());
    }

    public List<Double> findKZA() { return jdbc.query("select kz_ia from kz_a", new Finder.MapperDoubleA());}

    public List<Double> findTimeKZA() { return jdbc.query("select time from kz_a", new Finder.MapperDoubleTimeA());}

    public List<Double> findKZB() { return jdbc.query("select kz_ib from kz_b", new Finder.MapperDoubleB());}

    public List<Double> findTimeKZB() { return jdbc.query("select time from kz_b", new Finder.MapperDoubleTimeB());}

    public List<Double> findKZC() { return jdbc.query("select kz_ic from kz_c", new Finder.MapperDoubleC());}

    public List<Double> findTimeKZC() { return jdbc.query("select time from kz_c", new Finder.MapperDoubleTimeC());}


    private static class MapperDoubleA implements RowMapper<Double> {
        @Override
        public Double mapRow(ResultSet resultSet, int i) throws SQLException{
            return resultSet.getDouble("kz_ia");
        }
    }
    private static class MapperDoubleTimeA implements RowMapper<Double> {
        @Override
        public Double mapRow(ResultSet resultSet, int i) throws SQLException{
            return resultSet.getDouble("time");
        }
    }

    private static class MapperDoubleB implements RowMapper<Double> {
        @Override
        public Double mapRow(ResultSet resultSet, int i) throws SQLException{
            return resultSet.getDouble("kz_ib");
        }
    }
    private static class MapperDoubleTimeB implements RowMapper<Double> {
        @Override
        public Double mapRow(ResultSet resultSet, int i) throws SQLException{
            return resultSet.getDouble("time");
        }
    }

    private static class MapperDoubleC implements RowMapper<Double> {
        @Override
        public Double mapRow(ResultSet resultSet, int i) throws SQLException{
            return resultSet.getDouble("kz_ic");
        }
    }
    private static class MapperDoubleTimeC implements RowMapper<Double> {
        @Override
        public Double mapRow(ResultSet resultSet, int i) throws SQLException{
            return resultSet.getDouble("time");
        }
    }


    private static class MapperA implements RowMapper<KZ_A> {
        @Override
        public KZ_A mapRow(ResultSet resultSet, int i) throws SQLException {
            double IA = resultSet.getDouble("kz_ia");
            double TIME = resultSet.getDouble("time");
            return new KZ_A(TIME, IA);
        }
    }


    private static class MapperB implements RowMapper<KZ_B> {
        @Override
        public KZ_B mapRow(ResultSet resultSet, int i) throws SQLException {
            double IB = resultSet.getDouble("kz_ib");
            double TIME = resultSet.getDouble("time");
            return new KZ_B(TIME, IB);
        }
    }

    private static class MapperC implements RowMapper<KZ_C> {
        @Override
        public KZ_C mapRow(ResultSet resultSet, int i) throws SQLException {
            double IC = resultSet.getDouble("kz_ic");
            double TIME = resultSet.getDouble("time");
            return new KZ_C(TIME, IC);
        }
    }


}
