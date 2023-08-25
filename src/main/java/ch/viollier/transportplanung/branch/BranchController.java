package ch.viollier.transportplanung.branch;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/branches")
public class BranchController {
        private final BranchService branchService;

        @Autowired
        public BranchController(BranchService branchService){
            this.branchService = branchService;
        }

        @GetMapping
        public ResponseEntity<List<Branch>> getAllBranches(){
            return ResponseEntity.ok(branchService.getAllBranches());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Branch> getBranchById(@PathVariable Long id){
            Branch branch = branchService.getBranchById(id);
            return ResponseEntity.ok(branch);
        }

        @PostMapping
        public ResponseEntity<Branch> createBranch(@Valid @RequestBody Branch branch){
            Branch newBranch  = branchService.createBranch(branch);
            return ResponseEntity.ok(newBranch);
        }


        @PutMapping("/{id}")
        public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @Valid @RequestBody Branch newBranch){
            Branch branch = branchService.updateBranch(id,newBranch);
            return ResponseEntity.ok(branch);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> deleteBranch(Long id){
            branchService.deleteBranch(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
}
