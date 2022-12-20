package com.example.springboot_collegelibrary.faceRecognition;

import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;

@Service
public class FaceService {

    public File TakePicture(String userEmail) {
        System.out.println("Attempting to take picture");

        // Load the OpenCV library
        nu.pattern.OpenCV.loadLocally();

        // Create a new video capture object
        VideoCapture capture = new VideoCapture(0);

        // Check if the video capture object was created successfully
        if (!capture.isOpened()) {
            System.out.println("Error: Could not access webcam.");
            return null;
        }

        // Create a new matrix to store the video frame
        Mat frame = new Mat();

        // Read a frame from the video capture object
        capture.read(frame);

        // Save the frame to a file
        String filePath = "src/main/resources/static/images/"+ userEmail+".jpg";
        org.opencv.imgcodecs.Imgcodecs.imwrite(filePath, frame);

        // Release the video capture object
        capture.release();

        return new File(filePath);
    }

    public static void FaceSimilarityVideoAndPicture(String userEmail) {
        System.setProperty("java.library.path", "C:/opencv/build/java/x64");
        // Load the OpenCV library
        System.loadLibrary("opencv_java460");

        // Create a new VideoCapture object
        VideoCapture capture = new VideoCapture(0);

        // Check if the video stream is open
        if (!capture.isOpened()) {
            System.out.println("Error opening video stream");
            return;
        }

        // Load the face classifier
        CascadeClassifier faceClassifier = new CascadeClassifier("C:/opencv/build/etc/haarcascades/haarcascade_frontalface_default.xml");
        // Loop through the frames of the video stream
        while (true) {
            // Read a frame from the video stream
            Mat frame = new Mat();
            capture.read(frame);
            // Detect faces in the frame
//            compareFace("src/main/resources/static/images/"+ userEmail+".jpg",frame);
            compareFace("src/main/resources/static/images/724thomas@hanmail.net.jpg",frame);
            MatOfRect faces = new MatOfRect();
            faceClassifier.detectMultiScale(frame, faces);

            // Iterate over the detected faces and draw a rectangle around each face
            for (Rect rect : faces.toArray()) {
                Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0), 3);
            }

            // Display the frame in a window
            HighGui.imshow("Video", frame);

            // Wait for a key press before continuing to the next frame
            int key = HighGui.waitKey(1);
            if (key == 27) { // Escape key
                break;
            }
        }

        // Release the video capture resources
        capture.release();
    }

    public static double compareFace(String filename, Mat frame){
        Mat image1 = Imgcodecs.imread(filename, Imgcodecs.IMREAD_GRAYSCALE);

        Mat hist1= new Mat();
        Mat hist2= new Mat();
        Imgproc.calcHist(Arrays.asList(image1), new MatOfInt(0), new Mat(), hist1, new MatOfInt(256), new MatOfFloat(0, 256));
        Imgproc.calcHist(Arrays.asList(frame), new MatOfInt(0), new Mat(), hist2, new MatOfInt(256), new MatOfFloat(0, 256));

        double similarity = Imgproc.compareHist(hist1, hist2, Imgproc.CV_COMP_CORREL);
        System.out.println("Similarity: " + similarity);
        return similarity;
    }
}
