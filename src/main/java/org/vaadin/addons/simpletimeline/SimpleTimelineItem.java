package org.vaadin.addons.simpletimeline;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.shared.Tooltip;

@Tag("simple-timeline-item")
@JsModule("@parttio/simple-timeline/simple-timeline.js")
@NpmPackage(value = "@parttio/simple-timeline", version = "2.0.5")
public class SimpleTimelineItem extends Component implements HasStyle {

    public static final String STYLE_PRIMARY = "primary";
    public static final String STYLE_SECONDARY = "secondary";

    public static final String STYLE_ERROR = "error";

    public static final String VARIANT_FILLED = "filled";

    public static final String VARIANT_DASHED = "dashed";
    private static final int MIN_Y = -5;
    private static final int MAX_Y = 5;

    private String tooltip = null;

    private SimpleTimelineItem() {
    }

    public SimpleTimelineItem(int x, int y, String caption) {
        this();
        this.getElement().setProperty("x", x >= 0 && x <= 100 ? x : (x > 0 ? 100:0));
        this.getElement().setProperty("y", y >= MIN_Y && MAX_Y <= 100 ? (y != 0?y:1) :(y > 0 ? MAX_Y : MIN_Y));
        this.getElement().setText(caption);
    }

    public String getText() {
        return this.getElement().getText();
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
        Tooltip.forComponent(this).withText(tooltip)
                .withPosition(Tooltip.TooltipPosition.TOP_START);
    }
}
