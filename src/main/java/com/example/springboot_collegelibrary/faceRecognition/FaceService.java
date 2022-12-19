package com.example.springboot_collegelibrary.faceRecognition;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.springframework.stereotype.Service;

@Service
public class FaceService {

    public static void TakePicture(String outputFileName) {
        System.out.println("Attempting to take picture");

        // Load the OpenCV library
        nu.pattern.OpenCV.loadLocally();

        // Create a new video capture object
        VideoCapture capture = new VideoCapture(0);

        // Check if the video capture object was created successfully
        if (!capture.isOpened()) {
            System.out.println("Error: Could not access webcam.");
            return;
        }

        // Create a new matrix to store the video frame
        Mat frame = new Mat();

        // Read a frame from the video capture object
        capture.read(frame);

        // Save the frame to a file
        org.opencv.imgcodecs.Imgcodecs.imwrite(outputFileName, frame);

        // Release the video capture object
        capture.release();
    }
}
