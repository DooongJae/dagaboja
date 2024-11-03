package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SseController {
	
	@Autowired
	private final SseEmitterService sseEmitterService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
 
	@Autowired
    public SseController(SseEmitterService sseEmitterService) {
        this.sseEmitterService = sseEmitterService;
    }

    @GetMapping("/sse")
    public void handleSse(HttpServletResponse response) throws IOException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        sseEmitterService.addClient(response);

        try {
            response.getWriter().write("data: Connected\n\n");
            response.getWriter().flush();
        } catch (IOException e) {
            sseEmitterService.removeClient(response);
        }
    }

    @PostMapping("/broadcast")
    public ResponseEntity<Void> broadcast(@RequestBody String message) {
        try {
            sseEmitterService.broadcast(message);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok().build();
    }
	
	
	
}
