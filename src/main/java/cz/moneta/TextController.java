package cz.moneta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {
     
    private final TextService textService;    

    public TextController(TextService textService) {
		super();
		this.textService = textService;
	}

	@GetMapping("/text/transform")
    public Output transform(@RequestParam(value="text", defaultValue="") String text) {
		
		String transformedText = textService.transform(text); 
        return new Output(transformedText);
    }
}
