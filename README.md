# SimpleTimeline Add-on for Vaadin

[![Published on Vaadin Directory](https://img.shields.io/vaadin-directory/v/idle.svg)](https://vaadin.com/directory/component/simpletimeline)


This is a Vaadin Java wrapper for an existing [simple-timeline](https://github.com/parttio/simple-timeline) Lit-based web component. 

```
final SimpleTimeline timeline = new SimpleTimeline("Release schedule");
timeline.add(10, "Planning").addClassNames(SimpleTimelineItem.STYLE_SECONDARY,SimpleTimelineItem.VARIANT_DASHED);
timeline.add(20, -1, "Brainstorming").setTooltip("🧠🧠🧠");
timeline.add(40, "More planning").addClassNames(SimpleTimelineItem.STYLE_PRIMARY);
timeline.add(70, 2, "Scrum").addClassNames(SimpleTimelineItem.STYLE_PRIMARY, SimpleTimelineItem.VARIANT_FILLED);
timeline.add(95, 2, "Deadline: 31.12.2022").addClassNames(SimpleTimelineItem.VARIANT_FILLED, SimpleTimelineItem.STYLE_ERROR);
timeline.setBreaks(25,50,75);
timeline.addClickListener(e -> Notification.show(e.getItem().getText()));
add(timeline);
```

![Release schedule](https://github.com/samie/SimpleTimeline/blob/v23/roadmap-timeline.png)


By default theme follows Lumo styling variables.

## Development instructions

Starting the test/demo server:
1. Run `mvn`.
2. Open http://localhost:8080 in the browser.

## Publishing to Vaadin Directory

You can create the zip package needed for [Vaadin Directory](https://vaadin.com/directory/) using
```
mvn versions:set -DnewVersion=1.0.0 # You cannot publish snapshot versions 
mvn clean install -Pdirectory
```

The package is created as `target/simpletimeline-1.0.0.zip`

For more information or to upload the package, visit https://vaadin.com/directory/my-components?uploadNewComponent
