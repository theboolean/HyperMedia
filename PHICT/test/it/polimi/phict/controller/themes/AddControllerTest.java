package it.polimi.phict.controller.themes;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AddControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/themes/add");
        AddController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/themes/add.jsp"));
    }
}
