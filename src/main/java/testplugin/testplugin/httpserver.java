package testplugin.testplugin;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsExchange;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class httpserver implements CommandExecutor{
    private final TestPlugin plugin;

    public httpserver(TestPlugin plugin) {
        this.plugin = plugin;
    }
    public HttpServer server;

    {
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("http-server-start")) {
            try {
                server.createContext("/", new ServerHandler());
                server.setExecutor(null);
                server.start();
                sender.sendMessage("Starting local http server at port 8080");
            } catch (Exception e) {
                e.printStackTrace();
                sender.sendMessage("§4Some problems occurred when starting server");
            }
            return true;
        }
        /*
        else if (cmd.getName().equalsIgnoreCase("http-server-stop")) {
            server.stop(999999999);
            return true;
        }
         */
        return false;
    }
    static class ServerHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<h1 style=\"text-align: center;\">Hello World!</h1>";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes(StandardCharsets.UTF_8));
            os.close();
        }
    }

}
