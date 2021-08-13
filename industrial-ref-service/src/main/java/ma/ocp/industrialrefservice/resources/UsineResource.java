package ma.ocp.industrialrefservice.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UsineResource {

    static List<Usine> usines = new ArrayList<>();
    static {
        usines.add(new Usine(1L,"JFC1","OCP LJORF"));
        usines.add(new Usine(2L,"JFC2","OCP LJORF"));
        usines.add(new Usine(3L,"JFC3","OCP LJORF"));
    }

    @GetMapping("/usine")
    public ResponseEntity<List<Usine>> getAllUsine(@AuthenticationPrincipal Jwt jwt){
        if ( jwt!=null ) {
            log.trace("***** JWT Headers: {}", jwt.getHeaders());
            log.trace("***** JWT Claims: {}", jwt.getClaims().toString());
            log.trace("***** JWT Token: {}", jwt.getTokenValue());
        }
        return ResponseEntity.ok(usines);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Usine {
        Long id;
        String name;
        String company;
    }
}
