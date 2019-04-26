package lol.gilliard;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Api {

    /**
     * This function listens at endpoint "/api/owlfacts"
     */
    @FunctionName("owlfacts")
    public HttpResponseMessage owlfacts(
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
     * This function listens at endpoint "/api/owlpic"
     */
    @FunctionName("owlpic")
    public HttpResponseMessage owlpic(
            @HttpTrigger(name="req", methods={HttpMethod.GET}, authLevel=AuthorizationLevel.ANONYMOUS, route="api/owlpic")
                    HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {

        OwlPics.PicWithAttribution picWithAttribution = OwlPics.pics.get(new Random().nextInt(OwlPics.pics.size()));

        try {
            CloseableHttpResponse resp = HttpClients.createDefault().execute(new HttpGet(picWithAttribution.picUrl));

            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            resp.getEntity().writeTo(byteStream);

            return request.createResponseBuilder(HttpStatus.OK)
                    .header("Content-Type", resp.getEntity().getContentType().getElements()[0].toString())
                    .header("X-Attribution", picWithAttribution.attributionUrl)
                    .body(byteStream.toByteArray())
                    .build();

        } catch (Exception e){
            return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR).body("Twit-twooo there's been a problem fetching your pic, sorry").build();

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
