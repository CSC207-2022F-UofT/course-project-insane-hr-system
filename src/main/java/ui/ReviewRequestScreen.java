package ui;

import controller.ReviewRequestController;
import data_access.ReviewRequestDataAccess;
import presenter.ReviewRequestPresenter;
import review_request.*;

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
            Object[] options = {"Approve", "Deny"};
            int result = JOptionPane.showOptionDialog(frame, "Please approve or deny the leave " +
                    "request", "Review Leave Request", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            if (result != JOptionPane.CANCEL_OPTION){
                String response = controller.reviewRequest(oid, result == JOptionPane.YES_OPTION).getResult();
                JOptionPane.showMessageDialog(frame, "You have " + response.toLowerCase() + "the " +
                        "leave request.", "Leave Request " + response, JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
