package com.bezkoder.spring.jwt.mongodb.cloudVision;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.vision.v1.*;
import io.grpc.Context;
import org.springframework.stereotype.Service;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CloudVisionService {

    // Detects text in the specified image.
    public BatchAnnotateImagesResponse detectText(String filePath) throws IOException {
        List<AnnotateImageRequest> requests = new ArrayList<>();
        BatchAnnotateImagesResponse result = null;
        ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            result = response;
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                }else {
                    // For full list of available annotations, see http://g.co/cloud/vision/docs
                    for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
                        System.out.format("Text: %s%n", annotation.getDescription());
                        System.out.format("Position : %s%n", annotation.getBoundingPoly());
                    }
                }

            }
        }

        return result;
    }

    public BatchAnnotateImagesResponse detectTextInputString(InputStream inputStream) throws IOException {
        List<AnnotateImageRequest> requests = new ArrayList<>();
        BatchAnnotateImagesResponse result = null;
        ByteString imgBytes = ByteString.readFrom(inputStream);

        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            result = response;
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                }else {
                    // For full list of available annotations, see http://g.co/cloud/vision/docs
                    for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
                        System.out.format("Text: %s%n", annotation.getDescription());
                        System.out.format("Position : %s%n", annotation.getBoundingPoly());
                    }
                }

            }
        }

        return result;
    }


    public static void detectDocumentsGcs(String gcsSourcePath, String gcsDestinationPath)
            throws Exception {

        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            List<AsyncAnnotateFileRequest> requests = new ArrayList<>();

            // Set the GCS source path for the remote file.
            GcsSource gcsSource = GcsSource.newBuilder().setUri(gcsSourcePath).build();

            // Create the configuration with the specified MIME (Multipurpose Internet Mail Extensions)
            // types
            InputConfig inputConfig =
                    InputConfig.newBuilder()
                            .setMimeType(
                                    "application/pdf") // Supported MimeTypes: "application/pdf", "image/tiff"
                            .setGcsSource(gcsSource)
                            .build();

            // Set the GCS destination path for where to save the results.
            GcsDestination gcsDestination =
                    GcsDestination.newBuilder().setUri(gcsDestinationPath).build();

            // Create the configuration for the System.output with the batch size.
            // The batch size sets how many pages should be grouped into each json System.output file.
            OutputConfig outputConfig =
                    OutputConfig.newBuilder().setBatchSize(2).setGcsDestination(gcsDestination).build();

            // Select the Feature required by the vision API
            Feature feature = Feature.newBuilder().setType(Feature.Type.DOCUMENT_TEXT_DETECTION).build();

            // Build the OCR request
            AsyncAnnotateFileRequest request =
                    AsyncAnnotateFileRequest.newBuilder()
                            .addFeatures(feature)
                            .setInputConfig(inputConfig)
                            .setOutputConfig(outputConfig)
                            .build();

            requests.add(request);

            // Perform the OCR request
            OperationFuture<AsyncBatchAnnotateFilesResponse, OperationMetadata> response =
                    client.asyncBatchAnnotateFilesAsync(requests);

            System.out.println("Waiting for the operation to finish.");

            // Wait for the request to finish. (The result is not used, since the API saves the result to
            // the specified location on GCS.)
            List<AsyncAnnotateFileResponse> result =
                    response.get(180, TimeUnit.SECONDS).getResponsesList();


        }
    }
}
