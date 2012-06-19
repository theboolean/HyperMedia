package it.polimi.phict.controller.projects;

import it.polimi.phict.controller.projects.NewController;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NewControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/Projects/New");
        NewController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/Projects/New.jsp"));
    }
}
