package tn.esprit.examendatacenter.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examendatacenter.Entitites.Datacenter;

import java.util.Date;
import java.util.List;

public interface DatacenterRepository extends JpaRepository<Datacenter,Integer> {
    public List<Datacenter> findByDateFabricationAfter(Date date);
}
