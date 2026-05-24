package school.sptech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import school.sptech.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {


    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.sla_mttr = " +
            "(SELECT CAST(AVG(r.mttrMinutos) AS int) FROM RegistroAlerta r " +
            " WHERE r.fkResponsavel = :id AND r.resolvidoEm IS NOT NULL) " +
            "WHERE u.idUsuario = :id")
    void atualizarSlaMttr(@Param("id") Integer idAnalista);

    @Query("SELECT AVG(r.mttrMinutos) FROM RegistroAlerta r " +
            "WHERE r.fkResponsavel = :id AND r.resolvidoEm IS NOT NULL")
    Double calcularMediaMttr(@Param("id") Integer idAnalista);
}