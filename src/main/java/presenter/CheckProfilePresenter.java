package presenter;

import check_profile_validation.CheckProfileOutputBoundary;
import check_profile_validation.CheckProfileResponseModel;
import check_profile_validation.VisualLevel;
import screen_builder.FrameFactory;
import screen_builder.ScreenBuilder;
import view_model.ScreenType;
import view_model.UIDataModel;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CheckProfilePresenter implements CheckProfileOutputBoundary {
    private final UIDataModel dataModel;

    public CheckProfilePresenter(UIDataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public void prepareUserFrame(CheckProfileResponseModel responseModel) {
        ScreenBuilder screenBuilder = getBuilder(responseModel);
        //TODO: getBuilder is not yet finished
        responseModel.getGateway().addObserver(dataModel);

        if (responseModel.getVisualLevel() == VisualLevel.INVISIBLE) {
            show(screenBuilder.getNotVisible());
        }else if (responseModel.getVisualLevel() == VisualLevel.ONLY_FACE) {
            show(screenBuilder.getIntroOnly());
        }else if (responseModel.getVisualLevel() == VisualLevel.PROFILE) {
            show(screenBuilder.getIntroAndTable());
        }else if (responseModel.getVisualLevel() == VisualLevel.EDITABLE) {
            FrameFactory factory = new FrameFactory();
//            factory.create(ScreenType.)
            //TODO
            show(screenBuilder.getIntroTableAndButton());
        }
        show(screenBuilder.getNotVisible());
    }

    private ScreenBuilder getBuilder(CheckProfileResponseModel responseModel) {
//TODO
        return null;
    }

    @Override
    public void prepareOrgFrame(CheckProfileResponseModel responseModel) {
//TODO
    }
    @Override
    public void update() {
//TODO
    }

    private void show(JFrame frame) {
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
