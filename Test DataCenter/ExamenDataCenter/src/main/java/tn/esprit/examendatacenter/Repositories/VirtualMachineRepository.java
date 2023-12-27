package tn.esprit.examendatacenter.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examendatacenter.Entitites.VirtualMachine;

public interface VirtualMachineRepository extends JpaRepository<VirtualMachine,Integer> {
}
