package ui;

import javax.swing.*;

public class FrameFactory {
    JFrame createUserFrame(ViewIModel viewModel) {
        JFrame frame = new JFrame(viewModel.getFrameName() + "'s File");
        frame.setContentPane(new RootPanelFactory().createRootPanel(viewModel.getFrameName(), viewModel.getIntro(), viewModel.getLeftPanel(), viewModel.getRightPanel()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    JFrame createOrganizationFrame(String orgType, ViewIModel viewModel) {
        JFrame frame = new JFrame(orgType + viewModel.getFrameName());
        frame.setContentPane(new RootPanelFactory().createRootPanel(viewModel.getFrameName(), viewModel.getIntro(), viewModel.getLeftPanel(), viewModel.getRightPanel()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }
}
