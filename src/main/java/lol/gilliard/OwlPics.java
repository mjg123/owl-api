package lol.gilliard;

import java.util.Arrays;
import java.util.List;

public class OwlPics {

    public static final List<PicWithAttribution> pics = Arrays.asList(

            new PicWithAttribution(
                    "640px-Great_Horned_Owl_at_twilight,_Mojave_Desert.jpg",
                    "https://commons.wikimedia.org/wiki/File:Great_Horned_Owl_at_twilight,_Mojave_Desert.jpg"),

            new PicWithAttribution(
                    "Eastern_Barn_Owl_(Tyto_javanica_stertens),_Raigad,_Maharashtra.jpg",
                    "https://commons.wikimedia.org/wiki/File:Eastern_Barn_Owl_(Tyto_javanica_stertens),_Raigad,_Maharashtra.jpg"),

            new PicWithAttribution(
                    "603px-Athene_cuniculariaa.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Athene_cuniculariaa.jpg/603px-Athene_cuniculariaa.jpg")

    );

    public static class PicWithAttribution{
        public final String picFileName;
        public final String attributionUrl;

        public PicWithAttribution(String picFileName, String attributionUrl) {
            this.picFileName = picFileName;
            this.attributionUrl = attributionUrl;
        }
    }

}
