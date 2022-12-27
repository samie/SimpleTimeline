package org.vaadin.addons.simpletimeline;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends VerticalLayout {

    public View() {
        final SimpleTimeline timeline = new SimpleTimeline("Release schedule");
        timeline.add(10, "Planning").addClassNames(SimpleTimelineItem.STYLE_SECONDARY,SimpleTimelineItem.VARIANT_DASHED);
        timeline.add(20, -1, "Brainstorming").setTooltip("🧠🧠🧠");
        timeline.add(40, "More planning").addClassNames(SimpleTimelineItem.STYLE_PRIMARY);
        timeline.add(70, 2, "Scrum").addClassNames(SimpleTimelineItem.STYLE_PRIMARY, SimpleTimelineItem.VARIANT_FILLED);
        timeline.add(95, 2, "Deadline: 31.12.2022").addClassNames(SimpleTimelineItem.VARIANT_FILLED, SimpleTimelineItem.STYLE_ERROR);
        timeline.setBreaks(25,50,75);
        timeline.addClickListener(e -> Notification.show(e.getItem().getText()));
        add(timeline);

        add(new Button("Toggle Enable/Disable", e ->{
            timeline.setEnabled(!timeline.isEnabled());
        }));

        final SimpleTimeline tl = new SimpleTimeline("Industry nicknames");
        tl.setWidth("800px");
        tl.add(10, -3,"Corporate companies: \"Big Tocacco\"");
        tl.add(15, 2, "Drug companies: \"Big Pharma\"");
        tl.add(25, -1, "Farming industries: \"Big AG\"");
        tl.add(45, -2, "Automakers: \"Big Car\"").setClassName(SimpleTimelineItem.VARIANT_DASHED);
        tl.add(65, -1, "International Equestrian Federation: \"Big Horse\"");
        tl.add(75, 5, "The Board of Pediatric Medicine: \"Big Foot\"");
        tl.add(85, 1, "The Mining Industry: \"Big Hole\"");
        tl.add(95, -4, "The American Egg Board: \"Big Egg\"");
        tl.addClickListener(e -> Notification.show(e.getItem().getText()));
        add(tl);    }
}
