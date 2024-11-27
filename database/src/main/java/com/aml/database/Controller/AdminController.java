package com.aml.database.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aml.database.Service.AdminService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor  
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*") 
public class AdminController { ////realtime project-1

    //private  MediaService mediaService; 

   /** @PutMapping("/transfer/{mediaId}/{newBranchId}")
    public ResponseEntity<MediaDto> transferMedia(@PathVariable("mediaId") int mediaId, 
                                                  @PathVariable("newBranchId") int newBranchId) {
        MediaDto updatedMedia = mediaService.transferMedia(mediaId, newBranchId);
        return new ResponseEntity<>(updatedMedia, HttpStatus.OK);
    }
 */

    private AdminService adminService;
   

}
