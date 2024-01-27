package tn.esprit.examen.RestController;

import lombok.AllArgsConstructor;
import tn.esprit.examen.Services.IService;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    private IService iService;
}
