import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RequestHandler implements Runnable {
    private Socket clientSocket;

    public RequestHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String requestLine = in.readLine();
            if (requestLine != null) {
                System.out.println("Received: " + requestLine);
                String[] requestParts = requestLine.split(" ");
                String method = requestParts[0];
                String path = requestParts[1];

                if (method.equals("GET")) {
                    handleGetRequest(path, out);
                } else if (method.equals("POST")) {
                    handlePostRequest(path, in, out);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleGetRequest(String path, PrintWriter out) throws IOException {
        if (path.equals("/")) {
            path = "/index.html"; // Serve index.html by default
        }

        // Cambiar la ruta para que apunte a src/main/resources
        String filePath = "src/main/resources" + path;
        File file = new File(filePath);

        if (file.exists() && !file.isDirectory()) {
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: " + getContentType(file));
            out.println("Content-Length: " + file.length());
            out.println();
            // Enviar el contenido del archivo
            Files.copy(file.toPath(), clientSocket.getOutputStream());
        } else {
            out.println("HTTP/1.1 404 Not Found");
            out.println();
        }
    }

    private void handlePostRequest(String path, BufferedReader in, PrintWriter out) throws IOException {
        // Implementar lógica para manejar solicitudes POST
        StringBuilder requestBody = new StringBuilder();
        String line;
        while (!(line = in.readLine()).isEmpty()) {
            requestBody.append(line).append("\n");
        }
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/plain");
        out.println();
        out.println("Received POST request with body: " + requestBody.toString());
    }

    private String getContentType(File file) {
        String fileName = file.getName();
        if (fileName.endsWith(".html")) return "text/html";
        if (fileName.endsWith(".css")) return "text/css";
        if (fileName.endsWith(".js")) return "application/javascript";
        if (fileName.endsWith(".png")) return "image/png";
        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) return "image/jpeg";
        return "application/octet-stream";
    }
}