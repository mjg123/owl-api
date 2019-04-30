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
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Athene_cuniculariaa.jpg/603px-Athene_cuniculariaa.jpg"),

            new PicWithAttribution(
                    "_wp-content_uploads_0638551344d3981efbe56e0108ae4d458fa21c5e1382721127-s-thumbnail2.jpg",
                    "http://animalch.net/article/464938162.htm"),

            new PicWithAttribution(
                    "_wp-content_uploads_b340a3c9a9cac6f9c8c517cd333845e4f3d7eb1b1382721145-s-thumbnail2.jpg",
                    "http://animalch.net/article/464938162.htm"),

            new PicWithAttribution(
                    "owlhead.jpg",
                    "http://animalch.net/article/464938162.htm"),

            new PicWithAttribution(
                    "weighing.jpg",
                    "http://animalch.net/article/464938162.html")

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
