package com.example.springboot_collegelibrary.faceRecognition;

import nu.pattern.OpenCV;
import org.bytedeco.librealsense.frame;
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

    public void TakePictureAndDetectFace(String userEmail) {
        // Load the OpenCV library
        System.setProperty("java.library.path", "src/main/resources/classifier/");
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        nu.pattern.OpenCV.loadLocally();
        OpenCV.loadShared();
        // Load the OpenCV library
//        System.loadLibrary("opencv_java460");
        // Create a new video capture object
        // Check if the video capture object was created successfully
        // Create a new matrix to store the video frame
        int detectedFaces = 0;
        while (detectedFaces != 1) {
            VideoCapture capture = new VideoCapture(0);
            if (!capture.isOpened()) {
                System.out.println("Error: Could not access webcam.");
                return;
            }
            Mat frame = new Mat();
            // Read a frame from the video capture object
            capture.read(frame);
            // Save the frame to a file
            Imgcodecs.imwrite("src/main/resources/static/images/" + userEmail + ".jpg", frame);
            // Release the video capture object
            capture.release();
            // Load the input image
            Mat image = Imgcodecs.imread("src/main/resources/static/images/" + userEmail + ".jpg");
            // Load the cascade classifier
            CascadeClassifier faceDetector = new CascadeClassifier("C:/opencv/build/etc/haarcascades/haarcascade_frontalface_default.xml");
            // Detect faces in the image
            MatOfRect faceDetections = new MatOfRect();
            faceDetector.detectMultiScale(image, faceDetections);

            if (faceDetections.toArray().length == 0) {
                System.out.println("No face detected");
            } else if (faceDetections.toArray().length == 1) {
                System.out.println("Face detected");
                detectedFaces = 1;
            } else {
                System.out.println("Multiple faces detected");
            }
            // Draw a bounding box around each face
//            for (Rect rect : faceDetections.toArray()) {
//                Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 3);
//                // Save the output image
//                Imgcodecs.imwrite(outputFileName, image);
//            }
        }
    }

    public String FaceSimilarityVideoAndPicture(String userEmail) {
        System.setProperty("java.library.path", "src/main/resources/classifier/");
        System.setProperty("java.awt.headless", "false");
        nu.pattern.OpenCV.loadLocally();
        OpenCV.loadShared();
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture capture = new VideoCapture(0);

        // Check if the video stream is open
        if (!capture.isOpened()) {
            System.out.println("Error opening video stream");
            return "Error opening video stream";
        }

        // Load the face classifier
        CascadeClassifier faceClassifier = new CascadeClassifier("src/main/resources/classifier/haarcascade_frontalface_default.xml");
        // Loop through the frames of the video stream
        double similarity=0;
        int tries=0;
        while (similarity<0.80 && tries<100) {
            tries+=1;

            Mat frame = new Mat();
            capture.read(frame);


            MatOfRect faceDetections = new MatOfRect();
            faceClassifier.detectMultiScale(frame, faceDetections);

            try {
                Rect faceRect = faceDetections.toArray()[0]; // assume there is only one face
                Mat face = new Mat(frame, faceRect);
                similarity = compareFace("src/main/resources/static/images/"+ userEmail+".jpg", face);
            } catch (Exception e) {
                System.out.println("No face detected");
            }
            MatOfRect faces = new MatOfRect();
            faceClassifier.detectMultiScale(frame, faces);

            // Iterate over the detected faces and draw a rectangle around each face
//            for (Rect rect : faces.toArray()) {
//                Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0), 3);
//            }

            // Display the frame in a window
//            HighGui.imshow("Video", frame);
//            int key = HighGui.waitKey(1);
//            if (key == 27) { // Escape key
//                break;
//            }
        }
        capture.release();
        return tries < 100 ? "Correct Face detected" : "Wrong face detected";
    }

    public double compareFace(String filename, Mat frame){
        Mat image1 = Imgcodecs.imread(filename, Imgcodecs.IMREAD_GRAYSCALE);

        Mat hist1= new Mat();
        Mat hist2= new Mat();
        Imgproc.calcHist(Arrays.asList(image1), new MatOfInt(0), new Mat(), hist1, new MatOfInt(256), new MatOfFloat(0, 256));
        Imgproc.calcHist(Arrays.asList(frame), new MatOfInt(0), new Mat(), hist2, new MatOfInt(256), new MatOfFloat(0, 256));

        double similarity = Imgproc.compareHist(hist1, hist2, Imgproc.CV_COMP_CORREL);
        System.out.println("Similarity: " + similarity);
        return similarity;
    }

    public void cutOnlyFace(String userEmail) {
        // Load the OpenCV library
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        nu.pattern.OpenCV.loadLocally();
        OpenCV.loadShared();
        // Load the input image
        Mat image = Imgcodecs.imread("src/main/resources/static/images/"+ userEmail+".jpg");

        // Load the cascade classifier
        CascadeClassifier faceDetector = new CascadeClassifier("C:/opencv/build/etc/haarcascades/haarcascade_frontalface_default.xml");

        // Detect faces in the image
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        // Crop the image to just the face
        Rect faceRect = faceDetections.toArray()[0]; // assume there is only one face
        Mat face = new Mat(image, faceRect);

        // Save the output image
        Imgcodecs.imwrite("src/main/resources/static/images/"+ userEmail+".jpg", face);
    }
}
