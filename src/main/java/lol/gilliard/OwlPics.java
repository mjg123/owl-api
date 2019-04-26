package lol.gilliard;

import java.util.Arrays;
import java.util.List;

public class OwlPics {

    public static final List<PicWithAttribution> pics = Arrays.asList(

            new PicWithAttribution(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Great_Horned_Owl_at_twilight%2C_Mojave_Desert.jpg/640px-Great_Horned_Owl_at_twilight%2C_Mojave_Desert.jpg",
                    "https://commons.wikimedia.org/wiki/File:Great_Horned_Owl_at_twilight,_Mojave_Desert.jpg"),

            new PicWithAttribution(
                    "https://upload.wikimedia.org/wikipedia/commons/f/f2/Eastern_Barn_Owl_%28Tyto_javanica_stertens%29%2C_Raigad%2C_Maharashtra.jpg",
                    "https://commons.wikimedia.org/wiki/File:Eastern_Barn_Owl_(Tyto_javanica_stertens),_Raigad,_Maharashtra.jpg"),

            new PicWithAttribution(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Athene_cuniculariaa.jpg/603px-Athene_cuniculariaa.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Athene_cuniculariaa.jpg/603px-Athene_cuniculariaa.jpg")

    );

    public static class PicWithAttribution{
        public final String picUrl;
        public final String attributionUrl;

        public PicWithAttribution(String picUrl, String attributionUrl) {
            this.picUrl = picUrl;
            this.attributionUrl = attributionUrl;
        }
    }

}
