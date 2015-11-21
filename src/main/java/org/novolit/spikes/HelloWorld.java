package org.novolit.spikes;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {

        get("/", (request, response) -> {
            response.status(401);
            return "Go Away!!!";
        });

        // matches "GET /hello/foo" and "GET /hello/bar"
        // request.params(":name") is 'foo' or 'bar'
        get("/hello/:name", (request, response) -> "Hello: " + request.params(":name"));

        post("/hello", (request, response) ->
            "Hello: " + request.body()
        );

        // matches "GET /say/hello/to/world"
        // request.splat()[0] is 'hello' and request.splat()[1] 'world'
        get("/say/*/to/*", (request, response) -> "Number of splat parameters: " + request.splat().length);
    }
}
