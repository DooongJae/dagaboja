package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class SseEmitterService {

    private final List<HttpServletResponse> clients = new ArrayList<>();

    public synchronized void addClient(HttpServletResponse response) {
        clients.add(response);
    }

    public synchronized void removeClient(HttpServletResponse response) {
        clients.remove(response);
    }

    public synchronized void broadcast(String message) throws IOException {
        for (HttpServletResponse client : clients) {
            try {
                PrintWriter writer = client.getWriter();
                writer.write("data: " + message + "\n\n");
                writer.flush();
                client.flushBuffer();
            } catch (IOException e) {
                removeClient(client);
            }
        }
    }
}
