package ch.viollier.transportplanung.branch;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
public class BranchService {
    private final BranchRepository branchRepository;
    @Autowired
    public BranchService(BranchRepository branchRepository){
        this.branchRepository = branchRepository;
    }

    public List<Branch> getAllBranches(){
        return branchRepository.findAll();
    }

    /**
     * This method returns a specific branch selected
     * by the id
     * @param id the id of the branch
     * @return returns a branch
     * @throws EntityNotFoundException
     */
    public Branch getBranchById(Long id) throws EntityNotFoundException{
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if(optionalBranch.isEmpty()) throw new EntityNotFoundException("Branch not found");
        return optionalBranch.get();
    }

    /**
     * This method returns a List of branches with the name
     * containing a string. If no matching branches are
     * found, an empty list is returned.
     * @param name the name searched for
     * @return a list of matching branches
     */
    public List<Branch> getBranchesByName(String name){
        return branchRepository.findByNameContaining(name);
    }

    /**
     * This method creates a branch in the database
     * @param branch the branch object to be saved
     * @return the created branch
     * @throws EntityExistsException
     */
    public Branch createBranch(Branch branch) throws EntityExistsException{
        Branch existingBranch = branchRepository.findByName(branch.getName());
        if (existingBranch!=null) throw new EntityExistsException("Branch already exists");
        return branchRepository.save(branch);
    }

    /**
     * This method gets the to be updated branch by the id,
     * changes its attributes and saves them to the database.
     * If the branch doesn't exist an exception gets thrown.
     * @param id of the to be updated branch
     * @param newBranch the new branch object
     * @return branch with updated values.
     * @throws EntityNotFoundException
     */
    public Branch updateBranch(Long id, Branch newBranch) throws EntityNotFoundException{
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if(optionalBranch.isEmpty()) throw new EntityNotFoundException("Branch not found");
        Branch branch = optionalBranch.get();
        branch.setName(newBranch.getName());
        branch.setStreet(newBranch.getStreet());
        branch.setCity(newBranch.getCity());
        branch.setZip(newBranch.getZip());
        return branchRepository.save(branch);

    }

    /**
     * This method deletes a defined branch
     * @param id of the branch to be deleted
     * @throws EntityNotFoundException
     */
    public void deleteBranch(Long id) throws EntityNotFoundException{
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if(optionalBranch.isEmpty()) throw new EntityNotFoundException("Branch not found");
        branchRepository.deleteById(id);
    }

}
