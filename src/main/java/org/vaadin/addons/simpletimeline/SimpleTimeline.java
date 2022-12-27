package org.vaadin.addons.simpletimeline;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

import java.util.Arrays;
import java.util.stream.Collectors;


@Tag("simple-timeline")
@JsModule("@parttio/simple-timeline/simple-timeline.js")
@NpmPackage(value = "@parttio/simple-timeline", version = "2.0.5")
public class SimpleTimeline extends Component implements HasStyle, HasSize, HasEnabled, HasComponents {

    public SimpleTimeline() {
    }

    public void setEnabled(boolean enabled) {
        this.getElement().setEnabled(enabled);
    }

    public boolean isEnabled() {
        return this.getElement().isEnabled();
    }

    public SimpleTimeline(String caption) {
        getElement().setProperty("caption", caption);
    }

    public SimpleTimelineItem add(int x, String caption) {
        return add(x,1,caption);
    }

    public void setBreaks(int... breaks) {
        this.getElement().setProperty("breaks", Arrays.stream(breaks)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(",")));
    }

    public SimpleTimelineItem add(int x, int y, String caption) {
        SimpleTimelineItem item = new SimpleTimelineItem(x, y, caption);
        add(item);
        return item;
    }

    @DomEvent("simple-timeline-click")
    public static class ClickEvent extends ComponentEvent<SimpleTimeline> {
        private final int itemIndex;

        public ClickEvent(SimpleTimeline timeline,
                          boolean fromClient,
                          @EventData("event.detail") int itemIndex) {
            super(timeline, fromClient);
            this.itemIndex = itemIndex;
        }
        public SimpleTimeline getSimpleTimeline() {
            return (SimpleTimeline) this.source;
        }
        public int getItemIndex() {
            return this.itemIndex;
        }

        public SimpleTimelineItem getItem() {
            return (SimpleTimelineItem)getSimpleTimeline().getChildren().collect(Collectors.toList()).get(this.itemIndex);
        }
    }
    public Registration addClickListener(
            ComponentEventListener<SimpleTimeline.ClickEvent> listener) {
        return addListener(SimpleTimeline.ClickEvent.class, listener);
    }

}
