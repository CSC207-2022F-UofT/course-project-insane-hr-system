package screen_builder;

import view_model.OrgDataModel;
import view_model.UIDataModel;
import screen_builder.ScreenBuilder;

public class ProjectScreenBuilder extends OrgScreenBuilder {
    public ProjectScreenBuilder(OrgDataModel dataModel) {
        super(dataModel);
    }
// Implement all these methods to create our different frame.
    // there are some help function in super class, like getLeftRows, getRightRows,
    // we could add more helper function if you think it will be used in other frame.

    /**
     * This method set the Introduction part of the frame.
     *
     * @return is a long and well-formed string that contain all detail of the user or organization.
     */
    @Override
    protected String setIntro() {
        return super.setIntro();
    }

    /**
     * This method set the Introduction title.
     *
     * @return is a string that at least have the name of the user or organization.
     */
    @Override
    protected String setInfoTitle() {
        return super.setInfoTitle();
    }

    /**
     * This method set the Frame name in the top. Default is HR system.
     *
     * @return is a string of the frame name
     */
    @Override
    protected String setFrameName() {
        return super.setFrameName();
    }

}
