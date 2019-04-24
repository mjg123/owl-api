package lol.gilliard;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

public class Api {

    /**
     * This function listens at endpoint "/api/owlfact"
     */
    @FunctionName("owlfacts")
    public HttpResponseMessage run(
            @HttpTrigger(name="req", methods={HttpMethod.GET, HttpMethod.POST}, authLevel=AuthorizationLevel.ANONYMOUS, route="api/owlfacts")
                    HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {

        int count;

        try {
            count = Integer.parseInt(request.getQueryParameters().get("count"));
        } catch (NumberFormatException ex) {
            count = 1;
        }

        if (count > 10) count = 10;
        if (count < 1) count = 1;

        Collections.shuffle(OwlFacts.facts);
        List<String> facts = OwlFacts.facts.subList(0, count);

        return request.createResponseBuilder(HttpStatus.OK).header("Content-Type", "application/json").body(new ResponseJson(facts)).build();
    }

    public static class ResponseJson {
        public final List<String> facts;
        public final boolean success = true;

        public ResponseJson(List<String> facts) {
            this.facts = facts;
        }
    }

    /**
     * This function serves the static HTML. See also proxies.json
     */
    @FunctionName("index")
    public HttpResponseMessage index(
            @HttpTrigger(name="req", methods={HttpMethod.GET}, authLevel=AuthorizationLevel.ANONYMOUS, route="")
                    HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {

        InputStream is = this.getClass().getClassLoader().getResourceAsStream("index.html");

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String body = reader.lines().collect(Collectors.joining(System.lineSeparator()));

        return request.createResponseBuilder(HttpStatus.OK)
                .header("Content-Type", "text/html")
                .header("X-Flight", "Silent")
                .body(body)
                .build();
    }
}
