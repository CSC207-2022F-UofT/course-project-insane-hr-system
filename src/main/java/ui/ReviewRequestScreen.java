package ui;

import controller.ReviewRequestController;
import data_access.ReviewRequestDataAccess;
import presenter.ReviewRequestPresenter;
import use_case.review_request.ReviewRequestDsGateway;
import use_case.review_request.ReviewRequestInputBoundary;
import use_case.review_request.ReviewRequestInteractor;
import use_case.review_request.ReviewRequestOutputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class ReviewRequestScreen extends JPanel implements ActionListener {
    JButton reviewRequestButton = new JButton("Approve/Deny Request");
    JFrame frame;
    ReviewRequestController controller;
    UUID oid;

    public ReviewRequestScreen(JFrame frame,UUID oid) {
        super();
        reviewRequestButton.addActionListener(this);
        this.frame = frame;
        this.oid = oid;
        this.add(reviewRequestButton);
        ReviewRequestDsGateway gateway = new ReviewRequestDataAccess();
        ReviewRequestOutputBoundary presenter = new ReviewRequestPresenter();
        ReviewRequestInputBoundary interactor = new ReviewRequestInteractor(gateway, presenter);
        this.controller = new ReviewRequestController(interactor);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        try {
            Object[] options = {"Deny", "Approve"};
            int result = JOptionPane.showOptionDialog(frame, "Please approve or deny the leave " +
                    "request", "Review Leave Request", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[1]);
            if (result != JOptionPane.CLOSED_OPTION){
                String response = controller.reviewRequest(oid, result == JOptionPane.NO_OPTION).getResult();
                JOptionPane.showMessageDialog(frame, "You have " + response.toLowerCase() + " the " +
                        "leave request.", "Leave Request " + response, JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new ReviewRequestScreen(frame, UUID.randomUUID()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
