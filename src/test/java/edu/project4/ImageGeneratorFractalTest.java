package edu.project4;

import edu.project4.multi.MultiPixelFireGenerator;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ImageGeneratorFractalTest {

    private static final String PATH = "src/main/resources/project4Fractals/testFractal";
    private static final String DIRECTORY_PATH = "src/main/resources/project4Fractals";

    @BeforeAll
    static void generateImage() {
        MultiPixelFireGenerator pixelFireGenerator = new MultiPixelFireGenerator(1920, 1080);
        Pixel[][] pixels = pixelFireGenerator.generate(1000000, 100);
        ImageGenerator imageGenerator = new ImageGeneratorFractal();
        imageGenerator.generate(pixels, PATH);
    }

    @Test
    void generateTest() {
        Path directoryPath = Path.of(DIRECTORY_PATH);
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)) {
            boolean check = false;
            for (Path path : directoryStream) {
                if (path.toString().equalsIgnoreCase(PATH + ".jpg")) {
                    check = true;
                }
            }
            assertThat(check).isTrue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterAll
    static void deleteImage() throws IOException {
        Path pathImage = Path.of(PATH + ".jpg");
        Files.delete(pathImage);
    }

}
