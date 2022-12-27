package org.vaadin.addons.simpletimeline;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.TestBenchElement;

public class ViewIT extends AbstractViewTest {

    @Test
    public void componentWorks() {
        final TestBenchElement elem = $("simple-timeline").waitForFirst();
        // Check that axa-text contains at least one other element, which means that
        // is has been upgraded to a custom element and not just rendered as an empty
        // tag
        Assert.assertTrue(
            elem.$(TestBenchElement.class).all().size() > 0);
    }
}
