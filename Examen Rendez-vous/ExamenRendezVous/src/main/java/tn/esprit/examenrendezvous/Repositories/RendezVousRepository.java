package tn.esprit.examenrendezvous.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.examenrendezvous.Entities.RendezVous;
import tn.esprit.examenrendezvous.Entities.Specialite;

import java.util.Date;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
    @Query("SELECT rv FROM RendezVous rv WHERE rv.medecin.specialite = :specialite AND rv.medecin IN " +
            "(SELECT m FROM Medecin m JOIN m.cliniquesMedecin c WHERE c.idClinique = :idClinique)")
    List<RendezVous> findRendezVousByCliniqueAndSpecialite(@Param("idClinique") Long idClinique, @Param("specialite") Specialite specialite);
    @Query("SELECT r FROM RendezVous r JOIN r.medecin m JOIN m.cliniquesMedecin c WHERE c.idClinique = ?1 AND m.specialite = ?2")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique,Specialite specialite);
    List<RendezVous> findAllByMedecinIdMedecinAndDateRDVBetween(Long idMedecin, Date startDate, Date endDate);
}
